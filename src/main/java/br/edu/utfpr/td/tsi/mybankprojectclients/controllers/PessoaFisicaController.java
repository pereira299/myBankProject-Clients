package br.edu.utfpr.td.tsi.mybankprojectclients.controllers;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.Endereco;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaFisicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

@Component
public class PessoaFisicaController implements IPessoaFisicaController {
    private final IPessoaFisicaDAO pessoaFisicaDAO;

    public PessoaFisicaController(IPessoaFisicaDAO pessoaFisicaDAO) {
        this.pessoaFisicaDAO = pessoaFisicaDAO;
    }

    public PessoaFisica criar(PessoaFisica pessoa) throws InternalErrorException {
        //Verifica se o CPF é válido
        if(!pessoa.getCpf().matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        //Verifica se o CPF já existe
        if(this.pessoaFisicaDAO.buscarPorCpf(pessoa.getCpf()).size() > 0) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        //Verifica se o endereço é válido
        Endereco endereco = pessoa.getEndereco();
        if(endereco == null) {
            throw new IllegalArgumentException("Endereço inválido");
        }else {
            if(endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
                throw new IllegalArgumentException("Bairro inválido");
            } else if (endereco.getNum() <= 0) {
                throw new IllegalArgumentException("Número inválido");
            } else if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
                throw new IllegalArgumentException("Cidade inválida");
            } else if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
                throw new IllegalArgumentException("Estado inválido");
            } else if (endereco.getLogradouro() == null || endereco.getLogradouro().isEmpty()) {
                throw new IllegalArgumentException("Logradouro inválido");
            }
        }
        //Verifica se a data de nascimento é válida
        if(pessoa.getNasc() == null) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
        //Verifica se possui mais de 18 anos
        Calendar now = Calendar.getInstance();
        int daysIn18Years = 365 * 18;
        if(Duration.between(pessoa.getNasc().toInstant(), now.toInstant()).toDays() < daysIn18Years) {
            throw new IllegalArgumentException("Cliente deve ter mais de 18 anos");
        }
        //Verifica se o nome é válido
        if(pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        //Verifica se o sexo é válido
        if(pessoa.getSexo() != 'M' && pessoa.getSexo() != 'F') {
            throw new IllegalArgumentException("Sexo inválido");
        }

        //Salva no banco
        try{
            return this.pessoaFisicaDAO.criar(pessoa);
        }catch (InternalErrorException e) {
            throw e;
        }
    }

    public int atualizar(int id, PessoaFisica pessoa) throws InternalErrorException {
        if(id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        if(pessoa == null) {
            throw new IllegalArgumentException("Pessoa inválida");
        }
        try{
            this.pessoaFisicaDAO.atualizar(id, pessoa);
            return id;
        }catch (InternalErrorException e) {
            throw e;
        }
    }

    public List<PessoaFisica> buscar() throws InternalErrorException {
        try{
            return this.pessoaFisicaDAO.buscar();
        }catch (InternalErrorException e) {
            throw e;
        }
    }

    public List<PessoaFisica> buscar(int id) throws InternalErrorException {
        if(id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        try{
            return this.pessoaFisicaDAO.buscar(id);
        }catch (InternalErrorException e) {
            throw e;
        }
    }

    public List<PessoaFisica> buscar(String nome) throws InternalErrorException {

        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        try{
            return this.pessoaFisicaDAO.buscar(nome);
        }catch (InternalErrorException e) {
            throw e;
        }
    }

    public List<PessoaFisica> buscarPorCpf(String cpf) throws InternalErrorException {
        if(cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF inválido");
        }
        try{
            return this.pessoaFisicaDAO.buscarPorCpf(cpf);
        }catch (InternalErrorException e) {
            throw e;
        }
    }
    public int remover(int id) throws InternalErrorException {
        if(id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        try{
            this.pessoaFisicaDAO.remover(id);
            return id;
        }catch (InternalErrorException e) {
            throw e;
        }
    }

}
