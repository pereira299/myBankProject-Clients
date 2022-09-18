package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPessoaFisicaDAO extends JpaRepository<PessoaFisica, Integer> {
    public void criar(PessoaFisica pessoa);
    public void atualizar(int id, PessoaFisica pessoa);
    public void buscar();
    public void buscar(int id);
    public void buscar(String name);
    public void buscarPorCpf(String cpf);
    public void remover(int id);
}
