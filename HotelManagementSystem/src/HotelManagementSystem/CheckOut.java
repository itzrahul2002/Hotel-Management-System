package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblnroomumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    CheckOut(){
        setLayout(null);
        getContentPane().setBackground(Color.white);


        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,160,30);
        text.setForeground(Color.red);
        text.setFont(new Font("Tahoma", Font.BOLD,30));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,85,100,30);
        lblid.setFont(new Font("Arial", Font.BOLD,15));
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(170,85,150,25);
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(325,85,20,20);
        add(tick);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,135,150,30);
        lblroom.setFont(new Font("Arial", Font.BOLD,15));
        add(lblroom);

        lblnroomumber=new JLabel();
        lblnroomumber.setBounds(170,135,100,30);
        add(lblnroomumber);


        JLabel lblcheckin= new JLabel("CheckIn Time");
        lblcheckin.setBounds(30,185,150,30);
        lblcheckin.setFont(new Font("Arial", Font.BOLD,15));
        add(lblcheckin);

        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(170,185,100,30);
        add(lblcheckintime);

        JLabel lblcheckout= new JLabel("Checkout Time");
        lblcheckout.setBounds(30,235,150,30);
        lblcheckout.setFont(new Font("Arial", Font.BOLD,15));
        add(lblcheckout);


        Date date = new Date();
        lblcheckouttime=new JLabel(" "+date);
        lblcheckouttime.setBounds(170,235,100,30);
        add(lblcheckouttime);

        checkout = new JButton("Check Out");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);


        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(175,280,120,30);
        back.addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("Document_Id_Number"));
                lblnroomumber.setText(rs.getString("Room_Number"));
                lblcheckintime.setText(rs.getString("Check_In_Time"));
            }
        }catch (Exception ae) {
            ae.printStackTrace();
        }


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(360,65,400,250);
        add(image);

        setBounds(230,150,800,400);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==checkout){
            String query = "delete from customer where Document_Id_Number ='"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set Availability = 'Available' where Room_Number ='"+lblnroomumber.getText()+"'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "CheckOut Done ✅");

                setVisible(false);
                new Reception();
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new CheckOut();
    }

}
