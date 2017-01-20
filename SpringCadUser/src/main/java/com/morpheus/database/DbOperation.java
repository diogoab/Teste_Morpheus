package com.morpheus.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.morpheus.model.UsuarioModel;

/*
 * Classe que faz a gravacao e a leitura em um arquivo simulando um banco de dados.
 */
public class DbOperation {

	public List<UsuarioModel> findAll() {
		List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("database.stored"));
			String linha;
			while ((linha = br.readLine()) != null) {
				usuarios.add(new Gson().fromJson(linha, UsuarioModel.class));
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return usuarios;
	}

	public void insert(UsuarioModel usuario) {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("database.stored", true));
			br.write(new Gson().toJson(usuario) + "\n");
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
