package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaFisicaDAO implements IPessoaFisicaDAO{
    private final List<PessoaFisica> lista;
    private static int nextId = 1;

    public PessoaFisicaDAO(){
        this.lista = new ArrayList<>();
    }

    @Override
    public PessoaFisica criar(PessoaFisica pessoa) throws InternalErrorException {
        try{
            pessoa.setId(this.nextId);
            this.lista.add(pessoa);
            nextId++;
            return pessoa;
        }catch(Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao criar pessoa fisica");
        }
    }

    @Override
    public void atualizar(int id, PessoaFisica pessoa) throws InternalErrorException{
        try{

        this.lista.stream()
                .filter(pf -> pf.getId() == id)
                .forEach(pf -> {
                    pf.setEndereco(pessoa.getEndereco() != null ? pessoa.getEndereco() : pf.getEndereco());
                    pf.setNome(pessoa.getNome() != null ? pessoa.getNome() : pf.getNome());
                    pf.setNasc(pessoa.getNasc() != null ? pessoa.getNasc() : pf.getNasc());
                });
        }catch(Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao atualizar pessoa fisica");
        }
    }

    @Override
    public List<PessoaFisica> buscar() throws InternalErrorException{
        try{
            return this.lista;
        }catch(Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao buscar pessoa fisica");
        }
    }

    @Override
    public List<PessoaFisica> buscar(int id) throws InternalErrorException{
        try{
            return this.lista.stream()
                .filter(pf -> pf.getId() == id)
                .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao buscar pessoa fisica");
        }
    }

    @Override
    public List<PessoaFisica> buscar(String name) throws InternalErrorException{
        try{

        return this.lista.stream()
                .filter(pf -> pf.getNome().equals(name))
                .collect(Collectors.toList());
        }catch(Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao buscar pessoa fisica");
        }
    }

    @Override
    public List<PessoaFisica> buscarPorCpf(String cpf) throws InternalErrorException{
        try{
            return this.lista.stream()
                .filter(pf -> pf.getCpf().equals(cpf))
                .collect(Collectors.toList());
        }catch(Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao buscar pessoa fisica");
        }
    }

    @Override
    public void remover(int id) throws InternalErrorException{
        try{
            this.lista.removeIf(pf -> pf.getId() == id);
        }catch (Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao remover pessoa fisica");
        }
    }
}
