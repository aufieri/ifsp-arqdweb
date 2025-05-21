package model;

import java.io.Serializable;

public class Usuario implements Serializable  {
    private String userName;   
    private String senha;
    
 // getters e setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
 
}
