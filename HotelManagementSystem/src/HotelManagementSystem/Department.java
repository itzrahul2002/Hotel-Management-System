package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(500,0,600,600);
//        add(image);

        JLabel l1 =new JLabel("Departments");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        l1.setBounds(60,10,200,40);
        add(l1);

        JLabel l2 =new JLabel("Budgets");
        l2.setForeground(Color.red);
        l2.setFont(new Font("Tahoma",Font.BOLD,30));
        l2.setBounds(440,10,150,40);
        add(l2);


        table = new JTable();
        table.setBounds(0,80,700,300);
        add(table);

        try {
            Conn c = new Conn();
            String query = "Select * from departments";
            ResultSet rs = c.s.executeQuery(query);

//            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ae){
            ae.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(280,400,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);


        setBounds(305,120,700,480);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Department();
    }

}
