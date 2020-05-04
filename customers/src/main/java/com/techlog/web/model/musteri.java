package com.techlog.web.model;

public class musteri {
	
	private int kisiNo;
	private String ad, soyad, kurum, departman, pozisyon, tarih, aktiflik, ekleyen, lastChange;
	
	public musteri(int kisiNo, String ad, String soyad, String kurum, String departman, String pozisyon, String tarih,
			String aktiflik, String ekleyen, String lastChange) {
		super();
		this.kisiNo = kisiNo;
		this.ad = ad;
		this.soyad = soyad;
		this.kurum = kurum;
		this.departman = departman;
		this.pozisyon = pozisyon;
		this.tarih = tarih;
		this.aktiflik = aktiflik;
		this.ekleyen = ekleyen;
		this.lastChange = lastChange;
	}

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

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getAktiflik() {
		return aktiflik;
	}

	public void setAktiflik(String aktiflik) {
		this.aktiflik = aktiflik;
	}

	public String getEkleyen() {
		return ekleyen;
	}

	public void setEkleyen(String ekleyen) {
		this.ekleyen = ekleyen;
	}

	public String getLastChange() {
		return lastChange;
	}

	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}

	@Override
	public String toString() {
		return "musteri [kisiNo=" + kisiNo + ", ad=" + ad + ", soyad=" + soyad + ", kurum=" + kurum + ", departman="
				+ departman + ", pozisyon=" + pozisyon + ", tarih=" + tarih + ", aktiflik=" + aktiflik + ", ekleyen="
				+ ekleyen + ", lastChange=" + lastChange + "]";
	}
	
	
	
	

}
