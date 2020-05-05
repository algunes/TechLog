package com.techlog.web.dao;
import java.sql.*;


import com.techlog.web.model.musteri;

public class MusteriDAO {
	
	public musteri getMusteri(String ad) {

		musteri m = new musteri();
		// String s = new String("call search('emel',null,null)");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekniksatistakip","root","Arturo19....?");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("call search('" + ad + "',null,null,null,null,null)");
			
			if (rs.next()) {
			
			m.setKisiNo(rs.getInt("musteri_kisi_no"));
			m.setAd(rs.getString("musteri_ad"));
			m.setSoyad(rs.getString("musteri_soyad"));
			m.setKurum(rs.getString("musteri_kurumsal_isim"));
			m.setDepartman(rs.getString("musteri_departman"));
			m.setPozisyon(rs.getString("musteri_pozisyon"));
			m.setEmail(rs.getString("musteri_email"));
			m.setTelefon(rs.getString("musteri_tel"));
			m.setAdres(rs.getString("musteri_adres"));
			m.setEkleyen(rs.getString("ekleyen"));
			m.setTarih(rs.getString("eklenme_tarihi"));
			
			st.close();
			con.close();
			}
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return m;
	}

}
