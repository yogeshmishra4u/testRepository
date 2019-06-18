package com.telenor.greetingrestapi;

import java.util.Arrays;

public enum AccountOptionsEnum {
	BUSINESS("business"),
	PERSONAL("personal");
	
	/*//business("business"),
	//personal("personal");
	
	 public final String accountName;
	 AccountOptionsEnum (String accountName){
		this.accountName = accountName;
	}*/
	private String accountName;
	private AccountOptionsEnum (String accountName){
		this.accountName = accountName;
	}
	public static AccountOptionsEnum fromValue(String accountName) {
		for (AccountOptionsEnum accountOption : values()) {
			if (accountOption.accountName.equalsIgnoreCase(accountName)) {
				return accountOption;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + accountName + ", Allowed values are " + Arrays.toString(values()));
	}
	
}
