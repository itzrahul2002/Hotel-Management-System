package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfname,tfcompany,tfmodel,tfage,tflocation;
    JComboBox typecombo,gendercombo,avaiablecombo;
    AddDriver(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        heading.setForeground(Color.red);
        heading.setBounds(150,12,250,50);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblname.setBounds(60,80,1250,30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblage.setBounds(60,120,1250,30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,120,150,30);
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblgender.setBounds(60,160,120,30);
        add(lblgender);

        String genderoptions[] = {"Male","Female"};
        gendercombo = new JComboBox(genderoptions);
        gendercombo.setBounds(200,160,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblcompany.setBounds(60,200,120,30);
        add(lblcompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(200,200,150,30);
        add(tfcompany);

        JLabel lbltype = new JLabel("Car Model");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbltype.setBounds(60,240,120,30);
        add(lbltype);

        tfmodel = new JTextField();
        tfmodel.setBounds(200,240,150,30);
        add(tfmodel);

        JLabel lblavaiable = new JLabel("Available");
        lblavaiable.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblavaiable.setBounds(60,280,120,30);
        add(lblavaiable);

        String driveroptions[] = {"Available","Busy"};
        avaiablecombo = new JComboBox(driveroptions);
        avaiablecombo.setBounds(200,280,150,30);
        avaiablecombo.setBackground(Color.WHITE);
        add(avaiablecombo);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbllocation.setBounds(60,320,120,30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200,320,150,30);
        add(tflocation);

        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.setBounds(60,380,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.addActionListener(this);
        cancel.setBounds(220,380,130,30);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,60,500,310);
        add(image);



        setBounds(170,120,950,490);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name = tfname.getText();
            String age= tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available =(String) avaiablecombo.getSelectedItem();
            String location = tflocation.getText();


            try{
                Conn c = new Conn();

                String query ="insert into Driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"New Driver Added Successfully ✅");
                setVisible(false);

            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
