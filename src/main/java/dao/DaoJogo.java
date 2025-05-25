package dao;

import java.util.ArrayList;
import model.Jogo;

public class DaoJogo {

    private static DaoJogo instance;
    private ArrayList<Jogo> listaDeJogos;

    private DaoJogo() {
        this.listaDeJogos = new ArrayList<Jogo>();

        listaDeJogos.add(new Jogo(
            "Minecraft", 
            "Mojang Studios",  
            2011,              
            "Ação e Aventura", 
            "Jogo sandbox de construção e sobrevivência em mundo aberto.", 
            "Multilíngue", 
            "PC, Xbox, PlayStation, Switch, Mobile", 
            "Livre", 
            4.9,
            "minecraft.jpg"
        ));
        
        listaDeJogos.add(new Jogo(
            "GTA V", 
            "Rockstar Games", 
            2013, 
            "Mundo Aberto", 
            "Exploração e ação em Los Santos com três protagonistas.", 
            "Inglês", 
            "PC, PlayStation 3, PlayStation 4, Xbox 360, Xbox One", 
            "18 anos", 
            5.0,
            "gtav.png"
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
            4.8,
            "tw3.jpg"
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
        this.listaDeJogos = lista;
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

    // Busca pelo título (contém, case insensitive)
    public ArrayList<Jogo> buscarPorTitulo(String termo) {
        ArrayList<Jogo> resultados = new ArrayList<>();
        if (termo == null || termo.trim().isEmpty()) {
            return resultados;
        }
        termo = termo.toLowerCase();

        for (Jogo jogo : listaDeJogos) {
            if (jogo.getTitulo().toLowerCase().contains(termo)) {
                resultados.add(jogo);
            }
        }
        return resultados;
    }
}
