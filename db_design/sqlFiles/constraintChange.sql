  ALTER table fatura MODIFY kullanici_id INT;
  
  ALTER TABLE fatura
  DROP FOREIGN KEY fatura_ibfk_3;
  
  ALTER table fatura
	ADD CONSTRAINT FOREIGN KEY (kullanici_id)
	REFERENCES kullanici(kullanici_id) ON DELETE SET NULL;