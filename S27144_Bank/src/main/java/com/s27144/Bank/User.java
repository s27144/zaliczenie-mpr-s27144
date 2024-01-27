package com.s27144.Bank;


public class User {

    private int id;
    private String imie;
    private String nazwisko;
    private double saldo;


    public User(int ID, double SALDO, String Imie, String Nazwisko) {
        this.id = ID;
        this.saldo = SALDO;
        this.imie = Imie;
        this.nazwisko = Nazwisko;
    }
    public void removeBalance(double usunSaldo) {

        this.saldo -= usunSaldo;
    }
    public void addBalance(double dodaneSaldo) {

        this.saldo += dodaneSaldo;
    }

    public void setId(int id) {

        this.id = id;
    }
    public int getId() {

        return id;
    }

    public void setBalance(double ustawioneSaldo) {
        this.saldo = ustawioneSaldo;
    }
    public String getImie() {

        return imie;
    }
    public String getNazwisko() {

        return nazwisko;
    }
    public double getSaldo() {

        return saldo;
    }

}