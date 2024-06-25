package org.desafio_web.framework.data;

import org.desafio_web.framework.supports.Fakers;

public class UseresData {

    private static Fakers fakers = new Fakers();
    private static EncapsulationData data = new EncapsulationData();

    public static EncapsulationData userOne() {
        String email = fakers.getEmail();
        String name = email.split("\\.")[0];
        data.setEmail(email);
        data.setName(name);
        data.setPassword(fakers.getPassword());
        EncapsulationData userOne = new EncapsulationData(data.getEmail(), data.getName(), data.getPassword(), data.getPassword());
        return userOne;
    }

    public static EncapsulationData userTwo() {
        String email = fakers.getEmail();
        String name = email.split("\\.")[0];
        data.setEmail(email);
        data.setName(name);
        data.setPassword(fakers.getPassword());
        EncapsulationData userTwo = new EncapsulationData(data.getEmail(), data.getName(), data.getPassword(), data.getPassword());
        return userTwo;
    }
}
