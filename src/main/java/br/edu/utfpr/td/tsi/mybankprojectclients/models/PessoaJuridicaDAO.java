package br.edu.utfpr.td.tsi.mybankprojectclients.models;

import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaJuridicaDAO implements IPessoaJuridicaDAO{

    private final ArrayList<PessoaJuridica> lista;
    private static int nextId = 1;

    public PessoaJuridicaDAO() {
        this.lista = new ArrayList<>();
    }

    @Override
    public PessoaJuridica criar(PessoaJuridica pessoa) throws InternalErrorException{
        try{
            pessoa.setId(this.nextId);
            this.lista.add(pessoa);
            nextId++;
            return pessoa;
        }catch (Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao criar pessoa juridica");
        }
    }

    public void atualizar(int id, PessoaJuridica pessoa) throws InternalErrorException{
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
    public ArrayList<PessoaJuridica> buscar() throws InternalErrorException{
        try{
            return this.lista;
        }catch (Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao buscar pessoa juridica");
        }
    }

    @Override
    public List<PessoaJuridica> buscar(int id) throws InternalErrorException{
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
    public List<PessoaJuridica> buscar(String name) throws InternalErrorException {
        try{
            return this.lista.stream()
                .filter(pf -> pf.getNome().equals(name))
                .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao buscar pessoa juridica por nome");
        }
    }

    @Override
    public List<PessoaJuridica> buscarPorCnpj(String cnpj) throws InternalErrorException{
        try{
            return this.lista.stream()
                .filter(pf -> pf.getCnpj().equals(cnpj))
                .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao buscar pessoa juridica por cnpj");
        }
    }

    @Override
    public void remover(int id) throws InternalErrorException{
        try{
            this.lista.removeIf(pf -> pf.getId() == id);
        }catch (Exception e){
            System.out.println(e);
            throw new InternalErrorException("Erro ao remover pessoa juridica");
        }
    }
}
