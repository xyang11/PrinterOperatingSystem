import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class main extends Application {
	static final int NUMBER_OF_DISKS = 2;
	static final int NUMBER_OF_USER = 4;
	static final int NUMBER_OF_PRINTERS = 3;
	static ResourceManager DiskManager = new ResourceManager(NUMBER_OF_DISKS);
	static ResourceManager PrinterManager = new ResourceManager(NUMBER_OF_PRINTERS);
	static Disk[] Disks = new Disk[NUMBER_OF_DISKS];
	static Printer[] Printers = new Printer[NUMBER_OF_PRINTERS];
	static DirectoryManager directory = new DirectoryManager();
	//GUI Declarations

	users USER = new users();
	printers PRINTER = new printers();
	disks DISK = new  disks();
	int counter = 200;
	String last1 = "";
	String last2 = "";
	String last3 = "";
	public static void main(String[] args) {			
		launch(args);		
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		UserThread[] Users= new UserThread[NUMBER_OF_USER];
		for(int i=0; i < NUMBER_OF_DISKS; i++)
			Disks[i] = new Disk();
		for(int i=0; i < NUMBER_OF_USER; i++)
			Users[i] = new UserThread(i+1);
		for(int i=0; i < NUMBER_OF_PRINTERS; i++)
			Printers[i] = new Printer(i+1);

		for(int i=0; i < Users.length; i++)
			Users[i].start();
		
		
	
		Stage window = new Stage();
	
		Button startButton;
		window.setTitle("141 OS");		
		
		startButton = new Button();
		startButton.setText("click to start");  		
		startButton.setOnAction(e ->{
			DISK.display("Disks display");
			USER.display();
			PRINTER.display("printers display");
		});
		
		Label label1 = new Label();
		VBox layout1 = new VBox(20);
	
		layout1.getChildren().addAll(label1,startButton);
		Scene scene =new Scene(layout1, 300, 250);		

		
		Thread thread = new Thread(new Runnable() {
			@Override 
			public void run() {
				Runnable updater = new Runnable() {

					@Override
					public void run() {
							if(Users[0].content.charAt(0) != '.') 					
								USER.u1.appendText(Users[0].content.toString()+"\n");														
							if(Users[1].content.charAt(0) != '.')
								USER.u2.appendText(Users[1].content.toString()+"\n");
							if(Users[2].content.charAt(0) != '.')
								USER.u3.appendText(Users[2].content.toString()+"\n");
							if(Users[3].content.charAt(0) != '.')
								USER.u4.appendText(Users[3].content.toString()+"\n");
							DISK.disk1.setHeight(Disks[0].freesector()*10);
							DISK.disk2.setHeight(Disks[1].freesector()*10);
							if(counter % 2800 == 0) {
								if (Disks[0].isreading)
									DISK.disk1.setFill(Color.RED);
								else
									DISK.disk1.setFill(Color.BLACK);
								if(Disks[1].isreading)
									DISK.disk2.setFill(Color.RED);
								else
									DISK.disk2.setFill(Color.BLACK);
								if(Printers[0].content != last1)
								{
									PRINTER.p1.appendText(Printers[0].content);
									last1 = Printers[0].content;
								}
								if(Printers[1].content != last2)
								{
									PRINTER.p2.appendText(Printers[1].content);
									last2 = Printers[1].content;
								}
								if(Printers[2].content != last3)
								{
									PRINTER.p3.appendText(Printers[2].content);		
									last3 = Printers[2].content;
								}
							
							}
							counter = counter +200;
					}					
				};
				
					
				while(true) {
					
					try {
						Thread.sleep(200);
						
					}
					catch(InterruptedException ex) {}
					Platform.runLater(updater);					
				}
			} 
		});
		
        thread.setDaemon(true);
        thread.start();

		
		window.setScene(scene);
		window.show();
	}
		
		
		


}
