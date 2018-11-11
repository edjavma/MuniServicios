package gt.gob.muni.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.gob.muni.model.Role;
import gt.gob.muni.model.Usuario;
import gt.gob.muni.service.UsuarioService;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UsuarioService usuarioService; 
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findUserByName(username);
		if(usuario==null){
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getPassword(), 
				 true, true, true, true, getGrantedAuthorities(usuario));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Usuario usuario){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Role> roles = usuarioService.findRolesByUsuario(usuario.getIdUsuario());
		for(Role rol:roles){
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return authorities;
	}

}
