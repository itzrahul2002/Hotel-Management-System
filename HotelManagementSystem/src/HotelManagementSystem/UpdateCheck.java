package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpending,tfpaid;
    JButton check,update,back;
    UpdateCheck(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("UPDATE STATUS");
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        text.setBounds(80,20,250,40);
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
        lblroom.setBounds(30,120,150,20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(220,120,150,25);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        lblname.setBounds(30,160,100,20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220,160,150,25);
        add(tfname);

        JLabel lblcheckin = new JLabel("CheckIn Time");
        lblcheckin.setFont(new Font("Tahoma",Font.BOLD,16));
        lblcheckin.setBounds(30,200,150,20);
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(220,200,150,25);
        add(tfcheckin);

        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpaid.setBounds(30,240,150,20);
        add(lblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(220,240,150,25);
        add(tfpaid);

        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpending.setBounds(30,280,150,20);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(220,280,150,25);
        add(tfpending);

        check = new JButton("Check");
        check.setBounds(30,340,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,340,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,340,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);



        setBounds(150,100,980,500);
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
                    tfname.setText(rs.getString("Name"));
                    tfcheckin.setText(rs.getString("Check_In_Time"));
                    tfpaid.setText(rs.getString("Deposite_Amount"));
                }
                ResultSet rs2 = c.s.executeQuery("Select * from room where Room_Number ='"+tfroom.getText()+"'");
                while (rs2.next()) {
                    String price = rs2.getString("Price");
                    int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText(" "+amountpaid);
                }
            }catch (Exception qe){
                qe.printStackTrace();
            }
        }else if(e.getSource()==update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set Room_Number = '"+room+"',Name = '"+name+"',Check_In_Time = '"+checkin+"',Deposite_Amount = '"+deposit+"' where Document_Id_Number = '"+number+"'");

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
        new UpdateCheck();
    }
}
