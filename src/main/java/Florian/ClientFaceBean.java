package Florian;
import java.time.LocalDate;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean{
	private String message = " (Ici message statique provenant de ClientFaceBean)";
	private Integer integerValue = 5;
	private Boolean booleanValue = true;
    private LocalDate localDateValue = LocalDate.now();
    
	public String getMessage() {
		return message;
	}
	
    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public LocalDate getLocalDateValue() {
        return localDateValue;
    }
    
    public String createNew() {
        return "vue-client";
    }
}
    
