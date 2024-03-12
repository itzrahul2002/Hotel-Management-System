package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    ManagerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel l1 =new JLabel("Name");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setBounds(40,10,100,20);
        add(l1);

        JLabel l2 =new JLabel("Age");
        l2.setForeground(Color.red);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l2.setBounds(170,10,100,20);
        add(l2);

        JLabel l3 =new JLabel("Gender");
        l3.setForeground(Color.red);
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l3.setBounds(280,10,100,20);
        add(l3);

        JLabel l4 =new JLabel("Job");
        l4.setForeground(Color.red);
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l4.setBounds(410,10,100,20);
        add(l4);

        JLabel l5 =new JLabel("Salary");
        l5.setForeground(Color.red);
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l5.setBounds(530,10,100,20);
        add(l5);


        JLabel l6 =new JLabel("Phone");
        l6.setForeground(Color.red);
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        l6.setBounds(650,10,100,20);
        add(l6);

        JLabel l7 =new JLabel("Email Id");
        l7.setForeground(Color.red);
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        l7.setBounds(770,10,100,20);
        add(l7);

        JLabel l8 =new JLabel("Aadhar");
        l8.setForeground(Color.red);
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        l8.setBounds(890,10,100,20);
        add(l8);



        table = new JTable();
        table.setBounds(0,50,1000,400);
        add(table);

        try {
            Conn c = new Conn();
            String query = "Select * from employee where Job ='Manager'";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ae){
            ae.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(460,500,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);


        setBounds(150,45,1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new ManagerInfo();
    }

}
