package com.code4worldpeace.capstone3.Shared.Utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.*;

@Component
public class SkuGenerator {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public String generateSku(int length) {
		
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {

		StringBuilder returnValue = new StringBuilder(length);
		
		for(int i=0; i<length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return returnValue.toString();
	}
	
}
