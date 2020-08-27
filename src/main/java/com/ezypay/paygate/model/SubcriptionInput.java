package com.ezypay.paygate.model;

public class SubcriptionInput {

	private Double amout;
	private String subscriptionType;
	private Integer startFrom;
	private String startDate;
	private String endDate;

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

	public Integer getStartFrom() {
		return startFrom;
	}

	public void setStartFrom(Integer startFrom) {
		this.startFrom = startFrom;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
