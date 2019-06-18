package com.telenor.greetingrestapi.controller;

import javax.validation.constraints.Positive;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telenor.greetingrestapi.AccountOptionsConverter;
import com.telenor.greetingrestapi.AccountOptionsEnum;
import com.telenor.greetingrestapi.AccountSizeConverter;
import com.telenor.greetingrestapi.AccountSizeEnum;



@RestController("/greeting")
@Validated
public class GreetingController {
	
	 @RequestMapping(value= "/greeting", produces = {MediaType.TEXT_PLAIN_VALUE})
	   public String getGreeting(@RequestParam AccountOptionsEnum account,
		   @RequestParam (required=false) @Positive(message = "only positive Integers are allowed for user id") Integer id , 
		   @RequestParam (required=false) AccountSizeEnum type) {
		   if(account.equals(AccountOptionsEnum.PERSONAL)) {
			   if(id!=null) {
				   return "Hi, userId "+ id;
			   }else{
				   return "user id should not be null or blank";
			   }
		   }
		   if(account.equals(AccountOptionsEnum.BUSINESS)) {
			   if(type.equals(AccountSizeEnum.BIG)) {
				   return "Welcome, business user!";
			   }else if(type.equals(AccountSizeEnum.SMALL)){
				   return "Path is not yet implemented";
			   }
			   
		   }
		return "Wrong inputs";
	   }
	   @InitBinder
		public void initBinder(final WebDataBinder webdataBinder) {
			webdataBinder.registerCustomEditor(AccountOptionsEnum.class, new AccountOptionsConverter());
			webdataBinder.registerCustomEditor(AccountSizeEnum.class, new AccountSizeConverter());
		}
}
