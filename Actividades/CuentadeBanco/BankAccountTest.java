package com.codingdojo.cuentadebanco;

import java.util.Scanner;

public class BankAccountTest {

	public static void main(String[] args) {

		BankAccount banco = new BankAccount();
        Scanner scanner = new Scanner(System.in);

		System.out.println(banco.getNumeroCuenta());
		banco.depositarSaldo(scanner);
		banco.consultarSaldo(scanner);
		banco.retirarDinero(scanner);
		banco.consultarSaldo(scanner);

	}

}
