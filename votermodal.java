package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class votermodal {
	private final StringProperty fullname;
	private final StringProperty club;
	private final StringProperty president;
	private final StringProperty vicep;
	private final StringProperty secretary;
	
	public votermodal (String fullname,String club, String president,String vicep, String secretary) {
		this.fullname = new SimpleStringProperty(fullname);
		this.president = new SimpleStringProperty(president);
		this.club = new SimpleStringProperty(club);
		this.vicep = new SimpleStringProperty(vicep);
		this.secretary= new SimpleStringProperty(secretary);
	}
	public String getfullname() {
		return fullname.get();
	}
	public void setfullname(String value) {
		fullname.set(value);
	}
	public String getclub() {
		return club.get();
	}
	public void setclub(String value) {
		club.set(value);
	}
	public String getpresident() {
		return president.get();
	}
	public void setpresident(String value) {
		president.set(value);
	}
	public String getvicep() {
		return vicep.get();
	}
	public void setvicep(String value) {
		vicep.set(value);
	}
	public String getsecretary() {
		return secretary.get();
	}
	public void setsecretary(String value) {
		secretary.set(value);
	}
	public StringProperty fullnameProperty() {
		return fullname;
	}
	public StringProperty clubProperty() {
		return club;
	}public StringProperty presidentProperty() {
		return president;
	}
	public StringProperty vicepProperty() {
		return vicep;
	}public StringProperty secretaryProperty() {
		return secretary;
	}
}
