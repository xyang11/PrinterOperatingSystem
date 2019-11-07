import java.lang.StringBuffer;
import java.util.concurrent.TimeUnit;
public class Disk {
	
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	private int next_write = 0;
	
	void write(int sector, StringBuffer data) throws InterruptedException
	{
		TimeUnit.MILLISECONDS.sleep(200);
		sectors[sector]= data;
		next_write = sector + 1;
	}
	StringBuffer read(int sector) throws InterruptedException
	{
		TimeUnit.MILLISECONDS.sleep(200);
//		System.out.println(sectors[sector]);
		return sectors[sector];
		
	}	
	int freesector()
	{
		return next_write;
	}
}
