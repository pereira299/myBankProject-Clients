package br.edu.utfpr.td.tsi.mybankprojectclients.controllers;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;

import java.util.List;

public interface IPessoaJuridicaController {

    PessoaJuridica criar(PessoaJuridica pessoa);
    int atualizar(int id, PessoaJuridica pessoa);
    int remover(int id);
    List<PessoaJuridica> buscar();
    List<PessoaJuridica> buscar(int id);
    List<PessoaJuridica> buscar(String name);
    List<PessoaJuridica> buscarPorCnpj(String cnpj);
}
