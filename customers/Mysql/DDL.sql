CREATE TABLE kullanici_yetkileri (
    yetki_id INT AUTO_INCREMENT,
    yetki_adi  VARCHAR(50) NOT NULL UNIQUE,
    musteri_yonetimi BOOLEAN NOT NULL DEFAULT FALSE,
    fatura_yonetimi BOOLEAN NOT NULL DEFAULT FALSE,
    teklif_yonetimi BOOLEAN NOT NULL DEFAULT FALSE,
    stok_yonetimi BOOLEAN NOT NULL DEFAULT FALSE,
    teknik_servis BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (yetki_id)
);

INSERT INTO kullanici_yetkileri (yetki_adi, musteri_yonetimi, fatura_yonetimi, teklif_yonetimi, stok_yonetimi, teknik_servis)
VALUES('Administrator', true, true, true, true, true);

INSERT INTO kullanici_yetkileri (yetki_adi, musteri_yonetimi, fatura_yonetimi, teklif_yonetimi, stok_yonetimi, teknik_servis)
VALUES('Accounting', true, true, true, true, false);

INSERT INTO kullanici_yetkileri (yetki_adi, musteri_yonetimi, fatura_yonetimi, teklif_yonetimi, stok_yonetimi, teknik_servis)
VALUES('Sales', true, false, true, false, false);

INSERT INTO kullanici_yetkileri (yetki_adi, musteri_yonetimi, fatura_yonetimi, teklif_yonetimi, stok_yonetimi, teknik_servis)
VALUES('Technical Service', true, false, true, true, true);

CREATE TABLE kullanici (
    kullanici_id INT AUTO_INCREMENT,
    yetki_id INT NOT NULL,
    calisan_adi varchar(150) NOT NULL,
    calisan_soyadi varchar(150) NOT NULL,
    calisan_departman varchar(50) NOT NULL,
    calisan_tel varchar(50) NOT NULL,
    calisan_email varchar(100) NOT NULL UNIQUE,
    calisan_toplam_satis decimal(15,2) NOT NULL,
    kullanici_sifre varchar(50) NOT NULL,
    PRIMARY KEY (kullanici_id),
    FOREIGN KEY (yetki_id) REFERENCES kullanici_yetkileri(yetki_id)
);
CREATE TABLE kullanici_bildirim_mesaj (
	calisan_bildirim_mesaj_no INT AUTO_INCREMENT,
    kullanici_id INT,
    bildirim_mesaj LONGTEXT,
    bildirim_mesaj_type_flag TINYINT DEFAULT false,
    bildirim_mesaj_date DATE NOT NULL,
    bildirim_mesaj_okundu_flag TINYINT DEFAULT false,
    PRIMARY KEY (calisan_bildirim_mesaj_no),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
    );
CREATE TABLE musteri (
    musteri_id INT NOT NULL AUTO_INCREMENT,
    musteri_kurumsal_isim VARCHAR(50) NOT NULL,
    musteri_tarih DATE NOT NULL,
    kullanici_id INT,
    PRIMARY KEY (musteri_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id)
    ON DELETE SET NULL
);
CREATE TABLE musteri_kisiler (
    musteri_kisi_no INT AUTO_INCREMENT,
    musteri_id INT NOT NULL,
    musteri_ad VARCHAR(100) NOT NULL,
    musteri_soyad VARCHAR(100) NOT NULL,
    musteri_departman VARCHAR(255) NOT NULL,
    musteri_pozisyon VARCHAR(255),
    musteri_kisi_tarih DATE NOT NULL,
    musteri_aktiflik VARCHAR(50) NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (musteri_kisi_no),
    FOREIGN KEY (musteri_id) REFERENCES musteri(musteri_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
CREATE TABLE musteri_tel (
    musteri_tel_id INT AUTO_INCREMENT,
    musteri_kisi_no INT NOT NULL,
    musteri_tel VARCHAR(50) NOT NULL,
    musteri_primary_tel_flag boolean NOT NULL,
    is_active boolean default true,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (musteri_tel_id),
    FOREIGN KEY (musteri_kisi_no) REFERENCES musteri_kisiler(musteri_kisi_no) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
CREATE TABLE musteri_adres (
    musteri_adres_no INT AUTO_INCREMENT,
    musteri_adres VARCHAR(255),
    musteri_id INT NOT NULL,
    musteri_primary_address_flag tinyint DEFAULT false,
    is_active boolean default true,
    kullanici_id INT NOT NULL,
    last_change DATE NOT NULL,
    PRIMARY KEY (musteri_adres_no),
    FOREIGN KEY (musteri_id) REFERENCES musteri(musteri_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
CREATE TABLE musteri_adresler_junction (
    musteri_adres_id INT AUTO_INCREMENT,
    musteri_kisi_no INT NOT NULL,
    musteri_id INT NOT NULL,
    musteri_adres_no INT NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (musteri_adres_id),
    FOREIGN KEY (musteri_kisi_no) REFERENCES musteri_kisiler(musteri_kisi_no) ON DELETE CASCADE,
    FOREIGN KEY (musteri_id) REFERENCES musteri(musteri_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
CREATE TABLE musteri_email (
    musteri_email_no INT AUTO_INCREMENT,
    musteri_kisi_no INT NOT NULL,
    musteri_email VARCHAR(100) NOT NULL,
    musteri_primary_email_flag boolean NOT NULL,
    is_active boolean default true,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (musteri_email_no),
    FOREIGN KEY (musteri_kisi_no) REFERENCES musteri_kisiler(musteri_kisi_no) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);