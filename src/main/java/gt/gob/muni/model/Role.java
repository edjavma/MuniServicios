package gt.gob.muni.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "Role.findAll",
				query = "SELECT r FROM Role r "),
	@NamedQuery(name = "Role.findById",
				query = "SELECT r FROM Role r WHERE r.idRole = :idRole "),
	@NamedQuery(name = "Role.findByNombre",
				query = "SELECT r FROM Role r WHERE UPPER(r.nombre) = UPPER(:nombre) ")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Role.findRoleTarget",
                      query = "SELECT * FROM ROLE A "+ 
							"WHERE NOT EXISTS (  "+
							"SELECT 1 FROM USUARIO_ROLE "+ 
							"WHERE ID_ROLE = A.ID_ROLE "+
							"AND ID_USUARIO = ? )"+
							//"AND ESTADO = 'A' )  "+
							"ORDER BY A.NOMBRE ASC ",
                     resultClass = Role.class)
})
@Table(name = "ROLE")
public class Role {
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROLE")
	private BigDecimal idRole;
	
	@Basic(optional = false)
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Basic(optional = true)
	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Basic(optional = false)
	@Column(name = "USUARIO_INSERT")
	private String usuarioInsert;
	
	@Basic(optional = false)
	@Column(name = "FECHA_INSERT")
	private Date fechaInsert;
	
	@Basic(optional = true)
	@Column(name = "USUARIO_UPDATE")
	private String usuarioUpdate;
	
	@Basic(optional = true)
	@Column(name = "FECHA_UPDATE")
	private Date fechaUpdate;

	public Role(BigDecimal idRole, String nombre, String descripcion,
			String usuarioInsert, Date fechaInsert, String usuarioUpdate,
			Date fechaUpdate) {
		super();
		this.idRole = idRole;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioInsert = usuarioInsert;
		this.fechaInsert = fechaInsert;
		this.usuarioUpdate = usuarioUpdate;
		this.fechaUpdate = fechaUpdate;
	}
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getIdRole() {
		return idRole;
	}

	public void setIdRole(BigDecimal idRole) {
		this.idRole = idRole;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuarioInsert() {
		return usuarioInsert;
	}

	public void setUsuarioInsert(String usuarioInsert) {
		this.usuarioInsert = usuarioInsert;
	}

	public Date getFechaInsert() {
		return fechaInsert;
	}

	public void setFechaInsert(Date fechaInsert) {
		this.fechaInsert = fechaInsert;
	}

	public String getUsuarioUpdate() {
		return usuarioUpdate;
	}

	public void setUsuarioUpdate(String usuarioUpdate) {
		this.usuarioUpdate = usuarioUpdate;
	}

	public Date getFechaUpdate() {
		return fechaUpdate;
	}

	public void setFechaUpdate(Date fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}
	
	

}
