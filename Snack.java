package application;

abstract class Snack extends Product implements Comparable<Product> {

	// Override compareTo method
	@Override
	public int compareTo(Product o) {
		// Initialize comparison by brand name first
	    int result = this.getBrandName().toUpperCase().compareTo(o.getBrandName().toUpperCase());
	    // Initialize comparison by price
	    if(result == 0){
			if (this.getPrice() > o.getPrice()){
				result = 1;
			} else if (this.getPrice() < o.getPrice()) {
				result =  -1;
			} else {
				result = 0;
			}
	    }
	    return result;
	}
	
	// Constructor without arguments
	public Snack() {
		super.setCompanyName("Frito Lay");
		super.setBrandName("Lays");
		super.setOunces(1.0);
		super.setPrice(1.0);
		super.setCost(0.20);
		super.setProductImage("lays-classic.png");
	}
	
	// Constructor with arguments
	public Snack(String companyName,  String brandName,  double ounces,  double price,  double cost, String productImage) {
		super.setCompanyName(companyName);
		super.setBrandName(brandName);
		super.setOunces(ounces);
		super.setPrice(price);
		super.setCost(cost);
		super.setProductImage(productImage);
	}
	
	public Snack(Snack copySnack) {
		super.setCompanyName(copySnack.getCompanyName());
		super.setBrandName(copySnack.getBrandName());
		super.setOunces(copySnack.getOunces());
		super.setPrice(copySnack.getPrice());
		super.setCost(copySnack.getCost());
		super.setProductImage(copySnack.getProductImage());
	}

	// Override toString() method
	@Override
	public String toString() {
		return super.toString();
	}
}
