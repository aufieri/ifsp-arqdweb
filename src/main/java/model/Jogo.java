package model;

import java.io.Serializable;

public class Jogo implements Serializable {
	
	public static int lastId = 0;
	private int id; 
    private String titulo;
    private String desenvolvedor;
    private int anoLancamento;
    private String genero;
    private String sinopse;
    private String idioma;
    private String plataforma;
    private String classificacao;
    private double avaliacao;
    
    public Jogo() {
    	this.id = Jogo.lastId++;
    }
    
    public Jogo(String titulo, String desenvolvedor, int anoLancamento, String genero,
            String sinopse, String idioma, String plataforma, String classificacao, double avaliacao) {
    this.id = Jogo.lastId++;
    this.titulo = titulo;
    this.desenvolvedor = desenvolvedor;
    this.anoLancamento = anoLancamento;
    this.genero = genero;
    this.sinopse = sinopse;
    this.idioma = idioma;
    this.plataforma = plataforma;
    this.classificacao = classificacao;
    this.avaliacao = avaliacao;
}
    
    // getters e setters
    
    public int getId() {
        return id;
    }
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDesenvolvedor() {
		return desenvolvedor;
	}
	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public int getId() {
		return id;
	}
}