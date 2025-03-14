
package latihan.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;//untuk mengformat dan mengurai angka, mata uang dan persentase
import java.util.Locale;//untuk mewakili wilayah geografis, politik atau budaya tertentu, untuk menentukan format angka(Locale.US) atau (Locale.ID)


public class PembelianPage extends JFrame 
{
    private JTextField jumlahField;
    private JComboBox<String> jenisDVDComboBox;//untuk pemilihan jenis DVD pada setiap Kategori
    private JLabel ppnLabel;
    private JLabel totalHargaLabel;
    private int harga;
    private JLabel jumlahBeliValueLabel;
    private JLabel diskonLabel;//diskon akan dilakukan jika orang beli lebih dari 2 DVD
    private JLabel diskonValueLabel;
    
    public PembelianPage(String kategori, int harga)
    {
        setTitle("Halaman pembelian");
        setSize(290,430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        
        this.harga = harga;
        
        JLabel kategoriLabel = new JLabel("Kategori");
        JLabel kategoriValueLabel = new JLabel(kategori);
        JLabel hargaLabel = new JLabel("Harga");
        JLabel hargaValueLabel = new JLabel(formatRupiah(harga) + " / pcs");
        JLabel jumlahLabel = new JLabel("Jumlah");
        jumlahField = new JTextField();
        JLabel jenisDVDLabel = new JLabel("Jenis DVD");
        String[] jenisDVDOptions = getJenisDVDOptions(kategori);
        jenisDVDComboBox = new JComboBox<>(jenisDVDOptions);
        JButton beliButton = new JButton("Beli");
        JButton kembaliButton = new JButton("Kembali");
        
        JButton totalPembelianButton = new JButton("Total Pembelian");
        JLabel hargaSatuanLabel = new JLabel("harga Satuan");
        JLabel hargaSatuanValueLabel = new JLabel(formatRupiah(harga));
        JLabel jumlahBeliLabel = new JLabel("Jumlah");
        jumlahBeliValueLabel = new JLabel("");
        JLabel ppnLabel = new JLabel("PPN (11%)");
        this.ppnLabel = new JLabel("");
        JLabel totalHargaLabel = new JLabel("Total Harga");
        this.totalHargaLabel = new JLabel("");
        //INISIALISASI LABEL DISKON
        diskonLabel = new JLabel("Diskon");
        diskonValueLabel = new JLabel("");
        
        kembaliButton.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               new MainPage("123230003");
               dispose();
           }
        });
        
        beliButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                hitungTotal();
            }
        });
        
        add(kategoriLabel);
        add(kategoriValueLabel);
        add(hargaLabel);
        add(hargaValueLabel);
        add(jumlahLabel);
        add(jumlahField);
        add(jenisDVDLabel);
        add(jenisDVDComboBox);
        add(beliButton);
        add(totalPembelianButton);
        add(new JLabel());
        add(hargaSatuanLabel);
        add(jumlahBeliLabel);
        add(jumlahBeliValueLabel);
        add(diskonLabel);
        add(diskonValueLabel);
        add(ppnLabel);
        add(this.ppnLabel);
        add(totalHargaLabel);
        add(this.totalHargaLabel);
        add(kembaliButton);
        add(new JLabel());
        kembaliButton.setBackground(Color.RED); //mengatur warna button merah
        kembaliButton.setForeground(Color.WHITE);//mengatur warna text di button

       
        kategoriLabel.setBounds(20,10,440,15);
        kategoriValueLabel.setBounds(120,10,440,15);
        
        jumlahLabel.setBounds(20,30,440,15);
        jumlahField.setBounds(120,30,120,20);
        
        jenisDVDLabel.setBounds(20,50,440,15);
        jenisDVDComboBox.setBounds(120,50,120,22);
        
        totalPembelianButton.setBounds(20,80,220,18);
        totalPembelianButton.setBackground(Color.GRAY);
        totalPembelianButton.setForeground(Color.WHITE);
        
        
        hargaSatuanLabel.setBounds(20,100,440,15);
        hargaValueLabel.setBounds(120,100,440,15);
        
        jumlahBeliLabel.setBounds(20,120,440,15);
        jumlahBeliValueLabel.setBounds(120,120,440,15);
        
        diskonLabel.setBounds(20,140,440,15);
        diskonValueLabel.setBounds(120,140,440,15);
        
        ppnLabel.setBounds(20,160,440,15);
        this.ppnLabel.setBounds(120,160,440,15);
        
        totalHargaLabel.setBounds(20,180,440,15);
        this.totalHargaLabel.setBounds(120,180,440,15);
        
        beliButton.setBounds(20,220,220,20);
        beliButton.setBackground(Color.green);
        beliButton.setForeground(Color.white);
        kembaliButton.setBounds(20,245,220,20);
        
        setVisible(true);
    }
    
    private String[] getJenisDVDOptions(String kategori)
    {
        if(kategori.equals("DVD Anak"))
        {
            return new String[]{"Nyanyian Anak-Anak", "Edukasi Anak-Anak", "Cerita Anak-Anak"};    
        }
        
        else if(kategori.equals("DVD Dewasa"))
        {
            return new String[]{"Film Action", "Film Drama","Film Komedi"};
        }
        
        else if(kategori.equals("DVD Lansia"))
        {
            return new String[]{"Film Klasik","Film Dokumenter","Religi"};
        }
        
        return new String[]{};
    }
    
    private void hitungTotal()
    {
        try
        {
            int jumlah = Integer.parseInt(jumlahField.getText());
            double diskon = 0;
            if(jumlah > 2)
            {
                diskon = 0.10;//DISKON 10 %
            }
            double hargaSetelahDiskon = harga * jumlah *(1 - diskon);
            double ppn = (harga * jumlah) * 0.11;
            double total = (harga * jumlah) + ppn;
            
            jumlahBeliValueLabel.setText(jumlah + " pcs");
            diskonValueLabel.setText(String.format("%.0f%%", diskon * 100));
            ppnLabel.setText(formatRupiah(ppn));
            totalHargaLabel.setText(formatRupiah(total));
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Masukkan jumlah yang valid.");
        }
    }
    
    private String formatRupiah(double nilai)
    {
        Locale localID = new Locale("in","ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localID);
        return formatRupiah.format(nilai);
    }
}
