package org.generation.italy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EsercitazioneNation {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/db-nations";
		String user = "root";
		String password = "K.zcbap_582_";
		
		try(Connection con = DriverManager.getConnection(url, user, password)) {
			
			String sql = "select c.name as country_name, c.country_id, r.name as region_name, c2.name as continent_name from countries c join continents c2 on c.country_id join regions r on c.country_id = r.region_id order by c.name;";
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				
				try(ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						System.out.print(rs.getString(1) + " - ");
						System.out.print(rs.getString(2) + " - ");
						System.out.print(rs.getString(3) + " - ");
						System.out.println(rs.getString(4));
					}
					
				}
			}
			
		}catch(SQLException e) {
			System.out.println("si è verificato un errore");
			System.out.println(e.getMessage());
		}


	}

}
