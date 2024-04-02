package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class userrrrmodal {
	private final StringProperty Username;
	private final StringProperty email;
	private final StringProperty password;
	
	public userrrrmodal (String Username,String email, String password) {
		this.Username = new SimpleStringProperty(Username);
		this.email = new SimpleStringProperty(email);
		this.password = new SimpleStringProperty(password);
	}
	public String getusername() {
		return Username.get();
	}
	public void setusername(String value) {
		Username.set(value);
	}
	public String getpassword() {
		return password.get();
	}
	public void setpassword(String value) {
		password.set(value);
	}
	public String getemial() {
		return email.get();
	}
	public void setemail(String value) {
		email .set(value);
	}
	public StringProperty emailProperty() {
		return email;
	}
	public StringProperty usernameProperty() {
		return Username;
	}public StringProperty passwordProperty() {
		return password;
	}
	
}
