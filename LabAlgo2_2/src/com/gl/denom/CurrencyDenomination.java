package com.gl.denom;
import java.util.Arrays;
import java.util.Scanner;
public class CurrencyDenomination {
private int[] currencyValue;
private int[] reverseCurrency;
private int currencyDenom;

public CurrencyDenomination() {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the size of currency denominations");
	this.currencyDenom=sc.nextInt();
	this.currencyValue=new int [this.currencyDenom];
	int denomPosition=0;
	for(int i=0;i<currencyDenom;i++) {
		denomPosition++;
		System.out.println("Enter the currency denominations value at " + denomPosition);
		this.currencyValue[i]=sc.nextInt();
	}
	
}

public void SortDesc() {
	Arrays.sort(this.currencyValue);
	this.reverseCurrency=new int[this.currencyDenom];
	for(int i=0;i<this.currencyDenom;i++) {
		this.reverseCurrency[i]=this.currencyValue[this.currencyDenom-1-i];
	}
}

public void PayCheck(int payAmount) {
	System.out.println("Your payment approach in order to give min no of notes will be");
	for(int i=0;i<this.currencyDenom;i++) {
		int count=0;
		while(payAmount>=this.reverseCurrency[i]) {
			payAmount-=this.reverseCurrency[i];
			count++;
		}
		if(count>0) {
			System.out.println(this.reverseCurrency[i] + ":" + count);	
		}
	}	
}

public static void main(String[] args) {
	CurrencyDenomination denom=new CurrencyDenomination();
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the amount you want to pay");
	int payAmount= sc.nextInt();
	denom.SortDesc();
	denom.PayCheck(payAmount);
}
}
