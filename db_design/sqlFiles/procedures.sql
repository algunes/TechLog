/*
createUser (kullanici oluşturma)
CALL createUser(yetki_id, "ad", "soyad", "departman", "telefon", "email", 0.00 (decimal), "sifre");
şeklinde argüman geçilmeli.
yetki_id : eklenecek kullanicinin yetkileri kullanici_yetkileri tablosunda önceden tanımlanan satırlardan birine refereans vermelidir.
--> 1- Admin
--> 2- Accounter
--> 3- Sales Person
--> 4- Technical Service Expert
*/
DELIMITER $$
CREATE PROCEDURE createUser(
IN yetki_id INT,
IN ad VARCHAR(150),
IN soyad VARCHAR(150),
IN departman VARCHAR(50),
IN telefon VARCHAR(50),
IN email VARCHAR(100),
IN toplamSatis decimal(15,2),
IN sifre VARCHAR(50))
BEGIN
DECLARE kullanici_id_ INT;
	INSERT INTO kullanici(
    yetki_id, 
    calisan_adi, 
    calisan_soyadi, 
    calisan_departman, 
    calisan_tel, 
    calisan_email, 
    calisan_toplam_satis, 
    kullanici_sifre) 
    values(
    yetki_id,
    ad,
    soyad,
    departman,
    telefon,
    email,
    toplamSatis,
    sifre
    );
    SET kullanici_id_ = LAST_INSERT_ID();
    INSERT INTO kullanici_bildirim_mesaj(
    kullanici_id,
    bildirim_mesaj,
    bildirim_mesaj_type_flag,
    bildirim_mesaj_date)
    values(
    kullanici_id_,
    "Hello. Welcome to the system. Now, you are an user of it. Enjoy!",
    false,
    curdate());
END $$
DELIMITER ;

/*
createCorporateCustomer (Kurumsal Müşteri Üstbaşlık)
CALL createCorporateCustomer("Kurumsal İsim", kullanici_id);
Şeklinde argüman geçilmeli.
müşteri kayıt ve son değişiklik tarihleri o anki sistem tarihi olarak atanacaktır. 
*/

DELIMITER $$
 CREATE PROCEDURE createCorporateCustomer(
IN kurumsal_isim VARCHAR(255),
IN kullanici_id INT
)
BEGIN
	INSERT INTO musteri(
    musteri_kurumsal_isim, 
    musteri_tarih, 
    kullanici_id, 
    last_change 
    ) 
    values(
    kurumsal_isim,
    curdate(),
    kullanici,
    curdate()
    );   
END $$
DELIMITER ;

/*
createCustomer (Müşteri Kişi Bilgisi Gir, Bu tabloya adres, email ve tel. bilgileri girilmez)
müşteri kayıt ve son değişiklik tarihleri o anki sistem tarihi olarak atanacaktır.
CALL createCustomer(musteri_id, "Ad", "Soyad", "Departman", "Pozisyon-Ünvan", kullanici_id);
Şeklinde argüman girilmelidir.
*/

DELIMITER $$
 CREATE PROCEDURE createCustomer(
IN musteri_id INT,
IN ad VARCHAR(100),
IN soyad VARCHAR(100),
IN departman VARCHAR(255),
IN pozisyon VARCHAR(255),
IN kullanici_id INT
)
BEGIN
	INSERT INTO musteri_kisiler(
    musteri_id,
    musteri_ad,
    musteri_soyad,
    musteri_departman,
    musteri_pozisyon,
    musteri_kisi_tarih,
    musteri_aktiflik,
    kullanici_id,
    last_change
    ) 
    values(
    musteri_id,
    ad,
    soyad,
    departman,
    pozisyon,
    curdate(),
    'Aktif',
    kullanici_id,
    curdate()
    );   
END $$
DELIMITER ;

/*
createCustomerAddress (Argüman verilen yeni Adresi girer, girdiği adresi argümandaki müşteriye bağlar / Genel olarak müşteriler ve adresler arasında many-to-many ilişki var)
 CALL createCustomerAddress(musteri_id, musteri_kisi_no, "Tam Adres", müşteri üstbaşlık olarak primary_flag (true/false), müşteri kişisel başlık olarak primary (true / false), kullanici_id);
 primary_flag's default value is "FALSE"
 Şeklinde argüman girilir.
*/

