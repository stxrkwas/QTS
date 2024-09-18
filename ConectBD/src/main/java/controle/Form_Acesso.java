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
    JButton Login, limpar;
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
        Password.setBounds(50,240,100,25);
    
        N_User.setBounds(50,180,300,40);
        senha.setBounds(50,270,300,45);
        Login.setBounds(90,350,100,35);
        limpar.setBounds(220,350,90,35);
    
        // Definindo a fonte dos componentes
        Titulo.setFont(new Font("Gadugi", Font.BOLD,30));
        subtitle.setFont(new Font("Gadugi", Font.PLAIN,18));
        Name.setFont(new Font("Gadugi", Font.BOLD,18));
        Password.setFont(new Font("Gadugi", Font.BOLD,18));
        N_User.setFont(new Font("Gadugi", Font.PLAIN,12));
        senha.setFont(new Font("Gadugi", Font.PLAIN,12));
        
        // Definindo a cor dos botões
        Login.setBackground(new Color(224, 188, 211));
        limpar.setBackground(new Color(224, 188, 211));
        
        // Ações executadas ao clicar no botão Login
        Login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            try{
                String pesuisa = "select * from acesso where Nome like '" +N_User.getText()+ "' && Senha like '" +senha.getText()+ "'"; 
                con_cliente.executaSQL(pesuisa);

                if(con_cliente.resultset.first()){
                    JOptionPane.showMessageDialog(null,"Seja bem-vindo(a)!","Acesso concedido.",JOptionPane.INFORMATION_MESSAGE);
                    controle acesso = new controle();
                    acesso.setVisible(true);
                    dispose();
                }
                
                else{
                    
                    JOptionPane.showMessageDialog(null, "Usuário não localizado!\nVerifique as informações digitadas nos campos ou feche o programa.",
                    "Erro!",JOptionPane.INFORMATION_MESSAGE);
                    TentAtual--;   
                        
                    if(TentAtual==0){
                        JOptionPane.showMessageDialog(null, "Verifique as informações digitadas nos campos ou feche o programa.",
                        "Última tentativa!",JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    N_User.setText("");
                    senha.setText("");
                    N_User.requestFocus();
                    
                    if(TentAtual<0){
                        JOptionPane.showMessageDialog(null, "Limite de tentativas excedido.",
                        "Programa encerrado.",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }

                }
                
            }
            
            catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel acessar ao seu cadastro\n nos registros do banco","Cadastro inválido",JOptionPane.INFORMATION_MESSAGE);
                con_cliente.desconecta();
            }}
        });
     
        // Ações executadas ao clicar no botão limpar
        limpar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               N_User.setText(null);
               senha.setText(null);
               N_User.requestFocus();
            }
        });
     
        // Definindo a cor de fundo da tela
        tela.setBackground(new Color(255, 255, 240));

        // Adicionando os componentes na tela
        tela.add(Titulo);
        tela.add(Name);
        tela.add(Password);
        tela.add(N_User);
        tela.add(senha);
        tela.add(Login);
        tela.add(limpar);
        tela.add(subtitle);
        
        // Definindo o tamanho da tela
        setSize(415,470);
        
        // Definindo a tela como visível
        setVisible(true);
        
        //
        setLocationRelativeTo(null);
    }
}
  
