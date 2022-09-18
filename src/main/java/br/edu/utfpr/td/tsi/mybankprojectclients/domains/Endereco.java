package br.edu.utfpr.td.tsi.mybankprojectclients.domains;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column()
    String logradouro;

    @Column()
    String bairro;

    @Column()
    int num;

    @Column()
    String cidade;

    @Column()
    String estado;

    @Column()
    String complemento;

    public Endereco(int id, String logradouro, String bairro, int num, String cidade, String estado, String complemento) {
        this.id = id;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.num = num;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    @Deprecated
    public Endereco() {}

    //Getters
    public int getId() {return id;}
    public String getLogradouro() {return logradouro;}
    public String getBairro() {return bairro;}
    public int getNum() {return num;}
    public String getCidade() {return cidade;}
    public String getEstado() {return estado;}
    public String getComplemento() {return complemento;}

    //Setters
    public void setId(int id) {this.id = id;}
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public void setNum(int num) {this.num = num;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setEstado(String estado) {this.estado = estado;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
}
