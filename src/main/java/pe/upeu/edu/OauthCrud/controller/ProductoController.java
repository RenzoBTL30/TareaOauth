package pe.upeu.edu.OauthCrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.upeu.edu.OauthCrud.entity.Producto;
import pe.upeu.edu.OauthCrud.servicesImpl.ProductoServiceImpl;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Producto>> getProductos(){
		try {
			List<Producto> list = new ArrayList<>();
			list = productoService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/post")
	public ResponseEntity<Producto> save(@RequestBody Producto pro){
		try {
			Producto pr = productoService.create(pro);
			return new ResponseEntity<>(pr, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable("id") int id){
		Producto producto = productoService.read(id);
			if(producto.getId()>0) {
				return new ResponseEntity<>(producto, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			productoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto pr, @PathVariable("id") int id){
		try {
			Producto ul = productoService.read(id);
			if (ul.getId()>0) {
				ul.setNombre(pr.getNombre());
				ul.setPrecio(pr.getPrecio());
				ul.setStock(pr.getStock());
				ul.setCategoria(pr.getCategoria());
				return new ResponseEntity<>(productoService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
