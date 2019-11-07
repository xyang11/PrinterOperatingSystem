
public class PrintJobThread extends Thread{
	
	
	int fdN, fsS, ffL;
	StringBuffer data = new StringBuffer();
	public PrintJobThread(FileInfo f) {

		fdN = f.diskNumber;
		fsS = f.startingSector;
		ffL = f.fileLength;
	}
	@Override
	public void run()
	{
		try
		{
			int index = main.PrinterManager.request();
//			int FreePrinter = index + 1;
			for(int i = fsS ; i < fsS+ ffL; i++) 
			{
//				System.out.println("this is printer " + FreePrinter);
				data = main.Disks[fdN].read(i);
				main.Printers[index].print(data);
			}
			main.Printers[index].content = ".";
//			System.out.println("Printer "+FreePrinter+" is released");
			main.PrinterManager.release(index);
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
