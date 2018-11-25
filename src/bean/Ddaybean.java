package bean;

import java.sql.Date;

public class Ddaybean {
private String id;
private int cost;
private int pay;
private int countday;
private String information;
private Date startday;
private Date endday;
private int pay2;
public int getPay2() {
	return pay2;
}
public void setPay2(int pay2) {
	this.pay2 = pay2;
}
public Date getStartday() {
	return startday;
}
public void setStartday(Date startday) {
	this.startday = startday;
}
public Date getEndday() {
	return endday;
}
public void setEndday(Date endday) {
	this.endday = endday;
}
public String getInformation() {
	return information;
}
public void setInformation(String information) {
	this.information = information;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getPay() {
	return pay;
}
public void setPay(int pay) {
	this.pay = pay;
}
public int getCountday() {
	return countday;
}
public void setCountday(int countday) {
	this.countday = countday;
}



}
