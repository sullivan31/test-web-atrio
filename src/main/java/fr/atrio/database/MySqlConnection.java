package fr.atrio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConnection {
	 private static Connection instance;

	    //Privée pour interdire l'instanciation
	    private MySqlConnection() {
	    }

	    /**
	     *
	     * @return une connexion à la DB ou null
	     */
	    public static Connection getInstance() {

	        //Est ce que j'ai déjà une connection construite ?
	        //Si oui je la retourne
	        if (instance == null) {//Sinon je la construis et je la retourne
	            //Properties datas = new Properties();
	            //datas.load(inStream);
	            String host = "localhost";
	            String port = "3306";
	            String database = "test";
	            String login = "toto";
	            String pwd = "tata";
	            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false";
	            try {
	                Class.forName("com.mysql.jdbc.Driver");

	                instance = DriverManager.getConnection(url, login, pwd);
	            } catch (SQLException ex) {
	                Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
	                System.exit(1);
	            } catch (ClassNotFoundException ex) {
	                Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
	                System.exit(2);
	            }
	        }
	        return instance;

	    }
}