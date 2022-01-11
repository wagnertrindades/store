package br.com.alura.microservice.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.store.client.ProviderClient;
import br.com.alura.microservice.store.controller.dto.BuyDTO;
import br.com.alura.microservice.store.controller.dto.InfoProviderDTO;

@Service
public class BuyService {

	@Autowired
	private ProviderClient providerClient;
	
	public void processBuy(BuyDTO buy) {
		
		InfoProviderDTO info = providerClient.getInfoByState(buy.getAddress().getState());
		
		System.out.println(info.getAddress());
	}

}
