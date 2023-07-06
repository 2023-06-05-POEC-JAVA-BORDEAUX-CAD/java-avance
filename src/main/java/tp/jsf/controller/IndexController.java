package tp.jsf.controller;

import java.io.Serializable;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

@Named
@ApplicationScoped
public class IndexController implements Serializable {
	private int count = 0;
	private String message = "Wicked is good";

	public String createNew() {
		count = 1 - count;
		if (count == 1) {
			return "impaire";
		}
		return "pair";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
