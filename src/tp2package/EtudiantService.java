package tp2package;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService implements EtudiantServiceInterface  {
	
	
	boolean inscription (int matricule, String nom, String prenom, String email,String pwd, int id_universite) throws SQLException, FileNotFoundException	
	{
		EtudiantRepository StudRep= new EtudiantRepository();
		OutputWindowMessage popup = new OutputWindowMessage();
		OutputSavefileMessage savefile = new OutputSavefileMessage();
		savefile.outPut_Msg("", matricule);
//	    UniversiteRepository UnivRep= new UniversiteRepository();
	    Etudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
//	    Universite univ=UnivRep.GetById(id_universite);
	    popup.outPut_Msg("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule ",matricule);
	    System.out.println("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
	    
	    if(email == null || email.length() == 0)
	    {
	    	return false;
	    }
	    
	    if (StudRep.Exists(matricule))
	    {
	        return false;
	    }
	    
		if (StudRep.Exists(email))
	    {
	        return false;
	    }
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 StudRep.add(stud);
		 popup.outPut_Msg("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule ",matricule);
		 System.out.println("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	
	
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
