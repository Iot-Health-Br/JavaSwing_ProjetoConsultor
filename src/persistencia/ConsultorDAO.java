/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelos.Consultor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ferramentas.ConexaoBD;
import java.util.ArrayList;

public class ConsultorDAO implements IConsultorDAO{
  //Atributos
  //atributo com a classe de conexao com o banco de dados
  private Connection conexao = null;
  //Metodos
  public ConsultorDAO() throws Exception{
      conexao = ConexaoBD.getConexao();
  }
  // Metodos da interface
  @Override
  public void createConsultor(Consultor pessoa) throws Exception {
    try {
      String sql = "insert into consultor(nome,email,idconsultor) values (?, ?, ?)";
      PreparedStatement preparedStatement = conexao.prepareStatement(sql);
      // Parameters iniciar os elementos
      
      preparedStatement.setString(1, pessoa.getNome());
      preparedStatement.setString(2, pessoa.getEmail());
      preparedStatement.setString(3, pessoa.getIdconsultor());

      preparedStatement.executeUpdate();
    } 
    catch (SQLException erro) {
        //Erro do comando SQL - chave, coluna, nome da tabela, ...
        throw new Exception("SQL Erro: "+ erro.getMessage());
    } 
    catch(Exception erro){
        throw erro;
    }   
  }

  @Override
  public ArrayList<Consultor> listaDeConsultores() throws Exception {
      
      ArrayList<Consultor> listaDosConsultores = new ArrayList<Consultor>();
      String sql = "select * from consultor";
      
      try {
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Consultor pessoa = new Consultor();
                pessoa.setIdconsultor(rs.getString("idconsultor"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));      
                listaDosConsultores.add(pessoa);
            }
      } 
      catch (SQLException e) {
            e.printStackTrace();
      }
        return listaDosConsultores;
  }

}
