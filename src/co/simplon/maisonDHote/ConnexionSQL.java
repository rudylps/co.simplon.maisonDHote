package co.simplon.maisonDHote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionSQL {
	
	private final static String BDPATH = "jdbc:mysql://localhost:3306/maisondhote";
	private final static String DBUSER = "admin";
	private final static String DBPASSWORD = "admin"; 
	private static Connection connection;
	
	public void initConnexion() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
		System.out.println("go!");
	}

	public void insertData(String nom, String prenom, String mail, String tel) throws SQLException //exception qd ça ne marche pas
	{
		// interface permettant l'execution de requetes sql
		Statement statement = null; // objet statement 

		try {
			statement = connection.createStatement();
			// obligé de mettre les accents AltGr+7, pas de simple quote. Alternance langage java et mysql, c'est pour ça les doubles et simples quotes
			String sql = "INSERT INTO `reservation` (`nom`, `prenom`, `mail`, `tel`) VALUES ('" + nom + "', '" + prenom + "', '" + mail + "', '" + tel + "')"; 
			statement.executeUpdate(sql); // execute la chaine de caracteres du dessus sous forme de requete
		}
		catch(SQLException e){
			System.out.println("Erreur à l'insertion des données");
		}
		finally{	 
			statement.close();
		}
	
		System.out.println();
	}
	
}
