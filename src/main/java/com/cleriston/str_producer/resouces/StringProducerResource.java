package com.cleriston.str_producer.resouces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleriston.str_producer.services.StringProducerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerResource {

	private final StringProducerService producerService = new StringProducerService();
	
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody String message) {
		producerService.sendMessage(message);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
}
