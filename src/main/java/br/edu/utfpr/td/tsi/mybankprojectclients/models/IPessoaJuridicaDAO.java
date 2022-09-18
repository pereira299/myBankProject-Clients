package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;

public interface IPessoaJuridicaDAO {
    public void criar(PessoaJuridica pessoa);
    public void atualizar(int id, PessoaJuridica pessoa);
    public void buscar();
    public void buscar(int id);
    public void buscar(String name);
    public void buscarPorCnpj(String cnpj);
    public void remover(int id);
}
