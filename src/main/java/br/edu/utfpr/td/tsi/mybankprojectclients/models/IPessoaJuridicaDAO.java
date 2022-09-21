package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;

import java.util.ArrayList;
import java.util.List;

public interface IPessoaJuridicaDAO {
    PessoaJuridica criar(PessoaJuridica pessoa) throws InternalErrorException;
    void atualizar(int id, PessoaJuridica pessoa) throws InternalErrorException;
    ArrayList<PessoaJuridica> buscar() throws InternalErrorException;
    List<PessoaJuridica> buscar(int id) throws InternalErrorException;
    List<PessoaJuridica> buscar(String name) throws InternalErrorException;
    List<PessoaJuridica> buscarPorCnpj(String cnpj) throws InternalErrorException;
    void remover(int id) throws InternalErrorException;
}
