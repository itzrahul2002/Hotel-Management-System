package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading =new JLabel("Search For Rooms");
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        heading.setBounds(350,20,500,40);
        add(heading);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(80,100,100,25);
        add(lblbed);

        String option[] ={"Single Bed","Double Bed"};
        bedtype = new JComboBox(option);
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);

        available = new JCheckBox("Only Display Available");
        available.setForeground(Color.red);
        available.setBounds(650,100,200,25);
        available.setBackground(Color.white);
        add(available);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(40,165,150,20);
        lblroom.setFont(new Font("Tahoma",Font.BOLD,18));
        lblroom.setForeground(Color.red);
        add(lblroom);


        JLabel l1 =new JLabel("Availiblity");
        l1.setBounds(260,160,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        l1.setForeground(Color.red);
        add(l1);

        JLabel l2 =new JLabel("Cleaning Status");
        l2.setBounds(430,160,150,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,18));
        l2.setForeground(Color.red);
        add(l2);

        JLabel l3 =new JLabel("Status");
        l3.setBounds(670,160,100,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,18));
        l3.setForeground(Color.red);
        add(l3);

        JLabel l4 =new JLabel("Price");
        l4.setBounds(870,160,100,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,18));
        l4.setForeground(Color.red);
        add(l4);




        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try {
            Conn c = new Conn();
            String query = "Select * from room";
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
                String query ="select * from room where Bed_Type ='"+bedtype.getSelectedItem()+"'";
                String query2 ="select * from room where Availability ='Available' and Bed_Type ='"+bedtype.getSelectedItem()+"'";

                Conn c = new Conn();
                ResultSet rs ;
                if(available.isSelected()){
                    rs = c.s.executeQuery(query2);
                }else {
                    rs = c.s.executeQuery(query);
                }

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
        new SearchRoom();
    }

}
