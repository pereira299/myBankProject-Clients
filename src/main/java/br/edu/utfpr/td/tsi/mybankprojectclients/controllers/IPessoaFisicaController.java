package br.edu.utfpr.td.tsi.mybankprojectclients.controllers;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;

import java.util.List;

public interface IPessoaFisicaController {
    PessoaFisica criar(PessoaFisica pessoa);
    int atualizar(int id, PessoaFisica pessoa);
    int remover(int id);
    List<PessoaFisica> buscar();
    List<PessoaFisica> buscar(int id);
    List<PessoaFisica> buscar(String name);
    List<PessoaFisica> buscarPorCpf(String cpf);
}
