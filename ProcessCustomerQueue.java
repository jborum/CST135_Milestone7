package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessCustomerQueue extends Transaction {
	
	public void ProcessCustomerQueue() throws FileNotFoundException {
	  Queue customerQue = new LinkedList();
	  
      Scanner scanner = new Scanner(new File("CustomerDisplay.txt"));
      scanner.useDelimiter(",");
      customerQue.add(scanner.next());
      while(scanner.hasNext()){
    	  customerQue.offer(scanner.next()+"|");
      }
      scanner.close();
  }
	  
	  //System.out.println("Queue Print:: " + customerQue);

	  //String head = customerQue.element();
	  //System.out.println("Head element:: " + head);

	  //String element1 = customerQue.poll();
	  //System.out.println("Removed Element:: " + element1);

	  //System.out.println("Queue Print after poll:: " + customerQue);
	  
	  //String element2 = customerQue.remove();
	  
	  //System.out.println("Removed Element:: " + element2);

	  //System.out.println("Queue Print after remove:: " + customerQue);  
	
	
	
	public Product first() {
		return (Product) super.getTransaction().get(0);
	}
	
	public int length() {
		return super.getNumberOfTransaction();
	}
	
	public void in(Product product) {
		super.addTransaction(product);
	}
	
	public void out() {
	}
	
	public boolean isEmpty() {
		return super.getTransaction().isEmpty();
	}

}
