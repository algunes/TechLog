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
-- This is your current Limit. From this point you have to rearrange constraints!!!!
CREATE TABLE marka (
    marka_id INT NOT NULL AUTO_INCREMENT,
    marka VARCHAR(150) UNIQUE NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (marka_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * from marka;
CREATE TABLE model (
    model_id INT NOT NULL AUTO_INCREMENT,
    model VARCHAR(255) UNIQUE NOT NULL,
    marka_id INT NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (model_id),
    FOREIGN KEY (marka_id) REFERENCES marka(marka_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * from model;
CREATE TABLE aksesuar (
    aksesuar_id INT NOT NULL AUTO_INCREMENT,
    marka_id INT NOT NULL,
    model_id INT NOT NULL,
    aksesuar VARCHAR(255) NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (aksesuar_id),
    FOREIGN KEY (marka_id) REFERENCES marka(marka_id) ON DELETE CASCADE,
    FOREIGN KEY (model_id) REFERENCES model(model_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * from aksesuar;
CREATE TABLE sarf (
    sarf_id INT NOT NULL AUTO_INCREMENT,
    marka_id INT NOT NULL,
    model_id INT NOT NULL,
    sarf VARCHAR(255) NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (sarf_id),
    FOREIGN KEY (marka_id) REFERENCES marka(marka_id) ON DELETE CASCADE,
    FOREIGN KEY (model_id) REFERENCES model(model_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM sarf;
CREATE TABLE stok_durum (
    stok_durum_id INT NOT NULL AUTO_INCREMENT,
    stok_durumu VARCHAR(100) NOT NULL,
    last_change DATE NOT NULL,
    PRIMARY KEY (stok_durum_id)
);
INSERT INTO stok_durum(stok_durumu, last_change)
	VALUES
("Stokta" , curdate() );
INSERT INTO stok_durum(stok_durumu, last_change)
	VALUES
("Satıldı" , curdate() );
INSERT INTO stok_durum(stok_durumu, last_change)
	VALUES
("Dış Kayıt" , curdate() );

SELECT * FROM stok_durum;
CREATE TABLE seri_numaralari (
    urun_seri_id INT NOT NULL AUTO_INCREMENT,
    marka_id INT NOT NULL,
    model_id INT,
    aksesuar_id INT,
    musteri_id INT,
    stok_durum_id INT NOT NULL,
    seri_no VARCHAR(255) NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (urun_seri_id),
    FOREIGN KEY (marka_id) REFERENCES marka(marka_id),
    FOREIGN KEY (model_id) REFERENCES model(model_id),
    FOREIGN KEY (aksesuar_id) REFERENCES aksesuar(aksesuar_id),
    FOREIGN KEY (musteri_id) REFERENCES musteri(musteri_id),
    FOREIGN KEY (stok_durum_id) REFERENCES stok_durum(stok_durum_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM seri_numaralari;
CREATE TABLE sozlesme (
    sozlesme_id INT NOT NULL AUTO_INCREMENT,
    urun_seri_id INT NOT NULL,
    baslangic_tarih DATE NOT NULL,
    bitis_tarih DATE NOT NULL,
    periyod INT NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (sozlesme_id),
    FOREIGN KEY (urun_seri_id) REFERENCES seri_numaralari(urun_seri_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM sozlesme;
CREATE TABLE cihaz_stok (
    cihaz_stok_id INT NOT NULL AUTO_INCREMENT,
    model_id INT NOT NULL,
    stok_adedi INT NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (cihaz_stok_id),
    FOREIGN KEY (model_id) REFERENCES model(model_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM cihaz_stok;
CREATE TABLE aksesuar_stok (
    aksesuar_stok_id INT NOT NULL AUTO_INCREMENT,
    aksesuar_id INT NOT NULL,
    stok_adedi INT NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (aksesuar_stok_id),
    FOREIGN KEY (aksesuar_id) REFERENCES aksesuar(aksesuar_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM aksesuar_stok;
CREATE TABLE birim (
    birim_id INT NOT NULL AUTO_INCREMENT,
    birim VARCHAR(50),
    last_change DATE NOT NULL,
    PRIMARY KEY (birim_id)
);
INSERT INTO birim(birim, last_change)
	VALUES
(NULL , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("kg" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("gr" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("mg" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("lt" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("ml" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("m" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("cm" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("mm" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("Square Meter" , curdate() );
INSERT INTO birim(birim, last_change)
	VALUES
("Cubic Meter" , curdate() );
CREATE TABLE sarf_stok (
    sarf_stok_id INT NOT NULL AUTO_INCREMENT,
    sarf_id INT NOT NULL,
    sarf_miktari decimal(15,2) NOT NULL,
    birim_id INT,
    stok_adedi INT NOT NULL,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (sarf_stok_id),
    FOREIGN KEY (sarf_id) REFERENCES sarf(sarf_id) ON DELETE CASCADE,
    FOREIGN KEY (birim_id) REFERENCES birim(birim_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * from sarf_stok;
CREATE TABLE teklif_durum (
    teklif_durum_id INT NOT NULL AUTO_INCREMENT,
    teklif_durum VARCHAR(50) NOT NULL,
    last_change DATE NOT NULL,
    PRIMARY KEY (teklif_durum_id)
);
INSERT INTO teklif_durum(teklif_durum, last_change)
	VALUES
("Aktif" , curdate() );
INSERT INTO teklif_durum(teklif_durum, last_change)
	VALUES
("Pasif" , curdate() );
INSERT INTO teklif_durum(teklif_durum, last_change)
	VALUES
("Onaylandı" , curdate() );
INSERT INTO teklif_durum(teklif_durum, last_change)
	VALUES
("Ret" , curdate() );
SELECT * FROM teklif_durum;
CREATE TABLE urun_aciklama (
    urun_desc_id INT NOT NULL AUTO_INCREMENT,
    model_id INT,
    aksesuar_id INT,
    sarf_id INT,
    sozlesme_id INT,
    aciklama VARCHAR(255) NOT NULL UNIQUE,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (urun_desc_id),
    FOREIGN KEY (model_id) REFERENCES model(model_id),
    FOREIGN KEY (aksesuar_id) REFERENCES aksesuar(aksesuar_id),
    FOREIGN KEY (sarf_id) REFERENCES sarf(sarf_id),
    FOREIGN KEY (sozlesme_id) REFERENCES sozlesme(sozlesme_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM urun_aciklama;
CREATE TABLE on_satis (
    on_satis_id INT NOT NULL AUTO_INCREMENT,
    kullanici_id INT,
    musteri_id INT NOT NULL,
    musteri_kisi_no INT NOT NULL,
    urun_desc_id INT NOT NULL,
    on_satis_miktar DECIMAL(15,2),
    birim_id INT,
    on_satis_adet INT NOT NULL,
    on_satis_fiyat decimal(15,2) NOT NULL,
    on_satis_flag TINYINT DEFAULT false,
    last_change DATE NOT NULL,
    PRIMARY KEY (on_satis_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL,
    FOREIGN KEY (musteri_id) REFERENCES musteri(musteri_id) ON DELETE CASCADE,
    FOREIGN KEY (musteri_kisi_no) REFERENCES musteri_kisiler(musteri_kisi_no) ON DELETE CASCADE,
    FOREIGN KEY (urun_desc_id) REFERENCES urun_aciklama(urun_desc_id),
    FOREIGN KEY (birim_id) REFERENCES birim(birim_id)
);
SELECT * FROM on_satis;
CREATE TABLE teklif (
    teklif_id INT NOT NULL AUTO_INCREMENT,
    teklif_no VARCHAR(255) NOT NULL,
    kullanici_id INT,
    musteri_id INT NOT NULL,
    musteri_kisi_no INT NOT NULL,
    urun_desc_id INT NOT NULL,
    urun_miktari DECIMAL(15,2),
    birim_id INT,
    urun_adedi INT NOT NULL,
    teklif_fiyat decimal(15,2) NOT NULL,
    teklif_durum_id INT NOT NULL,
    teklif_tarih DATE NOT NULL,
    last_change DATE NOT NULL,
    PRIMARY KEY (teklif_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL,
    FOREIGN KEY (musteri_id) REFERENCES musteri(musteri_id),
    FOREIGN KEY (musteri_kisi_no) REFERENCES musteri_kisiler(musteri_kisi_no) ON DELETE CASCADE,
    FOREIGN KEY (urun_desc_id) REFERENCES urun_aciklama(urun_desc_id),
    FOREIGN KEY (birim_id) REFERENCES birim(birim_id),
    FOREIGN KEY (teklif_durum_id) REFERENCES teklif_durum(teklif_durum_id)
);
SELECT * FROM teklif;
CREATE TABLE yedek_parca (
    yedek_parca_id INT NOT NULL AUTO_INCREMENT,
    marka_id INT NOT NULL,
    model_id INT,
    yedek_parca_ismi VARCHAR(255) NOT NULL,
    yedek_parca_kodu VARCHAR(255),
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (yedek_parca_id),
    FOREIGN KEY (marka_id) REFERENCES marka(marka_id) ON DELETE CASCADE,
    FOREIGN KEY (model_id) REFERENCES model(model_id) ON DELETE CASCADE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM yedek_parca;
CREATE TABLE garanti_durum (
    garanti_durum_id INT NOT NULL AUTO_INCREMENT,
    garanti_durumu VARCHAR(100) NOT NULL,
    last_change DATE NOT NULL,
    PRIMARY KEY (garanti_durum_id)
);
INSERT INTO garanti_durum(garanti_durumu, last_change)
	VALUES
("Garanti Kapsamında" , curdate() );
INSERT INTO garanti_durum(garanti_durumu, last_change)
	VALUES
("Garanti Kapsamında Değil" , curdate() );
CREATE TABLE teknik_servis_durum (
    teknik_servis_durum_id INT NOT NULL AUTO_INCREMENT,
    teknik_servis_durumu VARCHAR(100) NOT NULL,
    last_change DATE NOT NULL,
    PRIMARY KEY (teknik_servis_durum_id)
);
INSERT INTO teknik_servis_durum(teknik_servis_durumu, last_change)
	VALUES
("İşlem Devam Etmekte" , curdate() );
INSERT INTO teknik_servis_durum(teknik_servis_durumu, last_change)
	VALUES
("İşlem Sona Erdi" , curdate() );
SELECT * FROM teknik_servis_durum;
CREATE TABLE teknik_servis (
	teknik_servis_no INT NOT NULL AUTO_INCREMENT,
    urun_seri_id INT NOT NULL,
    musteri_kisi_no INT NOT NULL,
    giris_tarihi DATE NOT NULL,
    cikis_tarihi DATE NOT NULL,
    ariza_tanimi VARCHAR(255),
    yapilan_islem VARCHAR(255),
    yedek_parca_id INT,
    garanti_durum_id INT,
    teknik_servis_fiyat DECIMAL(15,2),
    teknik_servis_durum_id INT,
    kullanici_id INT,
    last_change DATE NOT NULL,
    PRIMARY KEY (teknik_servis_no),
    FOREIGN KEY (urun_seri_id) REFERENCES seri_numaralari(urun_seri_id),
    FOREIGN KEY (musteri_kisi_no) REFERENCES musteri_kisiler(musteri_kisi_no),
    FOREIGN KEY (yedek_parca_id) REFERENCES yedek_parca(yedek_parca_id),
    FOREIGN KEY (garanti_durum_id) REFERENCES garanti_durum(garanti_durum_id),
    FOREIGN KEY (teknik_servis_durum_id) REFERENCES teknik_servis_durum(teknik_servis_durum_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL
);
SELECT * FROM teknik_servis;
CREATE TABLE fatura (
    fatura_id INT NOT NULL AUTO_INCREMENT,
    fatura_seri_no VARCHAR(255) NOT NULL,
    fatura_sira_no VARCHAR(255) NOT NULL,
    kullanici_id INT,
    teklif_id INT,
    on_satis_id INT,
    teknik_servis_no INT,
    urun_seri_id INT,
    fatura_miktar DECIMAL(15,2),
    birim_id INT,
    fatura_adet INT,
    fatura_fiyat decimal(15,2) NOT NULL,
    fatura_tarih DATE NOT NULL,
    last_change DATE NOT NULL,
    PRIMARY KEY (fatura_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanici(kullanici_id) ON DELETE SET NULL,
    FOREIGN KEY (teklif_id) REFERENCES teklif(teklif_id) ON DELETE SET NULL,
    FOREIGN KEY (on_satis_id) REFERENCES on_satis(on_satis_id) ON DELETE SET NULL,
    FOREIGN KEY (teknik_servis_no) REFERENCES teknik_servis(teknik_servis_no),
    FOREIGN KEY (urun_seri_id) REFERENCES seri_numaralari(urun_seri_id),
    FOREIGN KEY (birim_id) REFERENCES birim(birim_id)
);
SELECT * FROM fatura;