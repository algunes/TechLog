package com.techlog.web.model;

public class musteri {
	
	private int kisiNo;
	private String ad, soyad, kurum, departman, pozisyon, email, telefon, adres, ekleyen, tarih;
	
	

	public int getKisiNo() {
		return kisiNo;
	}

	public void setKisiNo(int kisiNo) {
		this.kisiNo = kisiNo;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getKurum() {
		return kurum;
	}

	public void setKurum(String kurum) {
		this.kurum = kurum;
	}

	public String getDepartman() {
		return departman;
	}

	public void setDepartman(String departman) {
		this.departman = departman;
	}

	public String getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getEkleyen() {
		return ekleyen;
	}

	public void setEkleyen(String ekleyen) {
		this.ekleyen = ekleyen;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	@Override
	public String toString() {
		return "musteri [kisiNo=" + kisiNo + ", ad=" + ad + ", soyad=" + soyad + ", kurum=" + kurum + ", departman="
				+ departman + ", pozisyon=" + pozisyon + ", email=" + email + ", telefon=" + telefon + ", adres="
				+ adres + ", ekleyen=" + ekleyen + ", tarih=" + tarih + "]";
	}

}
