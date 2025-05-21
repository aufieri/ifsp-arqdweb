package pe.dux.ifsp.dao;

import java.util.ArrayList;

import pe.dux.ifsp.model.Livro;

public class DAOLivro {
	private static DAOLivro instance;
	private ArrayList<Livro> listaDeLivros;

	
	private DAOLivro() {
		this.listaDeLivros = new ArrayList<Livro>();
	}
	
	public static DAOLivro getInstance() {
		if (instance == null) {
			instance = new DAOLivro();
		}
		return instance;
	}

	public ArrayList<Livro> getListaDeLivros() {
		return listaDeLivros;
	}

	public void setListaDeLivros(ArrayList<Livro> lista) {
		listaDeLivros = lista;
	}
	
	public boolean adicionarLivro(Livro T) {
		return listaDeLivros.add(T);
	}
	
	public boolean removerLivro(Livro T) {
		return listaDeLivros.remove(T);
	}
}
