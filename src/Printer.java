import java.io.*;
import java.util.concurrent.TimeUnit;
public class Printer {
	
	String path = "./outputs/";
	String content = new String();
	int index;
	BufferedWriter Writer = null;
	Printer(int id){
		index = id;
	}
	void print(StringBuffer b) throws InterruptedException, IOException
	{
		TimeUnit.MILLISECONDS.sleep(2750);
		Writer = new BufferedWriter(new FileWriter(path+"PRINTER"+index, true));
		Writer.flush();
		content = b.toString()+"\n";
		Writer.write(content);
		Writer.close();
		
		
		
	}
}
