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
public class Telefone {
    private Byte ddd;
    private Integer numero;
    private Boolean celular;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Telefone() {
    }

    public Telefone(Byte ddd, Integer numero, Boolean celular) {
        this.ddd = ddd;
        this.numero = numero;
        this.celular = celular;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return "(" + ddd + ") " + (!celular ? String.format("%04d-%04d",  (numero / 1_0000) % 1_0000, numero % 1_0000) : String.format("%03d-%03d-%03d",  numero/ 1000000, (numero / 1_000) % 1_000, numero % 1_000));
    }
    //</editor-fold>
    
}
