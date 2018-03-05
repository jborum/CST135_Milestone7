package application;

public class Drink extends Product implements Comparable<Product> {
	
	@Override
	public int compareTo(Product other){
		if (getBrandName().toUpperCase().compareTo(other.getBrandName().toUpperCase()) > 0) {
			return 1;
		} else if (getBrandName().toUpperCase().compareTo(other.getBrandName().toUpperCase()) < 0) {
			return -1;
		} else if (getPrice() > other.getPrice()) {
			return 1;
		} else if (getPrice() < other.getPrice()) {
			return -1;
		} else if (getOunces() > other.getOunces()) {
			return 1;
		} else if (getOunces() < other.getOunces()) {
			return -1;
		} else if (getCost() > other.getCost()) {
			return 1;
		} else if (getCost() < other.getCost()) {
			return -1;
		}
		else return 0;
	}
	
	// Constructor without arguments
	public Drink() {
		super.setCompanyName("Pepsi Co.");
		super.setBrandName("Mountain Dew");
		super.setOunces(12);
		super.setPrice(2.0);
		super.setCost(0.5);
		super.setProductImage("mountainDew.png");
	}
	
	// Constructor with arguments
	public Drink(String companyName,  String brandName, double ounces,  double price,  double cost, String productImage) {
		super.setCompanyName(companyName);
		super.setBrandName(brandName);
		super.setOunces(ounces);
		super.setPrice(price);
		super.setCost(cost);
		super.setProductImage(productImage);
	}
	
	// Constructor to copy product
	public Drink(Drink copyDrink) {
		super.setCompanyName(copyDrink.getCompanyName());
		super.setBrandName(copyDrink.getBrandName());
		super.setOunces(copyDrink.getOunces());
		super.setPrice(copyDrink.getPrice());
		super.setCost(copyDrink.getCost());
		super.setProductImage(copyDrink.getProductImage());
	}

	// Override toString() method
	@Override
	public String toString() {
		return "Drink, " + super.getCompanyName() + ", " + super.getBrandName() + ", " + super.getOunces() + " floz., $" + super.getPrice() + ", $" + super.getCost() + ", " + super.getProductImage();
	}
}

