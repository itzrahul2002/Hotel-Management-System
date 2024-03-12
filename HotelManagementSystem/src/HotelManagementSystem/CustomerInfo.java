package HotelManagementSystem;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel l1 =new JLabel("Doc Type");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setBounds(10,10,120,20);
        add(l1);

        JLabel l2 =new JLabel("Doc No");
        l2.setForeground(Color.red);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l2.setBounds(170,10,120,20);
        add(l2);

        JLabel l3 =new JLabel("Name");
        l3.setForeground(Color.red);
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l3.setBounds(360,10,100,20);
        add(l3);

        JLabel l4 =new JLabel("Gender");
        l4.setForeground(Color.red);
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l4.setBounds(480,10,100,20);
        add(l4);

        JLabel l5 =new JLabel("Country");
        l5.setForeground(Color.red);
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l5.setBounds(630,10,100,20);
        add(l5);


        JLabel l6 =new JLabel("Room No");
        l6.setForeground(Color.red);
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        l6.setBounds(780,10,100,20);
        add(l6);


        JLabel l8 =new JLabel("CheckIn Time");
        l8.setForeground(Color.red);
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        l8.setBounds(930,10,140,20);
        add(l8);

        JLabel l9 =new JLabel("Deposit Amt");
        l9.setForeground(Color.red);
        l9.setFont(new Font("Tahoma",Font.BOLD,20));
        l9.setBounds(1080,10,140,20);
        add(l9);



        table = new JTable();
        table.setBounds(0,50,1230,400);
        add(table);

        try {
            Conn c = new Conn();
            String query = "Select * from customer";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ae){
            ae.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(570,500,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);


        setBounds(30,40,1230,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }

}
