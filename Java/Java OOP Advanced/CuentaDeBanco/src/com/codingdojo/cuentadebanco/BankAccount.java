package com.codingdojo.cuentadebanco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BankAccount {

	private String numeroCuenta = ""; // Número de cuenta del usuario
	private double saldoCCorriente = 0; // Saldo de Cuenta Corriente
	private double saldoCAhorros = 0; // Saldo de Cuenta de Ahorros
	private static int cuentasCreadas = 0; // Cantidad de cuentas generadas
	private static int saldoCuenta = 0; // Saldo total de todas las cuentas disponibles

	public BankAccount() {
		super();
		generarNCuenta();
		cuentasCreadas++;

	}

	private String generarNCuenta() {

		// Método privado para generar un número aleatorio de 10 dígitos sin repetición.
		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			digits.add(i);
		}

		Collections.shuffle(digits);

		long randomNumber = 0;
		for (int i = 0; i < 10; i++) {
			randomNumber = randomNumber * 10 + digits.get(i);
			numeroCuenta = "" + randomNumber;
		}

		return numeroCuenta;
	}

	public void depositarSaldo(Scanner scanner) {

		// Método para depositar montos en cualquier cuenta.
		boolean opcionValida = false;

		do {
			System.out.println("¿Cuánto deseas depositar?");
			int monto = scanner.nextInt();
			System.out.println("¿A qué cuenta quieres realizar el depósito?");
			System.out.println("1. Cuenta corriente");
			System.out.println("2. Cuenta de ahorros");
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				saldoCCorriente += monto;
				saldoCuenta += monto;
				System.out.println("Se ha depositado " + "$" + monto + " en tu Cuenta Corriente.");
				opcionValida = true;
				break;
			case 2:
				saldoCAhorros += monto;
				saldoCuenta += monto;
				System.out.println("Se ha depositado " + "$" + monto + " en tu Cuenta de Ahorros.");
				opcionValida = true;
				break;
			default:
				System.out.println("Opción inválida. Seleccione una opción válida del menú.");

			}
		} while (!opcionValida);
	}

	public void consultarSaldo(Scanner scanner) {

		// Método para consultar saldo de cualquier tipo de cuenta o ambas.
		boolean opcionValida = false;

		do {
			System.out.println("¿De qué cuenta desea consultar saldo?");
			System.out.println("1. Cuenta corriente");
			System.out.println("2. Cuenta de ahorros");
			System.out.println("3. Todas mis cuentas");
			int opcioncuenta = scanner.nextInt();
			switch (opcioncuenta) {
			case 1:
				System.out.println("Su saldo actual en Cuenta Corriente es de " + "$" + getSaldoCCorriente());
				opcionValida = true;
				break;
			case 2:
				System.out.println("Su saldo actual en Cuenta de Ahorros es de " + "$" + getSaldoCAhorros());
				opcionValida = true;
				break;
			case 3:
				System.out.println("El saldo total de todas sus cuentas es de " + "$" + getSaldoCuenta());
				opcionValida = true;
				break;
			default:
				System.out.println("Opción inválida. Seleccione una opción válida del menú.");
			}
		} while (!opcionValida);
	}

	public void retirarDinero(Scanner scanner) {

		// Método para retirar dinero de cualquier tipo de cuenta.
		boolean montoPermitido = false;

		do {
			System.out.println("¿Cuánto deseas retirar?");
			int monto = scanner.nextInt();
			System.out.println("¿De qué cuenta desea retirar dinero?");
			System.out.println("1. Cuenta corriente");
			System.out.println("2. Cuenta de ahorros");
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				if (monto < saldoCCorriente) {
					saldoCCorriente -= monto;
					saldoCuenta -= monto;
					System.out.println("Se ha retirado " + "$" + monto + " de tu Cuenta Corriente.");
					montoPermitido = true;

				} else {
					System.out.println("Saldo insuficiente para realizar la transacción.");
				}

				break;
			case 2:
				if (monto < saldoCAhorros) {
					saldoCAhorros -= monto;
					saldoCuenta -= monto;
					System.out.println("Se ha retirado " + "$" + monto + " de tu Cuenta de Ahorros.");
					montoPermitido = true;

				} else {
					System.out.println("Saldo insuficiente para realizar la transacción.");
				}

				break;
			default:
				System.out.println("Opción inválida. Seleccione una opción válida del menú.");

			}
		} while (!montoPermitido);
	}

	// Getters y setters.

	public String getNumeroCuenta() {
		return "Tu número de cuenta es: " + numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldoCCorriente() {
		return saldoCCorriente;
	}

	public void setSaldoCCorriente(double saldoCCorriente) {
		this.saldoCCorriente = saldoCCorriente;
	}

	public double getSaldoCAhorros() {
		return saldoCAhorros;
	}

	public void setSaldoCAhorros(double saldoCAhorros) {
		this.saldoCAhorros = saldoCAhorros;
	}

	public static int getCuentasCreadas() {
		return cuentasCreadas;
	}

	public static void setCuentasCreadas(int cuentasCreadas) {
		BankAccount.cuentasCreadas = cuentasCreadas;
	}

	public static int getSaldoCuenta() {
		return saldoCuenta;
	}

	public static void setSaldoCuenta(int saldoCuenta) {
		BankAccount.saldoCuenta = saldoCuenta;
	}

}
