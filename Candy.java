package application;


public class Candy extends Snack {

	// Constructor without arguments
	public Candy() {
		super.setCompanyName("Mars, Inc.");
		super.setBrandName("M&M");
		super.setOunces(3.5);
		super.setPrice(1.75);
		super.setCost(0.22);
		super.setProductImage("m&m.jpg");
	}
	// Constructor with arguments
	public Candy(String companyName,  String brandName,  double ounces,  double price,  double cost, String productImage) {
		super.setCompanyName(companyName);
		super.setBrandName(brandName);
		super.setOunces(ounces);
		super.setPrice(price);
		super.setCost(cost);
		super.setCost(super.getPrice() / super.getOunces());
		super.setProductImage(productImage);
	}
	
	// Constructor to copy product
	public Candy(Candy copyCandy) {
		super.setCompanyName(copyCandy.getCompanyName());
		super.setBrandName(copyCandy.getBrandName());
		super.setOunces(copyCandy.getOunces());
		super.setPrice(copyCandy.getPrice());
		super.setCost(copyCandy.getCost());
		super.setProductImage(copyCandy.getProductImage());
	}

	// Override toString() method
	@Override
	public String toString() {
		return "Candy" + super.toString();
	}
}
