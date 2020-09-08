/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;



import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import dao.CourseDao;
import dao.CourseDaoImpl;
import dao.DBHelper;
import gui.LoginFrame;
import gui.MainFrame;
import model.Student;
import service.CourseService;
import service.CourseServiceImpl;

public class Main {

    public static void main(String[] args) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
//            MainFrame mainFrame = new MainFrame(courseService);
//            mainFrame.setSize(1650, 1080);
//            mainFrame.setVisible(true);
             LoginFrame loginFrame=new LoginFrame();
             loginFrame.setVisible(true);
        } catch (Exception e) {
        }
    }
}

