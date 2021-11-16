package pe.upeu.edu.OauthCrud.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.upeu.edu.OauthCrud.entity.Producto;
import pe.upeu.edu.OauthCrud.repository.ProductoRepository;
import pe.upeu.edu.OauthCrud.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto create(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

	@Override
	public Producto update(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

}
