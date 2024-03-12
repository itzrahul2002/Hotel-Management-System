package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem  extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setSize(1200,565);
        setLocation(45,70);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0,1200,565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,435,1000,100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.BOLD,42));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1050,465,100,35);
        next.setFont(new Font("serif",Font.PLAIN,24));
        next.addActionListener(this);
        next.setBackground(Color.white);
        next.setForeground(Color.MAGENTA);
        image.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(false);
            try{
                Thread.sleep(600);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(600);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }










    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
