package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(-6,0, 1550,900);

//        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
//        image.setBounds(0,0,1550,900);
        add(image);

        JLabel text = new JLabel("THE AVENGERS GROUP WELCOMES YOU");
        text.setBounds(160,60,1000,50);
        text.setFont(new Font("Serif", Font.BOLD,46));
        text.setForeground(Color.red);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);


        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);


        JMenu about = new JMenu("ABOUT");
        about.setForeground(Color.BLUE);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getActionCommand().equals("ADD EMPLOYEE")){
                new AddEmployee();
            }
            else if(e.getActionCommand().equals("ADD ROOMS")){
                new AddRooms();
            }
            else if(e.getActionCommand().equals("ADD DRIVERS")){
                new AddDriver();
            }
            else if(e.getActionCommand().equals("RECEPTION")){
                new Reception();
            }
            else if(e.getActionCommand().equals("About")){
                new About();
            }

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Dashboard();
    }

}
