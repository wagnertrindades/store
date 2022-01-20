package br.com.alura.microservice.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.alura.microservice.store.client.ProviderClient;
import br.com.alura.microservice.store.controller.dto.BuyDTO;
import br.com.alura.microservice.store.controller.dto.InfoOrderDTO;
import br.com.alura.microservice.store.controller.dto.InfoProviderDTO;
import br.com.alura.microservice.store.model.Buy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class BuyService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BuyService.class);
	
	private static final String BUY_SERVICE = "buyService";
	
	@Autowired
	private ProviderClient providerClient;
	
	@TimeLimiter(name= BUY_SERVICE)
	@CircuitBreaker(name= BUY_SERVICE, fallbackMethod= "processBuyFallback")
	@Retry(name= BUY_SERVICE)
	public Buy processBuy(BuyDTO buy) {
		
		final String state = buy.getAddress().getState();
		
		LOG.info("searching provider info of {}", state);
		InfoProviderDTO info = providerClient.getInfoByState(state);
		
		LOG.info("creating an order");
		InfoOrderDTO order = providerClient.createOrder(buy.getItens());
		
		Buy buyObject = new Buy();
		buyObject.setOrderId(order.getId());
		buyObject.setPreparationTime(order.getPreparationTime());
		buyObject.setDestinyAddress(buy.getAddress().toString());
		
		return buyObject;
	}
	
	public Buy processBuyFallback(BuyDTO buy, Exception ex) {
		LOG.info("calling processBuyFallback and returning default buy data");
		
		Buy buyFallback = new Buy();
		buyFallback.setDestinyAddress(buy.getAddress().toString());
		
		return buyFallback;
	}

}
