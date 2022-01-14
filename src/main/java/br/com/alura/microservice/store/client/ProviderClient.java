package br.com.alura.microservice.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.microservice.store.controller.dto.BuyItensDTO;
import br.com.alura.microservice.store.controller.dto.InfoOrderDTO;
import br.com.alura.microservice.store.controller.dto.InfoProviderDTO;

@FeignClient("provider")
public interface ProviderClient {
	
	@RequestMapping("/info/{state}")
	InfoProviderDTO getInfoByState(@PathVariable String state);

	@PostMapping("/order")
	InfoOrderDTO createOrder(List<BuyItensDTO> itens);
}
