package com.example.tiendajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tiendajpa.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByDisponible(Integer disponible);
	
	List<Producto> findByNuevoAndDisponibleOrderByIdDesc(int nuevo, int disponible);
	
	List<Producto> findByPrecioBetweenOrderByPrecioDesc(double s1, double s2);
	
	List<Producto> findByDisponibleIn(int[] disponible);
}
