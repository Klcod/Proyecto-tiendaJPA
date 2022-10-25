package com.example.tiendajpa;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.tiendajpa.model.Categoria;
import com.example.tiendajpa.model.Perfil;
import com.example.tiendajpa.model.Producto;
import com.example.tiendajpa.model.Usuario;
import com.example.tiendajpa.repository.CategoriasRepository;
import com.example.tiendajpa.repository.PerfilesRepository;
import com.example.tiendajpa.repository.ProductosRepository;
import com.example.tiendajpa.repository.UsuariosRepository;



@SpringBootApplication
public class TiendajpaApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repoCategorias;
	
	@Autowired
	private ProductosRepository repoProductos;
	
	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Autowired
	private PerfilesRepository repoPerfiles;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TiendajpaApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// guardar();-- buscarPorId();-- modificar();-- eliminar(); --- conteo(); --- eliminarTodos();
		//encontrarPorIds(); -- buscarTodos(); -- existeId(); -- guardarTodas(); ---buscarTodosJpa()
		buscarUsuario();
	}
	/**
	 * Metodo para buscar un usuario y desplegar sus perfiles asociados.
	 */
	public void buscarUsuario() {
		Optional<Usuario> optional = repoUsuarios.findById(50);
		if (optional.isPresent()) {
			Usuario u = optional.get();
			System.out.println("Usuario: " + u.getNombre());
			System.out.println("Perfiles asignados");
			for (Perfil p : u.getPerfiles()) {
				System.out.println(p.getPerfil());
			}
		}else {
			System.out.println("Usuario no encontrado");
		}
	}
/**
 * Crear un usuario con 2 perfiles ("ADMINISTRADOR", "USUARIO")
 */
private void crearUsuarioConDosPerfiles() {
	Usuario user = new Usuario();
	user.setNombre("Addy Paz");
	user.setEmail("addyPaz@gmail.com");
	user.setFechaRegistro(new Date());
	user.setUsername("addys");
	user.setPassword("12345");
	user.setEstatus(1);
	
	Perfil per1 = new Perfil();
	per1.setId(2);
	
	Perfil per2 = new Perfil();
	per2.setId(3);
	
	user.agregar(per1);
	user.agregar(per2);
	
	repoUsuarios.save(user); 
}
	
	/**
	 * Metodo para crear PERFILES / ROLES
	 
	private void crearPerfilesAplicacion() {
		repoPerfiles.saveAll(getPerfilesAplicacion());
	}*/

	private void guardarVacante() {
		
		Producto producto = new Producto();
		producto.setNombre("Dell XPS 15");
		producto.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
		producto.setFecha(new Date());
		producto.setPrecio(140000.0);
		producto.setDescuento("25");
		producto.setPreciocondescuento(120000.0);
		producto.setNuevo(1);
		producto.setOferta("3");
		producto.setDisponible(1);
		producto.setImagen("product03.png");
		producto.setDetalles("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
		Categoria cat = new Categoria();
		cat.setId(2);
		producto.setCategoria(cat);
		repoProductos.save(producto);
	}
	
	private void buscarProductos() {
		List<Producto> lista= repoProductos.findAll();
		for(Producto v: lista) {
			System.out.println(v.getId()+ " " + v.getNombre() + "-> " +  v.getCategoria().getNombre());		
		}
	}
	
	/**
	 *  Metodo findAll [Con Paginacion y Ordenados] - Interfaz PagingAndStortingRepository
	 */
	private void buscarTodosPaginacionOrdenados() {
		Page<Categoria> page = repoCategorias.findAll(PageRequest.of(0, 5,Sort.by("nombre").descending()));
		System.out.println("Total Registros: " + page.getTotalElements());
		System.out.println("Total Paginas: " + page.getTotalPages());
		for (Categoria c : page.getContent()) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	
	/**
	 *  Metodo findAll [Con paginación] - Interfaz PagingAndStortingRepository 
	 */
	private void buscarTodosPaginacion() {
		Page<Categoria> page = repoCategorias.findAll(PageRequest.of(0, 5));
		System.out.println("Total Registros: " + page.getTotalElements());
		System.out.println("Total Paginas: " + page.getTotalPages());
		for (Categoria c : page.getContent()) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	
	/**
	 *  Metodo findAll [Ordenados por un campo] - Interfaz PagingAndStortingRepository
	 */
	private void buscarTodosOrdenados() {
		List<Categoria> categorias = repoCategorias.findAll(Sort.by("nombre").descending());
		for (Categoria c : categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	
	/* Metodo deleteAllInBatch [Usar con precaución] - Interfaz JpaRepository*/
	private void borrarTodoEnBloque() {
		repoCategorias.deleteAllInBatch();
	}
	/* Metodo findAll - Interfaz JpaRepository*/
	private void buscarTodosJpa(){
		List<Categoria> categorias = repoCategorias.findAll();
		for (Categoria c : categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	private void guardarTodas() {
		List<Categoria> categorias = getListaCategorias();
		repoCategorias.saveAll(categorias);
				}


		private void existeId() {
		boolean existe = repoCategorias.existsById(5);
		System.out.println("La categoria existe: " + existe);
			}
	
	
	private void buscarTodos() {
		Iterable<Categoria> categorias = repoCategorias.findAll();
		for(Categoria cat: categorias) {
			System.out.println(cat);
		}
		
	}


	private void encontrarPorIds() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repoCategorias.findAllById(ids);
		for (Categoria cat : categorias) {
			System.out.println(cat);
		
		}
		
	}
	
	private void eliminarTodos() {
		repoCategorias.deleteAll();
		
			}
	
	private void conteo() {
		long count = repoCategorias.count();
		System.out.println("Total Categorias: " + count);
			}
	
	
	private void modificar() {

		Optional<Categoria> optional = repoCategorias.findById(2);
		if(optional.isPresent()) {
			Categoria catTmp = optional.get();
			catTmp.setNombre("Laptops");
			catTmp.setDescripcion("Las mejores laptops");
			repoCategorias.save(catTmp);
			System.out.println(optional.get());
		}
		else 
			System.out.println("Categoria no encontrada");
	}

	
	
	private void buscarPorId() {
		Optional <Categoria> optional = repoCategorias.findById(1);
		if(optional.isPresent())
			System.out.println(optional.get());
		else 
			System.out.println("Categoria no encontrada");
	}
	
	
	private void guardar() {
		Categoria cat  = new Categoria();
		cat.setNombre("Telefonos");
		cat.setDescripcion("Todo lo relacionado con la telefonia");
		repoCategorias.save(cat);
	}
	
	
	private void eliminar() {
		int idCategoria = 1;
		repoCategorias.deleteById(idCategoria);
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

/**
 * Metodo que regresa una lista de objetos de tipo Perfil que representa los diferentes PERFILES 
 * O ROLES que tendremos en nuestra aplicaciÃ³n de Empleos
 * @return
 
private List<Perfil> getPerfilesAplicacion(){		
	List<Perfil> lista = new LinkedList<Perfil>();
	Perfil per1 = new Perfil();
	per1.setPerfil("SUPERVISOR");
	
	Perfil per2 = new Perfil();
	per2.setPerfil("ADMINISTRADOR");
	
	Perfil per3 = new Perfil();
	per3.setPerfil("USUARIO");
	
	lista.add(per1);
	lista.add(per2);
	lista.add(per3);
	
	return lista;
}*/
}
