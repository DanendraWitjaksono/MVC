/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controller.controller_siswa;
import com.koneksi.koneksi;
import com.view.form_siswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class model_siswa implements controller_siswa {
    String jk;
    
    @Override
    public void Simpan(form_siswa siswa) {
        if (siswa.rbLaki.isSelected()) {
            jk = "Laki-laki";
        }else{
            jk = "Perempuan";
        }
        try {
            Connection con = koneksi.getcon();
            String sql = "Insert Into siswa Values (?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement (sql);
            prepare.setString(1, siswa.txtNIS.getText());
            prepare.setString(2, siswa.txtNama.getText());
            prepare.setString(3, jk);
            prepare.setString(4, (String) siswa.cbJurusan.getSelectedItem());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            siswa.setLebarKolom();
        }
    }

    @Override
    public void reset(form_siswa siswa) throws SQLException {
        siswa.txtNIS.setText("");
        siswa.txtNama.setText("");
        siswa.rbLaki.setSelected(true);
        siswa.cbJurusan.setSelectedIndex(0);
    }

    @Override
    public void ubah(form_siswa siswa) throws SQLException {
        if (siswa.rbLaki.isSelected()) {
            jk = "Laki-laki";
        }else{
            jk = "Perempuan";
        }
        try {
            Connection con = koneksi.getcon();
            String sql = "UPDATE siswa SET nama=?, jenis_kelamin=?," + "jurusan=? WHERE NIS=?";
            PreparedStatement prepare = con.prepareStatement (sql);
            prepare.setString(4, siswa.txtNIS.getText());
            prepare.setString(1, siswa.txtNama.getText());
            prepare.setString(2, jk);
            prepare.setString(3, (String) siswa.cbJurusan.getSelectedItem());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Simpan(siswa);
            siswa.setLebarKolom();
            baru(siswa);
        }
    }

    @Override
//    public void baru(form_siswa siswa) throws SQLException {
//       siswa.txtNIS.setText("");
//        siswa.txtNama.setText("");
//        siswa.rbLaki.setSelected(true);
//        siswa.cbJurusan.setSelectedIndex(0);
//    }
//    }
    
    
   
    
