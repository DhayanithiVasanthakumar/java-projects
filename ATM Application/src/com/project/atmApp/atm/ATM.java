package com.project.atmApp.atm;

public class ATM {

	private int cusID;
	private double amount;
	private double withdrawAmount;
	private double depositAmount;
	private int balance;

	/*
	 * default constructor
	 */
	public ATM() {

	}

	public ATM(int cusID, double amount, double withdrawAmount, double depositAmount, int balance) {
		this.cusID = cusID;
		this.amount = amount;
		this.withdrawAmount = withdrawAmount;
		this.depositAmount = depositAmount;
		this.balance = balance;
	}

	/*
	 * getter and setter
	 */

	public int getCustomerID() {
		return cusID;
	}

	public void setCustomerID(int cusID) {
		this.cusID = cusID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getWithDrawAmount() {
		return withdrawAmount;
	}

	public void setWithDrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

}