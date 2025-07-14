package model;

public class Comentario {
    private int id;
    private int idJogo;
    private int idUsuario;
    private String texto;
    private int nota;
    private String nomeUsuario;  


    // Construtor vazio
    public Comentario() {}

    // Construtor completo 
    public Comentario(int id, int idJogo, int idUsuario, String texto, int nota, String nomeUsuario) {
        this.id = id;
        this.idJogo = idJogo;
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.nota = nota;
        this.nomeUsuario = nomeUsuario; 

    }

    // Getters e Setters
    public int getIdComentario() {
        return id;
    }

    public void setIdComentario(int id) {
        this.id = id;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

}
