package com.consumoApi.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumoApi.modelo.Dws;
import com.consumoApi.modelo.Result;
import com.consumoApi.repositorio.DwsRepository;


@Service
public class ResultService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DwsRepository repo;
	
	public Optional<Dws> findById(Integer id){
		Optional<Dws> buscar = repo.findById(id);
		return buscar;
		
		
	}
	
	
	
	public ResponseEntity<List<Dws>> getAll(){
		List<Dws> lista = repo.findAll();
		return ResponseEntity.ok(lista);
	}
	
	public Result save(Result result) {
		Result res =restTemplate.postForObject("https://hello-world-rest-api-master.azurewebsites.net/dws", result, Result.class);
		return res;
		
	}
	
	public ResponseEntity<Dws> guardar(Dws dws){
		Dws dwsNew = repo.save(dws);
		return ResponseEntity.ok(dwsNew);
	}
	
	public ResponseEntity<Dws> actualizar(Dws dws,Integer id){
		Dws actualiza = repo.save(dws);
		return ResponseEntity.ok(actualiza);
		
	
	}
	
	public void eliminarPorId(Integer id){
		repo.deleteById(id);
		
	}
	
	

}
