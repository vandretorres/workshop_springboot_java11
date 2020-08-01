package com.softart.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;
	
	private OrderStatus(int i) {
		this.code = i;
	}
	
	
	// construtor de enums são privados.
	// necessario metodo public para retornar valor
	public int getCode() {
		return code;
	}
	
	
	// varre orderSTatus e retorna o status baseado no codigo inteiro fornecido
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			
			if(value.getCode() == code) {
				return  value;
			}
			
		}
		throw new IllegalArgumentException("Invalid OrderSatus Code");
	}
	
}
