/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Login;

/**
 *
 * @author Asus
 */
public interface LoginService {
            Login login(String username,String password) throws Exception;
  public boolean registration (Login login) throws Exception;

}
