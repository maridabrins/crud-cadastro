package com.thiago.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.cadastro.Dto.UsuarioDto;
import com.thiago.cadastro.model.UsuarioModel;
import com.thiago.cadastro.repository.UsuarioRepository;

@RestController
@RequestMapping("cadastro")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
//	@PostMapping
//	public String registerUsuario(@RequestBody UsuarioModel usuario) {
//		return usuarioService.registerUsuario(usuario);
//	}
	
	
	
	@PostMapping("cadastrar")
	public void registerUsuario(@RequestBody UsuarioDto usuario) {
		UsuarioModel user = new UsuarioModel(usuario);
		repository.save(user);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long id){
//		var user = usuarioRepository.getReferenceById(id);
//		return ResponseEntity.ok(new UsuarioDto(user));
//	}
	@GetMapping("get")
	public List<UsuarioModel> listarUsuarios(){
		List<UsuarioModel> lista = repository.findAll();
				return lista;
	}
	
	
}
