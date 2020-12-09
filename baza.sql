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

create table evidencija(
	sifra int not null primary key auto_increment,
	auto int not null,
	datum	datetime not null,
	natocenoLitara int not null,
	ukupnaCijena int not null,
	pocetnoStanje int not null,
	zavrsnoStanje int not null,
	udaljenost int not null	
);

create table oznaka(
	sifra int not null primary key auto_increment,
	naziv varchar(150)
);

create table evidencija_oznaka(
	evidencija int not null,
	oznaka int not null
);

alter table evidencija add foreign key (auto) references auto(sifra);
alter table evidencija_oznaka add foreign key (evidencija) references evidencija(sifra);
alter table evidencija_oznaka add foreign key (oznaka) references oznaka(sifra);
