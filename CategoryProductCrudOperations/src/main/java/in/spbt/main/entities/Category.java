package in.spbt.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table

public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	    private List<Product> products;
	 
	 public Category() {}
	 
	 public Category(String name) {
		 this.name=name;
	 }

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
	 
	 
}
