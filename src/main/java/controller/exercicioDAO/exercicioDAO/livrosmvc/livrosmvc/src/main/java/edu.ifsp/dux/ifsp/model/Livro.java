package pe.dux.ifsp.model;

public class Livro {
	public static int lastId = 0;
	private int id; 
	private String titulo;
	private String autor;
	private String genero;
	private int anoPublicacao;
	
	public Livro() {
		this.id = Livro.lastId++;
	}
	
	public Livro(String titulo, String autor, String genero, int anoPublicacao) {
		this();
		setTitulo(titulo);
		setAutor(autor);
		setGenero(genero);
		setAnoPublicacao(anoPublicacao);
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new IllegalArgumentException("Título é obrigatório.");
		}
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor == null || autor.trim().isEmpty()) {
			throw new IllegalArgumentException("Autor é obrigatório.");
		}
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if (genero == null || genero.trim().isEmpty()) {
			throw new IllegalArgumentException("Gênero é obrigatório.");
		}
		this.genero = genero;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		if (anoPublicacao <= 0) {
			throw new IllegalArgumentException("Ano de publicação inválido.");
		}
		this.anoPublicacao = anoPublicacao;
	}

	public int getId() {
		return id;
	}	
}
