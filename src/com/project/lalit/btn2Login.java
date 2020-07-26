package com.project.lalit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class btn2Login extends JFrame implements ActionListener {


    JLabel email;
    JLabel password;
    JTextField emailAddress;
    JPasswordField passwordInput;
    JButton login;
    JButton home;
    JButton reset;

    public void showFrame()
    {
        super.setBounds(510, 150, 350, 290);
        super.setTitle("Login Information");

        email =new JLabel("Email:");
        email.setBounds(20,20,60,25);
        super.add(email);
        emailAddress =new JTextField();
        emailAddress.setBounds(137,20,180,25);
        super.add(emailAddress);

        password =new JLabel("Password:");
        password.setBounds(20,80,80,25);
        super.add(password);
        passwordInput =new JPasswordField();
        passwordInput.setBounds(137,80,180,25);
        super.add(passwordInput);

        login = new JButton("Login");
        login.setBounds(125,125,80,25);
        super.add(login);
        login.addActionListener(this);

        home = new JButton("Home");
        home.setBounds(125,160,80,25);
        super.add(home);
        home.addActionListener(this);

        reset=new JButton("Reset");
        reset.setBounds(125,195,80,25);
        super.add(reset);
        reset.addActionListener(this);

        super.setResizable(false);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource().equals(home)){
            LandingPage lp = new LandingPage();
            lp.showFrame();
            super.dispose();
        }
        //-------------------------------------------------------------------------------------------------------------//
        else if(event.getSource().equals(login)){
            if(emailAddress.getText().trim().toLowerCase().isBlank()&&new String(passwordInput.getPassword()).trim().toLowerCase().isBlank()){
                emailAddress.setEditable(false);
                passwordInput.setEditable(false);
                emailAddress.setText("All fields are mandatory.");
                emailAddress.setBackground(Color.black);
                emailAddress.setForeground(Color.white);
                passwordInput.setText("All fields are mandatory.");
                passwordInput.setBackground(Color.black);
                passwordInput.setForeground(Color.white);
            }
            else if(emailAddress.getText().trim().toLowerCase().isBlank()||new String(passwordInput.getPassword()).trim().toLowerCase().isBlank()){
                emailAddress.setEditable(false);
                passwordInput.setEditable(false);
                emailAddress.setText("All fields are mandatory.");
                emailAddress.setBackground(Color.black);
                emailAddress.setForeground(Color.white);
                passwordInput.setText("All fields are mandatory.");
                passwordInput.setBackground(Color.black);
                passwordInput.setForeground(Color.white);

            }
            else{
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_Information",
                            "root", "root");
                    Statement st = co.createStatement();
                    ResultSet rs =st.executeQuery("Select * From USERS where EMAIL ='"+emailAddress.getText()+"' and PASSWORD = sha1('"+new String(passwordInput.getPassword())+"')");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"Congrats you have logged in.");

                        String naam=rs.getString("NAME");
                        String email = rs.getString("EMAIL");
                       // System.out.println(email);
                        String mobile=   rs.getString("MOBILE");
                        String address = rs.getString("ADDRESS");
                        String hobby= rs.getString("AREAOFINTEREST");

                         ShowDetails sd=new ShowDetails(email, address,mobile, hobby,naam);
                         sd.showFrame();
                         super.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Email id not found");


                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        }
        //-------------------------------------------------------------------------------------------------------------//
        else if(event.getSource().equals(reset)){
            emailAddress.setEditable(true);
            passwordInput.setEditable(true);
            emailAddress.setText("");
            emailAddress.setBackground(Color.white);
            emailAddress.setForeground(Color.black);
            passwordInput.setText("");
            passwordInput.setBackground(Color.white);
            passwordInput.setForeground(Color.black);
        }


    }
}