package gt.gob.muni.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gt.gob.muni.dao.UsuarioDao;
import gt.gob.muni.model.Role;
import gt.gob.muni.model.Usuario;
import gt.gob.muni.model.UsuarioRole;


public interface UsuarioService {
	public void create(Usuario usuario) throws Exception;
	public void asignar(UsuarioRole usuarioRole) throws Exception;
	public void update(Usuario usuario) throws Exception;
	public void modificarAsignacion(UsuarioRole usuarioRole) throws Exception;
	public void delete(Usuario usuario) throws Exception;
	public void updatepass(Usuario usuario) throws Exception;
	public List<Usuario> listAll();
	public Usuario findUserByName(String usuario);
	public Usuario findById(BigDecimal idUsuario);
	public UsuarioRole findUsuarioRole(BigDecimal usuarioRole);
	public UsuarioRole findByUsuarioByRole(BigDecimal idUsuario, BigDecimal idRole);
	public List<Role> findRolesByUsuario(BigDecimal idUsuario);
	public List<UsuarioRole> findUserRolesById(BigDecimal idUsuario);
}

@Service
class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Usuario findUserByName(String usuario) {
		try {
			return usuarioDao.findUserByName(usuario);
		} catch (Exception e) {			
			return null;
		}
	}

	@Override
	public List<Role> findRolesByUsuario(BigDecimal idUsuario) {
		try {
			return usuarioDao.findRolesByUsuario(idUsuario);
		} catch (Exception e) {
			return new ArrayList<Role>();
		}
	}

	@Override
	public void create(Usuario usuario) throws Exception{
		try {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuarioDao.create(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void update(Usuario usuario) throws Exception{
		try {
			usuarioDao.update(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void delete(Usuario usuario) throws Exception{
		try {
			usuarioDao.delete(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void updatepass(Usuario usuario) throws Exception{
		try {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuarioDao.update(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Usuario> listAll() {
		try {
			return usuarioDao.listAll();
		} catch (Exception e) {			
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public List<UsuarioRole> findUserRolesById(BigDecimal idUsuario) {
		try {
			return usuarioDao.findUserRolesById(idUsuario);
		} catch (Exception e) {
			return new ArrayList<UsuarioRole>();
		}
	}

	@Override
	public void asignar(UsuarioRole usuarioRole) throws Exception {
		try {
			usuarioDao.asignar(usuarioRole);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Usuario findById(BigDecimal idUsuario) {
		try {
			return usuarioDao.findById(idUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void modificarAsignacion(UsuarioRole usuarioRole) throws Exception {
		try {
			usuarioDao.modificarAsignacion(usuarioRole);
		} catch (Exception e) {			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public UsuarioRole findUsuarioRole(BigDecimal usuarioRole) {
		try {
			return usuarioDao.findUsuarioRole(usuarioRole);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public UsuarioRole findByUsuarioByRole(BigDecimal idUsuario,
			BigDecimal idRole) {
		try {
			return usuarioDao.findByUsuarioByRole(idUsuario, idRole);
		} catch (Exception e) {
			return null;
		}
	}

}
