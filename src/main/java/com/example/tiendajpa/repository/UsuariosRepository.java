package com.example.tiendajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tiendajpa.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
