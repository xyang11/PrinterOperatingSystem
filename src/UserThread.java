import java.lang.Thread;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.StringBuffer;

class UserThread extends Thread{

	StringBuffer content;


	int dN;
	UserThread(int id)
	{
		dN = id;	
	}
	
	boolean read ( BufferedReader r) throws IOException
	{	
		String line = r.readLine();
		if(line != null)
			content = new StringBuffer(line);
		return line != null;		
	}
	
	
	
	@Override	
	public void run()
	{

		BufferedReader Reader = null;
		FileInfo info = null;
		String saveName = null;
		String readName = "USER"+dN;
		String readpath =  "./inputs/";

		try
		{	
			Reader = new BufferedReader( new FileReader(readpath+readName));
			while(read(Reader)) {
			
				 switch(content.charAt(1))
				 {
				 case 's':
					 info = new FileInfo();
					 info.diskNumber = main.DiskManager.request();
					 info.startingSector = main.Disks[info.diskNumber].freesector();
					 
					 info.fileLength = 0;
					 saveName= content.substring(6);
					 
					 break;
				 case 'e':
					 main.DiskManager.release(info.diskNumber);
					 main.directory.enter(saveName, info);					 
					 break;					 
				 case 'p':					 				 
					 String printname = content.substring(7);
					 info  = main.directory.lookup(printname);
					 PrintJobThread PrinterJob = new PrintJobThread(info);					 
					 PrinterJob.start();
					 break;
				 default:
					 main.Disks[info.diskNumber].write(info.startingSector+info.fileLength, content);
					 info.fileLength++;
					 break;											 											 
				 }				
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	}
}