package application;
	
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {


	
	@Override
	public void start(Stage primaryStage) {
		mainMenu(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void mainMenu(Stage primaryStage) {
		
		ArrayList productArray = new ArrayList();
		Dispenser dispenser = new Dispenser();
		Inventory inventory = new Inventory();
		Transaction transaction = new Transaction();
		
		dispenser.displayProducts();
		productArray = dispenser.getProducts();
		
		VBox vboxMain = new VBox(5);
		GridPane mainGridPane = new GridPane();
		
		Image chipsImage = new Image("junkfood.jpg");
		ImageView inventoryImageView = new ImageView();
		inventoryImageView.setImage(chipsImage);
		inventoryImageView.setFitHeight(125);
		inventoryImageView.setFitWidth(250);
		
		Button btnCustomer = new Button();
		btnCustomer.setText("Customer Queue");
		btnCustomer.setMinWidth(250);
		btnCustomer.setMinHeight(25);
		vboxMain.getChildren().add(btnCustomer);
		
		btnCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	try {
					customerMenu();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		Button btnDispenser = new Button();
		btnDispenser.setText("Dispenser");
		btnDispenser.setMinWidth(250);
		btnDispenser.setMinHeight(25);
		vboxMain.getChildren().add(btnDispenser);
		
		btnDispenser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	dispenserMenu(inventory, transaction);
            }
        });
		
		Button btnInventory = new Button();
		btnInventory.setText("Inventory");
		btnInventory.setMinWidth(250);
		btnInventory.setMinHeight(25);
		vboxMain.getChildren().add(btnInventory);
		
		btnInventory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	inventoryMenu(dispenser);
            	//loginMenu();
            }
        });
		
		Button btnClose = new Button();
		btnClose.setText("Close");
		btnClose.setMinWidth(250);
		btnClose.setMinHeight(25);
		vboxMain.getChildren().add(btnClose);
		
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
		
		mainGridPane.setConstraints(inventoryImageView, 1, 1);
		mainGridPane.setConstraints(btnDispenser, 1, 2);
		mainGridPane.setConstraints(btnCustomer, 1, 3);
		mainGridPane.setConstraints(btnInventory, 1, 4);
		mainGridPane.setConstraints(btnClose, 1, 5);
		
		mainGridPane.getChildren().addAll(btnCustomer,inventoryImageView,btnDispenser, btnInventory, btnClose);

		primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(mainGridPane, 250, 225));
        //primaryStage.setResizable(false);
        primaryStage.show();
	}
	
	

		public void ShoppingAnimation() {
			// Create a pane
			Stage animationStage = new Stage();
			Pane pane = new Pane();
	
			// Add an image view and add it to pane
			ImageView imageView = new ImageView("shopping.jpg");
			pane.getChildren().add(imageView);
			imageView.setFitHeight(250);
			imageView.setFitWidth(250);

			// Create a path transition
			PathTransition pt = new PathTransition(Duration.millis(5000),
					new Line(100, 200, 100, 0), imageView);
			pt.setCycleCount(2);
			pt.play(); // Start animation

			// Create a scene and place it in the stage
			Scene scene = new Scene(pane, 250, 200);
			animationStage.setTitle("Checkout Animation"); // Set the stage title
			animationStage.setScene(scene); // Place the scene in the stage
			animationStage.show(); // Display the stage
		}
	
	public void dispenserMenu(Inventory inventory, Transaction transaction) {
		//System.out.println("Dispenser Menu");
		int imgDimension = 200;
		int btnDimension = 275;
		Stage dispenserStage = new Stage();
		GridPane dispenserPane = new GridPane();
		
		HBox transactionHbox = new HBox();
		transactionHbox.setPadding(new Insets(0,10,10,10));
		transactionHbox.setMinWidth(400);
		Label lblTotalTransaction = new Label("Total     ");
		TextField txtTotalTransaction = new TextField("$" + String.valueOf(transaction.getTransactionPrice()));
		//TextField txtTotalTransaction = new TextField();
		txtTotalTransaction.setStyle("-fx-text-fill: blue");
		txtTotalTransaction.setFont(Font.font("Times", 12));
		txtTotalTransaction.setAlignment(Pos.BASELINE_LEFT);
		txtTotalTransaction.setMinWidth(300);
		transactionHbox.getChildren().addAll(lblTotalTransaction,txtTotalTransaction);
		
		dispenserPane.setHgap(5);
		dispenserPane.setVgap(5);
		dispenserPane.setPadding(new Insets(5, 5, 5, 5));
		
		Image drinkImage = new Image("drinksImage.jpg");
		ImageView drinkImageView = new ImageView();
		drinkImageView.setImage(drinkImage);
		drinkImageView.setFitHeight(imgDimension);
		drinkImageView.setFitWidth(imgDimension);
		
		Button btnDrinks = new Button();
		btnDrinks.setText("Drinks");
		btnDrinks.setMaxWidth(btnDimension);
		btnDrinks.setMaxHeight(btnDimension);
		btnDrinks.setGraphic(drinkImageView);
		btnDrinks.setStyle("-fx-background-color: white;");
		
		btnDrinks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	//drinksMenu();
            	Stage drinkStage = new Stage();
        		GridPane drinkPane = new GridPane();
        		drinkPane.setHgap(10);
        		drinkPane.setVgap(10);
        		drinkPane.setPadding(new Insets(10, 10, 10, 10));
        		
        		ArrayList drinkList = new ArrayList();
        		drinkList = inventory.getDrinks();
        		
        		ArrayList transactionList = new ArrayList();
        		transactionList = transaction.getTransaction();
        		
        		ListView listViewInventory = new ListView();
        		listViewInventory.setMinSize(400, 100);
        		
        		ListView listViewTransaction = new ListView();
        		listViewTransaction.setMinSize(400, 100);
        		
            	listViewInventory.getItems().clear();
            	listViewTransaction.getItems().clear();
        		
        		Image img1 = new Image("pepsi.jpg");
        		ImageView imgView1 = new ImageView();
        		imgView1.setImage(img1);
        		imgView1.setFitHeight(imgDimension);
        		imgView1.setFitWidth(imgDimension);
        		
        		String strImage = ((Product) inventory.getDrinks().get(1)).getProductImage();
        		System.out.println("The string image for product 1 = " + strImage);
        		System.out.println("Total number of drinks :" + inventory.getNumberOfDrinks());
        		
        		for (int i = 0; i < inventory.getNumberOfDrinks(); i++) { // start of loop
        				listViewInventory.getItems().add(inventory.getDrinks().get(i));
        		} // End of For Loop
        		
        		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
        			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
        		}
        		
        		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
        		
        		int imgDimension = 200;
        		int btnWidth = 200;
        		int btnHeight = 25;
        		
        		Button btnAdd = new Button();
        		btnAdd.setText("ADD");
        		btnAdd.setMinWidth(btnWidth);
        		btnAdd.setMinHeight(btnHeight);
        		//btnAdd.setGraphic(imgView1);
        		
        		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewInventory.getSelectionModel().getSelectedIndex();
                    	transaction.addTransaction((Product) inventory.getDrinks().get(selectedItem));
                    	inventory.removeProduct(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfDrinks(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getDrinks().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                });
        		
        		Button btnRemove = new Button();
        		btnRemove.setText("REMOVE");
        		btnRemove.setMinWidth(btnWidth);
        		btnRemove.setMinHeight(btnHeight);
        		//btnRemove.setGraphic(imgView1);
        		
        		btnRemove.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewTransaction.getSelectionModel().getSelectedIndex();
                    	inventory.addProduct((Product) transaction.getProducts().get(selectedItem));
                    	transaction.removeTransaction(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfDrinks(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getDrinks().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                    
                });
        		
        		Button btnClose = new Button();
        		btnClose.setText("CLOSE");
        		btnClose.setMinWidth(btnWidth);
        		btnClose.setMinHeight(btnHeight);
        		
        		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	drinkStage.close();
                    }
                });
        		
        		Button btnCheckOut = new Button();
        		btnCheckOut.setText("CHECKOUT");
        		btnCheckOut.setMinWidth(btnWidth);
        		btnCheckOut.setMinHeight(btnHeight);
        		
        		btnCheckOut.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	ShoppingAnimation();
                    	
                		Stage checkOutStage = new Stage();
                		GridPane checkoutGridPane = new GridPane();
                		
                		checkoutGridPane.setPadding(new Insets(10, 10, 10, 10));
                		
                		Button btnClose = new Button();
                		btnClose.setText("Close");
                		btnClose.setMinWidth(300);
                		btnClose.setMinHeight(25);
                		
                		Button btnDone = new Button();
                		btnDone.setText("Main Menu");
                		btnDone.setMinWidth(300);
                		btnDone.setMinHeight(25);
                		
                		btnDone.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            	drinkStage.close();
                            	dispenserStage.close();
                            }
                        });
                		
                		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            }
                        });
                		
                		
                		
                		Label lblPayment = new Label("Total Amount Due $" + String.valueOf(transaction.getTransactionPrice()));
                		lblPayment.setStyle("-fx-text-fill: green");
                		lblPayment.setFont(Font.font("Times", 16));
                		lblPayment.setAlignment(Pos.BASELINE_CENTER);
                		lblPayment.setMinWidth(300);
                		
                		HBox hboxname = new HBox();
                		Label lblName = new Label("Name     ");
                		TextField txtName = new TextField();
                		txtName.setMinWidth(250);
                		txtName.setStyle("-fx-text-fill: blue");
                		txtName.setFont(Font.font("Times", 12));
                		txtName.setAlignment(Pos.BASELINE_LEFT);
                		hboxname.getChildren().addAll(lblName,txtName);
                		
                		checkoutGridPane.setConstraints(lblPayment, 1, 1);
                		checkoutGridPane.setConstraints(hboxname, 1, 2);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnDone, 1, 4);
                		
                		checkoutGridPane.getChildren().addAll(hboxname,btnDone, lblPayment,btnClose);
                		
                		checkOutStage.setScene(new Scene(checkoutGridPane, 320,150));
                		checkOutStage.setResizable(false);
                		checkOutStage.setTitle("Payment");
                		checkOutStage.show();
                    }
                });
        		
        		
        		drinkPane.setConstraints(listViewInventory, 1, 1);
        		drinkPane.setConstraints(imgView1, 2, 1);
        		drinkPane.setConstraints(btnAdd, 2, 2);
        		drinkPane.setConstraints(btnRemove, 2, 3);
        		drinkPane.setConstraints(btnCheckOut, 2, 4);
        		drinkPane.setConstraints(btnClose, 2, 5);
        		drinkPane.setConstraints(listViewTransaction, 3, 1);
        		drinkPane.setConstraints(transactionHbox, 3, 2);

        		drinkPane.getChildren().addAll(transactionHbox, listViewInventory, listViewTransaction, imgView1, btnAdd, btnRemove, btnCheckOut, btnClose);

        		drinkStage.setScene(new Scene(drinkPane, 1100,400));
        		drinkStage.setResizable(false);
        		drinkStage.setTitle("Drinks");
        		drinkStage.show();
            }
        });
		
		Image chipsImage = new Image("chipsImage.jpg");
		ImageView chipsImageView = new ImageView();
		chipsImageView.setImage(chipsImage);
		chipsImageView.setFitHeight(imgDimension);
		chipsImageView.setFitWidth(imgDimension);
		
		Button btnChips = new Button();
		btnChips.setText("Chips");
		btnChips.setMaxWidth(btnDimension);
		btnChips.setMaxHeight(btnDimension);
		btnChips.setGraphic(chipsImageView);
		btnChips.setStyle("-fx-background-color: white;");
		
		btnChips.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	//chipssMenu();
            	Stage chipsStage = new Stage();
        		GridPane chipsPane = new GridPane();
        		chipsPane.setHgap(10);
        		chipsPane.setVgap(10);
        		chipsPane.setPadding(new Insets(10, 10, 10, 10));
        		
        		ArrayList chipsList = new ArrayList();
        		chipsList = inventory.getChips();
        		
        		ArrayList transactionList = new ArrayList();
        		transactionList = transaction.getTransaction();
        		
        		ListView listViewInventory = new ListView();
        		listViewInventory.setMinSize(400, 100);
        		
        		ListView listViewTransaction = new ListView();
        		listViewTransaction.setMinSize(400, 100);
        		
            	listViewInventory.getItems().clear();
            	listViewTransaction.getItems().clear();
        		
        		Image img1 = new Image("lays-classic.jpg");
        		ImageView imgView1 = new ImageView();
        		imgView1.setImage(img1);
        		imgView1.setFitHeight(imgDimension);
        		imgView1.setFitWidth(imgDimension);
        		
        		String strImage = ((Product) inventory.getChips().get(1)).getProductImage();
        		System.out.println("The string image for product 1 = " + strImage);
        		System.out.println("Total number of chips :" + inventory.getNumberOfChips());
        		
        		for (int i = 0; i < inventory.getNumberOfChips(); i++) { // start of loop
        				listViewInventory.getItems().add(inventory.getChips().get(i));
        		} // End of For Loop
        		
        		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
        			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
        		}
        		
        		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
        		
        		int imgDimension = 200;
        		int btnWidth = 200;
        		int btnHeight = 25;
        		
        		Button btnAdd = new Button();
        		btnAdd.setText("ADD");
        		btnAdd.setMinWidth(btnWidth);
        		btnAdd.setMinHeight(btnHeight);
        		//btnAdd.setGraphic(imgView1);
        		
        		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewInventory.getSelectionModel().getSelectedIndex();
                    	transaction.addTransaction((Product) inventory.getChips().get(selectedItem));
                    	inventory.removeProduct(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfChips(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getChips().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                });
        		
        		Button btnRemove = new Button();
        		btnRemove.setText("REMOVE");
        		btnRemove.setMinWidth(btnWidth);
        		btnRemove.setMinHeight(btnHeight);
        		//btnRemove.setGraphic(imgView1);
        		
        		btnRemove.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewTransaction.getSelectionModel().getSelectedIndex();
                    	inventory.addProduct((Product) transaction.getProducts().get(selectedItem));
                    	transaction.removeTransaction(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfChips(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getChips().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                    
                });
        		
        		Button btnClose = new Button();
        		btnClose.setText("CLOSE");
        		btnClose.setMinWidth(btnWidth);
        		btnClose.setMinHeight(btnHeight);
        		
        		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	chipsStage.close();
                    }
                });
        		
        		Button btnCheckOut = new Button();
        		btnCheckOut.setText("CHECKOUT");
        		btnCheckOut.setMinWidth(btnWidth);
        		btnCheckOut.setMinHeight(btnHeight);
        		
        		btnCheckOut.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                		Stage checkOutStage = new Stage();
                		GridPane checkoutGridPane = new GridPane();
                		
                		checkoutGridPane.setPadding(new Insets(10, 10, 10, 10));
                		
                		Button btnClose = new Button();
                		btnClose.setText("Close");
                		btnClose.setMinWidth(300);
                		btnClose.setMinHeight(25);
                		
                		Button btnDone = new Button();
                		btnDone.setText("Main Menu");
                		btnDone.setMinWidth(300);
                		btnDone.setMinHeight(25);
                		
                		btnDone.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            	chipsStage.close();
                            	dispenserStage.close();
                            }
                        });
                		
                		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            }
                        });
                		
                		Label lblPayment = new Label("Total Amount Due $" + String.valueOf(transaction.getTransactionPrice()));
                		lblPayment.setStyle("-fx-text-fill: green");
                		lblPayment.setFont(Font.font("Times", 16));
                		lblPayment.setAlignment(Pos.BASELINE_CENTER);
                		lblPayment.setMinWidth(300);
                		
                		HBox hboxname = new HBox();
                		Label lblName = new Label("Name     ");
                		TextField txtName = new TextField();
                		txtName.setMinWidth(250);
                		txtName.setStyle("-fx-text-fill: blue");
                		txtName.setFont(Font.font("Times", 12));
                		txtName.setAlignment(Pos.BASELINE_LEFT);
                		hboxname.getChildren().addAll(lblName,txtName);
                		
                		checkoutGridPane.setConstraints(lblPayment, 1, 1);
                		checkoutGridPane.setConstraints(hboxname, 1, 2);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnDone, 1, 4);
                		
                		checkoutGridPane.getChildren().addAll(hboxname,btnDone, lblPayment,btnClose);
                		
                		checkOutStage.setScene(new Scene(checkoutGridPane, 320,150));
                		
                		checkOutStage.setScene(new Scene(checkoutGridPane, 320,90));
                		checkOutStage.setResizable(false);
                		checkOutStage.setTitle("Payment");
                		checkOutStage.show();
                    }
                });
        		
        		
        		chipsPane.setConstraints(listViewInventory, 1, 1);
        		chipsPane.setConstraints(imgView1, 2, 1);
        		chipsPane.setConstraints(btnAdd, 2, 2);
        		chipsPane.setConstraints(btnRemove, 2, 3);
        		chipsPane.setConstraints(btnCheckOut, 2, 4);
        		chipsPane.setConstraints(btnClose, 2, 5);
        		chipsPane.setConstraints(listViewTransaction, 3, 1);
        		chipsPane.setConstraints(transactionHbox, 3, 2);

        		chipsPane.getChildren().addAll(transactionHbox, listViewInventory, listViewTransaction, imgView1, btnAdd, btnRemove, btnCheckOut, btnClose);

        		chipsStage.setScene(new Scene(chipsPane, 1100,400));
        		chipsStage.setResizable(false);
        		chipsStage.setTitle("Chips");
        		chipsStage.show();
            }
        });
		
		Image candyImage = new Image("CandyImage.jpg");
		ImageView candyImageView = new ImageView();
		candyImageView.setImage(candyImage);
		candyImageView.setFitHeight(imgDimension);
		candyImageView.setFitWidth(imgDimension);
		
		Button btnCandy = new Button();
		btnCandy.setText("Candy");
		btnCandy.setMaxWidth(btnDimension);
		btnCandy.setMaxHeight(btnDimension);
		btnCandy.setGraphic(candyImageView);
		btnCandy.setStyle("-fx-background-color: white;");
		
		btnCandy.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	//candysMenu();
            	Stage candyStage = new Stage();
        		GridPane candyPane = new GridPane();
        		candyPane.setHgap(10);
        		candyPane.setVgap(10);
        		candyPane.setPadding(new Insets(10, 10, 10, 10));
        		
        		ArrayList candyList = new ArrayList();
        		candyList = inventory.getCandy();
        		
        		ArrayList transactionList = new ArrayList();
        		transactionList = transaction.getTransaction();
        		
        		ListView listViewInventory = new ListView();
        		listViewInventory.setMinSize(400, 100);
        		
        		ListView listViewTransaction = new ListView();
        		listViewTransaction.setMinSize(400, 100);
        		
            	listViewInventory.getItems().clear();
            	listViewTransaction.getItems().clear();
        		
        		Image img1 = new Image("m&m.jpg");
        		ImageView imgView1 = new ImageView();
        		imgView1.setImage(img1);
        		imgView1.setFitHeight(imgDimension);
        		imgView1.setFitWidth(imgDimension);
        		
        		String strImage = ((Product) inventory.getCandy().get(1)).getProductImage();
        		System.out.println("The string image for product 1 = " + strImage);
        		System.out.println("Total number of candy :" + inventory.getNumberOfCandy());
        		
        		for (int i = 0; i < inventory.getNumberOfCandy(); i++) { // start of loop
        				listViewInventory.getItems().add(inventory.getCandy().get(i));
        		} // End of For Loop
        		
        		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
        			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
        		}
        		
        		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
        		
        		int imgDimension = 200;
        		int btnWidth = 200;
        		int btnHeight = 25;
        		
        		Button btnAdd = new Button();
        		btnAdd.setText("ADD");
        		btnAdd.setMinWidth(btnWidth);
        		btnAdd.setMinHeight(btnHeight);
        		//btnAdd.setGraphic(imgView1);
        		
        		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewInventory.getSelectionModel().getSelectedIndex();
                    	transaction.addTransaction((Product) inventory.getCandy().get(selectedItem));
                    	inventory.removeProduct(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfCandy(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getCandy().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                });
        		
        		Button btnRemove = new Button();
        		btnRemove.setText("REMOVE");
        		btnRemove.setMinWidth(btnWidth);
        		btnRemove.setMinHeight(btnHeight);
        		//btnRemove.setGraphic(imgView1);
        		
        		btnRemove.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewTransaction.getSelectionModel().getSelectedIndex();
                    	inventory.addProduct((Product) transaction.getProducts().get(selectedItem));
                    	transaction.removeTransaction(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfCandy(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getCandy().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                    
                });
        		
        		Button btnClose = new Button();
        		btnClose.setText("CLOSE");
        		btnClose.setMinWidth(btnWidth);
        		btnClose.setMinHeight(btnHeight);
        		
        		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	candyStage.close();
                    }
                });
        		
        		Button btnCheckOut = new Button();
        		btnCheckOut.setText("CHECKOUT");
        		btnCheckOut.setMinWidth(btnWidth);
        		btnCheckOut.setMinHeight(btnHeight);
        		
        		btnCheckOut.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                		Stage checkOutStage = new Stage();
                		GridPane checkoutGridPane = new GridPane();
                		
                		checkoutGridPane.setPadding(new Insets(10, 10, 10, 10));
                		
                		Button btnClose = new Button();
                		btnClose.setText("Close");
                		btnClose.setMinWidth(300);
                		btnClose.setMinHeight(25);
                		
                		Button btnDone = new Button();
                		btnDone.setText("Main Menu");
                		btnDone.setMinWidth(300);
                		btnDone.setMinHeight(25);
                		
                		btnDone.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            	candyStage.close();
                            	dispenserStage.close();
                            }
                        });
                		
                		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            }
                        });
                		
                		Label lblPayment = new Label("Total Amount Due $" + String.valueOf(transaction.getTransactionPrice()));
                		lblPayment.setStyle("-fx-text-fill: green");
                		lblPayment.setFont(Font.font("Times", 16));
                		lblPayment.setAlignment(Pos.BASELINE_CENTER);
                		lblPayment.setMinWidth(300);
                		
                		HBox hboxname = new HBox();
                		Label lblName = new Label("Name     ");
                		TextField txtName = new TextField();
                		txtName.setMinWidth(250);
                		txtName.setStyle("-fx-text-fill: blue");
                		txtName.setFont(Font.font("Times", 12));
                		txtName.setAlignment(Pos.BASELINE_LEFT);
                		hboxname.getChildren().addAll(lblName,txtName);
                		
                		checkoutGridPane.setConstraints(lblPayment, 1, 1);
                		checkoutGridPane.setConstraints(hboxname, 1, 2);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnDone, 1, 4);
                		
                		checkoutGridPane.getChildren().addAll(hboxname,btnDone, lblPayment,btnClose);
                		
                		checkOutStage.setScene(new Scene(checkoutGridPane, 320,150));
                		checkOutStage.setResizable(false);
                		checkOutStage.setTitle("Payment");
                		checkOutStage.show();
                    }
                });
        		
        		
        		candyPane.setConstraints(listViewInventory, 1, 1);
        		candyPane.setConstraints(imgView1, 2, 1);
        		candyPane.setConstraints(btnAdd, 2, 2);
        		candyPane.setConstraints(btnRemove, 2, 3);
        		candyPane.setConstraints(btnCheckOut, 2, 4);
        		candyPane.setConstraints(btnClose, 2, 5);
        		candyPane.setConstraints(listViewTransaction, 3, 1);
        		candyPane.setConstraints(transactionHbox, 3, 2);

        		candyPane.getChildren().addAll(transactionHbox, listViewInventory, listViewTransaction, imgView1, btnAdd, btnRemove, btnCheckOut, btnClose);

        		candyStage.setScene(new Scene(candyPane, 1100,400));
        		candyStage.setResizable(false);
        		candyStage.setTitle("Candy");
        		candyStage.show();
            }
        });
		
		Image gumImage = new Image("gumImage.jpg");
		ImageView gumImageView = new ImageView();
		gumImageView.setImage(gumImage);
		gumImageView.setFitHeight(imgDimension);
		gumImageView.setFitWidth(imgDimension);
		
		Button btnGum = new Button();
		btnGum.setText("Gum");
		//btnGum.set
		btnGum.setMaxWidth(btnDimension);
		btnGum.setMaxHeight(btnDimension);
		btnGum.setGraphic(gumImageView);
		btnGum.setStyle("-fx-background-color: white;");
		
		btnGum.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	//gumsMenu();
            	Stage gumStage = new Stage();
        		GridPane gumPane = new GridPane();
        		gumPane.setHgap(10);
        		gumPane.setVgap(10);
        		gumPane.setPadding(new Insets(10, 10, 10, 10));
        		
        		ArrayList gumList = new ArrayList();
        		gumList = inventory.getGum();
        		
        		ArrayList transactionList = new ArrayList();
        		transactionList = transaction.getTransaction();
        		
        		ListView listViewInventory = new ListView();
        		listViewInventory.setMinSize(400, 100);
        		
        		ListView listViewTransaction = new ListView();
        		listViewTransaction.setMinSize(400, 100);
        		
            	listViewInventory.getItems().clear();
            	listViewTransaction.getItems().clear();
        		
        		Image img1 = new Image("lays-classic.jpg");
        		ImageView imgView1 = new ImageView();
        		imgView1.setImage(img1);
        		imgView1.setFitHeight(imgDimension);
        		imgView1.setFitWidth(imgDimension);
        		
        		String strImage = ((Product) inventory.getGum().get(1)).getProductImage();
        		System.out.println("The string image for product 1 = " + strImage);
        		System.out.println("Total number of gum :" + inventory.getNumberOfGum());
        		
        		for (int i = 0; i < inventory.getNumberOfGum(); i++) { // start of loop
        				listViewInventory.getItems().add(inventory.getGum().get(i));
        		} // End of For Loop
        		
        		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
        			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
        		}
        		
        		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
        		
        		int imgDimension = 200;
        		int btnWidth = 200;
        		int btnHeight = 25;
        		
        		Button btnAdd = new Button();
        		btnAdd.setText("ADD");
        		btnAdd.setMinWidth(btnWidth);
        		btnAdd.setMinHeight(btnHeight);
        		//btnAdd.setGraphic(imgView1);
        		
        		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewInventory.getSelectionModel().getSelectedIndex();
                    	transaction.addTransaction((Product) inventory.getGum().get(selectedItem));
                    	inventory.removeProduct(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfGum(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getGum().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                });
        		
        		Button btnRemove = new Button();
        		btnRemove.setText("REMOVE");
        		btnRemove.setMinWidth(btnWidth);
        		btnRemove.setMinHeight(btnHeight);
        		//btnRemove.setGraphic(imgView1);
        		
        		btnRemove.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	
                    	int selectedItem = listViewTransaction.getSelectionModel().getSelectedIndex();
                    	inventory.addProduct((Product) transaction.getProducts().get(selectedItem));
                    	transaction.removeTransaction(selectedItem);
                    	
                    	listViewInventory.getItems().clear();
                    	listViewTransaction.getItems().clear();
                    	
                		for (int i = 0; i < inventory.getNumberOfGum(); i++) { // start of loop
                				listViewInventory.getItems().add(inventory.getGum().get(i));
                		} // End of For Loop
                    	
                		for(int i=0; i < transaction.getNumberOfTransaction(); i++) {
                			listViewTransaction.getItems().add(transaction.getTransaction().get(i));
                		}
                		txtTotalTransaction.setText("$" + String.valueOf(transaction.getTransactionPrice()));
                    }
                    
                });
        		
        		Button btnClose = new Button();
        		btnClose.setText("CLOSE");
        		btnClose.setMinWidth(btnWidth);
        		btnClose.setMinHeight(btnHeight);
        		
        		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                    	gumStage.close();
                    }
                });
        		
        		Button btnCheckOut = new Button();
        		btnCheckOut.setText("CHECKOUT");
        		btnCheckOut.setMinWidth(btnWidth);
        		btnCheckOut.setMinHeight(btnHeight);
        		
        		btnCheckOut.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    // Override the handle method
                    public void handle(ActionEvent event) {
                		Stage checkOutStage = new Stage();
                		GridPane checkoutGridPane = new GridPane();
                		
                		checkoutGridPane.setPadding(new Insets(10, 10, 10, 10));
                		
                		Button btnClose = new Button();
                		btnClose.setText("Close");
                		btnClose.setMinWidth(300);
                		btnClose.setMinHeight(25);
                		
                		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	dispenserStage.close();
                            }
                        });
                		
                		Button btnDone = new Button();
                		btnDone.setText("Main Menu");
                		btnDone.setMinWidth(300);
                		btnDone.setMinHeight(25);
                		
                		btnDone.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            	gumStage.close();
                            	dispenserStage.close();
                            }
                        });
                		
                		btnClose.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            // Override the handle method
                            public void handle(ActionEvent event) {
                            	checkOutStage.close();
                            }
                        });
                		
                		Label lblPayment = new Label("Total Amount Due $" + String.valueOf(transaction.getTransactionPrice()));
                		lblPayment.setStyle("-fx-text-fill: green");
                		lblPayment.setFont(Font.font("Times", 16));
                		lblPayment.setAlignment(Pos.BASELINE_CENTER);
                		lblPayment.setMinWidth(300);
                		
                		HBox hboxname = new HBox();
                		Label lblName = new Label("Name     ");
                		TextField txtName = new TextField();
                		txtName.setMinWidth(250);
                		txtName.setStyle("-fx-text-fill: blue");
                		txtName.setFont(Font.font("Times", 12));
                		txtName.setAlignment(Pos.BASELINE_LEFT);
                		hboxname.getChildren().addAll(lblName,txtName);
                		
                		checkoutGridPane.setConstraints(lblPayment, 1, 1);
                		checkoutGridPane.setConstraints(hboxname, 1, 2);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnClose, 1, 3);
                		checkoutGridPane.setConstraints(btnDone, 1, 4);
                		
                		checkoutGridPane.getChildren().addAll(hboxname,btnDone, lblPayment,btnClose);
                		
                		checkOutStage.setScene(new Scene(checkoutGridPane, 320,150));
                		checkOutStage.setResizable(false);
                		checkOutStage.setTitle("Payment");
                		checkOutStage.show();
                    }
                });
        		
        		
        		gumPane.setConstraints(listViewInventory, 1, 1);
        		gumPane.setConstraints(imgView1, 2, 1);
        		gumPane.setConstraints(btnAdd, 2, 2);
        		gumPane.setConstraints(btnRemove, 2, 3);
        		gumPane.setConstraints(btnCheckOut, 2, 4);
        		gumPane.setConstraints(btnClose, 2, 5);
        		gumPane.setConstraints(listViewTransaction, 3, 1);
        		gumPane.setConstraints(transactionHbox, 3, 2);

        		gumPane.getChildren().addAll(transactionHbox, listViewInventory, listViewTransaction, imgView1, btnAdd, btnRemove, btnCheckOut, btnClose);

        		gumStage.setScene(new Scene(gumPane, 1100,400));
        		gumStage.setResizable(false);
        		gumStage.setTitle("Gum");
        		gumStage.show();
            }
        });
	
		Button btnDispenserClose = new Button();
		btnDispenserClose.setText("Close");
		btnDispenserClose.setMinWidth(250);
		btnDispenserClose.setMinHeight(15);
		
		btnDispenserClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	dispenserStage.close();
            }
        });
		
		dispenserPane.setConstraints(btnDrinks, 1, 1);
		dispenserPane.setConstraints(btnChips, 1, 2);
		dispenserPane.setConstraints(btnCandy, 2, 1);
		dispenserPane.setConstraints(btnGum, 2, 2);
		//dispenserPane.setConstraints(btnCheckout, 2, 3);
		dispenserPane.setConstraints(btnDispenserClose, 1, 3);

		
		dispenserPane.getChildren().addAll(btnDrinks, btnChips, btnCandy, btnGum, btnDispenserClose);

		dispenserStage.setScene(new Scene(dispenserPane, 575,480));
		dispenserStage.setResizable(false);
		dispenserStage.setTitle("Vending Machine");
		dispenserStage.show();
	}
	
	
	
	public void loginMenu() {
		Stage loginStage = new Stage();
		GridPane loginPane = new GridPane();
		
		loginPane.setHgap(20);
		loginPane.setVgap(5);
		loginPane.setPadding(new Insets(5, 5, 5, 5));
		
		Label lblLogin = new Label("Login");
		TextField txtLogin = new TextField();
		//txtLogin.setEditable(true);
		txtLogin.setStyle("-fx-text-fill: blue");
		txtLogin.setFont(Font.font("Times", 12));
		txtLogin.setAlignment(Pos.BASELINE_LEFT);
		
		Label lblPassword = new Label("Password");
		PasswordField txtPassword = new PasswordField();
		//txtLogin.setEditable(true);
		txtPassword.setStyle("-fx-text-fill: blue");
		txtPassword.setFont(Font.font("Times", 12));
		txtPassword.setAlignment(Pos.BASELINE_LEFT);
		
		Button btnOk = new Button();
		btnOk.setText("Ok");
		btnOk.setMinWidth(250);
		btnOk.setMinHeight(15);
		
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	
            	System.out.println("Login: " + txtLogin.getText());
            	System.out.println("Password :" + txtPassword.getText());
            	
            	if (txtLogin.getText().equals("") && txtPassword.getText().equals("")) {
            		//inventoryMenu();
            		loginStage.close();
            	}else {
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Login");
                	alert.setHeaderText(null);
                	alert.setContentText("Login or Password is Incorrect");
                	alert.showAndWait();
            	}
 
            }
        });
		
		Button btnClose = new Button();
		btnClose.setText("Close");
		btnClose.setMinWidth(250);
		btnClose.setMinHeight(15);
		
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	loginStage.close();
            }
        });
		
		
		loginPane.setConstraints(lblLogin, 1, 1);
		loginPane.setConstraints(txtLogin, 2, 1);
		loginPane.setConstraints(lblPassword, 1, 2);
		loginPane.setConstraints(txtPassword, 2, 2);
		loginPane.setConstraints(btnOk, 2, 3);
		loginPane.setConstraints(btnClose, 2, 4);

		loginPane.getChildren().addAll(lblLogin, txtLogin, lblPassword, txtPassword, btnOk, btnClose);

		loginStage.setScene(new Scene(loginPane, 350,125));
		loginStage.setResizable(false);
		loginStage.setTitle("Login");
		loginStage.show();
        
	}
	
	public void inventoryMenu(Dispenser dispenser) {
		
		Inventory inventory = new Inventory();
		ArrayList inventoryArray = inventory.getProducts();
		
		Stage inventoryStage = new Stage();
		GridPane inventoryPane = new GridPane();
		TextArea txtInventory = new TextArea();
		txtInventory.setMinWidth(500);
		txtInventory.setMinHeight(250);
		
		for(int i=0; i < inventoryArray.size(); i++) {
			txtInventory.appendText(inventoryArray.get(i).toString() + "\n");
		}
		
		inventoryPane.setHgap(20);
		inventoryPane.setVgap(5);
		inventoryPane.setPadding(new Insets(5, 5, 5, 5));
		
		Label lblInventory = new Label("Current Inventory");
		txtInventory.setPrefColumnCount(20);
		txtInventory.setPrefRowCount(5);
		txtInventory.setWrapText(true);
		txtInventory.setStyle("-fx-text-fill: blue");
		txtInventory.setFont(Font.font("Times",12));
		
		Label lblTotalDrinks = new Label("Quantity of Drinks");
		TextField txtTotalDrinks = new TextField(String.valueOf(inventory.getNumberOfDrinks()));
		//txtLogin.setEditable(true);
		txtTotalDrinks.setStyle("-fx-text-fill: blue");
		txtTotalDrinks.setFont(Font.font("Times", 12));
		txtTotalDrinks.setAlignment(Pos.BASELINE_LEFT);
		
		Label lblTotalChips = new Label("Quantity of Chips");
		TextField txtTotalChips = new TextField(String.valueOf(inventory.getNumberOfChips()));
		//txtLogin.setEditable(true);
		txtTotalChips.setStyle("-fx-text-fill: blue");
		txtTotalChips.setFont(Font.font("Times", 12));
		txtTotalChips.setAlignment(Pos.BASELINE_LEFT);
		
		Label lblTotalCandy = new Label("Quantity of Candy");
		TextField txtTotalCandy = new TextField(String.valueOf(inventory.getNumberOfCandy()));
		//txtLogin.setEditable(true);
		txtTotalCandy.setStyle("-fx-text-fill: blue");
		txtTotalCandy.setFont(Font.font("Times", 12));
		txtTotalCandy.setAlignment(Pos.BASELINE_LEFT);
		
		Label lblTotalGum = new Label("Quantity of Gum");
		TextField txtTotalGum = new TextField(String.valueOf(inventory.getNumberOfGum()));
		//txtLogin.setEditable(true);
		txtTotalGum.setStyle("-fx-text-fill: blue");
		txtTotalGum.setFont(Font.font("Times", 12));
		txtTotalGum.setAlignment(Pos.BASELINE_LEFT);
		
		Label lblTotalProducts = new Label("Quantity of Products");
		TextField txtTotalProducts = new TextField(String.valueOf(inventory.getNumberOfProducts()));
		//txtLogin.setEditable(true);
		txtTotalProducts.setStyle("-fx-text-fill: blue");
		txtTotalProducts.setFont(Font.font("Times", 12));
		txtTotalProducts.setAlignment(Pos.BASELINE_LEFT);
		
		Label lblInventoryPrice = new Label("Inventory Total Price");
		TextField txtInventoryPrice = new TextField("$" + String.valueOf(inventory.getInventoryPrice()));
		//txtLogin.setEditable(true);
		txtInventoryPrice.setStyle("-fx-text-fill: red");
		txtInventoryPrice.setFont(Font.font("Times", 12));
		txtInventoryPrice.setAlignment(Pos.BASELINE_LEFT);
		
		Button btnClose = new Button();
		btnClose.setText("Close");
		btnClose.setMinWidth(500);
		btnClose.setMinHeight(15);
		
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	inventoryStage.close();
            }
        });
		
		inventoryPane.setConstraints(lblInventory, 1, 1);
		inventoryPane.setConstraints(lblTotalDrinks, 1, 2);
		inventoryPane.setConstraints(lblTotalChips, 1, 3);
		inventoryPane.setConstraints(lblTotalCandy, 1, 4);
		inventoryPane.setConstraints(lblTotalGum, 1, 5);
		inventoryPane.setConstraints(lblTotalProducts, 1, 6);
		inventoryPane.setConstraints(lblInventoryPrice, 1, 7);
		
		inventoryPane.setConstraints(txtInventory, 2, 1);
		inventoryPane.setConstraints(txtTotalDrinks, 2, 2);
		inventoryPane.setConstraints(txtTotalChips, 2, 3);
		inventoryPane.setConstraints(txtTotalCandy, 2, 4);
		inventoryPane.setConstraints(txtTotalGum, 2, 5);
		inventoryPane.setConstraints(txtTotalProducts, 2, 6);
		inventoryPane.setConstraints(txtInventoryPrice, 2, 7);
		
		inventoryPane.setConstraints(btnClose, 2, 8);
		
		inventoryPane.getChildren().addAll(btnClose,lblInventoryPrice, lblInventory, lblTotalDrinks, lblTotalChips, lblTotalCandy, lblTotalGum,lblTotalProducts,txtInventoryPrice,txtInventory,txtTotalDrinks,txtTotalChips,txtTotalCandy,txtTotalGum,txtTotalProducts);

		inventoryStage.setScene(new Scene(inventoryPane,700,500));
		inventoryStage.setResizable(false);
		inventoryStage.setTitle("Inventory");
		inventoryStage.show();
		//System.out.println("Launch Inventory Menu");
	}
	
