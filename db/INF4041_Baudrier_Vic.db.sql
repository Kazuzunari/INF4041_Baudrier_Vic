BEGIN TRANSACTION;
CREATE TABLE "COUNTRY" (
	`idCountry`	INTEGER NOT NULL,
	`AliasCountry`	TEXT NOT NULL UNIQUE,
	PRIMARY KEY(`idCountry`)
);
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (1,'Test');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (2,'Inconnu');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (3,'Belgique');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (4,'Pays-bas');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (5,'Allemagne');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (6,'Brésil');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (7,'République Tchèque');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (8,'Espagne');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (9,'USA');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (10,'Italie');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (11,'Japon');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (12,'Nord de la France');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (13,'Mexique');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (14,'Inde');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (15,'Hollande');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (16,'Irlande');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (17,'Chine');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (18,'Amérique(Indétérminée)');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (19,'Thailande');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (20,'Corée');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (21,'Grande-Bretagne');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (22,'Slovénnie');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (23,'Angleterre');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (24,'Pays de Galle');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (25,'Ecosse');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (26,'Amérindien');
INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (27,'Danemark');
CREATE TABLE "CATEGORY" (
	`idCategory`	INTEGER NOT NULL,
	`AliasCategory`	TEXT NOT NULL UNIQUE,
	PRIMARY KEY(`idCategory`)
);
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (1,'Blonde');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (2,'Blanche');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (3,'Kriek');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (4,'Doubme');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (5,'Bavaroise');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (6,'Forte');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (7,'Ambrée');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (8,'Spéciale');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (9,'Irish Red Ale');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (10,'Fruit Beer');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (11,'India Pale Ale');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (12,'Pale Ale');
INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (13,'Irish Stout');
CREATE TABLE "BIERE" (
	`idBiere`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`note`	INTEGER NOT NULL DEFAULT 0,
	`name`	TEXT NOT NULL UNIQUE,
	`descritpion`	TEXT,
	`dateCreation`	TEXT NOT NULL,
	`pathPhoto`	TEXT,
	`idCategory`	INTEGER,
	`idCountry`	INTEGER
);
COMMIT;
