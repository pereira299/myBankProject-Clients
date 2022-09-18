package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaJuridicaDAO implements IPessoaJuridicaDAO{

    private final ArrayList<PessoaJuridica> lista;
    private int nextId = 0;

    public PessoaJuridicaDAO() {
        this.lista = new ArrayList<>();
    }

    @Override
    public PessoaJuridica criar(PessoaJuridica pessoa) {
        pessoa.setId(this.nextId);
        this.lista.add(pessoa);
        nextId++;
        return pessoa;
    }

    public void atualizar(int id, PessoaJuridica pessoa) {
        this.lista.stream()
                .filter(pf -> pf.getId() == id)
                .forEach(pf -> {
                    pf.setEndereco(pessoa.getEndereco() != null ? pessoa.getEndereco() : pf.getEndereco());
                    pf.setNome(pessoa.getNome() != null ? pessoa.getNome() : pf.getNome());
                    pf.setNasc(pessoa.getNasc() != null ? pessoa.getNasc() : pf.getNasc());
                });
    }

    @Override
    public ArrayList<PessoaJuridica> buscar() {
        return this.lista;
    }

    @Override
    public List<PessoaJuridica> buscar(int id) {
        return this.lista.stream()
                .filter(pf -> pf.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<PessoaJuridica> buscar(String name) {
        return this.lista.stream()
                .filter(pf -> pf.getNome().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<PessoaJuridica> buscarPorCnpj(String cnpj) {
        return this.lista.stream()
                .filter(pf -> pf.getCnpj().equals(cnpj))
                .collect(Collectors.toList());
    }

    @Override
    public void remover(int id) {
        this.lista.removeIf(pf -> pf.getId() == id);
    }
}
