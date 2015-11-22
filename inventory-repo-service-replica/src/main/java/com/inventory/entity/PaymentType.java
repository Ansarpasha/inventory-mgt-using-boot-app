package com.inventory.entity;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum PaymentType {

	CREDIT_CARD(1,"CREDIT_CARD"),
	DEBIT_CARD(2,"DEBIT_CARD"),
	NET_BANKING(3,"NET_BANKING"),
	CASH_ON_DELIVERY(4,"CASH_ON_DELIVERY");
	
	private String description;

    private int id;
    
    public static final Map<Integer, PaymentType> lookUp = new HashMap<>();

	static {
		for (PaymentType paymentType : EnumSet.allOf(PaymentType.class)) {
			lookUp.put(paymentType.getId(), paymentType);
		}
	}

	public static PaymentType get(int id) {
		return lookUp.get(id);
	}
	
    PaymentType(int id,String description){
		this.id=id;
		this.description=description;
		
	}

	public String getDescription() {
		return description;
	}
	
	public int getId() {
		return id;
	}
	
	

}
