package com.morpheus.repository;

import java.util.List;

import com.morpheus.database.DbOperation;
import com.morpheus.model.UsuarioModel;

/*
 * Classe responsavel por abstrair a ideia logica (Representation) de um banco de dados em um arquivo (DbOperation).
 */
public class UsuarioRepository {
	public List<UsuarioModel> listarTodosUsers() {
		DbOperation db = new DbOperation();
		return db.findAll();
	}

	public void inserirUsers(UsuarioModel usuario) {
		new DbOperation().insert(usuario);
	}
}
