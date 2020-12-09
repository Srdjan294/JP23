drop database if exists baza;
create database baza;
use baza;

create table auto(
	sifra   int not null primary key auto_increment,
	model 	varchar(50) not null,
	godiste int not null,
	volumenRezervoara int not null,
	registracija varchar(20) not null
);

#Izračun potrošnje auta prema natočenim litrama goriva i prema natočenom gorivu za određene novce
create table potrosnja(
	sifra	int not null primary key auto_increment,
	datum	datetime not null,
	natocenoLitara int not null,
	cijenaL  int not null,
	ukupnaCijena int not null,
	pocetnoStanje int not null,
	zavrsnoStanje int not null,
	udaljenost int not null, 
	potrosnjaLPoPrijedenimKm int not null, #natocenoLitara/udaljenost * 100(km)
	potrosnjaKnPoPrijedenimKm int not null #ukupnaCijena/udaljenost * 100(km)
);

#Izračun prelaska kilometara prema natočenim litrama goriva i prema natočenom gorivu za određene novce
create table izracunPrelaskaKm(
	sifra int not null primary key auto_increment,
	natocenoLitara int not null,
	cijenaL  int not null,
	ukupnaCijena int not null,
	potrosnjaAuta int not null,
	izracunKM_L int not null, #100/potrosnjaAuta * natocenoLitara
	izracunKM_Kn int not null #ukupnaCijena / cijenaL = natocenoLitara * 100/potrosnjaAuta
);

#Izračun natočenih litara i cijene goriva prema prijeđenim kilometrima
create table izracunGoriva(
	sifra int not null primary key auto_increment,
	udaljenost int not null,
	cijenaL int not null,
	potrosnjaAuta int not null,
	izracunL int not null, #potrosnjaAuta/100 * udaljenost
	ukupnaCijena int not null #potrosnjaAuta/100 * udaljenost * cijenaL
);

create table evidencija(
	sifra int not null primary key auto_increment,
	auto int not null,
	potrosnja int not null,
	izracunPrelaskaKm int not null,
	izracunGoriva int not null
);

alter table evidencija add foreign key (auto) references auto(sifra);
alter table evidencija add foreign key (potrosnja) references potrosnja(sifra);
alter table evidencija add foreign key (izracunPrelaskaKm) references izracunPrelaskaKm(sifra);
alter table evidencija add foreign key (izracunGoriva) references izracunGoriva(sifra);