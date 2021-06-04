package com.company;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.LinkedList;
import java.util.Queue;


public class Pesan_Tiket_BIS {
    private JPanel panel1;
    private JComboBox cbTujuan;
    private JComboBox cbJumlah;
    private JComboBox cbTanggal;
    private JComboBox cbBulan;
    private JTextField tfHarga;
    private JTextField tfNama1;
    private JTextField tfNama2;
    private JTextField tfNama3;
    private JTextField tfNama4;
    private JButton BATALButton;
    private JTextArea taTiket;
    private JTextField tfJam;
    private JButton PESANButton;
    private JButton RESETButton;
    private JLabel jlNP4;
    private JLabel jlNP3;
    private JLabel jlNP2;
    private JLabel jlNP1;
    private JButton PRINTButton;
    private JTextField tfBayar;
    private JTextField tfKembali;


    public Pesan_Tiket_BIS() {


        cbTujuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tujuan = cbTujuan.getSelectedItem().toString();
                Integer jumlah= Integer.parseInt(cbJumlah.getSelectedItem().toString());
                Integer harga = getHargaByTujuan(tujuan);
                String jam = getJamByTujuan(tujuan);
                Integer tharga = harga*jumlah;
                tfHarga.setText(String.valueOf(tharga));
                tfJam.setText(jam);

            }
        });
        cbJumlah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tujuan = cbTujuan.getSelectedItem().toString();
                Integer jumlah= Integer.parseInt(cbJumlah.getSelectedItem().toString());
                String tanggal = cbTanggal.getSelectedItem().toString();
                Integer harga = getHargaByTujuan(tujuan);
                Integer tharga = harga*jumlah;
                tfHarga.setText(String.valueOf(tharga));

                if(jumlah==1){
                    jlNP1.setText("NAMA PENUMPANG");
                    tfNama1.setEnabled(true);
                    tfNama2.setEnabled(false);
                    tfNama3.setEnabled(false);
                    tfNama4.setEnabled(false);
                    jlNP1.setEnabled(true);
                    jlNP2.setEnabled(false);
                    jlNP3.setEnabled(false);
                    jlNP4.setEnabled(false);
                    tfNama1.setVisible(true);
                    tfNama2.setVisible(false);
                    tfNama3.setVisible(false);
                    tfNama4.setVisible(false);
                    jlNP1.setVisible(true);
                    jlNP2.setVisible(false);
                    jlNP3.setVisible(false);
                    jlNP4.setVisible(false);

                }else if(jumlah==2){
                    jlNP1.setText("NAMA PENUMPANG 1");
                    tfNama1.setEnabled(true);
                    tfNama2.setEnabled(true);
                    tfNama3.setEnabled(false);
                    tfNama4.setEnabled(false);
                    jlNP1.setEnabled(true);
                    jlNP2.setEnabled(true);
                    jlNP3.setEnabled(false);
                    jlNP4.setEnabled(false);
                    tfNama1.setVisible(true);
                    tfNama2.setVisible(true);
                    tfNama3.setVisible(false);
                    tfNama4.setVisible(false);
                    jlNP1.setVisible(true);
                    jlNP2.setVisible(true);
                    jlNP3.setVisible(false);
                    jlNP4.setVisible(false);

                }else if (jumlah==3) {
                    jlNP1.setText("NAMA PENUMPANG 1");
                    tfNama1.setEnabled(true);
                    tfNama2.setEnabled(true);
                    tfNama3.setEnabled(true);
                    tfNama4.setEnabled(false);
                    jlNP1.setEnabled(true);
                    jlNP2.setEnabled(true);
                    jlNP3.setEnabled(true);
                    jlNP4.setEnabled(false);
                    tfNama1.setVisible(true);
                    tfNama2.setVisible(true);
                    tfNama3.setVisible(true);
                    tfNama4.setVisible(false);
                    jlNP1.setVisible(true);
                    jlNP2.setVisible(true);
                    jlNP3.setVisible(true);
                    jlNP4.setVisible(false);

                }else if (jumlah==4) {
                    jlNP1.setText("NAMA PENUMPANG 1");
                    tfNama1.setEnabled(true);
                    tfNama2.setEnabled(true);
                    tfNama3.setEnabled(true);
                    tfNama4.setEnabled(true);
                    jlNP1.setEnabled(true);
                    jlNP2.setEnabled(true);
                    jlNP3.setEnabled(true);
                    jlNP4.setEnabled(true);
                    tfNama1.setVisible(true);
                    tfNama2.setVisible(true);
                    tfNama3.setVisible(true);
                    tfNama4.setVisible(true);
                    jlNP1.setVisible(true);
                    jlNP2.setVisible(true);
                    jlNP3.setVisible(true);
                    jlNP4.setVisible(true);
                }

            }
        });

        PESANButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tujuan = cbTujuan.getSelectedItem().toString();
                Integer jumlah= Integer.parseInt(cbJumlah.getSelectedItem().toString());
                String tanggal = cbTanggal.getSelectedItem().toString();
                String bulan = cbBulan.getSelectedItem().toString();
                Integer harga = getHargaByTujuan(tujuan);
                Integer tharga = harga*jumlah;
                int kembali = 0;
                String jam = getJamByTujuan(tujuan);
                boolean cek0 = false;
                boolean cek1 = false;
                boolean cek2 = false;
                boolean cek3 = true;
                boolean cek4 = true;
                boolean cek5 = true;
                boolean cek6 = false;
                int x = 0, y=0, z=0;

 //Uang
                if (tfBayar.getText().isEmpty()){
                    JOptionPane.showMessageDialog(panel1, "Anda Belum Memasukan Nominal Pembayaran", "BAYAR", JOptionPane.WARNING_MESSAGE);
                } else{
                    if (tfBayar.getText().matches(".*\\D.*")) {
                        JOptionPane.showMessageDialog(panel1, "Masukan Hanya Berupa Angka\n(BAYAR)", "BAYAR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Integer bayar = Integer.parseInt(tfBayar.getText());
                        kembali = bayar - tharga;
                        if (kembali < 0) {
                            JOptionPane.showMessageDialog(panel1, "Uang Yang Anda Masukan Kurang\n(BAYAR)", "BAYAR", JOptionPane.WARNING_MESSAGE);
                        } else {
                            cek6 = true;
                        }
                    }
                }


//ambil nama
                Queue<String> nama_Penumpang = new LinkedList<>();
                nama_Penumpang.add(tfNama1.getText());
                nama_Penumpang.add(tfNama2.getText());
                nama_Penumpang.add(tfNama3.getText());
                nama_Penumpang.add(tfNama4.getText());


                String nama[] = new String[4];
                for(int i=0; i<jumlah; i++){
                    nama[i]= nama_Penumpang.remove();
                }

//cek0. NAMA TIDAK BOLEH MEMUAT ANGKA ATAU SIMBOL
                if(tfNama1.getText().matches(".*[^a-z&&[^A-Z&&[\\S]]].*") || tfNama2.getText().matches(".*[^a-z&&[^A-Z&&[\\S]]].*") || tfNama3.getText().matches(".*[^a-z&&[^A-Z&&[\\S]]].*") || tfNama4.getText().matches(".*[^a-z&&[^A-Z&&[\\S]]].*")) {
                    cek0=false;
                    JOptionPane.showMessageDialog(panel1, "NAMA TIDAK BOLEH MEMUAT ANGKA ATAU SIMBOL", "PERHATIAN !, NAMA", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    cek0=true;

                }

//cek1. Cek TUJUAN
                if (tujuan.equals("-PILIH-")) {
                    JOptionPane.showMessageDialog(panel1, "ANDA BELUM MEMILIH TUJUAN", "PERINGATAN !", JOptionPane.WARNING_MESSAGE);
                }else {
                    cek1=true;
                }

//cek2. Cek TANGGAL
                if (tanggal.equals("-PILIH-")  || bulan.equals("-BULAN-")) {
                    JOptionPane.showMessageDialog(panel1, "ANDA BELUM MEMILIH TANGGAL", "PERINGATAN !", JOptionPane.WARNING_MESSAGE);
                } else {
                    cek2=true;
                }

//cek3. Nama harus di isi
                for(int a=0; a<jumlah; a++){
                    if(nama[a].isEmpty()){
                        x=x+1;
                    }
                }

                if(x>0){
                    cek3=false;
                    JOptionPane.showMessageDialog(panel1, "NAMA TIDAK BOLEH KOSONG", "PERHATIAN !, NAMA", JOptionPane.INFORMATION_MESSAGE);
                }

// cek4. Nama tidak boleh diawali/diakhiri/seluruhnya spasi
                for(int a=0; a<jumlah; a++){
                    if(nama[a].matches("^[\\s].*") || nama[a].matches(".*[\\s]$")) {
                        y=y+1;
                    }
                }
                if(y>0){
                    JOptionPane.showMessageDialog(panel1, "NAMA TIDAK BOLEH DIAWALI ATAU DIAKHIRI SPASI","PERHATIAN !, NAMA", JOptionPane.INFORMATION_MESSAGE);
                    cek4=false;
                }


//cek5. jumlah karakter maks.18
                for(int a=0; a<jumlah; a++){
                    if(nama[a].length()>18){
                        z=z+1;
                    }
                }
                if(z>0) {
                    JOptionPane.showMessageDialog(panel1,"Panjang maksimal NAMA 18 karakter, silahkan menyingkatnya", "PERHATIAN !, NAMA", JOptionPane.INFORMATION_MESSAGE);
                    cek5=false;
                }



                if(cek0 && cek1 && cek2 && cek3 && cek4 && cek5 && cek6){
                    tfKembali.setText(String.valueOf(kembali));
                    taTiket.append("\t\tTIKET PENUMPANG\n\n" +
                            "Tujuan\t: " + tujuan +"\n"+
                            "Tanggal\t: "+ tanggal+ " " + bulan +"\n"+
                            "Jam\t: "+jam+"\n"+
                            "Tarif\t: Rp."+harga+"/orang\n" +
                            "Total\t: Rp."+(harga*jumlah)+"\n" +
                            "Daftar Penumpang :\n");

                    for (int b=0; b<jumlah; b++){
                        taTiket.append("\t"+(b+1)+". "+ nama[b].toUpperCase()+"\n"
                        );
                    }

                }


                if(cek0 && cek1 && cek2 && cek3 && cek4 && cek5 && cek6) {
                    cbTujuan.setEnabled(false);
                    cbJumlah.setEnabled(false);
                    cbTanggal.setEnabled(false);
                    cbBulan.setEnabled(false);
                    tfJam.setEnabled(false);
                    tfNama1.setEnabled(false);
                    tfNama2.setEnabled(false);
                    tfNama3.setEnabled(false);
                    tfNama4.setEnabled(false);
                    tfBayar.setEnabled(false);
                    BATALButton.setEnabled(false);
                    PESANButton.setEnabled(false);
                    PRINTButton.setEnabled(true);
                    JOptionPane.showMessageDialog(panel1, "PEMESANAN BERHASIL\nPastikan tiket telah tercetak sebelum menekan tombol 'RESET'","TRANSAKSI", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        });

        cbBulan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int t =1;
                if (cbBulan.getSelectedItem().toString().equals("-BULAN-")){
                    cbTanggal.removeAllItems();
                    cbTanggal.addItem("-HARI-");
                } else if (cbBulan.getSelectedItem().toString().equals("JUNI")){
                    cbTanggal.removeAllItems();
                    for (t=1; t<31; t++){
                        cbTanggal.addItem(t);
                    }
                } else {
                    cbTanggal.removeAllItems();
                    for (t=1; t<=31; t++){
                        cbTanggal.addItem(t);
                    }
                }

            }
        });

        BATALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNama1.setText("");
                tfNama2.setText("");
                tfNama2.setEditable(false);
                tfNama3.setText("");
                tfNama3.setEditable(false);
                tfNama4.setText("");
                tfNama4.setEditable(false);
                tfHarga.setText("");
                tfBayar.setText("");
                tfKembali.setText("");
                cbJumlah.setSelectedItem("1");
                cbTujuan.setSelectedItem("-PILIH-");
                cbTanggal.setSelectedItem("-HARI-");
                cbBulan.setSelectedItem("-BULAN-");
                jlNP1.setEnabled(true);
                jlNP2.setEnabled(false);
                jlNP3.setEnabled(false);
                jlNP4.setEnabled(false);

            }
        });

        RESETButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbTujuan.setSelectedItem("-PILIH-");
                cbTujuan.setEnabled(true);
                cbJumlah.setSelectedItem("1");
                cbJumlah.setEnabled(true);
                cbTanggal.setSelectedItem("-HARI-");
                cbTanggal.setEnabled(true);
                cbBulan.setSelectedItem("-BULAN-");
                cbBulan.setEnabled(true);
                tfJam.setText("");
                tfJam.setEnabled(true);
                tfHarga.setText("");
                tfNama1.setText("");
                tfNama1.setEnabled(true);
                tfNama2.setText("");
                tfNama2.setEnabled(false);
                tfNama3.setText("");
                tfNama3.setEnabled(false);
                tfNama4.setText("");
                tfNama4.setEnabled(false);
                taTiket.setText("");
                BATALButton.setEnabled(true);
                PESANButton.setEnabled(true);
                jlNP1.setEnabled(true);
                jlNP2.setEnabled(false);
                jlNP3.setEnabled(false);
                jlNP4.setEnabled(false);
                tfBayar.setEnabled(true);
                tfBayar.setText("");
                tfKembali.setText("");
                RESETButton.setEnabled(false);
                PRINTButton.setEnabled(false);
            }
        });

        PRINTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    taTiket.print();
                } catch (PrinterException printerException) {
                    printerException.printStackTrace();
                }
                RESETButton.setEnabled(true);
            }
        });

    }
    public int getHargaByTujuan(String tujuan){
        if(tujuan.equals("JOGJA-BEKASI")){
            return 150000;
        }else if (tujuan.equals("JOGJA-JAKARTA")) {
            return 180000;
        }else if (tujuan.equals("JOGJA-TANGERANG")){
            return 190000;
        }else if (tujuan.equals("JOGJA-BOGOR")){
            return 190000;
        }else if (tujuan.equals("JOGJA-MERAK")){
            return 245000;
        }
        return 0;
    }
    public String getJamByTujuan(String tujuan){
        if(tujuan.equals("JOGJA-BEKASI")){
            return  "16.30 WIB";
        }else if (tujuan.equals("JOGJA-JAKARTA")) {
            return  "15.30 WIB";
        }else if (tujuan.equals("JOGJA-TANGERANG")){
           return   "15.00 WIB";
        }else if (tujuan.equals("JOGJA-BOGOR")){
            return  "15.30 WIB";
        }else if (tujuan.equals("JOGJA-MERAK")){
            return  "13.00 WIB";
        }else {return "";}

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Pesan Tiket BIS");
        frame.setContentPane(new Pesan_Tiket_BIS().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
