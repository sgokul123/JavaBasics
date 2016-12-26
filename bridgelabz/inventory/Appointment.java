package com.bridgelabz.inventory;

public class Appointment {
private int docId;
private String patName;
private long patMobile;
private String date;
public int getDocId() {
	return docId;
}
public void setDocId(int docId) {
	this.docId = docId;
}
public String getPatName() {
	return patName;
}
public void setPatName(String patName) {
	this.patName = patName;
}
public long getPatMobile() {
	return patMobile;
}
public void setPatMobile(long patMobile) {
	this.patMobile = patMobile;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
}