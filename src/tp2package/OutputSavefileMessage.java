package tp2package;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class OutputSavefileMessage implements IJournal {

	@Override
	public void outPut_Msg(String message,int mat) throws FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream("outputmessage.txt")));
	}


}
