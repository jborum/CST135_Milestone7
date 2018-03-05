package application;

public class Gum extends Snack {

	// Constructor without arguments
	public Gum() {
		super.setCompanyName("Wrigley");
		super.setBrandName("Juciy Fruit");
		super.setOunces(0.25);
		super.setPrice(1.0);
		super.setCost(0.03);
		super.setProductImage("wrigleyjuicyfruit.jpg");
	}
	
	// Constructor with arguments
	public Gum(String companyName,  String brandName,  double ounces,  double price,  double cost, String productImage) {
		super.setCompanyName(companyName);
		super.setBrandName(brandName);
		super.setOunces(ounces);
		super.setPrice(price);
		super.setCost(cost);
		super.setCost(super.getPrice() / super.getOunces());
		super.setProductImage(productImage);
	}
	
	// Constructor to copy product
	public Gum(Gum copyGum) {
		super.setCompanyName(copyGum.getCompanyName());
		super.setBrandName(copyGum.getBrandName());
		super.setOunces(copyGum.getOunces());
		super.setPrice(copyGum.getPrice());
		super.setCost(copyGum.getCost());
		super.setProductImage(copyGum.getProductImage());
	}

	// Override toString() method
	@Override
	public String toString() {
		return "Gum" + super.toString();
	}
}