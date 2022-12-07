package tp2package;
import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EtudiantService serv=new EtudiantService();
		try {
			serv.inscription(131, "Guendouziiiii", "wassila", "geuefgn@gmail.comm","xxxx", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
