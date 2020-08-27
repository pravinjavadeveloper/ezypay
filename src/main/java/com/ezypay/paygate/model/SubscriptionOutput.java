package com.ezypay.paygate.model;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionOutput {

	private Double amout;
	private String subscriptionType;
	private List<String> invoiceDates = new ArrayList<String>(0);
	
	public void setAmout(Double amout) {
		this.amout = amout;
	}
	
	public Double getAmout() {
		return amout;
	}
	
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	
	public String getSubscriptionType() {
		return subscriptionType;
	}
	
	public void setInvoiceDates(List<String> invoiceDates) {
		this.invoiceDates = invoiceDates;
	}
	
	public List<String> getInvoiceDates() {
		return invoiceDates;
	}
	
}
