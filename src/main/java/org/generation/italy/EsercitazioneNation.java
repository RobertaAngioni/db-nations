package org.generation.italy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EsercitazioneNation {
	
	private final static String url = "jdbc:mysql://localhost:3306/db-nations";
	private final static String user = "root";
	private final static String password = "K.zcbap_582_";

	public static void main(String[] args) {
		
		
		
		
		try(Connection con = DriverManager.getConnection(url, user, password); 
				Scanner scan = new Scanner(System.in); ) {
			
			System.out.print("Inserire una stringa di ricerca: ");
			String ricerca = scan.nextLine();
			
			String sql = "select c.name as country_name, c.country_id, r.name as region_name, c2.name as continent_name \r\n"
					+ "from countries c \r\n"
					+ "join regions r on c.region_id = r.region_id \r\n"
					+ "join continents c2 on c2.continent_id = r.continent_id \r\n"
					+ "where c.name like ? \r\n"
					+ "order by c.name;";
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setString(1, "%" + ricerca + "%");
				
				try(ResultSet rs = ps.executeQuery()) {
					
					
					while(rs.next()) {
						System.out.print(rs.getString(1) + " - ");
						System.out.print(rs.getString(2) + " - ");
						System.out.print(rs.getString(3) + " - ");
						System.out.println(rs.getString(4));
					}
					
				}
				
			}
			scan.close();
			
		}catch(SQLException e) {
			System.out.println("si è verificato un errore");
			System.out.println(e.getMessage());
		}
		
		


	}

}
