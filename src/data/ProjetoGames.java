/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

/**
 *
 * @author mathe
 */
public class ProjetoGames {

    public String codigo, nome, desenvolvedora, plataforma, texto;
    public double valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getValor() {
        return valor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void imprimir() {
        texto = "Código: " + codigo;
        texto += "Nome:" + nome;
        texto += "Desenvolvedora: " + desenvolvedora;
        texto += "Plataforma: " + plataforma;
        texto += "Valor: "+valor;
    }

}
