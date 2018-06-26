package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class B {

	private Long id;
	private String b1;
	private String b2;
	private List<A> as;
	
	private List<C> cs;
	
	public B(String b1,String b2){
		this.b1=b1;
		this.b2=b2;
		as=new ArrayList<A>();
		cs=new ArrayList<C>();
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getB1() {
		return b1;
	}

	public void setB1(String b1) {
		this.b1 = b1;
	}

	public String getB2() {
		return b2;
	}

	public void setB2(String b2) {
		this.b2 = b2;
	}

	@OneToMany(mappedBy="b",cascade=CascadeType.ALL,orphanRemoval=true)
	public List<A> getAs() {
		return as;
	}

	public void setAs(List<A> as) {
		this.as = as;
	}
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<C> getCs() {
		return cs;
	}

	public void setCs(List<C> cs) {
		this.cs = cs;
	}	
}