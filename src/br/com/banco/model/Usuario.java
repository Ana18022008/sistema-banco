package br.com.banco.model;

public class Usuario {
    private String nome;
    private String senha;
    private boolean admin;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.admin = nome.endsWith(".adm");
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Object getSenha() {
        return senha;
    }
}
