package com.gad.demo.services.manipulators;

import com.gad.demo.models.DemoMessage;
import com.gad.demo.models.ManipulatedMessage;
import org.springframework.lang.NonNull;

public interface Manipulator {
	String getRegex();

	ManipulatedMessage manipulate(@NonNull DemoMessage message);
}
