package dao;

import java.util.ArrayList;

import model.Jogo;

public class DaoJogo {

		private static DaoJogo instance;
		private ArrayList<Jogo> listaDeJogos;
		
		private DaoJogo() {
			this.listaDeJogos = new ArrayList<Jogo>();
		}
		
		public static DaoJogo getInstance() {
			if (instance == null) {
				instance = new DaoJogo();
			}
			return instance;
		}
		
		public ArrayList<Jogo> getListaDeJogos(){
			return listaDeJogos;
		}
		
		public void setListaDeJogos(ArrayList<Jogo> lista) {
			listaDeJogos = lista;
		}
		
		public boolean adicionarJogo(Jogo J) {
			return listaDeJogos.add(J);
		}
		
		public boolean removerJogo(Jogo J) {
			return listaDeJogos.remove(J);
		}
		
		
		
}
