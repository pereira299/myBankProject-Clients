package br.edu.utfpr.td.tsi.mybankprojectclients.domains;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Calendar;

@Entity
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Cliente {
    String cnpj;
    String fantasia;

    public PessoaJuridica(int id, String nome, Endereco endereco, Calendar nasc, String cnpj, String fantasia) {
        super(id, nome, endereco, nasc);
        this.cnpj = cnpj;
        this.fantasia = fantasia;
    }

    @Deprecated
    public PessoaJuridica() {}

    //Getters
    public String getCnpj() {return cnpj;}
    public String getFantasia() {return fantasia;}

    //Setters
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
    public void setFantasia(String fantasia) {this.fantasia = fantasia;}
}
