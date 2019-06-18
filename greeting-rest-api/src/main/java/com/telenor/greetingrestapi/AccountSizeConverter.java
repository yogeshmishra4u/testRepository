package com.telenor.greetingrestapi;

import java.beans.PropertyEditorSupport;

public class AccountSizeConverter extends PropertyEditorSupport{

	 public void setAsText(final String text) throws IllegalArgumentException {
	        setValue(AccountSizeEnum.fromValue(text));
	    }

}
