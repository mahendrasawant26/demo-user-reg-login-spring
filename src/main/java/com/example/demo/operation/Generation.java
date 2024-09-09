package com.example.demo.operation;

import java.util.UUID;

public class Generation {
	public static String generateRandomID()
	{
		return UUID.randomUUID().toString();
	}
}
