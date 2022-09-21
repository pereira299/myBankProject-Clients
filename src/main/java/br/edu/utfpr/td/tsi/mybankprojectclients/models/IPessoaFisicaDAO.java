package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;
import java.util.List;

public interface IPessoaFisicaDAO{
    PessoaFisica criar(PessoaFisica pessoa) throws InternalErrorException;
    void atualizar(int id, PessoaFisica pessoa) throws InternalErrorException;
    List<PessoaFisica> buscar() throws InternalErrorException;
    List<PessoaFisica> buscar(int id) throws InternalErrorException;
    List<PessoaFisica> buscar(String name) throws InternalErrorException;
    List<PessoaFisica> buscarPorCpf(String cpf) throws InternalErrorException;
    void remover(int id) throws InternalErrorException;
}
