package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public interface IPessoaJuridicaDAO {
    PessoaJuridica criar(PessoaJuridica pessoa);
    void atualizar(int id, PessoaJuridica pessoa);
    ArrayList<PessoaJuridica> buscar();
    List<PessoaJuridica> buscar(int id);
    List<PessoaJuridica> buscar(String name);
    List<PessoaJuridica> buscarPorCnpj(String cnpj);
    void remover(int id);
}
