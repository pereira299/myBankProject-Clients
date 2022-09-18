package br.edu.utfpr.td.tsi.mybankprojectclients.controllers;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.Endereco;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaJuridicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaJuridicaDAO;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

@Component
public class PessoaJuridicaController implements IPessoaJuridicaController {


    private final IPessoaJuridicaDAO pessoaJuridicaDAO;

    public PessoaJuridicaController() {
        this.pessoaJuridicaDAO = new PessoaJuridicaDAO();
    }

    public PessoaJuridica criar(PessoaJuridica pessoa) {
        //Verifica se o CNPJ é válido
        if(pessoa.getCnpj() == null || !pessoa.getCnpj().matches("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")) {
            System.out.println("CNPJ inválido");
            return null;
        }
        //Verifica se o CNPJ já existe return null;
        if(this.pessoaJuridicaDAO.buscarPorCnpj(pessoa.getCnpj()).size() > 0) {
            return null;
        }
        //Verifica se o endereço é válido
        Endereco endereco = pessoa.getEndereco();
        if(endereco == null) {
            System.out.println("Endereço inválido");
            return null;
        }else {
            if(endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
                System.out.println("Bairro inválido");
                return null;
            } else if (endereco.getNum() <= 0) {
                System.out.println("CEP inválido");
                return null;
            } else if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
                System.out.println("Cidade inválida");
                return null;
            } else if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
                System.out.println("Estado inválido");
                return null;
            } else if (endereco.getLogradouro() == null || endereco.getLogradouro().isEmpty()) {
                System.out.println("Rua inválida");
                return null;
            }
        }
        //Verifica se a data de nascimento é válida
        if(pessoa.getNasc() == null) {
            System.out.println("Data de nascimento inválida");
            return null;
        }
        //Verifica se possui mais de 18 anos
        Calendar now = Calendar.getInstance();
        int daysIn18Years = 365 * 18;
        if(Duration.between(pessoa.getNasc().toInstant(), now.toInstant()).toDays() < daysIn18Years) {
            System.out.println("Cliente deve ter mais de 18 anos");
            return null;
        }
        //Verifica se o nome é válido
        if(pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            System.out.println("Nome inválido");
            return null;
        }
        //Verifica se o sexo é válido
        if(pessoa.getSexo() != 'M' && pessoa.getSexo() != 'F') {
            System.out.println("Sexo inválido");
            return null;
        }

        //Salva no banco
        return this.pessoaJuridicaDAO.criar(pessoa);
    }

    public int atualizar(int id, PessoaJuridica pessoa) {
        if(id <= 0) {
            System.out.println("ID inválido");
            return -1;
        }
        if(pessoa == null) {
            System.out.println("Pessoa inválida");
            return -1;
        }
        this.pessoaJuridicaDAO.atualizar(id, pessoa);
        return id;
    }

    public List<PessoaJuridica> buscar() {
        return this.pessoaJuridicaDAO.buscar();
    }

    public List<PessoaJuridica> buscar(int id) {
        if(id <= 0) {
            System.out.println("ID inválido");
            return null;
        }
        return this.pessoaJuridicaDAO.buscar(id);
    }

    public List<PessoaJuridica> buscar(String nome) {
        if(nome == null || nome.isEmpty()) {
            System.out.println("Nome inválido");
            return null;
        }
        return this.pessoaJuridicaDAO.buscar(nome);
    }

    public List<PessoaJuridica> buscarPorCnpj(String cnpj) {
        if(cnpj == null || cnpj.isEmpty()) {
            System.out.println("CNPJ inválido");
            return null;
        }
        return this.pessoaJuridicaDAO.buscarPorCnpj(cnpj);
    }
    public int remover(int id) {
        if(id <= 0) {
            System.out.println("ID inválido");
            return -1;
        }
        this.pessoaJuridicaDAO.remover(id);
        return id;
    }
}
