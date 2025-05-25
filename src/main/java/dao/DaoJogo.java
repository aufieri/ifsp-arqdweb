package dao;

import java.util.ArrayList;
import model.Jogo;

public class DaoJogo {

	private static DaoJogo instance;
	private ArrayList<Jogo> listaDeJogos;

	private DaoJogo() {
		this.listaDeJogos = new ArrayList<Jogo>();

		// Dados fixos agora adicionados como registros iniciais
		listaDeJogos.add(new Jogo(
			"Marvel Spider-Man 2", 
			"Insomniac Games", 
			2023, 
			"Ação e aventura", 
			"Peter Parker e Miles Morales enfrentam novos desafios em Nova York.", 
			"Português", 
			"PlayStation 5", 
			"16 anos", 
			4.9
		));
		
		listaDeJogos.add(new Jogo(
			"GTA VI", 
			"Rockstar Games", 
			2025, 
			"Mundo Aberto", 
			"Nova geração de crimes e histórias em Vice City.", 
			"Inglês", 
			"PlayStation 5, Xbox Series X/S, PC", 
			"18 anos", 
			5.0
		));

		listaDeJogos.add(new Jogo(
			"The Witcher 3: Wild Hunt", 
			"CD Projekt Red", 
			2015, 
			"RPG", 
			"Geralt de Rívia em busca de sua filha adotiva em um mundo de fantasia.", 
			"Português", 
			"PC, PS4, Xbox One, Switch", 
			"18 anos", 
			4.8
		));
	}

	public static DaoJogo getInstance() {
		if (instance == null) {
			instance = new DaoJogo();
		}
		return instance;
	}

	public ArrayList<Jogo> getListaDeJogos() {
		return listaDeJogos;
	}

	public void setListaDeJogos(ArrayList<Jogo> lista) {
		listaDeJogos = lista;
	}

	public boolean adicionarJogo(Jogo jogo) {
		return listaDeJogos.add(jogo);
	}

	public boolean removerJogo(Jogo jogo) {
		return listaDeJogos.remove(jogo);
	}

	public Jogo buscarPorId(int id) {
		for (Jogo jogo : listaDeJogos) {
			if (jogo.getId() == id) {
				return jogo;
			}
		}
		return null;
	}

	public boolean removerPorId(int id) {
		Jogo jogo = buscarPorId(id);
		if (jogo != null) {
			return listaDeJogos.remove(jogo);
		}
		return false;
	}
}
