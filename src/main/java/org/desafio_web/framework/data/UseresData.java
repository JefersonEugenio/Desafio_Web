package org.desafio_web.framework.data;

public class UseresData {

    public static EncapsulationData userJeferson() {
        EncapsulationData userJef = new EncapsulationData("jeferson@hotmail.com", "Jeferson", "1234567890", "1234567890");
        return userJef;
    }

    public static EncapsulationData userEugenio() {
        EncapsulationData userEug = new EncapsulationData("eugenio@hotmail.com", "Eugenio", "0987654321", "0987654321");
        return userEug;
    }
}
