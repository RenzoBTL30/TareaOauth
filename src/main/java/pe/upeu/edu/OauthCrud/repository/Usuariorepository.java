package pe.upeu.edu.OauthCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.upeu.edu.OauthCrud.entity.Usuario;


public interface Usuariorepository extends JpaRepository<Usuario, Integer>{
	public Usuario findByUsername(String username);
}
