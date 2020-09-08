/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Asus
 */

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection1() throws Exception {
		Properties p = new Properties();
		p.load(new FileReader("C:\\Users\\Asus\\eclipse-workspace\\Connection\\src\\main\\config.properties"));
		Class.forName(p.getProperty("db.driver")); // yeni driver clasii
		Connection c = DriverManager.getConnection(p.getProperty("db.url"), p.getProperty("db.username"),
				p.getProperty("db.password"));
		return c;
	}

}
     
