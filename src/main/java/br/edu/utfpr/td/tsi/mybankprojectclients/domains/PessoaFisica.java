package br.edu.utfpr.td.tsi.mybankprojectclients.domains;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Cliente {
    @Column()
    String cpf;

    public PessoaFisica(int id, String nome, Endereco endereco, Calendar nasc) {
        super(id, nome, endereco, nasc);
    }

    @Deprecated
    public PessoaFisica() {}


    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}
}
