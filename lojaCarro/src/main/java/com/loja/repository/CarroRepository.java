package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
