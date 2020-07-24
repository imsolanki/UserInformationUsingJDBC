package com.project.lalit;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class LimitContact extends PlainDocument {
    LimitContact(int i){
        super();
    }
    public void insertString(int offset, String str, AttributeSet attr)throws BadLocationException {
        if(str==null)
            return;
        if((getLength()+str.length())<=10){
            super.insertString(offset,str,attr);
        }

    }
}

class LimitName extends PlainDocument {
    LimitName(int i){
        super();
    }
    public void insertString(int offset, String str, AttributeSet attr)throws BadLocationException {
        if(str==null)
            return;
        if((getLength()+str.length())<=80){
            super.insertString(offset,str,attr);
        }

    }
}

public class btn1Signup extends JFrame implements ActionListener {

    JLabel name;
    JLabel email;
    JLabel mobile;
    JLabel password;
    JLabel confirmPass;
    JLabel address;
    JLabel areaOfInt;
    JTextField nameField;
    JTextField emailField;
    JTextField mobileField;
    JTextField passwordField;
    JTextField confirmPassField;
    JTextField areaOfIntField;
    JTextArea addressArea;
    JScrollPane pane;
    JButton submit;
    JButton home;


    public void showFrame(){
        super.setBounds(510,100,350,425);
        super.setTitle("Sign-Up");


        name =new JLabel("Name:");
        name.setBounds(20,20,60,25);
        super.add(name);
        nameField = new JTextField();
        nameField.setBounds(137,20,180,25);
        nameField.setDocument(new LimitName(80));
        super.add(nameField);

        email =new JLabel("Email:");
        email.setBounds(20,50,60,25);
        super.add(email);
        emailField = new JTextField();
        emailField.setBounds(137,50,180,25);
        super.add(emailField);

        mobile =new JLabel("Mobile:");
        mobile.setBounds(20,80,60,25);
        super.add(mobile);
        mobileField = new JTextField();
        mobileField.setBounds(137,80,180,25);
        mobileField.setDocument(new LimitContact(10));
        super.add(mobileField);

        password =new JLabel("Password:");
        password.setBounds(20,110,80,25);
        super.add(password);
        passwordField = new JTextField();
        passwordField.setBounds(137,110,180,25);
        super.add(passwordField);

        confirmPass =new JLabel("Confirm Password:");
        confirmPass.setBounds(20,140,115,25);
        super.add(confirmPass);
        confirmPassField = new JTextField();
        confirmPassField.setBounds(137,140,180,25);
        super.add(confirmPassField);

        address =new JLabel("Address:");
        address.setBounds(20,170,80,25);
        super.add(address);
        addressArea = new JTextArea();
        pane =new JScrollPane(addressArea);
        pane.setBounds(137,170,180,25);
        super.add(pane);

        areaOfInt =new JLabel("Hobbies:");
        areaOfInt.setBounds(20,200,80,25);
        super.add(areaOfInt);
        areaOfIntField = new JTextField();
        areaOfIntField.setBounds(137,200,180,25);
        super.add(areaOfIntField);


        submit =new JButton("Submit");
        submit.setBounds(125,260,80,25);
        super.add(submit);
        submit.addActionListener(this);

        home =new JButton("Home");
        home.setBounds(125,310,80,25);
        super.add(home);
        home.addActionListener(this);



        super.setResizable(false);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        //---------------------------------------------------------------------------------------------------------//
        if(event.getSource().equals(home))//home
        {
            LandingPage lp = new LandingPage();
            lp.showFrame();
            super.dispose();
        }

        //--------------------------------------------------------------------------------------------------------//

        else if(event.getSource().equals(submit)){

            if(nameField.getText().toUpperCase().trim().isBlank()){
                nameField.setBackground(Color.black);
                nameField.setText("All fields are mandatory.");
                nameField.setForeground(Color.white);
            }
            else if(emailField.getText().toUpperCase().trim().isBlank()){
                emailField.setBackground(Color.black);
                emailField.setText("All fields are mandatory.");
                emailField.setForeground(Color.white);
            }
            else if(mobileField.getText().toUpperCase().trim().isBlank()){
                mobileField.setBackground(Color.black);
                mobileField.setText("All fields are mandatory.");
                mobileField.setForeground(Color.white);
            }
            else if(passwordField.getText().toUpperCase().trim().isBlank()){
                passwordField.setBackground(Color.black);
                passwordField.setText("All fields are mandatory.");
                passwordField.setForeground(Color.white);
            }
            else if(confirmPassField.getText().toUpperCase().trim().isBlank()){
                confirmPassField.setBackground(Color.black);
                confirmPassField.setText("All fields are mandatory.");
                confirmPassField.setForeground(Color.white);
            }
            else if(addressArea.getText().toUpperCase().trim().isBlank()){
                addressArea.setBackground(Color.black);
                addressArea.setText("All fields are mandatory.");
                addressArea.setForeground(Color.white);
            }
            else if(areaOfIntField.getText().toUpperCase().trim().isBlank()){
                areaOfIntField.setBackground(Color.black);
                areaOfIntField.setText("All fields are mandatory.");
                areaOfIntField.setForeground(Color.white);
            }
            else{
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/userInformation",
                            "root","root");
                    //System.out.println("connected");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
