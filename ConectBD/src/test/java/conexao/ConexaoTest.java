/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 55119
 */
public class ConexaoTest {
   
    private Conexao c;
    
    public ConexaoTest() {
    
        c = new Conexao();
    }
    
    
    //estabelece a conexão com o banco antes de cada teste
    @BeforeEach
    public void setUp() {
        c = new Conexao();
        assertTrue(c.conecta(), "A conexão com o banco de dados falhou");
    }

    @AfterEach
    public void tearDown() {
        // Desconecta após cada teste
        c.desconecta();
    }
    
    /**
     * Test of conecta method, of class Conexao.
     */
    @Test
    public void testConecta() {
        boolean conectado = c.conecta();
        assertNotNull(c, "A instância de conexão não deve ser nula");
        assertNotNull(conectado, "A conexão deve ser estabelecida");
    }
    /**
     * Test of desconecta method, of class Conexao.
     */
    @Test
    public void testDesconecta() {
        boolean desconectado = c.desconecta();
        assertTrue(desconectado, "A desconexão não foi realizada com successo");
    }
    
    /**
     * Test of executaSQL method, of class Conexao.
     */
    @Test
    public void testExecutaSQL() {
        String sql = "SELECT * FROM acesso WHERE Nome LIKE ''";
        ResultSet resultSet = c.executaSQL(sql);
        assertNotNull(resultSet, "O resultado da consulta SQL não deve ser nulo");
        try{
            assertTrue(resultSet.next(),"O resultado deveria conter pelo menos uma linha");
        }
        catch(SQLException e){
        fail("Erro ao processar o ResultSet: "+ e.getMessage());
        }
    }
   
        // Teste em que ao ser executado, não encontra o usuário 'Tatiane'
    @Test
    public void testExecutaSQL2() {
        String sql = "SELECT * FROM acesso WHERE Nome LIKE 'Tatiane'";
        ResultSet resultSet = c.executaSQL(sql);
        assertNotNull(resultSet, "O resultado da consulta SQL não deve ser nulo");
        try{
            assertTrue(resultSet.next(),"O resultado da consulta deveria encontrar o usuário 'Tatiane'");
        }
        catch(SQLException e){
            fail("Erro ao processar o ResultSet: "+ e.getMessage());
        }
    }
    
    @Test
    public void testExecutaSQL3() {
        String sql = "SELECT * FROM acesso WHERE Nome LIKE 'Maria'";
        ResultSet resultSet = c.executaSQL(sql);
        assertNotNull(resultSet, "O resultado da consulta SQL não deve ser nulo");
        try{
            assertTrue(resultSet.next(),"O resultado da consulta deveria encontrar o usuário 'Maria'");
        }
        catch(SQLException e){
            fail("Erro ao processar o ResultSet: "+ e.getMessage());
        }
    }
}
