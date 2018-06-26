package org.hibernate.tutorial.em;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class A {

	private Long id;
	private String a1;
	private B b;
	
	public A(String a1){
		this.a1=a1;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	public B getB() {
//		return b;
//	}
//
//	public void setB(B b) {
//		this.b = b;
//	}
	
	
}
