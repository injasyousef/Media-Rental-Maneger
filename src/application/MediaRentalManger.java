package application;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManger implements MediaRentalInt {	
	ArrayList<Customer> customers=new ArrayList<>();
	ArrayList<Media> medies=new ArrayList<>();
	int limit;	
	
	public MediaRentalManger() {
	}
	@Override
	public void addCustomer(double id,String name, String address,double mobile, String plan) {
		customers.add(new Customer(id,name,address,mobile,plan));
	}
	public void ubdateCustomer(double id,String name, String address,double mobile, String plan) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getId()==id) {
				customers.get(i).setName(name);
				customers.get(i).setAddress(address);
				customers.get(i).setMobile(mobile);
				customers.get(i).setPlan(plan);
			}
		}
	}
	@Override
	public void addMovie(String code,String title, int copiesAvailable, String rating) {
		medies.add(new Movie(code,title,copiesAvailable,rating));
	}
	@Override
	public void addGame(String code,String title, int copiesAvailable, double weight) {
		medies.add(new Game(code,title,copiesAvailable,weight));
	}
	@Override
	public void addAlbum(String code,String title, int copiesAvailable, String artist, String songs) {
		medies.add(new Album(code,title,copiesAvailable,artist,songs));
	}
	@Override
	public void setLimitedPlanLimit(int value) {
		this.limit=value;
	}
	@Override
	public String getAllCustomersInfo() {
		String info="";
		for(int i=0;i<customers.size();i++) {
			info+=customers.get(i).toString()+"\n";
		}  
		return info;
	}
	@Override
	public String getAllMediaInfo() {
		String info="";
		for(int i=0;i<medies.size();i++) {
			info+=medies.get(i).toString()+"\n";
		}
		return info;
	}
	@Override
	public boolean addToCart(String customerName, String mediaTitle) {
		for(int i=0;i<=customers.size();i++) {
			if(customers.get(i).getName().equals(customerName)){
				if(customers.get(i).interestedIn.contains(mediaTitle))
					return false;
				else  {
					customers.get(i).interestedIn.add(mediaTitle);
					return true;
			}
		}
	}
		return false;
	}

	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		if(customers.isEmpty())
			return false;
		for(int i=0;i<=customers.size();i++) {
			if(customers.get(i).getName().equals(customerName)) {
				if(customers.get(i).interestedIn.contains(mediaTitle)) {
				customers.get(i).interestedIn.remove(mediaTitle);
				return true;
				}
			}
		}
		return false;
	}
	@Override
	public String processRequests() {
		Collections.sort(customers);
		String result="";
		for(int i=0;i<customers.size();i++) {
			if((customers.get(i).getPlan()).equals("limited")) {
				limit=2;
					for(int k=0;k<medies.size();k++) {
						if(limit>0) {
						   if(customers.get(i).interestedIn.contains(medies.get(k).getTitle())){
							   if(hasCopies(medies.get(k).getTitle())) {
							       result+="sending ["+medies.get(k).getTitle()+"] to ["+customers.get(i).getName()+"]\n";
							       customers.get(i).received.add(medies.get(k));
							       limit--;
							}
						}
					}
			   }
			}
			else if((customers.get(i).getPlan()).equals("unlimited")) {
					for(int k=0;k<medies.size();k++) {
						if(customers.get(i).interestedIn.contains(medies.get(k).getTitle())) {
							if(hasCopies(medies.get(k).getTitle())) {
							result+="sending ["+medies.get(k).getTitle()+"] to ["+customers.get(i).getName()+"]\n";
							customers.get(i).received.add(medies.get(k));
							}
					}
				}
			}
		}
		return result;
	}
	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		for(int i=0;i<customers.size();i++) {
				if(customers.get(i).getName().equals(customerName)){
					for(int j=0;j<medies.size();j++) {
						if(medies.get(j).getTitle().equals(mediaTitle)) {
							customers.get(i).received.remove(medies.get(j));
							medies.get(j).setNoc(medies.get(j).getNoc()+1);
							return true;
						}
					}
				}
		}
		return false;
	}
	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> a=new ArrayList<>();
			if(title!=null || rating!=null || artist!=null || songs!=null) {
			for(int i=0;i<medies.size();i++) {
				if(title!=null) {
				   if(medies.get(i).getTitle().equals(title))
					     a.add(medies.get(i).getTitle());
				}
				if(rating!=null) {
					if(medies.get(i) instanceof Movie)
				         if(((Movie)medies.get(i)).getRating().equals(rating))
					            a.add(medies.get(i).getTitle());
				}
				if(artist!=null) {
					if(medies.get(i) instanceof Album)
				         if(((Album) medies.get(i)).getArtist().equals(artist))
					            a.add(medies.get(i).getTitle());
				}
				if(songs!=null) {
					if(medies.get(i) instanceof Album)
				         if(((Album) medies.get(i)).getSong().equals(songs))
					            a.add(medies.get(i).getTitle());
				}
			}
		}
			else {
				for(int i=0;i<medies.size();i++)
					a.add(medies.get(i).getTitle());
			}
		Collections.sort(a);
		return a;
	}
	private boolean hasCopies(String mediaTitle) {
		for(int i=0;i<medies.size();i++) {
			if(medies.get(i).getTitle().equals(mediaTitle)) {
				if((medies.get(i).getNoc())>0) {
					medies.get(i).setNoc((medies.get(i).getNoc())-1);
					return true;
				}
			}
		}
		return false;
	}
}
