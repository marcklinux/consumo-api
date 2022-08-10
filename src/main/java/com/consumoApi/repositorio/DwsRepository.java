package com.consumoApi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.consumoApi.modelo.Dws;

@Repository
public interface DwsRepository extends JpaRepository<Dws,Integer> {

	

}
