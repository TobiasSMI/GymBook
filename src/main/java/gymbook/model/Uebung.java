package gymbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uebung {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	    private String name;
	   
	    private Integer gewicht;
	    private Integer wiederholung;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGewicht() {
		return gewicht;
	}

	public void setGewicht(Integer gewicht) {
		this.gewicht = gewicht;
	}

	public Integer getWiederholung() {
		return wiederholung;
	}

	public void setWiederholung(Integer wiederholung) {
		this.wiederholung = wiederholung;
	}
	 
	 
}
