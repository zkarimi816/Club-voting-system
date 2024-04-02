package application;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CTableModal {
	private final StringProperty fullname;
	private final IntegerProperty age;
	private final StringProperty major;
	private final DoubleProperty gpa;
	private final StringProperty email;
	private final StringProperty status;
	private final StringProperty position;
	private final StringProperty club;
	private final IntegerProperty c_id;
	
	
	public CTableModal (int c_id,String fullname, int age,String major, double gpa,String email, String status,String position, String club) {
		this.fullname = new SimpleStringProperty(fullname);
		this.age = new SimpleIntegerProperty(age);
		this.major = new SimpleStringProperty(major);
		this.gpa = new SimpleDoubleProperty(gpa);
		this.email = new SimpleStringProperty(email);
		this.status = new SimpleStringProperty(status);
		this.position = new SimpleStringProperty(position);
		this.club = new SimpleStringProperty(club);
		this.c_id = new SimpleIntegerProperty(c_id);
	}
	
	public String getfullname() {
		return fullname.get();
	}
	public void setfullname(String value) {
		fullname .set(value);
	}
	public int getage() {
		return age.get();
	}
	public void setage(int value) {
		age.set(value);
	}
	public String getmajor() {
		return major.get();
	}
	public void setmajor(String value) {
		major .set(value);
	}
	public double getgpa() {
		return gpa.get();
	}
	public void setgpa(double value) {
		gpa.set(value);
	}
	public String getemial() {
		return email.get();
	}
	public void setemail(String value) {
		email .set(value);
	}
	public String getstatus() {
		return status.get();
	}
	public void setstatus(String value) {
		status.set(value);
	}
	public String getposition() {
		return position.get();
	}
	public void setposition(String value) {
		position .set(value);
	}
	public String getclub() {
		return club.get();
	}
	public void setclub(String value) {
		club.set(value);
	}
	
	public int getid() {
		return c_id.get();
	}
	public void setid(int value) {
		c_id.set(value);
	}
	
	
	public StringProperty fullnameProperty() {
		return fullname;
	}
	
	public IntegerProperty ageProperty() {
		return age;
	}

	public StringProperty majorProperty() {
		return major;
	}
	
	public DoubleProperty gpaProperty() {
		return gpa;
	}

	public StringProperty emailProperty() {
		return email;
	}
	
	public StringProperty statusProperty() {
		return status;
	}

	public StringProperty positionProperty() {
		return position;
	}
	
	public StringProperty clubProperty() {
		return club;
	}
	
	public IntegerProperty idProperty() {
		return c_id;
	}
}
