package com.gad.demo.controllers;

import com.gad.demo.models.ManipulatedMessage;
import com.gad.demo.models.SimpleMessage;
import com.gad.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@PostMapping("/message")
	public ResponseEntity<ManipulatedMessage> message(@RequestBody SimpleMessage message) {
		ManipulatedMessage manipulatedMessage;
		ResponseEntity<ManipulatedMessage> result;
		try {
			manipulatedMessage = demoService.handleMessage(message);
			result = ResponseEntity.ok().body(manipulatedMessage);
		} catch (Throwable throwable) {
			result = ResponseEntity.badRequest().body(null);
		}
		return result;
	}

}
