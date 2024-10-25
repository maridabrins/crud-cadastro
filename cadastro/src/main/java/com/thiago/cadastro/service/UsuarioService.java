package com.thiago.cadastro.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thiago.cadastro.model.UsuarioModel;
import com.thiago.cadastro.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Método para registrar um usuário
	public String registerUsuario(UsuarioModel usuario) {
		usuarioRepository.save(usuario);
		return "Cadastro realizado";
	}
	
	//Método para buscar um usuário por Id
	public ResponseEntity<UsuarioModel> findUsuarioById(UUID id){
		Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
		return usuario.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	//Método para listar todos os usuários
	public List<UsuarioModel> finAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	//Método para deletar um usuário
	public String deleteUsuario(UUID id) {
		usuarioRepository.deleteById(id);
		return"Usuário deletado com sucesso!";
	}
	//Método para atualizar um usuário
	public UsuarioModel updateUsuario(UUID id, UsuarioModel usuarioAtualizado) {
		UsuarioModel usuario = usuarioRepository.findById(id).get();   //Obtém o usuário | busca se ja existe
		usuario.setCpf(usuarioAtualizado.getCpf());
		usuario.setNasc(usuarioAtualizado.getNasc());
		usuario.setEmail(usuarioAtualizado.getEmail());
		usuario.setSenha(usuarioAtualizado.getSenha());
		
		return usuarioRepository.save(usuario);  //Salve e retorna o usuário que foi alterado
	}
}
