package org.desafio_web.framework.data;

import org.desafio_web.framework.supports.Fakers;

public class UseresData {

    private static Fakers fakers = new Fakers();
    private static EncapsulationData dados = new EncapsulationData();

    public static EncapsulationData usuarioUm() {
        String email = fakers.getEmail();
        String nome = email.split("\\.")[0];
        dados.setEmail(email);
        dados.setNome(nome);
        dados.setSenha(fakers.getPassword());
        EncapsulationData usuarioUm = new EncapsulationData(dados.getEmail(), dados.getNome(), dados.getSenha(), dados.getSenha());
        return usuarioUm;
    }

    public static EncapsulationData usuarioDois() {
        String email = fakers.getEmail();
        String nome = email.split("\\.")[0];
        dados.setEmail(email);
        dados.setNome(nome);
        dados.setSenha(fakers.getPassword());
        EncapsulationData usuarioDois = new EncapsulationData(dados.getEmail(), dados.getNome(), dados.getSenha(), dados.getSenha());
        return usuarioDois;
    }
}
