package kz.vev.app.domain;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "D_PRODUCT")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3330163146450843151L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "MARK")
	private String mark;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String mame) {
		this.name = mame;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
