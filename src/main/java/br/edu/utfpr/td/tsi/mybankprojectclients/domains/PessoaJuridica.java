package br.edu.utfpr.td.tsi.mybankprojectclients.domains;

import java.util.Calendar;

public class PessoaJuridica extends Cliente {
    String cnpj;
    String fantasia;

    public PessoaJuridica(int id, String nome, Endereco endereco, Calendar nasc, char sexo, String cnpj, String fantasia) {
        super(id, nome, endereco, nasc, sexo);
        this.cnpj = cnpj;
        this.fantasia = fantasia;
    }


    //Getters
    public String getCnpj() {return cnpj;}
    public String getFantasia() {return fantasia;}

    //Setters
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
    public void setFantasia(String fantasia) {this.fantasia = fantasia;}
}
