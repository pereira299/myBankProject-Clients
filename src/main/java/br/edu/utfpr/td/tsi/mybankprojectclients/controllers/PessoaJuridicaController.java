package br.edu.utfpr.td.tsi.mybankprojectclients.controllers;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.Endereco;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaJuridicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

@Component
public class PessoaJuridicaController implements IPessoaJuridicaController {
    private final IPessoaJuridicaDAO pessoaJuridicaDAO;

    public PessoaJuridicaController(IPessoaJuridicaDAO pessoaJuridicaDAO) {
        this.pessoaJuridicaDAO = pessoaJuridicaDAO;
    }

    public PessoaJuridica criar(PessoaJuridica pessoa) throws InternalErrorException {
        //Verifica se o CNPJ é válido
        if(pessoa.getCnpj() == null || !pessoa.getCnpj().matches("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
        //Verifica se o CNPJ já existe return null;
        if(this.pessoaJuridicaDAO.buscarPorCnpj(pessoa.getCnpj()).size() > 0) {
            throw new IllegalArgumentException("CNPJ já cadastrado");
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
        return this.pessoaJuridicaDAO.criar(pessoa);
    }

    public int atualizar(int id, PessoaJuridica pessoa) throws InternalErrorException {
        if(id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        if(pessoa == null) {
            throw new IllegalArgumentException("Pessoa inválida");
        }
        this.pessoaJuridicaDAO.atualizar(id, pessoa);
        return id;
    }

    public List<PessoaJuridica> buscar() throws InternalErrorException {
        return this.pessoaJuridicaDAO.buscar();
    }

    public List<PessoaJuridica> buscar(int id) throws InternalErrorException {
        if(id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        return this.pessoaJuridicaDAO.buscar(id);
    }

    public List<PessoaJuridica> buscar(String nome) throws InternalErrorException {
        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        return this.pessoaJuridicaDAO.buscar(nome);
    }

    public List<PessoaJuridica> buscarPorCnpj(String cnpj) throws InternalErrorException {
        if(cnpj == null || cnpj.isEmpty()) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
        return this.pessoaJuridicaDAO.buscarPorCnpj(cnpj);
    }
    public int remover(int id) throws InternalErrorException {
        if(id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        this.pessoaJuridicaDAO.remover(id);
        return id;
    }
}
