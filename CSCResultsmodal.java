package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CSCResultsmodal {
	private final StringProperty president;
	private final StringProperty count;
	
	public CSCResultsmodal(String president, String count) {
		this.president = new SimpleStringProperty(president);
		this.count = new SimpleStringProperty(count);
	}
	
	public String getpresident() {
		return president.get();
	}
	public void setpresident(String value) {
		president .set(value);
	}
	public String getresult() {
		return count.get();
	}
	public void setresult(String value) {
		count.set(value);
	}
	
	public StringProperty presidentProperty() {
		return president;
	}
	
	public StringProperty countProperty() {
		return count;
	}
}
