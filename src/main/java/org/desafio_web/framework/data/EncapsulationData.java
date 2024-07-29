package org.desafio_web.framework.data;

public class EncapsulationData {

    private String email, nome, senha;
    private String conta;
    private String saldo, transferirValor;

    public EncapsulationData(String email, String nome, String senha, String confirmPassword) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public EncapsulationData() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getTransferirValor() {
        return transferirValor;
    }

    public void setTransferirValor(String transferirValor) {
        this.transferirValor = transferirValor;
    }
}