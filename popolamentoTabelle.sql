--Utenti
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('Giorgio', 'Rossi', 'RSSGRG90D17D416C', 'GR90', 'giorgio.rossi@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('Giorgia', 'Rossini', 'RSNGRG90D17D416C', 'fsdfsd', 'grossini@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('Gioele', 'Rossi', 'GSSGRG90D17D416C', 'dfhgfh', 'g.rossi@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('Davide', 'Filo', 'DVSGRG90D17D416C', 'fsdfdsf', 'df@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('Au', 'A', 'RASGRG90D17D416C', 'GR90', 'aua@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('B', 'R', 'RSSGRG90D17D416C', 'br', 'br@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('S', 'E', 'TTTTTG90D17D416C', 'fdsfq', 'se@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('H', 'J', 'ASDFGG90D17D416C', 'gfdgdfg', 'hj@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('K', 'K', 'HHHHHG90D17D416C', 'GR90', 'kk@gmail.com');
INSERT INTO utenti (nome, cognome, cf, password, email) 
	VALUES ('L', 'L', 'LLLLLG90D17D416C', 'GR90', 'll@gmail.com');
	
--Centri vaccinali
INSERT INTO centrivaccinali(nome, indirizzo, tipologia)
	VALUES ('primo', 'erba', 'ospedale');
INSERT INTO centrivaccinali(nome, indirizzo, tipologia)
	VALUES ('secondo', 'como', 'hub');
INSERT INTO centrivaccinali(nome, indirizzo, tipologia)
	VALUES ('terzo', 'varese', 'azienda');

--Eventi
INSERT INTO eventi(nome)
	VALUES ('tosse');
INSERT INTO eventi(nome)
	VALUES ('mal di testa');
INSERT INTO eventi(nome)
	VALUES ('febbre');
INSERT INTO eventi(nome)
	VALUES ('dolori muscolari e articolari');
INSERT INTO eventi(nome)
	VALUES ('linfoadenopatia');
INSERT INTO eventi(nome)
	VALUES ('tachicardia');
INSERT INTO eventi(nome)
	VALUES ('crisi ipertensiva');