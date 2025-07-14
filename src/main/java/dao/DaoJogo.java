package dao;

import java.util.ArrayList;
import java.util.Arrays;

import model.Jogo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.List;
import java.io.*;
import java.lang.reflect.Type;



public class DaoJogo {

    private static DaoJogo instance;
    private ArrayList<Jogo> listaDeJogos;
    private final String jsonPath = "C:/data/jogos.json";

    private DaoJogo() {
    	this.listaDeJogos = carregarJogosDoArquivo();
     if (this.listaDeJogos == null ||  this.listaDeJogos.isEmpty()) {
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
            "minecraft.jpg",
            120.00, 
            false,   
            true   
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
            "gtav.png",
            250.00, 
            true,   
            false   
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
            "tw3.jpg",
            180.00, 
            true,  
            true    
        ));
        
        salvarJogosNoArquivo(listaDeJogos);
     } 
    }

    public static DaoJogo getInstance() {
        if (instance == null) {
            instance = new DaoJogo();
        }
        return instance;
    }
    
    private ArrayList<Jogo> carregarJogosDoArquivo() {
        try (Reader reader = new FileReader(jsonPath)) {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<ArrayList<Jogo>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return null;
        }
    }

    private void salvarJogosNoArquivo(ArrayList<Jogo> lista) {
        try {
            File arquivo = new File(jsonPath);
            File parentDir = arquivo.getParentFile();

            if (!parentDir.exists()) {
                boolean criada = parentDir.mkdirs();
                if (criada) {
                    System.out.println("[LOG] Pasta criada: " + parentDir.getAbsolutePath());
                } else {
                    System.out.println("[ERRO] Não foi possível criar a pasta: " + parentDir.getAbsolutePath());
                }
            }

            try (Writer writer = new FileWriter(jsonPath)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(lista, writer);
                System.out.println("[LOG] Jogos salvos com sucesso em: " + jsonPath);
            }

        } catch (IOException e) {
            System.out.println("[ERRO] Falha ao salvar JSON de jogos: " + e.getMessage());
        }
    }

    public ArrayList<Jogo> getListaDeJogos() {
        return listaDeJogos;
    }

    public void setListaDeJogos(ArrayList<Jogo> lista) {
        this.listaDeJogos = lista;
    }

    public boolean adicionarJogo(Jogo jogo) {
    	boolean sucesso = listaDeJogos.add(jogo);
        if (sucesso) salvarJogosNoArquivo(listaDeJogos);
        return sucesso;
    }

    public boolean removerJogo(Jogo jogo) {
    	  boolean sucesso = listaDeJogos.remove(jogo);
    	    if (sucesso) salvarJogosNoArquivo(listaDeJogos);
    	    return sucesso;
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
        Jogo jogoARemover = null;
        for (Jogo jogo : listaDeJogos) {
            if (jogo.getId() == id) {
                jogoARemover = jogo;
                break;
            }
        }
        if (jogoARemover != null) {
            listaDeJogos.remove(jogoARemover);
            salvarJogosNoArquivo(listaDeJogos);
            return true;
        }
        return false;
    }




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

    public ArrayList<Jogo> getJogosDestaque() {
        ArrayList<Jogo> destaques = new ArrayList<>();
        for (Jogo jogo : listaDeJogos) {
            if (jogo.isDestaque()) {
                destaques.add(jogo);
            }
        }
        return destaques;
    }

    public ArrayList<Jogo> getJogosLancamento() {
        ArrayList<Jogo> lancamentos = new ArrayList<>();
        for (Jogo jogo : listaDeJogos) {
            if (jogo.isLancamento()) {
                lancamentos.add(jogo);
            }
        }
        return lancamentos;
    }


    public boolean atualizar(Jogo jogoAtualizado) {
        for (int i = 0; i < listaDeJogos.size(); i++) {
            if (listaDeJogos.get(i).getId() == jogoAtualizado.getId()) {
                listaDeJogos.set(i, jogoAtualizado);
                salvarJogosNoArquivo(listaDeJogos);
                return true;
            }
        }
        return false;
    }
    
    
    public ArrayList<Jogo> buscarPorTituloEGenero(String termo, String[] generos) {
        ArrayList<Jogo> encontrados = new ArrayList<>();
        String termoLower = (termo != null) ? termo.toLowerCase() : "";

        ArrayList<String> generosSelecionados = new ArrayList<>();
        if (generos != null) {
            for (String g : generos) {
                generosSelecionados.add(g);
            }
        }

        for (Jogo jogo : listaDeJogos) {
            boolean matchTitulo = termoLower.isEmpty() || jogo.getTitulo().toLowerCase().contains(termoLower);
            boolean matchGenero = generosSelecionados.isEmpty() || generosSelecionados.contains(jogo.getGenero());

            if (matchTitulo && matchGenero) {
                encontrados.add(jogo);
            }
        }

        return encontrados;
    }
    
}
