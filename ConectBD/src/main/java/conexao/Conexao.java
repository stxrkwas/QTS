/*
 * Classe responsavel pla conexão do MySQL com 3 métodos::
*1º Abertura de conexão
*2º Fechamento de conexão
*3º Execução de comandos SQL
*/
/*
Fontes usadas no projeto::

https://vejasp.abril.com.br/coluna/memoria/bordoes-inesqueciveis-dos-desenhos-animados
*/


/*
 * Realizado por: Edna
 * Desenvolido por: Bruna
 */

package conexao;
import javax.swing.JOptionPane;
import java.sql.*; //Import sql para poder realizar os comandos SQL no Java

public class Conexao {
    //'final' na declaração do tipo da variável signnifica que essa será constante
    //nesse caso ela será consante e privada
    
final private String driver = "com.mysql.cj.jdbc.Driver"; //Definindo driver para acesso aos dados
final private String url = "jdbc:mysql://localhost/clientes"; // acesso ao banco "clientes" que anteriormente subiu-se no localhost através do MySql(XAMPP)
final private String usuario = "root"; //usuario padrão do mysql
final private String senha = ""; //senha padrão do mysql

private Connection conexao; //Variável que armazenara a conexão aberta
public Statement statement; //variável que vai executar os comandos mysql no ambiente Java
public ResultSet resultset; //variável que vai armazenar o resultado da execução de um comando SQL



//Retorna um resultado true para uma conexão bem estabelecida
public boolean conecta(){  
    boolean result = true;
    try{
        Class.forName(driver);
        conexao = DriverManager.getConnection(url,usuario,senha);
        JOptionPane.showMessageDialog(null, "Conexão estabelecida ","Cowabunga!", JOptionPane.INFORMATION_MESSAGE);
    }catch(ClassNotFoundException Driver){
        JOptionPane.showMessageDialog(null, "Driver não localizado \n Olha como você escreveu o link de acesso ao banco "+Driver,"Se o Pica Pau tivesse comunicado a polícia, isso nunca teria acontecido.",JOptionPane.INFORMATION_MESSAGE);
        result = false;
    }catch(SQLException Fonte){
        JOptionPane.showMessageDialog(null,"Fonte de dados não localizada "+Fonte,"Muttley, faça alguma coisa!", JOptionPane.INFORMATION_MESSAGE);
        result = false;
    }
     return result;
    }



//Retorna um valor true para indicar que a desconexão foi bem estabelecida.
//Verifica se a conexão não é nula e não está fechada antes de tentar fechá-la
public boolean desconecta(){
    boolean result = true;
    try {
        if(conexao!= null && !conexao.isClosed()){
        conexao.close();
        JOptionPane.showMessageDialog(null,"Conexão com o banco fechada","Saída pela direita!", JOptionPane.INFORMATION_MESSAGE);
        }
    }catch(SQLException fecha){
        JOptionPane.showMessageDialog(null, "Erro ao fechar o banco","Oh, vida… ó azar…", JOptionPane.INFORMATION_MESSAGE);
        result = false;
    }
    
    return result;
}



public ResultSet executaSQL(String sql){
    try{
        if(conexao != null && !conexao.isClosed()){
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }else{
            JOptionPane.showMessageDialog(null,"Conexão não está aberta", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }catch(SQLException execao){
        JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: "+execao,"Que puxa!", JOptionPane.INFORMATION_MESSAGE);
        resultset = null;
    }
       return resultset;

}
}