drop database if exists baza;
create database baza;
use baza;

create table auto(
	sifra   int not null primary key auto_increment,
	model 	varchar(50) not null,
	godiste int not null,
	volumenRezervoara int not null,
	registracija varchar(20) not null,
	vlasnik int not null
);

create table evidencija(
	sifra int not null primary key auto_increment,
	auto int not null,
	datum	datetime not null,
	natocenoLitara int not null,
	ukupnaCijena int not null,
	pocetnoStanje int not null,
	zavrsnoStanje int not null
);

create table oznaka(
	sifra int not null primary key auto_increment,
	naziv varchar(150)
);

create table evidencija_oznaka(
	evidencija int not null,
	oznaka int not null
);

create table vlasnik(
	sifra int not null primary key auto_increment,
	ime varchar(50) not null,
	prezime varchar(50) not null,
	oib char(11) not null,
	brojMobitela int not null,
	email varchar(100) not null,
	datumRodenja datetime not null,
	spol varchar(10) not null
);

alter table evidencija add foreign key (auto) references auto(sifra);
alter table evidencija_oznaka add foreign key (evidencija) references evidencija(sifra);
alter table evidencija_oznaka add foreign key (oznaka) references oznaka(sifra);
alter table auto add foreign key (vlasnik) references vlasnik(sifra);