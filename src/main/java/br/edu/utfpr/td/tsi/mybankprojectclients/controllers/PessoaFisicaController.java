package br.edu.utfpr.td.tsi.mybankprojectclients.controllers;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.Endereco;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.IPessoaFisicaDAO;
import br.edu.utfpr.td.tsi.mybankprojectclients.models.PessoaFisicaDAO;
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

    public PessoaFisica criar(PessoaFisica pessoa) {
        //Verifica se o CPF é válido
        if(!pessoa.getCpf().matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")) {
            System.out.println("CPF inválido");
            return null;
        }
        //Verifica se o CPF já existe
        if(this.pessoaFisicaDAO.buscarPorCpf(pessoa.getCpf()).size() > 0) {
            System.out.println("CPF já cadastrado");
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
        return this.pessoaFisicaDAO.criar(pessoa);
    }

    public int atualizar(int id, PessoaFisica pessoa) {
        if(id <= 0) {
            System.out.println("ID inválido");
            return -1;
        }
        if(pessoa == null) {
            System.out.println("Pessoa inválida");
            return -1;
        }
        this.pessoaFisicaDAO.atualizar(id, pessoa);
        return id;
    }

    public List<PessoaFisica> buscar() {
        return this.pessoaFisicaDAO.buscar();
    }

    public List<PessoaFisica> buscar(int id) {
        if(id <= 0) {
            System.out.println("ID inválido");
            return null;
        }
        return this.pessoaFisicaDAO.buscar(id);
    }

    public List<PessoaFisica> buscar(String nome) {
        if(nome == null || nome.isEmpty()) {
            System.out.println("Nome inválido");
            return null;
        }
        return this.pessoaFisicaDAO.buscar(nome);
    }

    public List<PessoaFisica> buscarPorCpf(String cpf) {
        if(cpf == null || cpf.isEmpty()) {
            System.out.println("CPF inválido");
            return null;
        }
        return this.pessoaFisicaDAO.buscarPorCpf(cpf);
    }
    public int remover(int id) {
        if(id <= 0) {
            System.out.println("ID inválido");
            return -1;
        }
        this.pessoaFisicaDAO.remover(id);
        return id;
    }

}
