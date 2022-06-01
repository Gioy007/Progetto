create table Utenti
(
	UserID serial primary key,
	Nome varchar,
	Cognome varchar,
	CF varchar(16),
	"password" varchar,
	email varchar, 
	admin boolean default(false)
);

create table CentriVaccinali
(
	IDCentro serial primary key,
	Nome varchar not null,
	Indirizzo varchar,
	Tipologia varchar
);

CREATE TABLE Vaccinati
(
    IDVacc varchar(16) primary key,
    UserID int not null,
    DataSomm date,
    TipoVacc varchar,
	IDCentroVacc int,
	foreign key (IDCentroVacc)
		references CentriVaccinali(IDCentro)  on delete no action,
	foreign key (UserID)
		references Utenti(UserID) on delete no action
);

create table EventiAvversi
(
	ID serial primary key,
	IDVacc varchar,
	Evento varchar,
	Severita int check(severita>0) check(severita<6),
	Note varchar(256),
	foreign key (IDVacc)
		references Vaccinati(IDVacc) on delete no action	
);
