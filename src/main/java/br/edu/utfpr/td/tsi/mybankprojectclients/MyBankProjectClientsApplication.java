package br.edu.utfpr.td.tsi.mybankprojectclients;

import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaFisicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.controllers.PessoaJuridicaController;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.Endereco;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaFisicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaJuridicaDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Calendar;

@SpringBootApplication
public class MyBankProjectClientsApplication {
    private final PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
    private final PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
    private final PessoaJuridicaController pessoaJuridica = new PessoaJuridicaController(pessoaJuridicaDAO);
    private final PessoaFisicaController pessoaFisica = new PessoaFisicaController(pessoaFisicaDAO);

    public static void main(String[] args) {
        SpringApplication.run(MyBankProjectClientsApplication.class, args);
    }


    @PostConstruct
    public void init() {
            //this.fisica();
            //this.juridica();
    }

    public void fisica() {
        //Criar uma pessoa física
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        PessoaFisica pessoa = new PessoaFisica(
                0,
                "João Silva",
                new Endereco("Rua das Flores", "Centro", 123, "São Paulo", "SP",null),
                calendar,
                'M',
                "123.456.789-10"
        );

        //save the person
        pessoa = this.pessoaFisica.criar(pessoa);
        System.out.println(pessoa);

        //Get a person
        System.out.println(this.pessoaFisica.buscar(pessoa.getId()));

        //Update a person
        pessoa.setNome("João da Silva Pereira");
        this.pessoaFisica.atualizar(pessoa.getId(), pessoa);

        //Delete a person
        this.pessoaFisica.remover(pessoa.getId());

        //Get all persons
        System.out.println(this.pessoaFisica.buscar());

    }

    public void juridica() {
        //Criar uma pessoa física
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        PessoaJuridica pessoa = new PessoaJuridica(
                0,
                "João Silva Sistemas",
                new Endereco("Rua das Flores", "Centro", 123, "São Paulo", "SP",null),
                calendar,
                'M',
                "12.345.678/0001-90",
                "Meus Sistemas"
        );
        //save the person
        pessoa = this.pessoaJuridica.criar(pessoa);
        System.out.println(pessoa);

        //Get a person
        System.out.println(this.pessoaJuridica.buscar(pessoa.getId()));

        //Update a person
        pessoa.setNome("João da Silva Pereira");
        this.pessoaJuridica.atualizar(pessoa.getId(), pessoa);

        //Delete a person
        this.pessoaJuridica.remover(pessoa.getId());

        //Get all persons
        System.out.println(this.pessoaJuridica.buscar());
    }
}
