package com.project.lalit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame implements ActionListener {

    JButton btn1;
    JButton btn2;
    JTextField message;

    public void showFrame() {

        super.setBounds(510, 150, 350, 290);
        super.setTitle("User Information");

        btn1 =new JButton("Sign-Up");
        btn1.setBounds(125,60,80,25);
        super.add(btn1);
        btn1.addActionListener(this);

        btn2 =new JButton("Login");
        btn2.setBounds(125,115,80,25);
        super.add(btn2);
        btn2.addActionListener(this);

        message =new JTextField();
        message.setBounds(35,170,265,25);
        message.setText("Welcome to the Landing Page of the Application.");
        message.setEditable(false);
        super.add(message);

        super.setResizable(false);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource()==btn1){
            btn1Signup button1 =new btn1Signup();
            button1.showFrame();
            super.dispose();
        }
    }
}



/*super.setBounds(310, 80, 650, 490);
contact.setDocument(new LimitContact(10));

 */
