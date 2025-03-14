package latihan.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;




public class LoginPage extends JFrame
        
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private String usernamePlaceholder = "Masukkan username";
    private String passwordPlaceholder = "Masukkan password";
   
    public LoginPage() 
    {
        setTitle("Login Page");
        setSize(300,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        
        //MEMBUAT LABEL USERNAME
        JLabel usernameLabel = new JLabel("Username:"); //TULISAN SEBELAH KOTAK
        usernameField        = new JTextField();        //KOTAKKAN INPUT USERNAME
        usernameField.setText(usernamePlaceholder);     //AGAR Tulisan "Masukkan Username" dapat hilanh saat user input
        
        usernameField.addFocusListener(new FocusListener()
                {
                    @Override
                    public void focusGained(FocusEvent e)
                    {
                        if (usernameField.getText().equals(usernamePlaceholder))
                            {
                                usernameField.setText("");
                            }
                    }
                    
                    @Override
                    public void focusLost(FocusEvent e)
                    {
                         if (usernameField.getText().isEmpty())
                        {
                             usernameField.setText(usernamePlaceholder);
                        }
                    }
                });//tutup kurungnya sampai  sini agar ovveride berhasil
        
        //MEMBAT LABEL PASSWORD
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(); //membuar plcaholder "Masukkan password"
        passwordField.setText(passwordPlaceholder);
        
        passwordField.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if(new String(passwordField.getPassword()).equals(passwordPlaceholder))
                {
                    passwordField.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e)
            {
                if(new String(passwordField.getPassword()).isEmpty())
                {
                    passwordField.setText(passwordPlaceholder);
                }
            }
        });
        
        //MEMBUAT BUTTON LOGIN
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                login();
            }
        });
        
        setLayout(null);
        
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());//placeholder
        add(loginButton);
        
        usernameLabel.setBounds(20,10,100,20);
        usernameField.setBounds(120,10,150,20);
        passwordLabel.setBounds(20,30,100,20);
        passwordField.setBounds(120,30,150,20);
        loginButton.setBounds(100,80,100,30);
        
        setVisible(true);//untuk menampilkan codingan ini
    }
    
    private void login()
    {
        //LOGIKA UNTUK LOGIN
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String reversedUsername = new StringBuilder(username).reverse().toString();
        
        if(username.equals("123230003") && password.equals(reversedUsername))//SETINGAN USERNAME DAN PASSWORD
        {
            new MainPage(username);
            dispose();
        }
        
        else
        {
            JOptionPane.showMessageDialog(this,"Login gagal. Username atau password salah.");
        }
    }
    
    
    public static void main(String[] args)
    {
        new LoginPage();
    }
}
