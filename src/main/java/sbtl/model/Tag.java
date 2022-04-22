package sbtl.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	    private String tagName;
	    private String uebungName;
	    private Double gewicht;
	    private Integer wiederholung;
	    private LocalDate date = LocalDate.now();
	    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public Double getGewicht() {
		return gewicht;
	}

	public void setGewicht(Double gewicht) {
		this.gewicht = gewicht;
	}

	public Integer getWiederholung() {
		return wiederholung;
	}

	public void setWiederholung(Integer wiederholung) {
		this.wiederholung = wiederholung;
	}

	public String getUebungName() {
		return uebungName;
	}

	public void setUebungName(String uebungName) {
		this.uebungName = uebungName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	 
	 
}