public void customerMenu( ) throws FileNotFoundException {
		
		Inventory customer = new Inventory();
		ArrayList customerArray = customer.getProducts();
		
		Stage customerStage = new Stage();
		GridPane customerPane = new GridPane();
		TextArea txtInventory = new TextArea();
		txtInventory.setMinWidth(500);
		txtInventory.setMinHeight(250);
		
		//Scanner scanner = new Scanner(new File("C:\\Users\\JasonBorum\\eclipse-workspace\\JavaFxVending\\CSV\CustomerDisplay.txt"));
		//scanner.useDelimiter(",");
		//while(scanner.hasNext()){
		//  txtInventory.appendText(scanner.next()+"|\n");
		//}
		//scanner.close();

		customerPane.setHgap(20);
		customerPane.setVgap(5);
		customerPane.setPadding(new Insets(5, 5, 5, 5));
		
		Label lblInventory = new Label("Current Customer");
		txtInventory.setPrefColumnCount(20);
		txtInventory.setPrefRowCount(5);
		txtInventory.setWrapText(true);
		txtInventory.setStyle("-fx-text-fill: blue");
		txtInventory.setFont(Font.font("Times",12));
		
		
		
		Button btnClose = new Button();
		btnClose.setText("Close");
		btnClose.setMinWidth(500);
		btnClose.setMinHeight(15);
		
		btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Override the handle method
            public void handle(ActionEvent event) {
            	customerStage.close();
            }
        });
		
		customerPane.setConstraints(lblInventory, 1, 1);
		customerPane.setConstraints(txtInventory, 2, 1);
		customerPane.setConstraints(btnClose, 2, 8);
		customerPane.getChildren().addAll(btnClose, lblInventory,txtInventory);

		customerStage.setScene(new Scene(customerPane,700,350));
		customerStage.setResizable(false);
		customerStage.setTitle("Customer Queue");
		customerStage.show();
		//System.out.println("Launch Inventory Menu");
	}
}
