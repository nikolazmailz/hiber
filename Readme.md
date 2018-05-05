
### SQL SCRIPT CREATE TABLE FOT PostgreSQL DB ###

CREATE TABLE contact (
 ID INT PRIMARY KEY NOT NULL,
 first_name VARCHAR(60) NOT NULL,
 last_name VARCHAR(40) NOT NULL,
 birth_date DATE,
 version INT NOT NULL DEFAULT 0,
 UNIQUE (first_name, last_name)
);

CREATE TABLE hobby (
 hobby_id VARCHAR(20) PRIMARY KEY NOT NULL
);

CREATE TABLE contact_tel_detail(
 id INT PRIMARY KEY NOT NULL,
 contact_id INT NOT NULL,
 tel_type VARCHAR(20) NOT NULL,
 tel_number VARCHAR(20) NOT NULL,
 version INT NOT NULL DEFAULT 0,
 UNIQUE (contact_id, tel_type),
 CONSTRAINT FK_CONTACT_TEL_DETAIL_1 FOREIGN KEY (contact_id) REFERENCES contact (id)
);

CREATE TABLE contact_hobby_detail (
 contact_id INT NOT NULL,
 hobby_id VARCHAR(20) NOT NULL,
 PRIMARY KEY (contact_id, hobby_id),
 CONSTRAINT FK_CONTACT_HOBBY_DETAIL_1 FOREIGN KEY (contact_id) REFERENCES contact (id) ON DELETE CASCADE,
 CONSTRAINT FK_CONTACT_HOBBY_DETAIL_2 FOREIGN KEY (hobby_id) REFERENCES hobby (hobby_id)
);