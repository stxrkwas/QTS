/*Criação de uma tabela no JFrame
 *
 * Realizado por: Edna
 * Desenvolido por: Bruna
 *
 */

/*
Fontes usadas no projeto::

https://vejasp.abril.com.br/coluna/memoria/bordoes-inesqueciveis-dos-desenhos-animados
https://www.mensagenscomamor.com/frases-marcantes-pica-pau
*/


package controle;
import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import javax.swing.JOptionPane;
import conexao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel; //import para reconhecimento da tabela(JTable)
import java.sql.*;

public class controle extends JFrame{
        
    // Variável para instanciar a classe Conexao
    Conexao con_cliente;
    
    JTable clientes;
    JScrollPane barratbl;
    JLabel Nme,Cod, Dat, Tel, Email, imagem;
    JTextField  nome,codigo, data, telefone, email, pesq;
    JFormattedTextField D2, F2;
    MaskFormatter d2, t2;
    JButton antes,depois, primeiro, ultimo, novoR,
    Gravar, Alterar, Excluir, bpesquisa, sair, limpar;

    
    public controle(){
        
        con_cliente = new Conexao(); //inicialização do objeto
        con_cliente.conecta(); //chama o método que conecta no java class "Conexao"

        Container tela = getContentPane();
        setTitle("Clientes");
        setLayout(null);

        Nme = new JLabel("Nome");
        Cod = new JLabel("Código");
        Dat = new JLabel("Data");
        Tel = new JLabel("Telefone");
        Email = new JLabel("Email");
    
        nome = new JTextField(70);
        codigo = new JTextField(5);
        data = new JTextField(10);
        telefone = new JTextField(13);
        email = new JTextField(100);
        pesq = new JTextField(50);

        antes = new JButton("Anterior");
        depois = new JButton("Posterior");
        primeiro = new JButton("Primeiro");
        ultimo = new JButton("Último");
        novoR = new JButton("Novo Registro");
        Gravar = new JButton("Gravar");
        Alterar = new JButton("Alterar");
        Excluir = new JButton("Excluir");
        bpesquisa = new JButton("Pesquisar");
        //sair = new JButton("Sair");
        limpar = new JButton("Limpar");
    
        /*Definindo as mascaras=====================================================*/
        
        try{
            d2 = new MaskFormatter("##/##/####");
            t2 = new MaskFormatter("(##)#####-####");

            d2.setPlaceholderCharacter('_');
            t2.setPlaceholderCharacter('_');
        }
        
        catch(ParseException expc){}

        D2 = new JFormattedTextField(d2);
        F2 = new JFormattedTextField(t2);
        
        /*==========================================================================*/
    
        Cod.setBounds(50,100,100,25);
        Cod.setFont(new Font("Gadugi", Font.BOLD, 16));
        codigo.setBounds(110,100,50,25);

        //--------------------------------------------------------------------------//
        
        Nme.setBounds(50,140,100,25);
        Nme.setFont(new Font("Gadugi", Font.BOLD, 16));
        nome.setBounds(110,140,150,25);
        
        //-------------------------------------------------------------------------//
        
        Dat.setBounds(50,180,100,25);
        Dat.setFont(new Font("Gadugi", Font.BOLD, 16));
        data.setBounds(110,180,120,25);

        //-------------------------------------------------------------------------//

        Tel.setBounds(50,220,100,25);
        Tel.setFont(new Font("Gadugi", Font.BOLD, 16));
        telefone.setBounds(130,220,100,25);
        
        //-------------------------------------------------------------------------//

        Email.setBounds(50,260,100,25);
        Email.setFont(new Font("Gadugi", Font.BOLD, 16));
        email.setBounds(115,260,150,25);

        novoR.setBounds(50,300,135,25);
        Gravar.setBounds(205,300,100,25);
        Alterar.setBounds(325,300,100,25);
        Excluir.setBounds(445,300,100,25);
        
        antes.setBounds(120,600,100,25);
        depois.setBounds(240,600,100,25);
        primeiro.setBounds(360,600,100,25);
        ultimo.setBounds(480,600,100,25);

        //sair.setBounds(650,570,110,25);

        D2.setBounds(110, 180, 120, 25);
        F2.setBounds(130, 220, 100, 25);

        
        //Config da JTabel e a barra de pesquisa
        clientes = new javax.swing.JTable();
        barratbl = new javax.swing.JScrollPane();

        clientes.setBounds(77,360,550,200);
        barratbl.setBounds(77,360,550,200);
        
        // Barra de pesquisa
        pesq.setBounds(50,50,350,35);
        
        // Botão de pesquisa
        bpesquisa.setBounds(415,50,110,35);
        
        // Botão para limpar a pesquisa
        limpar.setBounds(545, 50, 110, 35);

        tela.add(clientes);
        tela.add(barratbl);
        tela.add(pesq);
        tela.add(bpesquisa);
        tela.add(limpar);
        //tela.add(sair);

        clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        clientes.setFont(new java.awt.Font("Gadugi", 0, 12));
    
        //JTable
        clientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][]{
            {null,null,null,null,null},
            {null,null,null,null,null},
            {null,null,null,null,null},
            {null,null,null,null,null}
        },

