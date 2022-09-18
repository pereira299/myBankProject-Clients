package br.edu.utfpr.td.tsi.mybankprojectclients.domains;

import java.util.Calendar;

public class Cliente {
    private int id;
    private String nome;
    private Endereco endereco;
    private Calendar nasc;
    private char sexo;

    public Cliente(int id, String nome, Endereco endereco, Calendar nasc, char sexo) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.nasc = nasc;
        this.sexo = sexo;
    }

    //Getters
    public int getId() {return id;}
    public String getNome() {return nome;}
    public Endereco getEndereco() {return endereco;}
    public Calendar getNasc() {return nasc;}
    public char getSexo() {return sexo;}

    //Setters
    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
    public void setNasc(Calendar nasc) {this.nasc = nasc;}
    public void setSexo(char sexo) {this.sexo = sexo;}
}
