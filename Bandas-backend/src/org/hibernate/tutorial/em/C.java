package org.hibernate.tutorial.em;

import javax.persistence.ManyToMany;

public class C {

	private String c1;
	private String c2;
	private int c3;
	
	private B bs;
	
	public C(String c1,String c2,int c3){
		this.c1=c1;
		this.c2=c2;
		this.c3=c3;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}
	
	public int getC3() {
		return c3;
	}

	public void setC3(int c3) {
		this.c3 = c3;
	}
	
	@ManyToMany(mappedBy="cs")
	public B getBs() {
		return bs;
	}

	public void setBs(B bs) {
		this.bs = bs;
	}
}
