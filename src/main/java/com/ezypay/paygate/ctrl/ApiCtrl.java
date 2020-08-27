package com.ezypay.paygate.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezypay.paygate.model.SubcriptionInput;
import com.ezypay.paygate.model.SubscriptionOutput;

@RestController
public class ApiCtrl {

	private static final String DAILY = "DAILY";
	private static final String WEEKLY = "WEEKLY";
	private static final String MONTHLY = "MONTHLY";
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yyyy");

	@PostMapping(path = "/subscription")
	@ResponseBody
	SubscriptionOutput subscription(@RequestBody SubcriptionInput input)
			throws ParseException {
		SubscriptionOutput subscriptionOutput = new SubscriptionOutput();
		subscriptionOutput.setAmout(input.getAmout());
		subscriptionOutput.setSubscriptionType(input.getSubscriptionType());
		List<String> invoiceDates = new ArrayList<String>(0);
		Date startDate = sdf.parse(input.getStartDate()); //Considering dates sending dd/MM/yyyy format
		Date endDate = sdf.parse(input.getEndDate());
		switch (input.getSubscriptionType()) {
		case DAILY:
			invoiceDates = getDailyInvoiceDate(startDate, endDate, input.getStartFrom());
			break;
		case WEEKLY:
			invoiceDates = getWeeklyInvoiceDate(startDate, endDate, input.getStartFrom());
			break;
		case MONTHLY:
			invoiceDates = getMonthlyInvoiceDate(startDate, endDate, input.getStartFrom());
			break;
		default:
			break;
		}
		subscriptionOutput.setInvoiceDates(invoiceDates);
		for (String string : subscriptionOutput.getInvoiceDates()) {
			System.out.println(string);
		}
		return subscriptionOutput;
	}

	private List<String> getMonthlyInvoiceDate(Date startDate, Date endDate, Integer integer) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		List<String> dates = new ArrayList<String>(0);
		while(startCal.getTime().compareTo(endDate)<=0){
			//Not correction solution if day of month 31 and if February is one of month within start and end end 
			if(startCal.get(Calendar.DAY_OF_MONTH)==integer)
				dates.add(sdf.format(startCal.getTime()));
			startCal.add(Calendar.DAY_OF_YEAR, 1);
		}
		return dates;
	}

	private List<String> getWeeklyInvoiceDate(Date startDate, Date endDate, Integer integer) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		List<String> dates = new ArrayList<String>(0);
		while(startCal.getTime().compareTo(endDate)<=0){
			if(startCal.get(Calendar.DAY_OF_WEEK)==integer)
				dates.add(sdf.format(startCal.getTime()));
			startCal.add(Calendar.DAY_OF_YEAR, 1);
		}
		return dates;
	}

	private List<String> getDailyInvoiceDate(Date startDate, Date endDate, Integer integer) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		List<String> dates = new ArrayList<String>(0);
		while(startCal.getTime().compareTo(endDate)<=0){
			dates.add(sdf.format(startCal.getTime()));
			startCal.add(Calendar.DAY_OF_YEAR, 1);
		}
		return dates;
	}

}
