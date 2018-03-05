package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class sorter {

		sorter sort = new sorter(0, 0);
	 	Product[] globalProducts;
	    static int length;

	    public void sort(Product[] globalInventoryList) {
	        if (globalInventoryList == null || globalInventoryList.length == 0) {
	            return;
	        }
	        super.globalProducts = globalInventoryList;
	        super.length = globalInventoryList.length;
	        sorter(0, length - 1);
	    }

	    private sorter(int a, int b) {
			// TODO Auto-generated method stub
			
		}

		public static sorter(final int lowerIndex, final int higherIndex) {
	        int a = lowerIndex;
	        int b= higherIndex;
	        String pivot = super.globalProducts[lowerIndex + (higherIndex - lowerIndex) / 2].getBrandName();

	        while (a <= b) {
	            while (super.globalProducts[a].getBrandName().compareToIgnoreCase(pivot) < 0) {
	                a++;
	            }

	            while (super.globalProducts[b].getBrandName().compareToIgnoreCase(pivot) > 0) {
	                b--;
	            }

	            if (a <= b) {
	               exchangeNames(a, b);
	                a++;
	                b--;
	            }
	        }
	        //call quickSort recursively
	        if (lowerIndex < b) {
	            sorter(lowerIndex, b);
	        }
	        if (a< higherIndex) {
	            sorter(a, higherIndex);
	        }
	    }

	    private static void sorter(int lowerIndex, int b) {
			// TODO Auto-generated method stub
			
		}

		static void exchangeNames(int a, int b) {
	        Product temp = super.globalProducts[a];
	        super.globalProducts[a] = super.globalProducts[b];
	        super.globalProducts[b] = temp;
	    }
	}

class RecursiveSerach {
	
	public static int recursiveSearch (ObservableList<Product> list, String key) {
		int low = 0;
		int high = list.size() - 1;
		int mid;
		
		// stores in temp list
		Product[] temp = new Product[list.size()];
		int a = 0;
		for (Product productTemp : list) {
			temp[a] = productTemp;
			a++;
		}
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (temp[mid].getBrandName().compareToIgnoreCase(key) < 0) {
				low = mid + 1;
			}
			else if (temp[mid].getBrandName().compareToIgnoreCase(key) > 0) {
				high = mid - 1;
			}
			else {
				writeCallStack(key);
				return mid;
			}
		}
		writeCallStack(key);
		return -1;
	}
	

    public static void writeCallStack(String key){

        //Stack trace file header
        final String FILE_HEADER = "Search Call Stack:  " + key + "\n\n";

        FileWriter fileWriter = null;

        try {

            //deletes existing inventory file before writing new contents
            try {
                File file = new File("Search Call Stack.txt");
                file.delete();
            } catch (Exception e) {
            }

            fileWriter = new FileWriter("Search Call Stack.txt");

            //Write the stack file header
            fileWriter.append(FILE_HEADER.toString());

            //Write a new product object list to the CSV file
                fileWriter.append(Arrays.toString(Thread.currentThread().getStackTrace()));
        } catch (Exception e) {
        	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setHeaderText(null);
        	alert.setContentText("ERROR");
        	alert.showAndWait();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setHeaderText(null);
            	alert.setContentText("ERROR");
            	alert.showAndWait();
            }
        }
    }
}










