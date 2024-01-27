package com.s27144.Bank;

public class ReturnInfoObject {

    private int statusCode;
    private double newBalance;


    public int getStatusCode() {
        return statusCode;
    }
    public double getnewBalance() {
        return newBalance;
    }

    public ReturnInfoObject(int code, double saldo)
    {
        statusCode = code;
        newBalance = saldo;
    }


}
