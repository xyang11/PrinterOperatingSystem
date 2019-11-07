import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;



class disks{
	
	Rectangle disk1 = new Rectangle();
	Rectangle disk2 = new Rectangle();
	public void display(String title)
	{
		//use circles to represent disks
		Stage window = new Stage();
		window.setTitle(title);		
		VBox d1_out = new VBox();
		VBox d2_out = new VBox();
		HBox g = new HBox(40);
		Scene scene = new Scene(g, 600,600);
		Label l1 = new Label();
		l1.setText("		USER1				");	
		Label l2 = new Label();
		l2.setText("		USER2				");		

		disk1.setWidth(100);
		disk1.setHeight(0);
		disk2.setWidth(100);
		disk2.setHeight(0);
		
		d1_out.getChildren().addAll(l1,disk1);
		d2_out.getChildren().addAll(l2,disk2);
		g.getChildren().addAll(d1_out,d2_out);
		window.setScene(scene);
		window.show();
	}
	
	
}


class users{
	TextArea u1 = new TextArea(); 
	TextArea u2 = new TextArea();
	TextArea u3 = new TextArea(); 
	TextArea u4 = new TextArea();
	public void display()
	{
		//main component declaration
		Stage window = new Stage();		
		window.setTitle("USERS DISPLAY");			
		VBox user_n_out1 = new VBox();
		VBox user_n_out2 = new VBox();
		VBox user_n_out3 = new VBox();
		VBox user_n_out4 = new VBox();
		HBox users = new HBox();
		
		//display name of each printer on the top
		Label User1 = new Label();
		User1.setText("				USER1				");	
		Label User2 = new Label();
		User2.setText("				USER2				");		
		Label User3 = new Label();
		User3.setText("				USER3				");	
		Label User4 = new Label();
		User4.setText("				USER4				");	
		
		//output area for each printer

		u1.setEditable(false);
		u2.setEditable(false);
		u3.setEditable(false);
		u4.setEditable(false);
		u1.setPrefWidth(200);
		u2.setPrefWidth(200);
		u3.setPrefWidth(200);
		u4.setPrefWidth(200);
		
		user_n_out1.getChildren().addAll(User1,u1);
		user_n_out2.getChildren().addAll(User2,u2);
		user_n_out3.getChildren().addAll(User3,u3);
		user_n_out4.getChildren().addAll(User4,u4);
		
		users.getChildren().addAll(user_n_out1,user_n_out2,user_n_out3,user_n_out4);

		
		Scene scene = new Scene(users);
		window.setScene(scene);
		window.show();
	}
}

class printers{
	TextArea p1 = new TextArea();

	TextArea p2 = new TextArea();

	TextArea p3 = new TextArea();		

	
	public void display(String title)
	{
		//main component declaration
		Stage window = new Stage();		
		window.setTitle(title);			
		HBox printername = new HBox();
		BorderPane border = new BorderPane();
		border.setTop(printername);
		
		//display name of each printer on the top
		Label printer1 = new Label();
		printer1.setText("				PRINTER1				");	
		Label printer2 = new Label();
		printer2.setText("				PRINTER2				");		
		Label printer3 = new Label();
		printer3.setText("				PRINTER3				");
		printername.getChildren().addAll(printer1,printer2,printer3);
		
		//output area for each printer

		p1.setPrefWidth(250);p2.setPrefWidth(200);p3.setPrefWidth(250);		
		p1.setEditable(false);p2.setEditable(false);p3.setEditable(false);
		
		border.setLeft(p1);
		border.setCenter(p2);
		border.setRight(p3);
		BorderPane.setAlignment(p1, Pos.CENTER_LEFT);
		BorderPane.setAlignment(p2, Pos.CENTER);
		BorderPane.setAlignment(p3, Pos.CENTER_RIGHT);
		
		Scene scene = new Scene(border);
		window.setScene(scene);
		window.showAndWait();
		
	}
}



