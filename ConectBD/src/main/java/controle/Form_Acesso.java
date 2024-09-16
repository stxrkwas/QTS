/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

/*Formulário para acessar a tabela "tbclientes"
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import conexao.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.sql.*;

// Imports para a adição de uma imagem:
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException; 


public class Form_Acesso extends JFrame {
    
    Conexao con_cliente;
    
    JPasswordField senha;
    JLabel Titulo, Password, Name, subtitle;
    JTextField N_User;
    JButton Login, /*close,*/ limpar;
    private int TentAtual =3;
    
    public Form_Acesso(){
    
        // Variável que instancia a classe Conexao
        con_cliente = new Conexao();
        
        // Instanciando o método conecta da classe Conexao
        con_cliente.conecta();
    
        // Título d ajanela
        setTitle("Tela para acesso ao sistema");
        
        // Painel que contém os componentes da tela
        Container tela = getContentPane();
        
        //
        setLayout(null);
    
        // Label para o título da tela
        Titulo = new JLabel("Login");
        
        // Label para o subtítulo da tela
        subtitle = new JLabel("Seja bem-vindo(a)!");
        
        // Label para o campo de senha
        Password = new JLabel("Senha");
        
        // Label para o campo de usuario
        Name = new JLabel("Nome de usuário ou email");
        
        // Jlabel que recebe a imagem 'icon'
        //img = new JLabel(icon);
    
        // Botão para realizar o login
        Login = new JButton("Entrar");
        
        // Botão para fechar a tela
        //close = new JButton("Fechar");
        
        // Botão para limpar os campos de texto
        limpar = new JButton("Limpar");
    
        // Campo de texto para inserir o nome de usuário
        N_User = new JTextField(20);
        
        // Campo de texto para inserir a senha
        senha = new JPasswordField(10);
    
        // Definindo o tamanho e as coordenadas dos componentes
        Titulo.setBounds(160,30,250,45);
        subtitle.setBounds(120,75,300,35);
        Name.setBounds(50,150,300,25);
        Password.setBounds(50,230,100,25);
    
        N_User.setBounds(50,180,300,40);
        senha.setBounds(50,260,300,45);
        Login.setBounds(90,350,100,35);
        limpar.setBounds(220,350,90,35);
        //close.setBounds(160,410,90,20);
    
        // Definindo a fonte dos componentes
        Titulo.setFont(new Font("Gadugi", Font.BOLD,30));
        subtitle.setFont(new Font("Gadugi", Font.PLAIN,18));
        Name.setFont(new Font("Gadugi", Font.BOLD,18));
        Password.setFont(new Font("Gadugi", Font.BOLD,18));
    
        Login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            try{
                String pesuisa = "select * from acesso where Nome like '" +N_User.getText()+ "' && Senha like '" +senha.getText()+ "'"; 
                con_cliente.executaSQL(pesuisa);

                if(con_cliente.resultset.first()){
                    JOptionPane.showMessageDialog(null,"Acesso concebido :))\n Seja bem vindo!!","Que coisa boaaaaaaaaaaaaaaaaaaaaaaa",JOptionPane.INFORMATION_MESSAGE);
                    controle acesso = new controle();
                    acesso.setVisible(true);
                    dispose();
                }
                
                else{
                    
                    JOptionPane.showMessageDialog(null, "Usuário não localizado!!\n \nReveja se as informações foram colocadas corretamente, ou *feche o programa*!!!!",
                    "Catapimbas Meo",JOptionPane.INFORMATION_MESSAGE);
                    TentAtual--;   
                        
                    if(TentAtual==0){
                        JOptionPane.showMessageDialog(null, "Última Tentativa!! \nReveja se as informações foram colocadas corretamente, ou *feche o programa*!!!!",
                        "Catapimbas Meo",JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    N_User.setText("");
                    senha.setText("");
                    N_User.requestFocus();

                }
                
                if(TentAtual<0){
                    JOptionPane.showMessageDialog(null, "Programa fechado\n\nMotivo-->Limites de tentaivas excedido!!!!",
                    "Saída pela Direita",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                
            }
            
            catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel acessar ao seu cadastro\n nos registros do banco","E lá vaaaamos nós!",JOptionPane.INFORMATION_MESSAGE);
                con_cliente.desconecta();
            }}
        });
    
        /*close.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               int frchar = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente fechar o programa??","Será que vem ai??",JOptionPane.YES_NO_CANCEL_OPTION);
               if(frchar == 0){
               System.exit(0);
               }
           }
        });*/
     
        limpar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               N_User.setText(null);
               senha.setText(null);
               N_User.requestFocus();
            }
        });
     
        tela.setBackground(new Color(255, 255, 240));

        tela.add(Titulo);
        tela.add(Name);
        tela.add(Password);
        tela.add(N_User);
        tela.add(senha);
        tela.add(Login);
        //tela.add(close);
        tela.add(limpar);
        tela.add(subtitle);
        

        setSize(415,500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
  
