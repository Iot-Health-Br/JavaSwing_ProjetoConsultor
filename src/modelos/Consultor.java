/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class Consultor {
  //Atributos
  private String idconsultor = "";
  private String nome = "";
  private String email = "";
  
  //Metodos

  public Consultor() {
  }
  public Consultor(String idconsultor, String nome, String email) {
    this.idconsultor = idconsultor;
    this.nome = nome;
    this.email = email;
  }
  public String getIdconsultor() {
    return idconsultor;
  }
  public void setIdconsultor(String idconsultor) {
    this.idconsultor = idconsultor;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  @Override
  public String toString() {
    return "Consultor{" + "idconsultor=" + idconsultor + ", nome=" + nome + ", email=" + email + '}';
  }
  
}
