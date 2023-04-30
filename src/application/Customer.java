package application;

import java.util.ArrayList;



public class Customer implements Comparable<Customer>{
	private double id;
	private double mobile;
	private String name;
	private String address;
	private String plan;
     ArrayList<String> interestedIn=new ArrayList<>();
     ArrayList<Media> received=new ArrayList<>();
	public Customer(double id,String name, String address,double mobile, String plan) {
		super();
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.id=id;
		this.mobile=mobile;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public double getMobile() {
		return mobile;
	}
	public void setMobile(double mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	@Override
	public int compareTo(Customer o) {
		return this.getName().compareTo(o.getName());
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", mobile=" + mobile + ", name=" + name + ", address=" + address + ", plan="
				+ plan + "]";
	}
	
	
	
}
