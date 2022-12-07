package tp2package;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EtudiantRepository implements EtudiantServiceInterface {
	
	
	void add(Etudiant E) throws SQLException, FileNotFoundException
	{

//		new DBConnection();
		OutputWindowMessage popup = new OutputWindowMessage();
		OutputSavefileMessage savefile = new OutputSavefileMessage();
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "INSERT INTO etudiant VALUES (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "','"+E.getPwd()+ "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
			    popup.outPut_Msg("log : ajout dans la BD eBOOKS de l'�tudiant  du Matricule",E.getMatricule());
				System.out.println("log : ajout dans la BD eBOOKS de l'�tudiant  du Matricule" + E.getMatricule());
//			    savefile.outPut_Msg("log : ajout dans la BD eBOOKS de l'�tudiant  du Matricule", E.getMatricule());
			}else if (rs == 0){
			    popup.outPut_Msg("log : Echec de l'ajout dans la BD de l'�tudiant  du Matricule",E.getMatricule());
				System.out.println("log : Echec de l'ajout dans la BD de l'�tudiant  du Matricule" + E.getMatricule());
//				savefile.outPut_Msg("log : Echec de l'ajout dans la BD de l'�tudiant  du Matricule", E.getMatricule());
			}
		connect.close();
	 }


	boolean Exists(String email) throws SQLException	
	{
//		DBConnection BD= new DBConnection();
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		boolean rs = stmt.execute(sql);
		
		if (rs){
			System.out.println("logBD--- :email existe dans la BD  " + email);
			connect.close();
			return true;
			}
		System.out.println("logBD--- : email n'existe pas " + email);	
		connect.close();
		return false;
	}
	
	boolean Exists(int mat) throws SQLException	
	{
//		DBConnection BD= new DBConnection();
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "SELECT * FROM etudiant WHERE matricule="+ mat;
		boolean rs = stmt.execute(sql);
		
		if (rs){
			System.out.println("logBD--- :etudiant avec ce matricule existe d�ja dans la BD  " + mat);
			connect.close();
			return true;
			}
		System.out.println("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		connect.close();
		return false;
	}

}
