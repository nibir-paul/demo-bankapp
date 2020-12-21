package com.bankapplication.test.maven;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.bankapplication.exceptions.maven.WrongAmountException;
import com.bankapplication.maven.BankAccount;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankAccountTest {
	
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	BankAccount acc;
	
	@Before
	public void setUptestDepositUpdatesBalance(){
		acc = new BankAccount(100); 
		System.setOut(new PrintStream(outputStreamCaptor));
	} 
	
	@After
	public void tearDown(){
		acc = null;
	}
	
	@Test
	public void testDepositUpdatesBalance() throws WrongAmountException{
		acc.deposit(100);
		assertEquals(acc.getBalance(), 200);
	}
	
	@Test
	public void testDepositeNotUpdateBalance() throws WrongAmountException {
		acc.deposit(-100);
		assertEquals(acc.getBalance(), 100);
	}
	
	@Test(expected = WrongAmountException.class)
	public void testAmountGreaterThan20K() throws WrongAmountException {
		acc.deposit(21000);
	}
	
	@Test
	public void testWithdrawUpdatesBalance(){
    	acc.withdraw(30);
    	assertEquals(acc.getBalance(), 70);
    }
	
	@Test
    public void testWithdrawForAmountGreaterThanBalance() throws Exception {
		acc.withdraw(300);
	    assertEquals("Not enough balance", outputStreamCaptor.toString().trim());
    }
}
