/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Produto {
    private String nome;
    private BigDecimal preco;

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public String getNome(){
        return nome;
    }

    public void setNome(String nome) throws Exception{
        if(nome.length()>150){
            throw new Exception("O nome não pode ter mais de 150 caracteres.\n");
        }
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "Produto: " + nome + "R$ " + preco.setScale(2, RoundingMode.HALF_UP);
    }
    //</editor-fold>
    
    
}
