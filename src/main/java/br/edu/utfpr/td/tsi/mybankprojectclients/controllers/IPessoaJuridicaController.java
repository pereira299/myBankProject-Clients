package br.edu.utfpr.td.tsi.mybankprojectclients.controllers;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;

import java.util.List;

public interface IPessoaJuridicaController {

    PessoaJuridica criar(PessoaJuridica pessoa) throws InternalErrorException;
    int atualizar(int id, PessoaJuridica pessoa) throws InternalErrorException;
    int remover(int id) throws InternalErrorException;
    List<PessoaJuridica> buscar() throws InternalErrorException;
    List<PessoaJuridica> buscar(int id) throws InternalErrorException;
    List<PessoaJuridica> buscar(String name) throws InternalErrorException;
    List<PessoaJuridica> buscarPorCnpj(String cnpj) throws InternalErrorException;
}
