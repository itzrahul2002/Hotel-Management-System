package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    Pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading =new JLabel("Pickup Services");
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        heading.setBounds(350,20,500,40);
        add(heading);

        JLabel lblcar = new JLabel("Type of Car");
        lblcar.setFont(new Font("Tahoma",Font.BOLD,15));
        lblcar.setBounds(80,100,100,25);
        add(lblcar);

        typeofcar = new Choice();
        typeofcar.setBounds(190,105,150,25);
        add(typeofcar);

        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from Driver");
            while (rs.next()){
                typeofcar.add(rs.getString("Car_Brand"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel lblroom = new JLabel("Name");
        lblroom.setBounds(40,165,150,20);
        lblroom.setFont(new Font("Tahoma",Font.BOLD,18));
        lblroom.setForeground(Color.red);
        add(lblroom);


        JLabel l1 =new JLabel("Age");
        l1.setBounds(200,160,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        l1.setForeground(Color.red);
        add(l1);

        JLabel l2 =new JLabel("Gender");
        l2.setBounds(330,160,150,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,18));
        l2.setForeground(Color.red);
        add(l2);

        JLabel l3 =new JLabel("Company");
        l3.setBounds(460,160,100,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,18));
        l3.setForeground(Color.red);
        add(l3);

        JLabel l4 =new JLabel("Car Brand");
        l4.setBounds(590,160,100,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,18));
        l4.setForeground(Color.red);
        add(l4);

        JLabel l5 =new JLabel("Availability");
        l5.setBounds(740,160,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,18));
        l5.setForeground(Color.red);
        add(l5);

        JLabel l6 =new JLabel("Location");
        l6.setBounds(890,160,100,20);
        l6.setFont(new Font("Tahoma",Font.BOLD,18));
        l6.setForeground(Color.red);
        add(l6);




        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try {
            Conn c = new Conn();
            String query = "Select * from driver";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ae){
            ae.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBounds(300,520,120,30);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(500,520,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);


        setBounds(120,45,1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){

            try{
                String query ="select * from driver where Car_Brand ='"+typeofcar.getSelectedItem()+"'";

                Conn c = new Conn();
                ResultSet rs ;

                rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Pickup();
    }

}
