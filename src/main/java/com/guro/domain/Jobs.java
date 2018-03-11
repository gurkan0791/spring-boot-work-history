package com.guro.domain;

import java.util.List;

public class Jobs {
	   private String companyName;
	   private String city;
	   private List<String> workDoneSentences;
	   
	public Jobs() {
	super();
	}
	public Jobs(String companyName, String city, List<String> workDoneSentences) {
	super();
	this.companyName = companyName;
	this.city = city;
	this.workDoneSentences = workDoneSentences;
}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getWorkDoneSentences() {
		return workDoneSentences;
	}
	public void setWorkDoneSentences(List<String> workDoneSentences) {
		this.workDoneSentences = workDoneSentences;
	}
   
}
