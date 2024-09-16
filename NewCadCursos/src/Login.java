/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Malu Passo Silva
 */
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.sql.*;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.text.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {

    // Variável de conexão:
    Conexao con_cliente;
    
    // Variáveis da tela gráfica:

    // Label para a imagem, título, subtitulo, nome de usuário e senha
    JLabel fundo, titulo, subtitulo, nome_u, senha_u;
    
    // Imagem 
    ImageIcon imagem;
    
    // Campos de texto para o nome de usuário
    JTextField username;
    
    // Campo de senha
    JPasswordField usenha;
    
    // Botões
    JButton login, cadastro;
    
    public Login() {
        
        // Instanciando a classe de conexão
        con_cliente = new Conexao();
        
        // Instanciando o método de conexão com o banco
        con_cliente.conecta();
        
        // Configurações da janela:
        
        // Definindo o título da janela
        setTitle("Login");
        
        // Definindo o tamanho da tela
        setSize(755, 527);
        
        // Configurando a visibilidade da tela
        setVisible(true);
        
        // Configurando o redimensionamento da tela
        setResizable(false);
        
        // Centraliza a tela gráfica em relação à tela do dispositivo
        setLocationRelativeTo(null);
        
        // Configurando as operações padrão da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //-----------------------------------------------------------//
        
        // Criando um objeto que representa a tela do aplicativo
        Container telalogin = getContentPane(); 
        
        // Configurando o layout para ser definido manualmente
        setLayout(null);
        
        // Configurando a cor de fundo do painel
        telalogin.setBackground(new Color(255, 255, 255));
        
        //
        telalogin.setVisible(true);
        
        //----------------------------------------------------------//
       
        // Criando os objetos das labels e atribuindo textos à elas:
        titulo = new JLabel("Login");
        subtitulo = new JLabel("Olá, seja bem-vindo!");
        nome_u = new JLabel("Nome de usuário");
        senha_u = new JLabel("Senha");
        
        //Criando um objeto ícone
        ImageIcon wallpaper = new ImageIcon("/Imagens/fundo_2.png");
        
        // Atribuindo a imagem do objeto 'wallpaper' ao objeto fundo
        fundo = new JLabel(wallpaper);
        
        // Definindo as coordenadas do objeto na janela
        fundo.setBounds(0, 0, 351, 527);
        
        // Definindo a visiblidade do objeto como verdadeiro
        fundo.setVisible(true);
        
        // Adicionando o elemento a tela
        telalogin.add(fundo);
        
        //----------------------------------------------------------//
        
        // Iniciando as configurações da label 'title_lbl':
        
        // Atribuindo a fonte e o seu tamanho à JLabel 'titulo'
        titulo.setFont(new Font("Gadugi", Font.BOLD, 30)); 
        
        // Alinhando o texto da label ao centro
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Definindo a cor da fonte
        titulo.setForeground(Color.BLACK);
        
        // Definindo as coordenadas do rótulo
        titulo.setBounds(352, 25, 404, 55);
        
        // Definindo o rótulo como visível
        titulo.setVisible(true);
        
        // Adicionando o rótulo a tela
        telalogin.add(titulo);
        
        //-------------------------------------------------------------//
        
        // Atribuindo a fonte e o seu tamanho ao rótulo
        subtitulo.setFont(new Font("Gadugi", Font.PLAIN, 18));
        
        // Definindo a cor da fonte
        subtitulo.setForeground(new Color(104, 104, 104));
        
        // Alinhando o texto da label ao centro
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Definindo as coordenadas do rótulo
        subtitulo.setBounds(352, 76, 404, 25);
        
        // Definindo o rótulo como visível
        subtitulo.setVisible(true);
        
        // Adicionando o rótulo a tela
        telalogin.add(subtitulo);
        
        //-------------------------------------------------------------//
        
        //Definindo a fonte, o tamanho e o peso da label
        nome_u.setFont(new Font("Gadugi", Font.BOLD, 16));
        
        //
        nome_u.setForeground(Color.BLACK);
        
        // Alinhando o texto da label à esquerda
        nome_u.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Definindo as coordenadas do rótulo
        nome_u.setBounds(402, 181, 404, 20);
        
        // Definindo o rótulo como visível
        nome_u.setVisible(true);
        
        // Adicionando o rótulo a tela
        telalogin.add(nome_u);
        
        //--------------------------------------------------------------//
        
        // Criando um objeto de campo de texto
        username = new JTextField(50);
        
        // Definindo a fonte, seu tamanho e "peso"
        username.setFont(new Font("Gadugi", Font.PLAIN, 12));
        
        // Alinhando o texto da label à esquerda
        username.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Definindo a cor da fonte
        username.setForeground(Color.BLACK);
        
        // Definindo as coordenadas do campo de texto
        username.setBounds(402, 211, 100, 45);
        
        // Definindo o campo como visível
        username.setVisible(true);
        
        // Adicionando o campo à tela 
        telalogin.add(username);
        
        //---------------------------------------------------------------//
        
        // Definindo a fonte, seu tamanho e "peso"
        senha_u.setFont(new Font("Gadugi", Font.BOLD, 16));
        
        // Definindo a cor da fonte
        senha_u.setForeground(Color.BLACK);
        
        // Alinhando o texto da label à esquerda
        senha_u.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Definindo as coordenadas do campo de texto
        senha_u.setBounds(402, 281, 404, 20);
        
        // Definindo o campo como visível
        senha_u.setVisible(true);
        
        // Adicionando o rótulo à tela
        telalogin.add(senha_u);
        
        //----------------------------------------------------------------//
        
        // Criando um objeto do tipo campo de senha
        usenha = new JPasswordField(20);
        
        // Definindo a fonte, seu tamanho e "peso"
        usenha.setFont(new Font("Gadugi", Font.PLAIN, 12));
        
        // Definindo a cor do rótulo
        usenha.setForeground(Color.BLACK);
        
        // Alinhando o texto da label à esquerda
        usenha.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Definindo as coordenadas do rótulo
        usenha.setBounds(402, 311, 100, 45);
        
        // Definindo o rótulo como visivel
        usenha.setVisible(true);
        
        // Adicionando o rotulo a tela
        telalogin.add(senha_u);
        
        //----------------------------------------------------------------//
        
        // Criando um objeto do tipo JButton
        login = new JButton();
        
        //
        login.setText("Entrar");
        
        //
        login.setBackground(new Color(102, 0, 255));
        
        //
        login.setFont(new Font("Gadugi", Font.BOLD, 14));
        
        //
        login.setForeground(new Color(255, 255, 255));
        
        // Definindo as coordenadas do rótulo
        login.setBounds(452, 402, 50, 35);
        
        //
        login.setVisible(true);
        
        // Adicionando evento ao clicar no botão:
        login.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
                // Testar
                try{
            
                    // Procurar registro de usuario e senha que equivalem aos digitados nos campos de texto e senha:
                    String pesquisa = "select * from usuario where nome_user like '" + username.getText() +"' && senha = " + usenha.getText()+ "";
                    
                    // Executa o método de pesquisa de registros no banco de dados
                    con_cliente.executaSQL(pesquisa);
            
                    // Caso o primeiro teste seja verdadeiro, abrir a tela 'Menu' e fechar a tela de login
                    if(con_cliente.resultset.first()){
                
                        /*Menu mostra = new Menu();
                        mostra.setVisible(true);
                        dispose();*/
                    }
            
                    // Caso o primeiro teste não funcione, avisar ao usuário não está no sistema
                    else{
                        JOptionPane.showMessageDialog(null, "\n Usuário não cadastrado!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                        con_cliente.desconecta();
                        System.exit(0);
                    }
        
                }// Fim do teste
                
                // Captura de uma exceção/erro, caso os dados não sejam localizados
                catch(SQLException errosql){
                    JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados! :\n " + errosql, 
                            "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }// Fim da captura
                
            }// Fim do método público
            
        }); // Fim da ação
        
        //
        telalogin.add(login);
        
        //------------------------------------------------------------------------------------------------------------------------------------------//
        
        //
        cadastro = new JButton();
        
        //
        cadastro.setText("Cadastrar-se");
        
        //
        cadastro.setBackground(new Color(102, 0, 255));
        
        //
        cadastro.setFont(new Font("Gadugi", Font.BOLD, 16));
        
        //
        cadastro.setForeground(new Color(255, 255, 255));
        
        //
        cadastro.setBounds(482, 402, 100, 35);
        
        //
        cadastro.setVisible(true);
        
        // Adicionando ação ao clicar o botão 'cadastro'
        cadastro.addActionListener(new java.awt.event.ActionListener() {
        
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            
                //Abrir a tela de cadastro e fechar a tela de login.
                Cadastro cad = new Cadastro();
                cad.setVisible(true);
                dispose();
                
            }
            
        });
        
        //
        telalogin.add(cadastro);
        
    }
                                      
    public static void main(String args[]) {
       
        new Login();

    }
                
}

