package com.gad.demo.services.manipulators;

import com.gad.demo.models.DemoMessage;
import com.gad.demo.models.ManipulatedMessage;
import org.springframework.stereotype.Component;

@Component
public class HashCodeManipulator implements Manipulator {
	@Override
	public String getRegex() {
		return "[A-Za-z]";
	}

	@Override
	public ManipulatedMessage manipulate(DemoMessage message) {
		return new ManipulatedMessage(message, message.getMessage() + message.hashCode());
	}
}
