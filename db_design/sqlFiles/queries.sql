-- CALL createUser(1, "admin", "admin", "admin", "0000", "admin@blabla.com", 0.00, "admin");
-- SELECT * FROM kullanici;
-- CALL createCorporateCustomer("Tüpraş", 1);
-- delete FROM musteri WHERE musteri_id=2;
-- CALL createCustomer(7, "Emrah", "Sıkırakipçiyan", "Satın Alma ve Envanter İşleri", "Satın Alma Uzmanı", 1);
-- CALL createCustomerAddress(6, 7, "Çimen Mahallesi, Jumanji Caddesi, Koşmak Sokak, No:7/6, Polonezköy/İstanbul", true, 1);
-- CALL createCustomerEmail(10, "emrah@sasyer.com", true, 1);
-- CALL createCustomerTel(10, "433118877887", true, 1);
-- SELECT * FROM musteri_tel;

-- SET GLOBAL time_zone = '+3:00';

-- Belli bir müşterinin detayı
SELECT 
    musteri_kisi_no AS 'Kişi No',
    musteri_ad AS 'İsim',
    musteri_soyad AS 'Soyad',
    musteri_kurumsal_isim AS 'Kurum',
    musteri_departman AS 'Departman',
    musteri_pozisyon AS 'Ünvan / Pozisyon',
    musteri_kisi_tarih AS 'Eklenme Tarihi',
    musteri_aktiflik AS 'Müşteri Durumu',
    CONCAT(calisan_adi, ' ', calisan_soyadi) AS Ekleyen,
    musteri_kisiler.last_change AS 'Son Değişiklik'
FROM
    musteri_kisiler
        INNER JOIN
    musteri USING (musteri_id)
		INNER JOIN
	kullanici k ON k.kullanici_id = musteri_kisiler.kullanici_id
WHERE
	musteri_kisi_no = 8
	AND musteri_aktiflik = 'Aktif';
    
    -- Belirli Bir Müşterinin Bütün Adreslerini Görüntüle
SELECT 
    m.musteri_adres,
    m.musteri_primary_address_flag,
    CONCAT(calisan_adi, ' ', calisan_soyadi) kullanici_id,
    m.last_change
FROM
    musteri_adres m
        INNER JOIN
    musteri_adresler_junction ma USING (musteri_adres_no)
		INNER JOIN
	kullanici k ON m.kullanici_id = k.kullanici_id
WHERE
	ma.musteri_kisi_no=8
ORDER BY m.musteri_primary_address_flag DESC;

-- Belirli bir müşterinin bütün email adreslerini görüntüle
SELECT
	musteri_email,
	musteri_primary_email_flag
FROM
	musteri_email
WHERE
	musteri_kisi_no=8
ORDER BY musteri_primary_email_flag DESC;

-- Belirli bir müşterinin bütün telefon numaralarını görüntüle
SELECT
	musteri_tel,
	musteri_primary_tel_flag
FROM
	musteri_tel
WHERE
	musteri_kisi_no=8
ORDER BY musteri_primary_tel_flag DESC;

/* 
	SELECT * FROM kurumsalmusteriler;
	Kurumsal Firmaları görüntüler
*/

SELECT 
    musteri_id, musteri_kurumsal_isim AS 'Kurumsal İsim'
FROM
    musteri
GROUP BY musteri_kurumsal_isim;
    
    /*
    SELECT * FROM aktifbutunmusteriler;
    Aktif Butun Musterileri Görüntüler
    */
CREATE VIEW aktifButunMusteriler
AS
SELECT 
    musteri_kisi_no AS 'Kişi No',
    musteri_ad AS 'İsim',
    musteri_soyad AS 'Soyad',
    musteri_kurumsal_isim AS 'Kurum',
    musteri_departman AS 'Departman',
    musteri_pozisyon AS 'Ünvan / Pozisyon',
    musteri_email AS 'Email',
    musteri_tel AS 'Telefon',
    musteri_adres AS 'Adres',
    musteri_kisi_tarih AS 'Eklenme Tarihi'
FROM
    musteri_kisiler
        INNER JOIN
    musteri USING (musteri_id)
        INNER JOIN
    musteri_email USING (musteri_kisi_no)
        INNER JOIN
    musteri_tel USING (musteri_kisi_no)
		INNER JOIN
			(musteri_adresler_junction
				INNER JOIN
			musteri_adres USING(musteri_adres_no)) 
	USING (musteri_kisi_no)
WHERE
    musteri_primary_email_flag = TRUE
    AND musteri_adresler_junction.musteri_kisi_primary_address_flag = true
        AND musteri_aktiflik = 'Aktif'
        AND musteri_primary_tel_flag = true
ORDER BY musteri_kurumsal_isim ASC;


 