DELIMITER $$
 CREATE PROCEDURE createCustomerAddress(
IN musteri_id INT,
IN musteri_kisi_no INT,
IN musteri_adres VARCHAR(255),
IN musteri_primary_address_flag TINYINT,
IN musteri_kisi_primary_address_flag_ TINYINT,
IN kullanici_id INT
)
BEGIN
	DECLARE musteri_adres_no_ INT;
	INSERT INTO musteri_adres(
    musteri_adres,
    musteri_id,
    musteri_primary_address_flag,
    kullanici_id,
    last_change
    ) 
    values(
    musteri_adres,
    musteri_id,
    musteri_primary_address_flag,
    kullanici_id,
    curdate()
    );
    SET musteri_adres_no_ = LAST_INSERT_ID();
    INSERT INTO musteri_adresler_junction(
    musteri_kisi_no,
    musteri_id,
    musteri_adres_no,
    musteri_kisi_primary_address_flag,
    kullanici_id,
    last_change
    )
    VALUES(
    musteri_kisi_no,
    musteri_id,
    musteri_adres_no_,
    musteri_kisi_primary_address_flag_,
    kullanici_id,
    curdate()
    );
END $$
DELIMITER ;

/*
assignCustomerToAnExistingAddress (Argüman verilen müşteriyle önceden kayıtlı adresi bağlar / Genel olarak müşteriler ve adresler arasında many-to-many ilişki var)
 CALL assignCustomerToAnExistingAddress(musteri_id, kisi_no, adres_no, musteri kisisel adres primary mi (true / false), kullanici_id);
 primary_flag can be null, default value is "FALSE"
 Şeklinde argüman girilir.
*/

DELIMITER $$
 CREATE PROCEDURE assignCustomerToAnExistingAddress(
IN musteri_id INT,
IN musteri_kisi_no INT,
IN musteri_adres_no INT,
IN musteri_kisi_primary_adres_flag_ TINYINT,
IN kullanici_id INT
)
BEGIN
    INSERT INTO musteri_adresler_junction(
    musteri_kisi_no,
    musteri_id,
    musteri_adres_no,
    musteri_kisi_primary_address_flag,
    kullanici_id,
    last_change
    )
    VALUES(
    musteri_kisi_no,
    musteri_id,
    musteri_adres_no,
    musteri_kisi_primary_adres_flag_,
    kullanici_id,
    curdate()
    );
END $$
DELIMITER ;

/*
createCustomerEmail (Musteri Emaillerini Tutar)
CALL createCustomerEmail(musteri_kisi_no, "Email", primary_flag(true/false), kullanici_id);
şeklinde argüman girilmeli.
*/

DELIMITER $$
 CREATE PROCEDURE createCustomerEmail(
IN musteri_kisi_no INT,
IN musteri_email VARCHAR(100),
IN musteri_primary_email_flag TINYINT,
IN kullanici_id INT
)
BEGIN
	INSERT INTO musteri_email(
    musteri_kisi_no,
    musteri_email,
    musteri_primary_email_flag,
    kullanici_id,
    last_change
    ) 
    values(
    musteri_kisi_no,
    musteri_email,
    musteri_primary_email_flag,
    kullanici_id,
    curdate()
    );   
END $$
DELIMITER ;

/*
createCustomerTel (müşteri telefonlarını tutar)
CALL createCustomerTel(musteri_kisi_no, "Telefon", primary_flag (true/False), kullanici_id);
şeklinde argüman girilmesi gerekir.
*/

DELIMITER $$
 CREATE PROCEDURE createCustomerTel(
IN musteri_kisi_no INT,
IN musteri_tel VARCHAR(50),
IN musteri_primary_tel_flag TINYINT,
IN kullanici_id INT
)
BEGIN
	INSERT INTO musteri_tel(
    musteri_kisi_no,
    musteri_tel,
    musteri_primary_tel_flag,
    kullanici_id,
    last_change
    ) 
    values(
    musteri_kisi_no,
    musteri_tel,
    musteri_primary_tel_flag,
    kullanici_id,
    curdate()
    );   
END $$
DELIMITER ;

/*
CALL createBrandNewCustomer('Kurumsal_isim.', 'musteri_adi', 'musteri_soyadi', 'departman', 'ünvan/pozisyon', 'adres', Müşterinin üstbaşlık olarak adresi primaryAdresMi (true/false), Müşterinin Bireysel adresi olarak primaryAdres mi (true/false) 'email', primaryEmailMi (true/false), 'tel', primaryTelMi (true/false), kullanici_id);
Kurumsal isimle birlikte sıfırdan müşteri oluşturma.
*/

