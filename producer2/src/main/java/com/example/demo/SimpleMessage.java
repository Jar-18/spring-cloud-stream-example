package com.example.demo;

public class SimpleMessage {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return "{value:\"" + value + "\"}";
	}
}
