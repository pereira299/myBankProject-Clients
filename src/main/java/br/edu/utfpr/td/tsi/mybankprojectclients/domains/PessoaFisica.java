package br.edu.utfpr.td.tsi.mybankprojectclients.domains;

import java.util.Calendar;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(int id, String nome, Endereco endereco, Calendar nasc, char sexo, String cpf) {
        super(id, nome, endereco, nasc, sexo);
        this.cpf = cpf;
    }

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}
}
