package com.telenor.greetingrestapi;

import java.beans.PropertyEditorSupport;

public class AccountOptionsConverter extends PropertyEditorSupport{

	 public void setAsText(final String text) throws IllegalArgumentException {
	        setValue(AccountOptionsEnum.fromValue(text));
	    }

}
