package br.edu.utfpr.td.tsi.mybankprojectclients.domains;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column()
    String nome;

    @OneToOne(targetEntity = Endereco.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Endereco endereco;

    @Column()
    Calendar nasc;

    public Cliente(int id, String nome, Endereco endereco, Calendar nasc) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.nasc = nasc;
    }

    @Deprecated
    public Cliente() {}

    //Getters
    public int getId() {return id;}
    public String getNome() {return nome;}
    public Endereco getEndereco() {return endereco;}
    public Calendar getIdade() {return nasc;}

    //Setters
    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
    public void setIdade(Calendar nasc) {this.nasc = nasc;}
}
