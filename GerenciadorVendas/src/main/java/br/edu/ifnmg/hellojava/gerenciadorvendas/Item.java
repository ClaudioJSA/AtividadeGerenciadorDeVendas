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
public class Item {
    private Integer quantidade;
    private Produto produto;

    public BigDecimal calcularTotal(){
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Item() {
    }

    public Item(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProdutos() {
        return produto;
    }

    public void setProdutos(Produto produto) {
        this.produto = produto;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return  produto.getNome() + " " + quantidade + " x R$ " + produto.getPreco().setScale(2, RoundingMode.HALF_UP) +
                " = R$ " + calcularTotal().setScale(2, RoundingMode.HALF_UP);
    }
    //</editor-fold>
}
