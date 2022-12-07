package tp2package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements EtudiantServiceInterface {
	
	
	Universite GetById(int universityId) throws SQLException {
		
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn(); 
		Statement stmt = connect.createStatement();
		OutputWindowMessage popup = new OutputWindowMessage();
		popup.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e",universityId);
		System.out.println("LogBD : d�but recherche de id universit� dans la base de donn�e"+universityId);
		
		String sql = "SELECT * FROM universite WHERE id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
		popup.outPut_Msg("LogBD : universit� r�cup�r�e",universityId);
		System.out.println("LogBD : universit� r�cup�r�e"+universityId);
		
		rs.next();
		return u;	
	
		
	}	
	
}
