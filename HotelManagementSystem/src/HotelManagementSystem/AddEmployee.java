package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit,cancel;
    JComboBox cbjob;
    AddEmployee(){
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.white);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60,190,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lbljob);

        String str[] = {"Front Desk Clerks","Manager","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waiters","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("EMAIL ID");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        JLabel lblaadhar = new JLabel("AADHAR ");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(120,445,150,30);
        submit.addActionListener(this);
        add(submit);

//        cancel = new JButton("Cancel");
//        cancel.setBackground(Color.black);
//        cancel.setForeground(Color.white);
//        cancel.setBounds(230,450,122,30);
//        cancel.addActionListener(this);
//        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2  = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,382);
        add(image);


        getContentPane().setBackground(Color.white);
        setBounds(220,85,850,540);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        String gender = null;
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty 🙏");
            return;
        }

        if(rbmale.isSelected()){
            gender ="Male";
        }
        else if(rbfemale.isSelected()){
            gender ="Female";
        }
        String job = (String) cbjob.getSelectedItem();

        try {
            Conn c = new Conn();

            String query = "insert into employee values ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee Details Added Successfully 📰");
            setVisible(false);


        }catch(Exception ae){
            ae.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
