/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

import java.time.LocalDate;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class GerenciadorVendas {
    public static void main(String[] args) {
        Credencial c1 = new Credencial();
        Credencial c2 = new Credencial();
        Credencial c3 = new Credencial();
        
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();
        Pessoa p3 = new Pessoa();
        
        Endereco endereco = null;
        Telefone t = null;
        
///Pessoa 1
        try{
            p1.setNome("Ana Zaira");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        p1.setNascimento(LocalDate.of(2000,1,29));        
        
        c1.setPessoa(p1);
        c1.setAdministrador(true);
        c1.setEmail("ana.zaira@mail.com");
        try{
            c1.setSenha("asdf123");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        p1.setCredencial(c1);
        
//        ea1.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
//        try{
//            ea1.setLogradouro("A1");
//        } catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        ea1.setNumero(1000);
//        try{
//            ea1.setBairro("Santa Ana I");
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        ea1.setCep(39401111);
//        p1.AdicionarEndereco(ea1);
        
         
        try{
            endereco = new Endereco(Endereco.TipoLogradouro.RUA, "A1", 1000, "Santa Ana I", 39401111);
            p1.AdicionarEndereco(endereco);
        } catch(Exception e1){
            System.out.println(e1.getMessage());
        }
        
        try{
            endereco = new Endereco(Endereco.TipoLogradouro.RUA, "A2", 1012, "Santa Ana II", 39401112);
            p1.AdicionarEndereco(endereco);
        } catch(Exception e2){
            System.out.println(e2.getMessage());
        }
        
        t = new Telefone((byte)38,123412341);
        p1.getTelefones().add(t);
        
        System.out.println(p1.getTelefones().get(0));
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
