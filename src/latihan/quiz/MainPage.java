
package latihan.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPage extends JFrame
{
    private static String username;//Variabel untuk menyimpan username
    
    public MainPage(String username)
    {
        MainPage.username = username; // Simpan username
        setTitle("Halaman Utama");// Judul
        setSize(400,250); //ukuran windowsnya panjang 400, lebar 250 pixel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        
        JLabel welcomeLabel = new JLabel("Selamat Datang, " + username);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel silakanPilih = new JLabel("Silakan Pilih Kategori DVD!");
        silakanPilih.setHorizontalAlignment(SwingConstants.LEFT);
        
        JButton anakButton = new JButton("DVD Anak");
        JButton dewasaButton = new JButton("DVD Dewasa");
        JButton lansiaButton = new JButton("DVD Lansia");
        JButton kembaliButton = new JButton ("Kembali ke Login");
        
        anakButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RincianDVDPage("DVD Anak", 27891);
                dispose();
            }
        });
        
        dewasaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RincianDVDPage("DVD Dewasa", 35399);
                dispose();
            }
        });
        
        lansiaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RincianDVDPage("DVD Lansia", 38550);
                dispose();
            }
        });
        
        kembaliButton.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed (ActionEvent e)
          {
              new LoginPage();
              dispose();
          }
        });
        
        setLayout(null);
        add(welcomeLabel);
        add(silakanPilih);
        add(anakButton);
        add(dewasaButton);
        add(lansiaButton);
        add(kembaliButton);
        
        welcomeLabel.setBounds(100,20,200,30);
        silakanPilih.setBounds(100,45,200,15);
        anakButton.setBounds(100,60,200,30);
        dewasaButton.setBounds(100,90,200,30);
        lansiaButton.setBounds(100,120,200,30);
        kembaliButton.setBounds(100,170,200,30);
        kembaliButton.setBackground(Color.RED); //mengatur warna button merah
        kembaliButton.setForeground(Color.WHITE);//mengatur warna text di button
        
        setVisible(true); //menampilkan codingan
    }
    
    public static String getUsername()
    {
        return username;
    }
}
