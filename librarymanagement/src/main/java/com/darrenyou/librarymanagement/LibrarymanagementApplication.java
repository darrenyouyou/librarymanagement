package com.darrenyou.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
@RestController
public class LibrarymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementApplication.class, args);
//		System.out.println("salt : " + generateSalt());
		//	salt : N6woWXGs8NFXnfLwe7XtaQ==
	}

	static String generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16]; // 16 bytes (128 bits) is a common choice
		random.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
}
