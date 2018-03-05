package application;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class GlobalInventory {

//		sorter sort = new sorter();
		ObservableList <Product> localInventory = FXCollections.observableArrayList();
		private static Scanner scanner;
		
		public GlobalInventory() {
			
			ObservableList <Product> globalInventoryList = FXCollections.observableArrayList();
			// creating the area to place inventory
			String CSVFile = "White Group.csv";
			Product[] productArrays;
			
			// creating scanners for inventory amounts
			try {
				scanner = new Scanner (new File (CSVFile));
				scanner.useDelimiter("[,\n]");
				
				String header = scanner.nextLine();
				
				int a = 0;
				while (scanner.hasNextLine()) {
					scanner.nextLine();
					a++;
				}
				
				scanner.close();
				productArrays = new Product[100];
				
				// creating a second scanner
				scanner = new Scanner (new File (CSVFile));
				scanner.useDelimiter("[,\n]");
				
				String header2 = scanner.nextLine()	;
				
				int b = 0;
				while (scanner.hasNextLine()) {
					String nextLine = scanner.nextLine();
					String[] lineArray = nextLine.split(",");
					String brandname = lineArray[0];
					String Price = lineArray[1];
					String Quantity = lineArray[2];
					double price = Double.parseDouble(Price);
					int quantity = Integer.parseInt(Quantity);
					String productID = lineArray[3];
					
					Product product1 = new Product  (brandname, price, productID);
					productArrays [a] = product;
					a++;
				}
				
				// recursive sorting
				sorter.sort (productArrays);
				globalInventoryList.addAll(); 
			}
				catch (Exception e) {
				Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setHeaderText(null);
                	alert.setContentText("ERROR");
                	alert.showAndWait();
					e.printStackTrace();
			}
			return;
		}
		
//		/*
//		 * 	creating a temp current inventory list 
//		 */
		public abstract ObservableList <Product> currentInventory (ObservableList<Product> inventory);
			String CSVFIle = "White Group.csv";
			
			// temp Product list
			Product[] temp = new Product[GlobalInventory.size()];
			int a = 0; {
			for (Product productTemp : localInventory) {
				temp [a] = productTemp;
				a++;
			}
			
			// recursive sort
			sorter.sort(temp);
			//	clears list
			localInventory.clear();
			//	match sorted temp list
			for (Product productTemp1 : temp) {
				List<Product> inventory;
				inventory.add (productTemp1);
			}
			
			try {
				scanner = new Scanner (new File (CSVFIle));
				scanner.useDelimiter("[,\n]");
				
				String header = scanner.nextLine();
				
				while (scanner.hasNextLine()) {
					String nextLine = scanner.nextLine();
					String[] lineArray = nextLine.split(",");
					String brandname = lineArray[0];
					String Price = lineArray[1];
					String Quantity = lineArray[2];
					double price = Double.parseDouble(Price);
					int quantity = Integer.parseInt(Quantity);
					String productID = lineArray[3];
					
					Product product = new Product (brandname, price, productID);
					localInventory.add(product);
				}

			} 
			catch (Exception e) {
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setHeaderText(null);
	          	alert.setContentText("ERROR");
	        	    alert.showAndWait();
					e.printStackTrace();
			}
			// comparing ProductID's for inventory
			a = 0;
			for (Product product : localInventory) {
				for (Product product1 : localInventory)
					if (product1.brandName.equals(product.getBrandName())) {
						product.setQuantity (product1.getQuantity());
					}
				a++;
			}
			return ;
		}
			private static int size() {
				// TODO Auto-generated method stub
				return 0;
			}		
}