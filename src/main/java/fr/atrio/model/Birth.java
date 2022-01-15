package fr.atrio.model;

public class Birth {
private int day;
private int month;
private int year;

//Default constructor
public Birth() {
	this.day=0;
	this.month=0;
	this.year=0;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

@Override
public String toString() {
	return "Birth [day=" + day + ", month=" + month + ", year=" + year + "]";
}




}
