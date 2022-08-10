package com.consumoApi.controlador;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.consumoApi.modelo.Dws;
import com.consumoApi.modelo.Result;
import com.consumoApi.servicio.ResultService;

@RestController
@RequestMapping("/api/dws")
public class ResultController {
	
	@Autowired
	private ResultService service;
	
	@GetMapping
	public ResponseEntity<List<Dws>> getAll(){
		ResponseEntity<List<Dws>>list = service.getAll();
		return list;
		
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Result save(@RequestBody Result result){
		Result res = service.save(result);
		return res;
	}
	
	@PostMapping("/guardar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity <Dws>guardar(@RequestBody Dws dws){
		ResponseEntity<Dws> guardado = service.guardar(dws);
		return guardado;
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dws> actualizar(@PathVariable Integer id,@RequestBody Dws dws){
		Optional<Dws> dwsOptional = service.findById(id);
		
		if(!dwsOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		dws.setId(dwsOptional.get().getId());
		service.guardar(dws);
		
		return ResponseEntity.ok(dws);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Dws> eliminarPorId(@PathVariable Integer id){
		Optional<Dws> dwsOptional = service.findById(id);
		
		if(!dwsOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		service.eliminarPorId(dwsOptional.get().getId());
		return ResponseEntity.noContent().build();
	}
	

}
