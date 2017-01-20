package com.morpheus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.morpheus.model.UsuarioModel;
import com.morpheus.repository.UsuarioRepository;

@RestController
@RequestMapping("users")
public class UsuarioController {
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@ResponseStatus(org.springframework.http.HttpStatus.ACCEPTED)
	public List<UsuarioModel> listaUsuario() {
		UsuarioRepository usr = new UsuarioRepository();
		return usr.listarTodosUsers();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	public void insereUsuario(@RequestBody String input) {
		UsuarioRepository usr = new UsuarioRepository();
		UsuarioModel usm = new Gson().fromJson(input, UsuarioModel.class);
		usr.inserirUsers(usm);
	}
}
