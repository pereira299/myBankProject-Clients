package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaFisicaDAO implements IPessoaFisicaDAO {
    private final ArrayList<PessoaFisica> lista;
    private int nextId = 0;

    public PessoaFisicaDAO() {
        this.lista = new ArrayList<>();
    }

    @Override
    public PessoaFisica criar(PessoaFisica pessoa) {
        pessoa.setId(this.nextId);
        this.lista.add(pessoa);
        nextId++;
        return pessoa;
    }

    @Override
    public void atualizar(int id, PessoaFisica pessoa) {
        this.lista.stream()
                .filter(pf -> pf.getId() == id)
                .forEach(pf -> {
                    pf.setEndereco(pessoa.getEndereco() != null ? pessoa.getEndereco() : pf.getEndereco());
                    pf.setNome(pessoa.getNome() != null ? pessoa.getNome() : pf.getNome());
                    pf.setNasc(pessoa.getNasc() != null ? pessoa.getNasc() : pf.getNasc());
                });
    }

    @Override
    public ArrayList<PessoaFisica> buscar() {
        return this.lista;
    }

    @Override
    public List<PessoaFisica> buscar(int id) {
        return this.lista.stream()
                .filter(pf -> pf.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<PessoaFisica> buscar(String name) {
        return this.lista.stream()
                .filter(pf -> pf.getNome().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<PessoaFisica> buscarPorCpf(String cpf) {
        return this.lista.stream()
                .filter(pf -> pf.getCpf().equals(cpf))
                .collect(Collectors.toList());
    }

    @Override
    public void remover(int id) {
        this.lista.removeIf(pf -> pf.getId() == id);
    }
}