DELIMITER $$
 CREATE PROCEDURE createBrandNewCustomer(
IN customerCorporateName VARCHAR(255),
IN Cname VARCHAR(100),
IN Csurname VARCHAR(100),
IN CDepartment VARCHAR(255),
IN Cposition VARCHAR(255),
IN cAddress VARCHAR(255),
IN cPrimaryAddressFlag TINYINT,
IN cPrimaryPersonAddressFlag TINYINT,
IN cEmail VARCHAR(100),
IN cPrimaryEmailFlag TINYINT,
IN cTel VARCHAR(50),
IN cPrimaryTelFlag TINYINT,
IN kullanici_id_ INT
)
BEGIN
DECLARE musteri_id_ INT;
DECLARE musteri_kisi_no_ INT;
DECLARE musteri_adres_no_ INT;
DECLARE musteri_email_no_ INT;
DECLARE musteri_tel_id_ INT;

INSERT INTO musteri(
    musteri_kurumsal_isim, 
    musteri_tarih, 
    kullanici_id, 
    last_change 
    ) 
    values(
    customerCorporateName,
    curdate(),
    kullanici_id_,
    curdate()
    );
    
SET musteri_id_ = LAST_INSERT_ID();

INSERT INTO musteri_kisiler(
    musteri_id,
    musteri_ad,
    musteri_soyad,
    musteri_departman,
    musteri_pozisyon,
    musteri_kisi_tarih,
    musteri_aktiflik,
    kullanici_id,
    last_change
    ) 
    values(
    musteri_id_,
    cName,
    cSurname,
    cDepartment,
    cPosition,
    curdate(),
    'Aktif',
    kullanici_id_,
    curdate()
    );
    
    SET musteri_kisi_no_ = LAST_INSERT_ID();
    
    INSERT INTO musteri_adres(
    musteri_adres,
    musteri_id,
    musteri_primary_address_flag,
    kullanici_id,
    last_change
    ) 
    values(
    cAddress,
    musteri_id_,
    cPrimaryAddressFlag,
    kullanici_id_,
    curdate()
    );
    
    SET musteri_adres_no_ = LAST_INSERT_ID();
    
    INSERT INTO musteri_adresler_junction(
    musteri_kisi_no,
    musteri_id,
    musteri_adres_no,
    musteri_kisi_primary_address_flag,
    kullanici_id,
    last_change
    )
    VALUES(
    musteri_kisi_no_,
    musteri_id_,
    musteri_adres_no_,
    cPrimaryPersonAddressFlag,
    kullanici_id_,
    curdate()
    );

INSERT INTO musteri_email(
    musteri_kisi_no,
    musteri_email,
    musteri_primary_email_flag,
    kullanici_id,
    last_change
    ) 
    values(
    musteri_kisi_no_,
    cEmail,
    cPrimaryEmailFlag,
    kullanici_id_,
    curdate()
    );
    SET musteri_email_no_ = LAST_INSERT_ID();

INSERT INTO musteri_tel(
    musteri_kisi_no,
    musteri_tel,
    musteri_primary_tel_flag,
    kullanici_id,
    last_change
    ) 
    values(
    musteri_kisi_no_,
    cTel,
    cPrimaryTelFlag,
    kullanici_id_,
    curdate()
    );
    SET musteri_tel_id_ = LAST_INSERT_ID();
    
    SELECT 
    musteri_kisiler.musteri_kisi_no AS 'Kişi No',
    musteri_ad AS 'İsim',
    musteri_soyad AS 'Soyad',
    musteri_kurumsal_isim AS 'Kurum',
    musteri_departman AS 'Departman',
    musteri_pozisyon AS 'Ünvan / Pozisyon',
    musteri_email AS 'Email',
    musteri_tel AS 'Telefon',
    musteri_adres AS 'Adres',
    musteri_kisi_tarih AS 'Eklenme Tarihi',
    musteri_aktiflik AS 'Müşteri Durumu'
FROM
    musteri_kisiler
        INNER JOIN
    musteri ON musteri.musteri_id = musteri_id_
        INNER JOIN
    musteri_email ON musteri_email.musteri_kisi_no = musteri_kisi_no_
        INNER JOIN
    musteri_tel ON musteri_tel.musteri_kisi_no = musteri_kisi_no_
		INNER JOIN
			(musteri_adresler_junction
				INNER JOIN
			musteri_adres ON musteri_adres.musteri_adres_no = musteri_adres_no_) 
	 ON musteri_adresler_junction.musteri_kisi_no = musteri_kisi_no_
