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
public class Endereco {
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private Integer cep;
    
    public enum TipoLogradouro {
        AVENIDA("AVENIDA"), PRACA("PRACA"), RUA("RUA"), OUTRO("OUTRO");
        
        private final String logradouro;
        
        private TipoLogradouro(String logradouro){
            this.logradouro = logradouro;
        }
        
        public String getLogradouro(){
            return logradouro;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Endereco() {
    }

    public Endereco(TipoLogradouro tipoLogradouro, String logradouro, Integer numero, String bairro, Integer cep) throws Exception{
        if(logradouro.length()>255){
            throw new Exception("O logradouro não pode ter mais de 255 caracteres.\n");
        }
        if(bairro.length()>50){
            throw new Exception("O bairro não pode ter mais de 50 caracteres.\n");
        }
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws Exception{
        if(logradouro.length()>255){
            throw new Exception("O logradouro não pode ter mais de 255 caracteres.\n");
        }
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro(){
        
        return bairro;
    }

    public void setBairro(String bairro) throws Exception{
        if(bairro.length()>50){
            throw new Exception("O bairro não pode ter mais de 50 caracteres.\n");
        }
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }      
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString() {
        return tipoLogradouro.getLogradouro() + " " + logradouro + ", " + numero + ", " + bairro + ", "+ String.format("%02d.%03d-%03d", cep / 1_000_000, (cep / 1_000) % 1_000, cep % 1_000);
    }
    //</editor-fold>
    
}
