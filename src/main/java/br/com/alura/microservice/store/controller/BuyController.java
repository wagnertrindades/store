package br.com.alura.microservice.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.store.controller.dto.BuyDTO;
import br.com.alura.microservice.store.model.Buy;
import br.com.alura.microservice.store.service.BuyService;

@RestController
@RequestMapping("/buy")
public class BuyController {
	
	@Autowired
	private BuyService buyService;
	
	@PostMapping
	private Buy processBuy(@RequestBody BuyDTO buy) {
		return buyService.processBuy(buy);
	}
}
