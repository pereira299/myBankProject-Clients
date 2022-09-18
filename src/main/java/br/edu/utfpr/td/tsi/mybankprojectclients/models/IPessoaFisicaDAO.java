package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;

import java.util.ArrayList;
import java.util.List;

public interface IPessoaFisicaDAO{
    PessoaFisica criar(PessoaFisica pessoa);
    void atualizar(int id, PessoaFisica pessoa);
    ArrayList<PessoaFisica> buscar();
    List<PessoaFisica> buscar(int id);
    List<PessoaFisica> buscar(String name);
    List<PessoaFisica> buscarPorCpf(String cpf);
    void remover(int id);
}
