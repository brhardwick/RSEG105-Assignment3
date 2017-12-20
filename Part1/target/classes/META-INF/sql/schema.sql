﻿DROP DATABASE RSEG105;
CREATE DATABASE RSEG105;
USE RSEG105;

CREATE TABLE IF NOT EXISTS `RSEG105`.`BOOK` (
    `ID` INT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    `CATEGORY_NAME` VARCHAR(100) NULL,
    `ISBN` VARCHAR(10) NULL,
    `TITLE` VARCHAR(500) NULL,
    `PUBLISHER` VARCHAR(100) NULL,
    `PRICE` DECIMAL(4,2) NULL 
)  ENGINE=INNODB;
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Fifty Years of 60 Minutes' ,'1501135805','Simon & Schuster ',22.04,'History');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Dot' ,'7636196120','Candlewick',7.04,'Childrens');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Life at the Top: New Yorks Exceptional Apartment Buildings' ,'8656534020','Vendome Press',23.04,'Architecture');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Irresistible: The Rise of Addictive Technology and the Business of Keeping Us Hooked' ,'1594206643','John Wiley & Sons',6.29,'Adventure');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Everything I Never Told You' ,'159420571X','Random House(UK)',17.71,'Science Fiction');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Things a Computer Scientist Rarely Talks About' ,'157586326X','Bloomsbury',7.37,'Technology');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Black Swan: The Impact of the Highly Improbable' ,'1400063515','Faber Alliance',5.19,'Romance');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Four: The Hidden DNA of Amazon, Apple, Facebook, and Google' ,'0735213658','Egmont',6.33,'Adventure');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Mere Christianity' ,'0684823780','Penguin Books',4.47,'Science Fiction');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Winesburg, Ohio' ,'055321439X','Pan Macmillan',8.76,'Technology');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Gödel, Escher, Bach: An Eternal Golden Braid' ,'0465026567','Pan Macmillan',5.04,'History');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Gay Science' ,'0394719859','Oxford University Press',5.79,'Philosophy');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Physics Of Christianity' ,'0385514247','Egmont',41.25,'Drama');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Attention Merchants: The Epic Scramble to Get Inside Our Heads' ,'0385352018','Simon & Schuster',6.55,'Adventure');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Client' ,'0385339089','Oxford University Press',9.08,'Science Fiction');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('12 Rules for Life: An Antidote to Chaos' ,'0345816021','Elsevier',5.41,'Technology');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Paper Towns' ,'014241493X','Egmont',18.41,'Romance');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Screwtape Letters' ,'0062023179','HarperCollins',4.46,'Drama');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('A Grief Observed' ,'0060652381','Random House(UK)',6.57,'Adventure');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Problem of Pain' ,'0006280935','Hachette Livre(UK)',5.41,'Science Fiction');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('In a Dark, Dark Wood' ,'1846558913','Pan Macmillan',28.73,'Technology');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Girl on the Train' ,'1594633665','Oxford University Press',26.76,'History');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The A.B.C. Murders' ,'1579126243','Hachette Livre(UK)',23.76,'Romance');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Moab Is My Washpot(Memoir #1)' ,'1569472025','John Wiley & Sons',19.13,'Drama');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('All the Light We Cannot See' ,'1476746583','Elsevier',18.29,'Adventure');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Point Your Face at This: Drawings' ,'1455512052','Penguin Books',12.84,'Science Fiction');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Orphan Masters Son' ,'812992792','Simon & Schuster',19.94,'Technology');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Tortilla Flat' ,'582461502','HarperCollins',10.32,'History');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Gone Girl' ,'553418351','Faber Alliance',17.1,'Romance');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('This is a Book' ,'446539708','Random House(UK)',16.16,'Drama');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Breakfast of Champions' ,'385334206','Bloomsbury',28.15,'Adventure');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Danny the Champion of the World' ,'375814256','Penguin Books',53.68,'Science Fiction');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Tragedy of Mister Morn' ,'307960811','Pearson Education',8.37,'Technology');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('Is Everyone Hanging Out Without Me?' ,'307886263','Hachette Livre(UK)',14.52,'History');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Nest' ,'62414216','HarperCollins',39.23,'Romance');
INSERT INTO BOOK(TITLE,ISBN,PUBLISHER,PRICE,CATEGORY_NAME) VALUES ('The Kind Worth Killing' ,'62267523','Pearson Education',39.35,'Drama');
