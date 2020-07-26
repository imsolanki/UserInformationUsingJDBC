package com.project.lalit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDetails extends JFrame implements ActionListener {
    String naam;
    String email;
    String mobile;
    String address;
    String hobby;

    JLabel name;
    JLabel emailID;
    JLabel mobileNo;
    JLabel addressOfUser;
    JLabel interest;
    JTextField nameField;
    JTextField emailField;
    JTextField mobileField;
    JScrollPane pane;
    JTextArea addressField;
    JTextField interestField;
    JButton home;



    public ShowDetails(String naam, String email, String mobile, String address, String hobby) throws HeadlessException {
        this.naam = naam;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.hobby = hobby;
    }

        public void showFrame()
    {
        super.setBounds(510, 150, 350, 280);
        super.setTitle("User_Details");

        name = new JLabel("Name:");
        name.setBounds(20, 20, 60, 25);
        super.add(name);
        nameField = new JTextField();
        nameField.setBounds(137, 20, 180, 25);
        nameField.setEditable(false);
        nameField.setText(this.naam);
        super.add(nameField);

        emailID = new JLabel("Email:");
        emailID.setBounds(20, 50, 60, 25);
        super.add(emailID);
        emailField = new JTextField();
        emailField.setBounds(137, 50, 180, 25);
        emailField.setEditable(false);
        emailField.setText(this.email);
        super.add(emailField);

        mobileNo = new JLabel("Mobile:");
        mobileNo.setBounds(20, 80, 60, 25);
        super.add(mobileNo);
        mobileField = new JTextField();
        mobileField.setBounds(137, 80, 180, 25);
        mobileField.setEditable(false);
        mobileField.setText(this.mobile);
        super.add(mobileField);

        addressOfUser = new JLabel("Address:");
        addressOfUser.setBounds(20, 110, 80, 25);
        super.add(addressOfUser);
        addressField = new JTextArea();
        pane = new JScrollPane(addressField);
        pane.setBounds(137, 110, 180, 25);
        addressField.setEditable(false);
        addressField.setText(this.address);
        super.add(pane);

        interest = new JLabel("Hobbies:");
        interest.setBounds(20, 140, 60, 25);
        super.add(interest);
        interestField = new JTextField();
        interestField.setBounds(137, 140, 180, 25);
        interestField.setEditable(false);
        interestField.setText(this.hobby);
        super.add(interestField);

        home =new JButton("Home");
        home.setBounds(135, 180, 80, 25);
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
            LandingPage lp =new LandingPage();
            lp.showFrame();
            super.dispose();
        }
    }
}
