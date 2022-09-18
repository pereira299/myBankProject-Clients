package br.edu.utfpr.td.tsi.mybankprojectclients.domains;


public class Endereco {
    private String logradouro;
    private String bairro;
    private int num;
    private String cidade;
    private String estado;
    private String complemento;

    public Endereco(String logradouro, String bairro, int num, String cidade, String estado, String complemento) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.num = num;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }


    //Getters
    public String getLogradouro() {return logradouro;}
    public String getBairro() {return bairro;}
    public int getNum() {return num;}
    public String getCidade() {return cidade;}
    public String getEstado() {return estado;}
    public String getComplemento() {return complemento;}

    //Setters
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public void setNum(int num) {this.num = num;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setEstado(String estado) {this.estado = estado;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
}
