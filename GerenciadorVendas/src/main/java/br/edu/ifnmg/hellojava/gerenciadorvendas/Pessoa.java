/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
    
    public BigDecimal totalCompras(){
        BigDecimal total = new BigDecimal(0);
        for(Compra c : compras){
            total = total.add(c.calcularTotal());
        }
        return total;
    }
    
    public boolean AdicionarEndereco(Endereco endereco){
        return enderecos.add(endereco);
    }
    
    public boolean AdicionarCompra(Compra compra){
        return compras.add(compra);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Pessoa() {
        enderecos = new ArrayList<>();
        telefones = new ArrayList<>();
        compras = new ArrayList<>();
        nascimento = LocalDate.of(01, Month.JANUARY, 0001);
        idade = 0;
    }
    
    public Pessoa(String nome, LocalDate nascimento) throws Exception{
        if(nome.length()>45){
            throw new Exception("O nome não pode ter mais de 45 caracteres.\n");
        }
        this.nome = nome;
        this.nascimento = nascimento;
        enderecos = new ArrayList<>();
        telefones = new ArrayList<>();
        compras = new ArrayList<>();
    }
    //</editor-fold>

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
        String s = "[";
        for(Compra cp : compras){
            s += String.format("%03d-%03d-%03d",  cp.getNotaFiscal()/ 1000000, (cp.getNotaFiscal() / 1_000) % 1_000, cp.getNotaFiscal() % 1_000);
            s +=", R$ ";
            s += cp.getTotal().setScale(2, RoundingMode.HALF_UP);
            s += "; ";
        }
        s +=']';
        return nome+", " + nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+", "+idade+" anos, "+credencial.getEmail()+", Senha: '"+credencial.getSenha()+"', "+ (credencial.getAdministrador() ? "Administrador" : "Usuário Geral")+", Endereços: "+enderecos+", Telefones: "+telefones+", Gasto Total: "+totalCompras()+", Compras: "+s;
    }
    //</editor-fold>
}
