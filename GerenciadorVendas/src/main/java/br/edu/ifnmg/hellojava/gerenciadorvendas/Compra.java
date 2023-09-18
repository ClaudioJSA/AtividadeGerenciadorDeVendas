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
    private BigDecimal total;
    
    public BigDecimal calcularTotal(){
        total = new BigDecimal(0);
        
        for(Item i : itens){
            total = total.add(i.calcularTotal());
        }
        return total;
    }
    
    public boolean adicionarItem(Item item){
        total = total.add(item.calcularTotal());
        return itens.add(item);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Compra() {
        itens = new ArrayList<>();
        total = new BigDecimal(0);
    }

    public Compra(Long notaFiscal, Pessoa cliente, ArrayList<Item> itens, BigDecimal total) {
        this.notaFiscal = notaFiscal;
        this.cliente = cliente;
        this.itens = itens;
        this.total = total;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
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
        return "Nota Fiscal: " + String.format("%03d-%03d-%03d",  notaFiscal/ 1000000, (notaFiscal / 1_000) % 1_000, notaFiscal % 1_000) + "; Cliente: " + cliente.getNome() + "; R$: " + total.setScale(2, RoundingMode.HALF_UP) + "; " + itens;
    }
    //</editor-fold>
}
