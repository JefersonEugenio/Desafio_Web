package org.desafio_web.framework.data;

public class EncapsulationData {

    private String email, name, password;
    private String account;
    private String balance, transferValue;

    public EncapsulationData(String email, String name, String password, String confirmPassword) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public EncapsulationData() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(String transferValue) {
        this.transferValue = transferValue;
    }
}