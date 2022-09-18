package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

public class PessoaFisicaDAO implements ApplicationRunner {
    private final IPessoaFisicaDAO repository;

    public PessoaFisicaDAO(IPessoaFisicaDAO repository) {
        this.repository = repository;
    }

    @Override
    public void criar(PessoaFisica pessoa) {
        this.repository.save(pessoa);
    }

    public Optional<PessoaFisica> atualizar(int id, PessoaFisica pessoa) {
        Optional<PessoaFisica> p;
        try{
            p = this.repository.findById(id)

            return p;
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void buscar() {

    }

    @Override
    public void buscar(int id) {

    }

    @Override
    public void buscar(String name) {

    }

    @Override
    public void buscarPorCpf(String cpf) {

    }

    @Override
    public void remover(int id) {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
