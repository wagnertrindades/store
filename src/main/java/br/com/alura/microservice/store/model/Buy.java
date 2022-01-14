package br.com.alura.microservice.store.model;

public class Buy {
	
	private Long orderId;
	
	private Integer preparationTime;
	
	private String destinyAddress;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(Integer preparationTime) {
		this.preparationTime = preparationTime;
	}
	
	public String getDestinyAddress() {
		return destinyAddress;
	}

	public void setDestinyAddress(String destinyAddress) {
		this.destinyAddress = destinyAddress;
	}
	
}
