package com.gad.demo.services.manipulators;

import com.gad.demo.models.DemoMessage;
import com.gad.demo.models.ManipulatedMessage;
import org.springframework.stereotype.Component;

@Component
public class TimeStampManipulator implements Manipulator {

	@Override
	public String getRegex() {
		return "[0-9]";
	}

	@Override
	public ManipulatedMessage manipulate(DemoMessage message) {
		return new ManipulatedMessage(message, message + String.valueOf(System.currentTimeMillis()));
	}
}
