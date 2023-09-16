/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Credencial {
    private String email;
    private String  senha;
    private Boolean administrador;
    private Pessoa pessoa;
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Credencial(){
        administrador = false;
    }

    public Credencial(String email, String senha, Boolean administrador, Pessoa pessoa) throws Exception{
        if(senha.length()>12){
            throw new Exception("A senha não pode ter mais de 12 caracteres.\n");
        }
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
        this.pessoa = pessoa;
    }

    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception{
        if(senha.length()>12){
            throw new Exception("A senha precisa ter no maximo 12 caracteres.\n");
        }
        this.senha = senha;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "Credencial: " + email + ", '" + senha + "', " + (administrador ? "Administrador" : "Usuário Geral") + '\n';
    }
    //</editor-fold>   
}
