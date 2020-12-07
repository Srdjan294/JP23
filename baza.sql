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
	sifra	int not null primary key auto_increment,
	datum	datetime not null,
	punjenjeULitrama int not null,
	cijena  int not null,
	pocetnoStanje int not null,
	zavrsnoStanje int not null,
	udaljenost int not null, 
	potrosnjaPoPrijedenimKm int not null
);

create table auto_evidencija(
	sifra int not null primary key auto_increment,
	auto int not null,
	evidencija int not null
);

alter table auto_evidencija add foreign key (auto) references auto(sifra);
alter table auto_evidencija add foreign key (evidencija) references evidencija(sifra);