WHERE
	musteri_kisiler.musteri_kisi_no = musteri_kisi_no_
	AND musteri_aktiflik = 'Aktif';
END $$
DELIMITER ;

/*
call bir_kurumsal_altindaki_musteriler(musteri_id);
Bir kurumsal başlık altındaki bütün müşterileri görüntüler.
*/

DELIMITER $$
 CREATE PROCEDURE bir_kurumsal_altindaki_musteriler(
IN musteri_id_ INT
)
BEGIN
    SELECT 
    musteri_kisi_no AS 'Kişi No',
    musteri_ad AS 'İsim',
    musteri_soyad AS 'Soyad',
    musteri_departman AS 'Departman',
    musteri_pozisyon AS 'Ünvan / Pozisyon',
    musteri_email AS 'Email',
    musteri_tel AS 'Telefon',
    musteri_adres AS 'Adres',
    musteri_kisi_tarih AS 'Eklenme Tarihi',
    musteri_aktiflik AS 'Müşteri Durumu'
FROM
    musteri_kisiler
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
musteri_kisiler.musteri_id = musteri_id_
AND
    musteri_primary_email_flag = TRUE
        AND musteri_aktiflik = 'Aktif'
        AND musteri_adresler_junction.musteri_kisi_primary_address_flag = true
        AND musteri_adres.is_active = true
        AND musteri_tel.is_active = true
        AND musteri_email.is_active = true
        AND musteri_primary_email_flag = true
        AND musteri_primary_tel_flag = true
ORDER BY musteri_ad ASC;
END $$
DELIMITER ;

/*
call search('ad','soyad','kurum', 'telefon', 'email', 'adres');
Müşteri Ad, soyad, kurum, telefon, email, adres bilgilerine göre arama yapar.
Arama yapılmayacak sütünlar null girilmeli // call search('ad', null, null, null, null, null); // gibi..
*/

DELIMITER $$
CREATE PROCEDURE search(
IN ad varchar(100),
IN soyad varchar(100),
IN kurumsalisim varchar(255),
IN telefon varchar(50),
IN email varchar(100),
IN adres varchar(255)
)
BEGIN

IF ad is not null THEN
        SET ad = CONCAT('%',ad,'%');
        END IF;
IF soyad is not null THEN
        SET soyad = CONCAT('%',soyad,'%');
        END IF;
IF kurumsalisim is not null THEN
        SET kurumsalisim = CONCAT('%',kurumsalisim,'%');
    END IF;
IF telefon is not null THEN
        SET telefon = CONCAT('%',telefon,'%');
        END IF;
IF email is not null THEN
        SET email = CONCAT('%',email,'%');
        END IF;
IF adres is not null THEN
        SET adres = CONCAT('%',adres,'%');
        END IF;
SELECT 
    musteri_kisi_no,
    musteri_ad,
    musteri_soyad,
    musteri_kurumsal_isim,
    musteri_departman,
    musteri_pozisyon,
    if (musteri_email.is_active, musteri_email, 'null') musteri_email,
    if (musteri_tel.is_active, musteri_tel, 'null') musteri_tel,
    if (musteri_adres.is_active, musteri_adres, 'null') musteri_adres,
    CONCAT(calisan_adi, ' ', calisan_soyadi) AS ekleyen,
    musteri_kisi_tarih AS 'eklenme_tarihi'
FROM
    musteri_kisiler
        INNER JOIN
    musteri USING (musteri_id)
		INNER JOIN
	kullanici k ON k.kullanici_id = musteri_kisiler.kullanici_id
        INNER JOIN
    musteri_email USING (musteri_kisi_no)
        INNER JOIN
    musteri_tel USING (musteri_kisi_no)
		INNER JOIN
			(musteri_adresler_junction
				right JOIN
			musteri_adres USING(musteri_adres_no)) 
	USING (musteri_kisi_no)
WHERE
    musteri_aktiflik = 'Aktif'
    AND musteri_adresler_junction.musteri_kisi_primary_address_flag = true
	AND musteri_primary_email_flag = TRUE
	AND musteri_primary_tel_flag = true
        AND (musteri_ad like ad
		AND musteri_soyad like soyad
		OR musteri_kurumsal_isim like kurumsalisim
		OR musteri_tel like telefon
		OR musteri_email like email
		OR musteri_adres like adres)
order by musteri_ad asc;

        END $$
DELIMITER ;
