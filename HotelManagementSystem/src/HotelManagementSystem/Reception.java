package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer,rooms,department,allemployee,customers,managerinfo,checkout,update,roomStatus,pickup,searchRoom,logout;
    Reception(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        newCustomer  = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setForeground(Color.white);
        newCustomer.setBackground(Color.black);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms  = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        rooms.setBackground(Color.black);
        add(rooms);

        department  = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setForeground(Color.white);
        department.setBackground(Color.black);
        department.addActionListener(this);
        add(department);

        allemployee  = new JButton("All Employees");
        allemployee.setBounds(10,150,200,30);
        allemployee.setForeground(Color.white);
        allemployee.setBackground(Color.black);
        allemployee.addActionListener(this);
        add(allemployee);

        customers  = new JButton("Customers Information");
        customers.setBounds(10,190,200,30);
        customers.setForeground(Color.white);
        customers.setBackground(Color.black);
        customers.addActionListener(this);
        add(customers);

        managerinfo  = new JButton("Manager Information");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setForeground(Color.white);
        managerinfo.setBackground(Color.black);
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout  = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setForeground(Color.white);
        checkout.setBackground(Color.black);
        checkout.addActionListener(this);
        add(checkout);

        update  = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setForeground(Color.white);
        roomStatus.setBackground(Color.black);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup  = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setForeground(Color.white);
        pickup.setBackground(Color.black);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom  = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setForeground(Color.white);
        searchRoom.setBackground(Color.black);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout  = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.white);
        logout.setBackground(Color.black);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(250,60,800,570);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if (e.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if (e.getSource()==department){
            setVisible(false);
            new Department();
        }
        else if (e.getSource()==allemployee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if (e.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }
        else if (e.getSource()==managerinfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if (e.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if (e.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }
        else if (e.getSource()==roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if (e.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }
        else if (e.getSource()==checkout){
            setVisible(false);
            new CheckOut();
        }
        else if (e.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Reception();
    }

}
