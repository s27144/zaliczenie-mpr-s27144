package com.s27144.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BankApplication {

	public BankApplication()
	{
		System.out.println("Testowy print");
	}

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
}
