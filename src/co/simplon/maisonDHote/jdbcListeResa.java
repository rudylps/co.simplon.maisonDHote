package co.simplon.maisonDHote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner; // importe ttes les classes dt il a besoin

public class jdbcListeResa {

	private final static String BDPATH = "jdbc:mysql://localhost:3306/maisondhote";
	private final static String DBUSER = "admin";
	private final static String DBPASSWORD = "admin"; // chemin de la bdd, login et mdp 
	
	private static Connection connection; // objet connexion, declaré pr etre utilisé
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException { //classe main, lancee de base par java. throws permet de ne pas faire try catch
		
		// Load the database driver
		Class.forName("com.mysql.jdbc.Driver"); // les 2 a mettre dans une fonction
		
		// Create the jdbc connection
		connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD); // recuperer l'objet connexion. Crée la connexion, renvoie aux exceptions. DriverManager
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(!input.equals("exit"))
		{
			System.out.println("What do you want to do ? D - Display all the DB record / A - Add new record in DB");
			input = sc.nextLine();
			
			switch (input) {
			case "A":
	
				String nom = "";
				String prenom = "";
				while((nom.isEmpty()) || (prenom.isEmpty()))
				{
					System.out.println("'Nom' for new record :");
					nom = sc.nextLine();
					
					System.out.println("'Prenom' for new record :");
					prenom = sc.nextLine();
				}
				
				insertData(nom, prenom);
				
				break;
			case "D":
				System.out.println("");
				showData();
				break;
			default:
				System.out.println("Wrong input !");
				break;
			}
			
			System.out.println();
		}
				
		
		// At the end, close the connection
		connection.close();
	}

	
	public static void insertData(String nom, String prenom) throws SQLException //exception qd ça ne marche pas
	{
		Statement statement = null; // objet statement 

		try {
			statement = connection.createStatement();
			// obligé de mettre les accents AltGr+7, pas de simple quote. Alternance langage java et mysql, c'est pour ça les doubles et simples quotes
			String sql = "INSERT INTO `reservation` (`nom`, `prenom`) VALUES ('" + nom + "', '" + prenom + "')"; 
			statement.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.println("An error occured trying to insert the new data !");
		}
		finally{	 
			statement.close();
		}
	
		System.out.println();
	}
	
//	public static void showData() throws SQLException
//	{
//		Statement statement = null;
//		ResultSet rs = null;
//
//		try {
//			// Create the statement
//			statement = connection.createStatement();
//			String sql = "SELECT * FROM reservation"; //
//			
//			// Execute the query
//			rs = statement.executeQuery(sql);
//		
//			// Loop on the results extracted from the database
//			System.out.println("Liste actuelle des reservations :");
//			while (rs.next()) {
//				System.out.println("  - " + rs.getString("id") + " : " + rs.getString("prenom") + " " +  rs.getString("nom"));
//			}
//		}
//		catch(SQLException e){
//			System.out.println("An error occured trying to read the data !");
//		}
//		finally{	 
//			statement.close();
//		}
//		
//		System.out.println();
//	}
	
	public static void showData() throws SQLException
	{
		Statement statement = null;
		ResultSet rs = null;

		//try {
			// Create the statement
			statement = connection.createStatement();
			String sql = "SELECT * FROM reservation"; //
			
			// Execute the query
			rs = statement.executeQuery(sql);
		
			// Loop on the results extracted from the database
			System.out.println("Liste actuelle des reservations :");
			while (rs.next()) {
				System.out.println("  - " + rs.getString("id") + " : " + rs.getString("prenom") + " " +  rs.getString("nom"));
			}
		//}
		//catch(SQLException e){
		//	System.out.println("An error occured trying to read the data !");
		//}
		//finally{	 
			statement.close();
		//}
		
		System.out.println();
	}
}
