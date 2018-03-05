package application;

abstract class Product implements Comparable<Product>{
	
	// Declare Variables
	private String companyName;
	String brandName;
	private String productImage;
	private double ounces;
	private double price;
	private double costPerOz;
	private double cost;
	private String Quantity;
	private String productID;

	// Constructor without arguments
	public Product() {
		companyName = "Frito Lay";
		brandName = "Lays";
		ounces = 1.0;
		price = 1.0;
		cost = 0.20;
		productImage = "lays-classic.png";
	}
	
	// Constructor with arguments
	public Product(String companyName,  String brandName,  double ounces,  double price,  double cost, String productImage) {
		this.setCompanyName(companyName);
		this.setBrandName(brandName);
		this.setOunces(ounces);
		this.setPrice(price);
		this.setCost(cost);
		this.setCost(this.getPrice() / this.getOunces());
		this.setProductImage(productImage);
	}
	
	public Product(String brandName,  double price,  String Quantity, String productID) {
		this.setBrandName(brandName);
		this.setPrice(price);
		this.setCost(cost);
		this.setCost(this.getPrice() / this.getOunces());
		this.setProductImage(productImage);
	}
	
	public Product(String brandName,  double price, String productID) {
		this.setBrandName(brandName);
		this.setPrice(price);
		this.setProductID(productID);
	}
	
	// Constructor to copy product
	public Product(Product copyProduct) {
		this.setCompanyName(copyProduct.getCompanyName());
		this.setBrandName(copyProduct.getBrandName());
		this.setOunces(copyProduct.getOunces());
		this.setPrice(copyProduct.getPrice());
		this.setCost(copyProduct.getCost());
		this.setProductImage(copyProduct.getProductImage());
	}
	
	// return the companyName
	public String getProductImage() {
		return productImage;
	}

	// parameter companyName the companyName to set
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	// return the companyName
	public String getCompanyName() {
		return companyName;
	}

	// parameter companyName the companyName to set
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	// return the brandName
	public String getBrandName() {
		return brandName;
	}

	// parameter brandName the brandName to set
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	// return the ounces
	public double getOunces() {
		return ounces;
	}

	// parameter ounces the ounces to set
	public void setOunces(double ounces) {
		this.ounces = ounces;
	}

	// return the price
	public double getPrice() {
		return price;
	}

	// parameter price the price to set
	public void setPrice(double price) {
		this.price = price;
	}

	// return the costPerOz
	public double getCostPerOz() {
		costPerOz = this.price / this.ounces;
		return costPerOz;
	}

	// return the cost
	public double getCost() {
		return cost;
	}

	// parameter cost the cost to set
	public void setCost(double cost) {
		this.cost = cost;
	}

//	public double getQuantity() {
//		return Quantity;
//	}

//	public void setQuantity(double quantity) {
//		Quantity = quantity;
//	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	public void setCostPerOz(double costPerOz) {
		this.costPerOz = costPerOz;
	}
	
	// Override toString() method
	@Override
	public String toString() {
		return ", " + companyName + ", " + brandName + ", " + ounces + " oz., $" + price + ", $" + cost + ", " + productImage;
	}
}
