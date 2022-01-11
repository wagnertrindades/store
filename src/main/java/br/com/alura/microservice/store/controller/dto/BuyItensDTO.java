package br.com.alura.microservice.store.controller.dto;

public class BuyItensDTO {
	
	private long id;
	private int amount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
