package com.gad.demo.models;

import lombok.Getter;

public class ManipulatedMessage implements DemoMessage {

	@Getter
	private final DemoMessage original;

	private final String manipulated;

	public ManipulatedMessage(DemoMessage original, String message) {
		this.original = original;
		this.manipulated = message;
	}

	@Override
	public String getMessage() {
		return manipulated;
	}
}
