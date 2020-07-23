package com.project.lalit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btn2Login extends JFrame implements ActionListener {


    JLabel email;
    JLabel password;
    JTextField emailAddress;
    JTextField passwordInput;
    JButton login;
    JButton home;

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
        passwordInput =new JTextField();
        passwordInput.setBounds(137,80,180,25);
        super.add(passwordInput);

        login = new JButton("Login");
        login.setBounds(125,125,80,25);
        super.add(login);

        home = new JButton("Home");
        home.setBounds(125,170,80,25);
        super.add(home);
        home.addActionListener(this);

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
    }
}
