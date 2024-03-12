package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    AddRooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        heading.setForeground(Color.red);
        heading.setBounds(150,22,220,40);
        add(heading);

        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblroomno.setBounds(60,80,1250,30);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblavailable.setBounds(60,130,1250,30);
        add(lblavailable);

        String availableoptions[] = {"Available","Occupied"};
        availablecombo = new JComboBox(availableoptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String cleanoptions[] = {"Cleaned","Dirty"};
        cleancombo = new JComboBox(cleanoptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String typeptions[] = {"Single Bed","Double Bed"};
        typecombo = new JComboBox(typeptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.addActionListener(this);
        cancel.setBounds(220,350,130,30);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);



        setBounds(170,120,950,470);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String roomnumber = tfroom.getText();
            String availabilty = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = (String) tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

            try{
                Conn c = new Conn();

                String query ="insert into room values('"+roomnumber+"','"+availabilty+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"New Room Added Successfully ✅");
                setVisible(false);

            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new AddRooms();
    }
}
