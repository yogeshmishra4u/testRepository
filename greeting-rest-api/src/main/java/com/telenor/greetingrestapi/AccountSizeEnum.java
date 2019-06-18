package com.telenor.greetingrestapi;

import java.util.Arrays;

public enum AccountSizeEnum {
	
	BIG("big"),
	SMALL("small");
	
	/*public final String accountType;
	AccountSizeEnum (String accountType){
		this.accountType = accountType;
	}*/
	private  String accountType;
	private AccountSizeEnum (String accountType){
		this.accountType = accountType;
	}
	public static AccountSizeEnum fromValue(String accountType) {
		for (AccountSizeEnum accountTypeVal : values()) {
			if (accountTypeVal.accountType.equalsIgnoreCase(accountType)) {
				return accountTypeVal;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + accountType + ", Allowed values are " + Arrays.toString(values()));
	}
}
