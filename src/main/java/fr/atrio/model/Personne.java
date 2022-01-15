package fr.atrio.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.fabric.xmlrpc.base.Array;

import fr.atrio.database.MySqlConnection;

public class Personne {
	private String name;
	private String firstname;
	private Birth birth;
	
	//Default constructor
	public void Personne () {
		this.name ="";
		this.firstname="";
		this.birth.setDay(0);
		this.birth.setMonth(0);
		this.birth.setYear(0);
	}
	
	public boolean personneCheck() {
		
		boolean flag = true ;
		if (this.birth.getYear()<1872) {
			flag=  false;
		}
		
		return flag;
	}
	
	public boolean personneSave() throws Exception {
		boolean flag = personneCheck();
		
		if (flag) {
			Connection conn = MySqlConnection.getInstance();
	        String req = "INSERT INTO personne(name, firstname, birth) VALUES (?,?,?)";
	        try {
	            //La requete préparée
	            PreparedStatement pstmt = conn.prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);
	            //Les données à injecter dans la requête préparée
	            pstmt.setString(1, this.name);
	            pstmt.setString(2, this.firstname);
	            pstmt.setString(3, this.birth.toString());
	            //Exécution de la requête
	           
	            pstmt.executeUpdate();
	        } catch (SQLException ex) {
	            throw new Exception("Cet personne existe déjà");
	        }	
	}
		return flag;
   }
	
public Personne[] selectAllPerson() {
        
        String req = "SELECT * FROM personne ORDER BY nom ASC;";
        Connection conn = MySqlConnection.getInstance();
        Personne[] result = new Array();
        
        try {

            PreparedStatement pstmt = conn.prepareStatement(req);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.first()) {
                do {
                    
                } while (rs.next());
            }

        } catch (SQLException ex) {
            
        }

        return result;
    }
}
