package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;

import java.util.ArrayList;

public class PessoaJuridicaDAO implements IPessoaJuridicaDAO{

    private ArrayList<PessoaJuridica> lista;

    public PessoaJuridicaDAO(){
        this.lista = new ArrayList<>();
    }


    @Override
    public void criar(PessoaJuridica pessoa) {

    }

    @Override
    public void atualizar(int id, PessoaJuridica pessoa) {

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
    public void buscarPorCnpj(String cnpj) {

    }

    @Override
    public void remover(int id) {

    }
}
