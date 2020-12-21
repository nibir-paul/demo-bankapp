package com.bankapplication.maven;

import com.bankapplication.exceptions.maven.WrongAmountException;

/**
 * Creation of BankAccount class to check transactions.
 * @author NP086260
 */
public class BankAccount {
    private int balance;
    
    /**
     * A minimum bank balance of the user.
     * @param amount
     */
    public BankAccount(int amount){
        balance = amount;
    }
    
    /**
     * Returns the balance in the account of the user.
     * @return balance
     */
    public int getBalance(){
        return balance;
    }
    
    /**
     * Deposits a certain amount to bank.
     * @param amount
     */
    public void deposit(int amount) throws WrongAmountException{
    	if (amount > 20000) {
    		throw new WrongAmountException("Amount greater than 20000 can't be deposited.");
    	}
    	else if (amount >= 0) {
    		balance += amount;
    	}
    }
    
    /**
     * Withdraws a certain amount from bank.
     * @param amount
     */
    public void withdraw(int amount){
    	if (amount > balance) {
        	System.out.println("Not enough balance");
        } else {
        	balance -= amount;
        }
    }
}