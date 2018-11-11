package gt.gob.muni.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import gt.gob.muni.model.Role;
import gt.gob.muni.model.Usuario;
import gt.gob.muni.model.UsuarioRole;


public interface UsuarioDao {
	public void create(Usuario usuario) throws Exception;
	public void asignar(UsuarioRole usuarioRole) throws Exception;
	public void update(Usuario usuario) throws Exception;
	public void modificarAsignacion(UsuarioRole usuarioRole) throws Exception;
	public void delete(Usuario usuario) throws Exception;
	public List<Usuario> listAll();
	public Usuario findUserByName(String usuario);
	public Usuario findById(BigDecimal idUsuario);
	public UsuarioRole findUsuarioRole(BigDecimal usuarioRole);
	public UsuarioRole findByUsuarioByRole(BigDecimal idUsuario, BigDecimal idRole);
	public List<Role> findRolesByUsuario(BigDecimal idUsuario);
	public List<UsuarioRole> findUserRolesById(BigDecimal idUsuario);
}

@Repository
@Transactional
class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Usuario findUserByName(String usuario) {
		try {
			TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByUsuario", Usuario.class);
			query.setParameter("nombre", usuario);
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException nr) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Role> findRolesByUsuario(BigDecimal idUsuario) {
		try {
			TypedQuery<Role> query = em.createNamedQuery("UsuarioRole.findRolesByUsuario", Role.class);
			query.setParameter("idUsuario", idUsuario);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Role>();
		}
	}

	@Override
	public void create(Usuario usuario) throws Exception{
		try {
			em.persist(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void update(Usuario usuario) throws Exception{
		try {
			em.merge(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void delete(Usuario usuario) throws Exception{
		try {
			usuario.setEstado("I");
			em.merge(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Usuario> listAll() {
		try {
			TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll",Usuario.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public List<UsuarioRole> findUserRolesById(BigDecimal idUsuario) {
		
		try {
			TypedQuery<UsuarioRole> query = em.createNamedQuery("UsuarioRole.findByUsuario",UsuarioRole.class);
			query.setParameter("idUsuario", idUsuario);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<UsuarioRole>();
		}
	}

	@Override
	public void asignar(UsuarioRole usuarioRole) throws Exception {
		try {
			em.persist(usuarioRole);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void modificarAsignacion(UsuarioRole usuarioRole) throws Exception {
		try {
			em.merge(usuarioRole);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Usuario findById(BigDecimal idUsuario) {
		try {
			TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findById",Usuario.class);
			query.setParameter("idUsuario", idUsuario);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UsuarioRole findUsuarioRole(BigDecimal usuarioRole) {
		try {
			TypedQuery<UsuarioRole> query = em.createNamedQuery("UsuarioRole.findById",UsuarioRole.class);
			query.setParameter("idUsuarioRole", usuarioRole);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UsuarioRole findByUsuarioByRole(BigDecimal idUsuario,
			BigDecimal idRole) {
		try {
			TypedQuery<UsuarioRole> query = em.createNamedQuery("UsuarioRole.findByUsuarioByRole", UsuarioRole.class);
			query.setParameter("idUsuario", idUsuario);
			query.setParameter("idRole", idRole);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
