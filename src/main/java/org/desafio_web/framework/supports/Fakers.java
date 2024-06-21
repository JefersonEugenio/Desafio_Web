package org.desafio_web.framework.supports;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Fakers {

    private Faker faker = new Faker(new Locale("pt-BR"));
    private String email,password, value;

    public String getEmail() {
        return email = faker.internet().emailAddress();
    }

    public String getPassword() {
        return password = faker.internet().password();
    }

    public Double getValue() {
        return faker.number().randomDouble(2,0,1000);
    }

}