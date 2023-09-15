/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Pessoa {
    private String nome;
    private LocalDate nascimento;
    private Byte idade;
    private ArrayList<Compra> compras;
    private ArrayList<Telefone> telefones;
    private ArrayList<Endereco> enderecos;
    private Credencial credencial;

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
        if(nome.length()>45){
            throw new Exception("O nome não pode ter mais de 45 caracteres.\n");
        }
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        idade = (byte)(LocalDate.now().getYear() - nascimento.getYear());
        if(LocalDate.now().getDayOfYear()<nascimento.getDayOfYear()){
            idade--;
        }
    }

    public Byte getIdade() {
        return idade;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "-PESSOA-\nNome: "+nome+"\nData de nascimento: " + nascimento+"\nIdade: "+idade+'\n';
    }
    //</editor-fold>
        
}
