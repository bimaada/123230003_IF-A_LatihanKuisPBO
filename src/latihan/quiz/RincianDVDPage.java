
package latihan.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class RincianDVDPage extends JFrame
{
    public RincianDVDPage(String kategori,int harga)
    {
        setTitle("Rincian " + kategori);
        setSize(400,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        JLabel judulLabel = new JLabel("Rincian " + kategori);
        judulLabel.setHorizontalAlignment(SwingConstants.CENTER);
        judulLabel.setBounds(100,20,200,30);
        add(judulLabel);
        
        JPanel rincianPanel = new JPanel();//untuk membuat tulisan jenis DVD
        rincianPanel.setLayout(new GridLayout(4,1));
        rincianPanel.setBounds(50,70,300,100);
        add(rincianPanel);
        if(kategori.equals("DVD Anak"))
        {
            //ISIAN DI KATEGORI DVD ANAK
            rincianPanel.add(new JLabel("Nyayian Anak-anak"));
            rincianPanel.add(new JLabel("Edukasi Anak-anak"));
            rincianPanel.add(new JLabel("Cerita Anak-anak"));   
        }
        
        else if (kategori.equals("DVD Dewasa"))
        {
            //ISIAN DI KATEGORI DVD DEWASA
            rincianPanel.add(new JLabel("Film Action"));
            rincianPanel.add(new JLabel("Film Drama"));
            rincianPanel.add(new JLabel("Film Komedi"));
        }
        
        else if (kategori.equals("DVD Lansia"))
        {
            //ISIAN DI KATEGORI DVD LANSIA
            rincianPanel.add(new JLabel("Film Klasik"));
            rincianPanel.add(new JLabel("Dokumenter"));
            rincianPanel.add(new JLabel("Religi"));
        }
        
        
        JButton beliButton = new JButton("Beli"); //membuat button beli
        beliButton.setBounds(100,200,100,30);
        beliButton.setBackground(Color.GREEN);
        beliButton.setForeground(Color.WHITE);
        beliButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new PembelianPage(kategori, harga);
                dispose();//menuju ke halaman pembelianpage saat user click beli
            }
        });
        
        add(beliButton);
        
        JButton kembaliButton = new JButton("kembali");
        kembaliButton.setBounds(200,200,100,30);
        kembaliButton.setBackground(Color.red);
        kembaliButton.setForeground(Color.white);
        kembaliButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MainPage(MainPage.getUsername());
                dispose();
            }
        });
        
        add(kembaliButton);
        setVisible(true);
    }
}