        new String[]{"Código","Nome","Data de nascimento","Telefone","Email"})
        {
        boolean[] canEdit = new boolean[]{
        false,false,false,false,false};

        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit[columnIndex];}
        });
    
        barratbl.setViewportView(clientes);
        clientes.setAutoCreateRowSorter(true); //classificação ordenada da tabela*/

        //=========================================================================== Botões
        /*
        sair.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                int frchar = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente fechar o programa??","Será que vem ai??",JOptionPane.YES_NO_CANCEL_OPTION);

                if(frchar == 0){
                 JOptionPane.showMessageDialog(null,"Obrigada pelo acesso de hoje,\n tenha um bom dia!","É hora de dar tchau ",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                }
             }
        });
        */
        antes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            try{
                con_cliente.resultset.previous();
                aprDados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel acessar \n o registro anterior ","Falha de acesso!",JOptionPane.INFORMATION_MESSAGE);
            }}
        });

        depois.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            try{
                con_cliente.resultset.next();
                aprDados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel acessar a próxima\n linha de registro","Falha de acesso!",JOptionPane.INFORMATION_MESSAGE);
            }}
        });
        
        primeiro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            try{
                con_cliente.resultset.first();
                aprDados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel acessar a primeira\n linha de registro","Falha de acesso!",JOptionPane.INFORMATION_MESSAGE);
            }}
        });

        ultimo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            try{
                con_cliente.resultset.last();
                aprDados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel acessar o ultimo\n registro","Falha de acesso!",JOptionPane.INFORMATION_MESSAGE);
            }}
        });

        novoR.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
           codigo.setText("");
           nome.setText("");
           email.setText("");
           telefone.setText("");
           data.setText("");
           codigo.requestFocus();
           }
        });
        
        Gravar.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                String Nome = nome.getText();
                String Email = email.getText();
                String Tel = telefone.getText();
                String nascs = data.getText();
        
                try{
                    String insert_sql = "insert into tbclientes (nome, telefone, email, dt_nasc) values('"+Nome+"','"+Tel+"','"+Email+"','"+nascs+"')";
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso!!","Gravação de dados",JOptionPane.INFORMATION_MESSAGE);

                    con_cliente.executaSQL("select * from tbclientes order by cod");
                    preencherTabela();

                }
                catch(SQLException erro){
                    JOptionPane.showMessageDialog(null,"Erro ao inserir os dados na tabela\n"+erro,"Erro de gravação.",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
   
      
        Alterar.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
            
                String Nome = nome.getText();
                String Email = email.getText();
                String Tel = telefone.getText();
                String nascs = data.getText();
                String sql;
                String msg= "";

                try{

                    if(codigo.getText().equals("")){
                        sql = "insert into tbclientes (nome, telefone, email, dt_nasc) values('"+Nome+"','"+Tel+"','"+Email+"','"+nascs+"')";

                        msg = "Inserção de um novo registro!";
                    }

                    else{
                        sql = "update tbclientes set Nome = '"+Nome+"',Telefone = '"+Tel+"', Email = '"+Email+"', dt_nasc = '"+nascs+"' where cod ="+codigo.getText();
                        msg= "Atualização de um registro!";
                    }

                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Alteração da tabela realizada\n com sucesso!!","Gravação de dados.",JOptionPane.INFORMATION_MESSAGE);

                    con_cliente.executaSQL("select * from tbclientes order by cod");
                    preencherTabela();

                }

                catch(SQLException erro){
                    JOptionPane.showMessageDialog(null,"Não foi possivel alterar o registro selecionado","Erro de gravação.",JOptionPane.INFORMATION_MESSAGE);
                }   
            }
        });
       
        Excluir.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
                
                String sql ="";
                
                try{
                    
                    int resposta = JOptionPane.showConfirmDialog(rootPane,"Tem certeza que deseja realizar essa ação?", "Esta certa(o) disso?",JOptionPane.YES_NO_CANCEL_OPTION, 3);
                    
                    if(resposta == 0){
                        sql = "delete from tbclientes where cod = "+codigo.getText();

                        int excloi = con_cliente.statement.executeUpdate(sql);
                        
                        if(excloi == 1){
                            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!!","Exclusão de dados.",JOptionPane.INFORMATION_MESSAGE);
                            con_cliente.executaSQL("select * from tbclientes order by cod");
                            con_cliente.resultset.first();
                            preencherTabela();
                            listRegistro();

                        }
                        
                        else{
                            JOptionPane.showMessageDialog(null,"Operação cancelada.", "Voltar à tela anterior.", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                
                catch(SQLException erro){
                    JOptionPane.showMessageDialog(null,"Não foi possivel excluir o registro\n Atenção!!!! Verifique se colocou o código do cliente no campo 'Código'\n "
                    +erro,"Erro de exclusão.",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        bpesquisa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String pesquisa = "select * from tbclientes where nome like '"+ pesq.getText()+"%'";
                    con_cliente.executaSQL(pesquisa);

                    if(con_cliente.resultset.first()){
                        preencherTabela();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente selecionado!",
                        "Erro de pesquisa.", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                
                catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Dados não encontrados no banco!","Erro de pesquisa.", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        limpar.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                pesq.setText(null);
                pesq.requestFocus();
                
                try{
                    String pesquisa = "select * from tbclientes where nome like '"+ pesq.getText()+"%'";
                    con_cliente.executaSQL(pesquisa);

                    if(con_cliente.resultset.first()){
                        preencherTabela();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente selecionado!",
                        "Erro de pesquisa", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                
                catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Dados não encontrados no banco!","Erro de pesquisa.", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        tela.add(Cod);
        tela.add(codigo);
        tela.add(Nme);
        tela.add(nome);
        tela.add(Dat);
        tela.add(data);
        tela.add(Tel);
        tela.add(telefone);
        tela.add(Email);
        tela.add(email);
        tela.add(antes);
        tela.add(depois);
        tela.add(primeiro);
        tela.add(ultimo);
        tela.add(novoR);
        tela.add(Gravar);
        tela.add(Alterar);
        tela.add(Excluir);

        tela.add(D2);
        tela.add(F2);

        tela.setBackground(new Color(183,213,172));

        setSize(706,705);
        setVisible(true);
        setLocationRelativeTo(null);

        con_cliente.executaSQL("select * from tbclientes order by cod");
        preencherTabela();
        listRegistro();
        
    }

    public void preencherTabela() {
        
        clientes.getColumnModel().getColumn(0).setPreferredWidth(1);
        clientes.getColumnModel().getColumn(1).setPreferredWidth(80);
        clientes.getColumnModel().getColumn(2).setPreferredWidth(20);
        clientes.getColumnModel().getColumn(3).setPreferredWidth(20);
        clientes.getColumnModel().getColumn(4).setPreferredWidth(90);
        
        DefaultTableModel modelo = (DefaultTableModel) clientes.getModel();
        modelo.setNumRows(0);
        
        try{
        
            con_cliente.resultset.beforeFirst();
            
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("cod"),
                    con_cliente.resultset.getString("nome"),
                    con_cliente.resultset.getString("dt_nasc"),
                    con_cliente.resultset.getString("telefone"),
                    con_cliente.resultset.getString("email")
                });
            }
       
        }
        
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Impossível ajustar os dados a tabela!!! \n", "Erro de ajuste!",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void listRegistro(){
    
        try{
            con_cliente.resultset.first(); //posicionando sempre no primeiro registro
            aprDados();
        }
        
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Impossível ajustar os dados a tabela!!! \n", "Erro de ajuste!",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void aprDados(){
        try{
            nome.setText(con_cliente.resultset.getString("nome"));
            codigo.setText(con_cliente.resultset.getString("cod"));
            data.setText(con_cliente.resultset.getString("dt_nasc"));
            telefone.setText(con_cliente.resultset.getString("telefone"));
            email.setText(con_cliente.resultset.getString("email"));
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados.","Erro de seleção!",JOptionPane.INFORMATION_MESSAGE);

        }
    }
}