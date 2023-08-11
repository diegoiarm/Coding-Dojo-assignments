package com.codingdojo.calculadorauno;

public class Calculator {
	private double operandOne = 10.5;
	private double operandTwo = 5.2;
	private String operator = "+";
	private double result;
	
	public void performOperation() {
        switch (operator) {
        case "+":
            result = operandOne + operandTwo;
            System.out.println("La suma de " + operandOne + " " + operator + " " + operandTwo + " es igual a " + result);
            break;
        case "-":
            result = operandOne - operandTwo;
            System.out.println("La resta de " + operandOne + " " + operator + " " + operandTwo + "es igual a " + result);

            break;
        default:
            System.out.println("Operación inválida");
    }
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
}
