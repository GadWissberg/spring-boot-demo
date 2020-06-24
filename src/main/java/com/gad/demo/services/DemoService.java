package com.gad.demo.services;

import com.gad.demo.models.ManipulatedMessage;
import com.gad.demo.models.SimpleMessage;
import com.gad.demo.services.manipulators.Manipulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class DemoService {

	@Autowired
	private List<Manipulator> manipulators;

	public ManipulatedMessage handleMessage(SimpleMessage msg) throws Throwable {
		if (Optional.ofNullable(msg).isPresent() && !msg.getMessage().isEmpty()) {
			return manipulators.stream()
					.filter(manipulator -> !msg.getMessage().substring(0, 1).matches(manipulator.getRegex()))
					.findFirst()
					.orElseThrow((Supplier<Throwable>) UnknownMessageTypeException::new).manipulate(msg);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private static class UnknownMessageTypeException extends Exception {
	}
}
