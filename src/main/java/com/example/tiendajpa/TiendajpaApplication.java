package com.example.tiendajpa;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tiendajpa.model.Categoria;
import com.example.tiendajpa.repository.CategoriasRepository;


@SpringBootApplication
public class TiendajpaApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TiendajpaApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// guardar();-- buscarPorId();-- modificar();-- eliminar(); --- conteo(); --- eliminarTodos();
		//encontrarPorIds(); -- buscarTodos(); -- existeId(); -- guardarTodas(); ---buscarTodosJpa()
		borrarTodoEnBloque();
	}
	
	/* Metodo deleteAllInBatch [Usar con precaución] - Interfaz JpaRepository*/
	private void borrarTodoEnBloque() {
		repo.deleteAllInBatch();
	}
	/* Metodo findAll - Interfaz JpaRepository*/
	private void buscarTodosJpa(){
		List<Categoria> categorias = repo.findAll();
		for (Categoria c : categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	private void guardarTodas() {
		List<Categoria> categorias = getListaCategorias();
		repo.saveAll(categorias);
				}


		private void existeId() {
		boolean existe = repo.existsById(5);
		System.out.println("La categoria existe: " + existe);
			}
	
	
	private void buscarTodos() {
		Iterable<Categoria> categorias = repo.findAll();
		for(Categoria cat: categorias) {
			System.out.println(cat);
		}
		
	}


	private void encontrarPorIds() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repo.findAllById(ids);
		for (Categoria cat : categorias) {
			System.out.println(cat);
		
		}
		
	}
	
	private void eliminarTodos() {
		repo.deleteAll();
		
			}
	
	private void conteo() {
		long count = repo.count();
		System.out.println("Total Categorias: " + count);
			}
	
	
	private void modificar() {

		Optional<Categoria> optional = repo.findById(2);
		if(optional.isPresent()) {
			Categoria catTmp = optional.get();
			catTmp.setNombre("Laptops");
			catTmp.setDescripcion("Las mejores laptops");
			repo.save(catTmp);
			System.out.println(optional.get());
		}
		else 
			System.out.println("Categoria no encontrada");
	}

	
	
	private void buscarPorId() {
		Optional <Categoria> optional = repo.findById(1);
		if(optional.isPresent())
			System.out.println(optional.get());
		else 
			System.out.println("Categoria no encontrada");
	}
	
	
	private void guardar() {
		Categoria cat  = new Categoria();
		cat.setNombre("Telefonos");
		cat.setDescripcion("Todo lo relacionado con la telefonia");
		repo.save(cat);
	}
	
	
	private void eliminar() {
		int idCategoria = 1;
		repo.deleteById(idCategoria);
			}
	




private List<Categoria> getListaCategorias(){
	List<Categoria> lista = new LinkedList<Categoria>();
	
	Categoria cat1 =  new Categoria();
	cat1.setNombre("Usb");
	cat1.setDescripcion("guarda tu informacion y llevala a donde sea");
	
	
	Categoria cat2 =  new Categoria();
	cat2.setNombre("Mochila tech");
	cat2.setDescripcion("Transporta de manera segura y compacta tu laptop, audifonos, tableta, etc");
	
	
	Categoria cat3 =  new Categoria();
	cat3.setNombre("Tableta");
	cat3.setDescripcion("Maneja tu informacion sin la necesidad de un mouse o un teclado");
	
	lista.add(cat1);
	lista.add(cat2);
	lista.add(cat3);
	
	return lista;
}
}
