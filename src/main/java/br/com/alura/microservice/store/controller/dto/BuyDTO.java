package br.com.alura.microservice.store.controller.dto;

import java.util.List;

public class BuyDTO {
	
	private List<BuyItensDTO> itens;
	private AddressDTO address;
	
	public List<BuyItensDTO> getItens() {
		return itens;
	}
	
	public void setItens(List<BuyItensDTO> itens) {
		this.itens = itens;
	}
	
	public AddressDTO getAddress() {
		return address;
	}
	
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
}
