/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Item {
    private Integer quantidade;
    private ArrayList<Produto> produtos;

    public BigDecimal calcularTotal(){
        BigDecimal total = new BigDecimal(0);
        int i=0;
        for(Produto p : produtos){
            total = total.add(p.getPreco());
        }
        return total;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "-ITENS-\n" + "Quantidade: " + quantidade + "\nProdutos: \n" + produtos + '\n';
    }
    //</editor-fold>
    
    
    
}
