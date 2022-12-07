package tp2package;
import javax.swing.JOptionPane;
public class OutputWindowMessage implements IJournal {

	@Override
	public void outPut_Msg(String message,int mat) {
		JOptionPane.showMessageDialog(null, message+mat,"window Message",JOptionPane.INFORMATION_MESSAGE);
	}

}
