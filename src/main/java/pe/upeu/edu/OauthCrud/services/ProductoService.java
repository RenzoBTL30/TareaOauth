package pe.upeu.edu.OauthCrud.services;

import java.util.List;

import pe.upeu.edu.OauthCrud.entity.Producto;

public interface ProductoService {
	Producto create(Producto producto);
	List<Producto> readAll();
	Producto read(int id);
	void delete(int id);
	Producto update(Producto producto);
}
