package com.techlog.web.model;

import java.util.*;

public class Musteri {
	
	private int kisiNo;
	private String ad, soyad, kurum, departman, pozisyon, ekleyen, tarih, last_change;
	private List<String> tel = new ArrayList<String>();
	private List<String> email = new ArrayList<String>();
	private List<String> adres = new ArrayList<String>();
	
		public Musteri() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<String> getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel.add(tel);
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email.add(email);
	}

	public List<String> getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres.add(adres);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ad == null) ? 0 : ad.hashCode());
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result + ((departman == null) ? 0 : departman.hashCode());
		result = prime * result + ((ekleyen == null) ? 0 : ekleyen.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + kisiNo;
		result = prime * result + ((kurum == null) ? 0 : kurum.hashCode());
		result = prime * result + ((last_change == null) ? 0 : last_change.hashCode());
		result = prime * result + ((pozisyon == null) ? 0 : pozisyon.hashCode());
		result = prime * result + ((soyad == null) ? 0 : soyad.hashCode());
		result = prime * result + ((tarih == null) ? 0 : tarih.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Musteri))
			return false;
		Musteri other = (Musteri) obj;
		if (ad == null) {
			if (other.ad != null)
				return false;
		} else if (!ad.equals(other.ad))
			return false;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
			return false;
		if (departman == null) {
			if (other.departman != null)
				return false;
		} else if (!departman.equals(other.departman))
			return false;
		if (ekleyen == null) {
			if (other.ekleyen != null)
				return false;
		} else if (!ekleyen.equals(other.ekleyen))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (kisiNo != other.kisiNo)
			return false;
		if (kurum == null) {
			if (other.kurum != null)
				return false;
		} else if (!kurum.equals(other.kurum))
			return false;
		if (last_change == null) {
			if (other.last_change != null)
				return false;
		} else if (!last_change.equals(other.last_change))
			return false;
		if (pozisyon == null) {
			if (other.pozisyon != null)
				return false;
		} else if (!pozisyon.equals(other.pozisyon))
			return false;
		if (soyad == null) {
			if (other.soyad != null)
				return false;
		} else if (!soyad.equals(other.soyad))
			return false;
		if (tarih == null) {
			if (other.tarih != null)
				return false;
		} else if (!tarih.equals(other.tarih))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
	

}
