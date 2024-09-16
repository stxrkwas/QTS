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
        Conexao con_cliente;
    
    JTable clientes;
    JScrollPane barratbl;
    JLabel Nme,Cod, Dat, Tel, Email,pTitulo, pesquisa, imagem;
    JTextField  nome,codigo, data, telefone, email, pesq;
    JFormattedTextField D2, F2;
    MaskFormatter d2, t2;
    JButton antes,depois, primeiro, ultimo, novoR,
    Gravar, Alterar, Excluir, bpesquisa, sair;

    
    public controle(){
         con_cliente = new Conexao(); //inicialização do objeto
    con_cliente.conecta(); //chama o método que conecta no java class "Conexao"

    Container tela = getContentPane();
    setTitle("Tabela 'Clientes' no ambiente Java");
    setLayout(null);
    
    Nme = new JLabel("Nome:: ");
    Cod = new JLabel("Código:: ");
    Dat = new JLabel("Data:: ");
    Tel = new JLabel("Telefone:: ");
    Email = new JLabel("Email:: ");
    pTitulo = new JLabel("Barra de pesquisa");
    pesquisa = new JLabel("Pesquisa pelo nome do cliente:: ");
    
    nome = new JTextField(70);
    codigo = new JTextField(5);
    data = new JTextField(10);
    telefone = new JTextField(13);
    email = new JTextField(100);
    pesq = new JTextField(50);
    
    antes = new JButton("Anterior");
    depois = new JButton("Posterior");
    primeiro = new JButton("Primeiro");
    ultimo = new JButton("Ultimo");
    novoR = new JButton("Novo Registro");
    Gravar = new JButton("Gravar");
    Alterar = new JButton("Alterar");
    Excluir = new JButton("Excluir");
    bpesquisa = new JButton("Pesquisar");
    sair = new JButton("Sair");
    
    /*Definindo as mascaras=====================================================*/
    try{
    d2 = new MaskFormatter("##/##/####");
    t2 = new MaskFormatter("(##)#####-####");
    
    d2.setPlaceholderCharacter('_');
    t2.setPlaceholderCharacter('_');
    
    }catch(ParseException expc){}
    
    D2 = new JFormattedTextField(d2);
    F2 = new JFormattedTextField(t2);
    /*==========================================================================*/
    
    Cod.setBounds(10,20,100,20);
    codigo.setBounds(60,20,50,20);
    
    Nme.setBounds(10,50,100,20);
    nome.setBounds(60,50,150,20);
    
    Dat.setBounds(10,80,100,20);
    data.setBounds(50,80,120,20);
    
    Tel.setBounds(10,110,100,20);
    telefone.setBounds(70,110,100,20);
    
    Email.setBounds(10,140,100,20);
    email.setBounds(50,140,150,20);
    
    antes.setBounds(10,200,100,25);
    depois.setBounds(110,200,100,25);
    primeiro.setBounds(210,200,100,25);
    ultimo.setBounds(310,200,100,25);
    
    novoR.setBounds(510,200,130,25);
    Gravar.setBounds(630,200,110,25);
    Alterar.setBounds(730,200,110,25);
    Excluir.setBounds(830,200,110,25);
    sair.setBounds(650,570,110,25);
    
    D2.setBounds(50, 80, 120, 20);
    F2.setBounds(70, 110, 100, 20);
    
    //Config da JTabel e a barra de pesquisa
    clientes = new javax.swing.JTable();
    barratbl = new javax.swing.JScrollPane();
    
    clientes.setBounds(50,250,550,200);
    barratbl.setBounds(50,250,550,200);
    
    pTitulo.setBounds(510,30,150,25);
    pesquisa.setBounds(510,50,190,25);
    pesq.setBounds(700,55,110,20);
    bpesquisa.setBounds(810,55,110,20);
    
    tela.add(clientes);
    tela.add(barratbl);
    tela.add(pTitulo);
    tela.add(pesquisa);
    tela.add(pesq);
    tela.add(bpesquisa);
    tela.add(sair);
    
    clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
    clientes.setFont(new java.awt.Font("Arial", 1, 12));
    pTitulo.setFont(new java.awt.Font("Arial", 1, 17));
    
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
    clientes.setAutoCreateRowSorter(true); //classificação ordenada da tabela
    
//=========================================================================== Botões
    sair.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            int frchar = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente fechar o programa??","Será que vem ai??",JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(frchar == 0){
             JOptionPane.showMessageDialog(null,"Obrigada pelo acesso de hoje,\n tenha um bom dia!","É hora de dar tchau ",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            }
         }
    });
    
    antes.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        
        try{
            con_cliente.resultset.previous();
            aprDados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel acessar \n o registro anterior ","Que puxa!",JOptionPane.INFORMATION_MESSAGE);
        }}
    });
    
    depois.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        
        try{
            con_cliente.resultset.next();
            aprDados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel acessar a próxima\n linha de registro"," Você viu um Rachador?",JOptionPane.INFORMATION_MESSAGE);
        }}
    });
        
    primeiro.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        
        try{
            con_cliente.resultset.first();
            aprDados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel acessar a primeira\n linha de registro","E lá vaaaamos nós!",JOptionPane.INFORMATION_MESSAGE);
        }}
    });
            
    ultimo.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        
        try{
            con_cliente.resultset.last();
            aprDados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel acessar o ultimo\n registro","Vudu é tapeação",JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null,"Dados inseridos com suceso!!","Yaba daba doo!!",JOptionPane.INFORMATION_MESSAGE);
            
            con_cliente.executaSQL("select * from tbclientes order by cod");
            preencherTabela();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao inserir os dados na tabela\n"+erro,"ah! o que que há velhinho??",JOptionPane.INFORMATION_MESSAGE);
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
            }else{
                sql = "update tbclientes set Nome = '"+Nome+"',Telefone = '"+Tel+"', Email = '"+Email+"', dt_nasc = '"+nascs+"' where cod ="+codigo.getText();
                msg= "Atualização de um registro!";
            }
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Alteração da tabela realizada\n com sucesso!!","Yaba daba doo!!",JOptionPane.INFORMATION_MESSAGE);
            
            con_cliente.executaSQL("select * from tbclientes order by cod");
            preencherTabela();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel alterar o registro selecionado","E la vaaaamos nós!",JOptionPane.INFORMATION_MESSAGE);
        }}
    });
       
        Excluir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String sql ="";
        try{
            int resp = JOptionPane.showConfirmDialog(rootPane,"Tem certeza que deseja realizar essa ação?","Esta certa(o) disso?",JOptionPane.YES_NO_CANCEL_OPTION, 3);
            if( resp == 0){
                sql = "delete from tbclientes where cod = "+codigo.getText();
            
                int excloi = con_cliente.statement.executeUpdate(sql);
                if(excloi == 1){
                    JOptionPane.showMessageDialog(null, "Dados excuidos com sucesso!!","Yaba, daba doo",JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from tbclientes order by cod");
                    con_cliente.resultset.first();
                    preencherTabela();
                    listRegistro();
            
                }else{
                    JOptionPane.showMessageDialog(null,"Operação cancelada :)", "Saída pela esquerda <- <- <- ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel excluir o registro\n Atenção!!!! Verifique se colocou o código do cliente no campo 'Código'\n "+erro,"Vudu é pra jacu",JOptionPane.INFORMATION_MESSAGE);
        }}
    });
        
        bpesquisa.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                String pesquisa = "select * from tbclientes where nome like '"+ pesq.getText()+"%'";
                con_cliente.executaSQL(pesquisa);
                
                if(con_cliente.resultset.first()){
                    preencherTabela();
                }else{
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente selecionado!","Se o Pica Pau tivesse comunicado a polícia, isso nunca teria acontecido.", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Dados não encontrados no banco!","Se o Pica Pau tivesse comunicado a polícia, isso nunca teria acontecido.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        });
        
        
        ImageIcon fundo = new ImageIcon("curinga.jpeg");
        imagem = new JLabel (fundo);
        
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
    tela.add(imagem);
    
    tela.setBackground(new Color(255,176,177));
    
    setSize(990,690);
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
       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Impossível ajustar os dados a tabela!!! \n", "Ah, O que que há velhinho??",JOptionPane.INFORMATION_MESSAGE);}
}
    
    public void listRegistro(){
    
    try{
        con_cliente.resultset.first(); //posicionando sempre no primeiro registro
        aprDados();
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Impossível ajustar os dados a tabela!!! \n", "Ah, O que que há velhinho??",JOptionPane.INFORMATION_MESSAGE);
    }
    }
    
    public void aprDados(){
    try{
        nome.setText(con_cliente.resultset.getString("nome"));
        codigo.setText(con_cliente.resultset.getString("cod"));
        data.setText(con_cliente.resultset.getString("dt_nasc"));
        telefone.setText(con_cliente.resultset.getString("telefone"));
        email.setText(con_cliente.resultset.getString("email"));
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados","Muttley, faça alguma coisa!!",JOptionPane.INFORMATION_MESSAGE);
        
    }}
}