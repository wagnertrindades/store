package br.com.alura.microservice.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.store.client.ProviderClient;
import br.com.alura.microservice.store.controller.dto.BuyDTO;
import br.com.alura.microservice.store.controller.dto.InfoOrderDTO;
import br.com.alura.microservice.store.controller.dto.InfoProviderDTO;
import br.com.alura.microservice.store.model.Buy;

@Service
public class BuyService {

	@Autowired
	private ProviderClient providerClient;
	
	public Buy processBuy(BuyDTO buy) {
		
		InfoProviderDTO info = providerClient.getInfoByState(buy.getAddress().getState());
		
		InfoOrderDTO order = providerClient.createOrder(buy.getItens());
		
		Buy buyObject = new Buy();
		buyObject.setOrderId(order.getId());
		buyObject.setPreparationTime(order.getPreparationTime());
		buyObject.setDestinyAddress(buy.getAddress().toString());
		
		return buyObject;
	}

}
