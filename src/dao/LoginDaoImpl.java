/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Login;
import model.Role;
import util.JdbcUtility;

/**
 *
 * @author Asus
 */
public class LoginDaoImpl implements LoginDao {

    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select l.id,username,name,surname,Role_id,Role_name from login l "
                + "inner join role r on l.Role_id=r.id "
                + "where l.active=1 and r.active=1 and "
                + "l.username=? and l.password=?";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();

                if (rs.next()) {
                    login.setId(rs.getLong("id"));
                    login.setUsername(rs.getString("username"));
                    login.setName(rs.getString("name"));
                    login.setSurname(rs.getString("surname"));
                    Role role = new Role();
                    role.setId(rs.getLong("Role_id"));
                    role.setRoleName(rs.getString("Role_name"));
                    login.setRole(role);
                } else {
                    login = null;
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    @Override
    public boolean registration(Login login) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into login(username,password,name,surname,Role_id) values (?,?,?,?,?)";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, login.getUsername());
                ps.setString(2, login.getPassword());
                ps.setString(3, login.getName());
                ps.setString(4, login.getSurname());
                ps.setLong(5, login.getRole().getId());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }
        return result;

    }

}
