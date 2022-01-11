package br.com.alura.microservice.store.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.store.controller.dto.BuyDTO;
import br.com.alura.microservice.store.controller.dto.InfoProviderDTO;

@Service
public class BuyService {

	public void processBuy(BuyDTO buy) {
		
		RestTemplate client = new RestTemplate();
		String state = buy.getAddress().getState();
		
		ResponseEntity<InfoProviderDTO> exchange = 
				client.exchange("http://localhost:8081/info/" + state, HttpMethod.GET, null, InfoProviderDTO.class);
		
		System.out.println(exchange.getBody().getAddress());
		
	}

}
