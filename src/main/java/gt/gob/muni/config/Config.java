package gt.gob.muni.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import gt.gob.muni.security.WebSecurityConfig;



@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({"gt.gob.muni.*"})
@PropertySource(value = { "classpath:application.properties" })
@Import(value = { WebSecurityConfig.class })
public class Config extends WebMvcConfigurerAdapter{

	@Autowired
    private Environment environment;
		
	@Bean(name="dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	/**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("/");
	    }
	 
	 @Bean
	    public MultipartResolver multipartResolver() {
	        return new StandardServletMultipartResolver();
	    }
	 
	 
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        return properties;        
	    }
	    
			
		
		@Bean
	     public JpaTransactionManager jpaTransactionManager() {
	         JpaTransactionManager transactionManager = new JpaTransactionManager();
	         transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
	         return transactionManager;
	     }

	    private HibernateJpaVendorAdapter vendorAdaptor() {
	         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	         vendorAdapter.setShowSql(true);
	         return vendorAdapter;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

	         LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	         entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
	         entityManagerFactoryBean.setDataSource(dataSource());
	         entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	         entityManagerFactoryBean.setPackagesToScan(new String[] {"gt.gob.muni.model"});             
	         entityManagerFactoryBean.setJpaProperties(hibernateProperties());

	         return entityManagerFactoryBean;
	     }
    
}
