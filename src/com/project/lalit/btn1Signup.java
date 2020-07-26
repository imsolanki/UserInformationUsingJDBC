package com.project.lalit;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


class LimitContact extends PlainDocument {
    LimitContact(int i) {
        super();
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;
        if ((getLength() + str.length()) <= 10) {
            super.insertString(offset, str, attr);
        }

    }
}

class LimitName extends PlainDocument {
    LimitName(int i) {
        super();
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;
        if ((getLength() + str.length()) <= 40) {
            super.insertString(offset, str, attr);
        }

    }
}

public class btn1Signup extends JFrame implements ActionListener {
    boolean first=true;
    String nameVar;
    String emailVar;
    String mobileNo;
    String passwordVar;
    String addressVar;
    String aOI;

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
    JPasswordField passwordField;
    JPasswordField confirmPassField;
    JTextField areaOfIntField;
    JTextArea addressArea;
    JScrollPane pane;
    JButton submit;
    JButton home;
    JButton reset;


    public void showFrame() {
        super.setBounds(510, 100, 350, 425);
        super.setTitle("Sign-Up");


        name = new JLabel("Name:");
        name.setBounds(20, 20, 60, 25);
        super.add(name);
        nameField = new JTextField();
        nameField.setBounds(137, 20, 180, 25);
        nameField.setDocument(new LimitName(40));
        super.add(nameField);

        email = new JLabel("Email:");
        email.setBounds(20, 50, 60, 25);
        super.add(email);
        emailField = new JTextField();
        emailField.setBounds(137, 50, 180, 25);
        super.add(emailField);

        mobile = new JLabel("Mobile:");
        mobile.setBounds(20, 80, 60, 25);
        super.add(mobile);
        mobileField = new JTextField();
        mobileField.setBounds(137, 80, 180, 25);
        mobileField.setDocument(new LimitContact(10));
        super.add(mobileField);
        mobileField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    if(first) {
                        mobileField.setDocument(new LimitContact(10));
                        //it is calling setText='' somewhere in its subclass
                        first=false;
                    }
                    mobileField.setEditable(true);
                }
                else if(ke.getKeyCode()==8){
                    mobileField.setEditable(true);
                } else{
                    mobileField.setDocument(new LimitName(40));
                    mobileField.setText("Enter only numeric digits(0-9)");
                    mobileField.setEditable(false);
                    first=true;
                }
            }
        });
        password = new JLabel("Password:");
        password.setBounds(20, 110, 80, 25);
        super.add(password);
        passwordField = new JPasswordField();
        passwordField.setBounds(137, 110, 180, 25);
        super.add(passwordField);

        confirmPass = new JLabel("Confirm Password:");
        confirmPass.setBounds(20, 140, 115, 25);
        super.add(confirmPass);
        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(137, 140, 180, 25);
        super.add(confirmPassField);

        address = new JLabel("Address:");
        address.setBounds(20, 170, 80, 25);
        super.add(address);
        addressArea = new JTextArea();
        pane = new JScrollPane(addressArea);
        pane.setBounds(137, 170, 180, 25);
        super.add(pane);

        areaOfInt = new JLabel("Hobbies:");
        areaOfInt.setBounds(20, 200, 80, 25);
        super.add(areaOfInt);
        areaOfIntField = new JTextField();
        areaOfIntField.setBounds(137, 200, 180, 25);
        super.add(areaOfIntField);


        submit = new JButton("Submit");
        submit.setBounds(125, 260, 80, 25);
        super.add(submit);
        submit.addActionListener(this);

        home = new JButton("Home");
        home.setBounds(125, 300, 80, 25);
        super.add(home);
        home.addActionListener(this);

        reset=new JButton("Reset");
        reset.setBounds(125,340,80,25);
        super.add(reset);
        reset.addActionListener(this);


        super.setResizable(false);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent event) {

        //---------------------------------------------------------------------------------------------------------//
        if (event.getSource().equals(home))//home
        {
            LandingPage lp = new LandingPage();
            lp.showFrame();
            super.dispose();
        }

        //--------------------------------------------------------------------------------------------------------//

        else if (event.getSource().equals(submit))//submit
        {
            if(nameField.getText().toUpperCase().trim().isBlank()&&emailField.getText().toUpperCase().trim().isBlank()
            &&mobileField.getText().toUpperCase().trim().isBlank()&&new String(passwordField.getPassword()).toUpperCase().trim().isBlank()
            &&new String(confirmPassField.getPassword()).toUpperCase().trim().isBlank()&&addressArea.getText().toUpperCase().trim().isBlank()
            &&areaOfIntField.getText().toUpperCase().trim().isBlank()){
                nameField.setBackground(Color.black);
                nameField.setText("All fields are mandatory.");
                nameField.setForeground(Color.white);
                emailField.setBackground(Color.black);
                emailField.setText("All fields are mandatory.");
                emailField.setForeground(Color.white);
                mobileField.setBackground(Color.black);
                mobileField.setText("All fields are mandatory.");
                mobileField.setForeground(Color.white);
                passwordField.setBackground(Color.black);
                passwordField.setText("All fields are mandatory.");
                passwordField.setForeground(Color.white);
                confirmPassField.setBackground(Color.black);
                confirmPassField.setText("All fields are mandatory.");
                confirmPassField.setForeground(Color.white);
                addressArea.setBackground(Color.black);
                addressArea.setText("All fields are mandatory.");
                addressArea.setForeground(Color.white);
                areaOfIntField.setBackground(Color.black);
                areaOfIntField.setText("All fields are mandatory.");
                areaOfIntField.setForeground(Color.white);
            }
            else if(nameField.getText().toUpperCase().trim().isBlank()) {
                nameField.setBackground(Color.black);
                nameField.setText("All fields are mandatory.");
                nameField.setForeground(Color.white);
            } else if (emailField.getText().toUpperCase().trim().isBlank()) {
                emailField.setBackground(Color.black);
                emailField.setText("All fields are mandatory.");
                emailField.setForeground(Color.white);
            } else if (mobileField.getText().toUpperCase().trim().isBlank()) {
                mobileField.setBackground(Color.black);
                mobileField.setText("All fields are mandatory.");
                mobileField.setForeground(Color.white);
            } else if (new String(passwordField.getPassword()).toUpperCase().trim().isBlank()) {
                passwordField.setBackground(Color.black);
                passwordField.setText("All fields are mandatory.");
                passwordField.setForeground(Color.white);
            } else if (new String(confirmPassField.getPassword()).toUpperCase().trim().isBlank()) {
                confirmPassField.setBackground(Color.black);
                confirmPassField.setText("All fields are mandatory.");
                confirmPassField.setForeground(Color.white);
            } else if (addressArea.getText().toUpperCase().trim().isBlank()) {
                addressArea.setBackground(Color.black);
                addressArea.setText("All fields are mandatory.");
                addressArea.setForeground(Color.white);
            } else if (areaOfIntField.getText().toUpperCase().trim().isBlank()) {
                areaOfIntField.setBackground(Color.black);
                areaOfIntField.setText("All fields are mandatory.");
                areaOfIntField.setForeground(Color.white);
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_Information",
                            "root", "root");
                    Statement st = co.createStatement();
                    st.executeUpdate("CREATE TABLE IF NOT EXISTS USERS(NAME VARCHAR(40),EMAIL VARCHAR(30) PRIMARY KEY," +
                            "MOBILE VARCHAR(10), PASSWORD VARCHAR(200), ADDRESS VARCHAR(100)," +
                            " AREAOFINTEREST VARCHAR(10))");

                    nameVar = nameField.getText();
                    emailVar = emailField.getText().toLowerCase();
                    mobileNo = mobileField.getText();
                    passwordVar = new String(passwordField.getPassword()).toLowerCase();
                    addressVar = addressArea.getText();
                    aOI = areaOfIntField.getText();
                    if(!passwordVar.equals (new String(confirmPassField.getPassword()))){
                        JOptionPane.showMessageDialog(null,"Entered Password & Confirm Password" +
                                " field must be same.");
                    }
                    else{
                        st.executeUpdate("INSERT INTO USERS VALUES('"+nameVar+"','"+emailVar+"'," +
                                "'"+mobileNo+"',sha1('"+passwordVar+"'),'"+addressVar+"','"+aOI+"')");
                        JOptionPane.showMessageDialog(null,"Congrats! Your Information has been saved.");
                        nameField.setText("");
                        nameField.setBackground(Color.white);
                        nameField.setForeground(Color.BLACK);
                        emailField.setText("");
                        emailField.setBackground(Color.white);
                        emailField.setForeground(Color.BLACK);
                        mobileField.setText("");
                        mobileField.setBackground(Color.white);
                        mobileField.setForeground(Color.BLACK);
                        passwordField.setText("");
                        passwordField.setBackground(Color.white);
                        passwordField.setForeground(Color.BLACK);
                        confirmPassField.setText("");
                        confirmPassField.setBackground(Color.white);
                        addressArea.setForeground(Color.BLACK);
                        addressArea.setText("");
                        addressArea.setBackground(Color.white);
                        addressArea.setForeground(Color.BLACK);
                        areaOfIntField.setText("");
                        areaOfIntField.setBackground(Color.white);
                        areaOfIntField.setForeground(Color.BLACK);
                    }

                } catch (Exception e ) {
                    JOptionPane.showMessageDialog(null, "Email id Already Exists");
                    e.printStackTrace();
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------//
        else if(event.getSource().equals(reset)){
            nameField.setText("");
            nameField.setBackground(Color.white);
            nameField.setForeground(Color.BLACK);
            emailField.setText("");
            emailField.setBackground(Color.white);
            emailField.setForeground(Color.BLACK);
            mobileField.setText("");
            mobileField.setBackground(Color.white);
            mobileField.setForeground(Color.BLACK);
            passwordField.setText("");
            passwordField.setBackground(Color.white);
            passwordField.setForeground(Color.BLACK);
            confirmPassField.setText("");
            confirmPassField.setBackground(Color.white);
            addressArea.setForeground(Color.BLACK);
            addressArea.setText("");
            addressArea.setBackground(Color.white);
            addressArea.setForeground(Color.BLACK);
            areaOfIntField.setText("");
            areaOfIntField.setBackground(Color.white);
            areaOfIntField.setForeground(Color.BLACK);

        }
    }
}



        /*NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        mobileField = new JFormattedTextField(formatter);
        mobileField.setBounds(137, 80, 180, 25);
        mobileField.setDocument(new LimitContact(10));
        super.add(mobileField);*/
// mobileField.addKeyListener(new keyAdapter());
//mobileNo = Integer.parseInt(mobileField.getText());
