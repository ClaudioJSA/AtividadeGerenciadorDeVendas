/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Compra {
    private Long notaFiscal;
    private Pessoa cliente;
    private ArrayList<Item> itens;
    
    public BigDecimal calcularTotal(){
        BigDecimal total = new BigDecimal(0);
        
        for(Item i : itens){
            total = total.add(i.calcularTotal());
        }
        return total;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Long getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Long notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "Nota Fiscal: " + new DecimalFormat("000.000.000").format(notaFiscal) + "; Cliente: " + cliente.getNome() + "; R$: " + calcularTotal().setScale(2, RoundingMode.HALF_UP) + ";" + itens+'"';
    }
    //</editor-fold>

}
