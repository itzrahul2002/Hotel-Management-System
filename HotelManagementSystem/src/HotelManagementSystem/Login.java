package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40,30,100,30);
        user.setFont(new Font("Arial", Font.BOLD,16));
        add(user);

        username = new JTextField();
        username.setBounds(150,30,150,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,90,100,30);
        pass.setFont(new Font("Arial", Font.BOLD,16));
        add(pass);

        password = new JPasswordField();
        password.setBounds(150,90,150,30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40,160,120,30);
        login.addActionListener(this);
        login.setForeground(Color.white);
        login.setBackground(Color.black);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,160,120,30);
        cancel.addActionListener(this);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2  = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,8,230,230);
        add(image);

        setBounds(350,200,600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String user = username.getText();
            String pass  = password.getText();

            try {
                Conn c = new Conn();

                String query = "select * from login where username ='"+user+"' and Password ='"+pass+"'";

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password ❌⚠️");
                    setVisible(false);
                }

            }catch (Exception ae){
                ae.printStackTrace();
            }

        }else if(e.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
