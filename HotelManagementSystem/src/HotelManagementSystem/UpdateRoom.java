package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom,tfname,tfavailable,tfstatus;
    JButton check,update,back;
    UpdateRoom(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.BOLD,28));
        text.setBounds(60,20,300,40);
        text.setForeground(Color.red);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(220,80,150,25);
        add(ccustomer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("Document_Id_Number"));
            }
        }catch (Exception ae) {
            ae.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Tahoma",Font.BOLD,16));
        lblroom.setBounds(30,130,150,20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(220,130,150,25);
        add(tfroom);

        JLabel lblname = new JLabel("Availability");
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        lblname.setBounds(30,180,100,20);
        add(lblname);

        tfavailable = new JTextField();
        tfavailable.setBounds(220,180,150,25);
        add(tfavailable);

        JLabel lblcleanstatus = new JLabel("Cleaning Status");
        lblcleanstatus.setFont(new Font("Tahoma",Font.BOLD,16));
        lblcleanstatus.setBounds(30,230,150,20);
        add(lblcleanstatus);

        tfstatus = new JTextField();
        tfstatus.setBounds(220,230,150,25);
        add(tfstatus);


        check = new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 =i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);



        setBounds(150,100,980,450);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String id =ccustomer.getSelectedItem();
            String query= "select * from customer where Document_Id_Number = '"+id+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()) {
                    tfroom.setText(rs.getString("Room_Number"));
                }
                ResultSet rs2 = c.s.executeQuery("Select * from room where Room_Number ='"+tfroom.getText()+"'");
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("Availability"));
                    tfstatus.setText(rs2.getString("Claenig_Status"));
                }
            }catch (Exception qe){
                qe.printStackTrace();
            }
        }else if(e.getSource()==update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set Availability = '"+available+"',Claenig_Status = '"+status+"' where Room_Number = '"+room+"'");

                JOptionPane.showMessageDialog(null,"Data Updated Successfully ‍🧑‍💻");

                setVisible(false);
                new Reception();
            }catch (Exception ee) {
                ee.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String[] args) {
        new UpdateRoom();
    }
}
