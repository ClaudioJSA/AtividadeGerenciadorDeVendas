/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.gerenciadorvendas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class GerenciadorVendas {
    public static void main(String[] args) {
        Credencial credencial1 = new Credencial();
        Credencial credencial2 = new Credencial();
        Credencial credencial3 = new Credencial();
        
        Pessoa cliente1 = new Pessoa();
        Pessoa cliente2 = new Pessoa();
        Pessoa cliente3 = new Pessoa();
        
        Endereco endereco = null;
        Telefone telefone = null;
        Item item = null;
        Compra compra = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        //<editor-fold defaultstate="collapsed" desc="Adição de Produtos">
        ///Abacaxi
        Produto produto = new Produto();
        try{
            produto.setNome("Abacaxi");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        produto.setPreco(BigDecimal.valueOf(1.99));
        produtos.add(produto);
        ///Banana
        produto = new Produto();
        try{
            produto.setNome("Banana");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        produto.setPreco(BigDecimal.valueOf(2.99));
        produtos.add(produto);
        ///Caqui
        produto = new Produto();
        try{
            produto.setNome("Caqui");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        produto.setPreco(BigDecimal.valueOf(3.99));
        produtos.add(produto);
        ///Damasco
        produto = new Produto();
        try{
            produto.setNome("Damasco");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        produto.setPreco(BigDecimal.valueOf(4.99));
        produtos.add(produto);
        ///Espinafre
        produto = new Produto();
        try{
            produto.setNome("Espinafre");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        produto.setPreco(BigDecimal.valueOf(1.99));
        produtos.add(produto);
        //</editor-fold>
         
        //<editor-fold defaultstate="collapsed" desc="Pessoa 1">
        try{
            cliente1.setNome("Ana Zaira"); 
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        cliente1.setNascimento(LocalDate.of(2000,1,29));
        
        credencial1.setPessoa(cliente1);
        credencial1.setAdministrador(true);
        credencial1.setEmail("ana.zaira@mail.com");
        try{
            credencial1.setSenha("asdf123");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        cliente1.setCredencial(credencial1);
        
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
            cliente1.getEnderecos().add(endereco);
        } catch(Exception e1){
            System.out.println(e1.getMessage());
        }
        
        try{
            endereco = new Endereco(Endereco.TipoLogradouro.RUA, "A2", 1012, "Santa Ana II", 39401112);
            cliente1.AdicionarEndereco(endereco);
        } catch(Exception e2){
            System.out.println(e2.getMessage());
        }
        
        telefone = new Telefone((byte)38,12341234, false);
        cliente1.getTelefones().add(telefone);
        
        compra = new Compra();
        compra.setCliente(cliente1);
        compra.setNotaFiscal(000100101L);
        item = new Item(11, produtos.get(0));
        compra.adicionarItem(item);
        
        cliente1.getCompras().add(compra);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Pessoa 2">
        try{
            cliente2.setNome("Beatriz Yana"); 
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        cliente2.setNascimento(LocalDate.of(1999,1,28));

        credencial2.setPessoa(cliente2);
        credencial2.setAdministrador(false);
        credencial2.setEmail("beatriz.yana@mail.com");
        try{
            credencial2.setSenha("123asfd");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        cliente2.setCredencial(credencial2);
        
        try{
            endereco = new Endereco(Endereco.TipoLogradouro.RUA, "B", 2022, "Santa Beatriz", 39402222);
            cliente2.getEnderecos().add(endereco);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        telefone = new Telefone((byte)38,23452345, false);
        cliente2.getTelefones().add(telefone);
        
        telefone = new Telefone((byte)38,923452345, true);
        cliente2.getTelefones().add(telefone);
        
        ///Adicionando compras
        ///Compra 1
        compra = new Compra();
        compra.setCliente(cliente2);
        compra.setNotaFiscal(000200202L);
        item = new Item(11, produtos.get(1));
        compra.adicionarItem(item);
        item = new Item(12, produtos.get(2));
        compra.adicionarItem(item);
        item = new Item(13, produtos.get(3));
        compra.adicionarItem(item);
        item = new Item(14, produtos.get(4));
        compra.adicionarItem(item);
        cliente2.getCompras().add(compra);

        ///Compra 2
        compra = new Compra();
        compra.setCliente(cliente2);
        compra.setNotaFiscal(000200212L);
        item = new Item(21, produtos.get(0));
        compra.adicionarItem(item);
        item = new Item(22, produtos.get(2));
        compra.adicionarItem(item);
        item = new Item(23, produtos.get(4));
        compra.adicionarItem(item);
        cliente2.getCompras().add(compra);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Pessoa 3">
        try{
            cliente3.setNome("Cecilia Xerxes"); 
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        cliente3.setNascimento(LocalDate.of(1998,1,27));

        credencial3.setPessoa(cliente3);
        credencial3.setAdministrador(false);
        credencial3.setEmail("cecilia.xerxes@mail.com");
        try{
            credencial3.setSenha("123123");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        cliente3.setCredencial(credencial3);
        
        try{
            endereco = new Endereco(Endereco.TipoLogradouro.RUA, "C1", 3031, "Santa Cecilia I", 39403331);
            cliente3.getEnderecos().add(endereco);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            endereco = new Endereco(Endereco.TipoLogradouro.RUA, "C2", 3032, "Santa Cecilia II", 39403332);
            cliente3.getEnderecos().add(endereco);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            endereco = new Endereco(Endereco.TipoLogradouro.RUA, "C3", 3033, "Santa Cecilia III", 39403332);
            cliente3.getEnderecos().add(endereco);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        telefone = new Telefone((byte)38,934563456, true);
        cliente3.getTelefones().add(telefone);
        
        telefone = new Telefone((byte)38,823452345, true);
        cliente3.getTelefones().add(telefone);
        
        ///Adicionando compras
        ///Compra 1
        compra = new Compra();
        compra.setCliente(cliente3);
        compra.setNotaFiscal(000300303L);
        item = new Item(33, produtos.get(0));
        compra.adicionarItem(item);
        item = new Item(32, produtos.get(2));
        compra.adicionarItem(item);
        item = new Item(31, produtos.get(3));
        compra.adicionarItem(item);
        cliente3.getCompras().add(compra);

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Exibindo dados">
        System.out.println("-PRODUTOS-");
        for(Produto p : produtos){
            System.out.println(p+"\n");
        }
        
        System.out.println("\n-CREDENCIAIS-");
        System.out.println(credencial1);
        System.out.println(credencial2);
        System.out.println(credencial3);
        
        System.out.println("\n-TELEFONES-");
        System.out.println("Cliente 1:");
        for(Telefone t: cliente1.getTelefones()){
            System.out.println(t+"\n");
        }
        System.out.println("Cliente 2:");
        for(Telefone t: cliente2.getTelefones()){
            System.out.println(t+"\n");
        }
        System.out.println("Cliente 3:");
        for(Telefone t: cliente3.getTelefones()){
            System.out.println(t+"\n");
        }
        
        System.out.println("\n-ENDERECOS-");
        System.out.println("Cliente 1:");
        for(Endereco e: cliente1.getEnderecos()){
            System.out.println(e+"\n");
        }
        System.out.println("Cliente 2:");
        for(Endereco e: cliente2.getEnderecos()){
            System.out.println(e+"\n");
        }
        System.out.println("Cliente 3:");
        for(Endereco e: cliente3.getEnderecos()){
            System.out.println(e+"\n");
        }
        
        System.out.println("\n-ITENS-");
        System.out.println("Cliente 1:");
        for(Compra p: cliente1.getCompras()){
            for(Item i:p.getItens()){
                System.out.println(i+"\n");
            }
        }
        System.out.println("Cliente 2:");
        for(Compra p: cliente2.getCompras()){
            for(Item i:p.getItens()){
                System.out.println(i+"\n");
            }
        }
        System.out.println("Cliente 3:");
        for(Compra p: cliente3.getCompras()){
            for(Item i:p.getItens()){
                System.out.println(i+"\n");
            }
        }
        
        System.out.println("\n-COMPRAS-");
        System.out.println("Cliente 1:");
        for(Compra c: cliente1.getCompras()){
            System.out.println(c+"\n");
        }
        System.out.println("Cliente 2:");
        for(Compra c: cliente2.getCompras()){
            System.out.println(c+"\n");
        }
        System.out.println("Cliente 3:");
        for(Compra c: cliente3.getCompras()){
            System.out.println(c+"\n");
        }
        
        System.out.println("\n-CLIENTES-");
        System.out.println("Cliente 1:");
        System.out.println(cliente1);
        System.out.println("\nCliente 2:");
        System.out.println(cliente2);
        System.out.println("\nCliente 3:");
        System.out.println(cliente3);
        //</editor-fold>  
    }
}
