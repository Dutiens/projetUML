insert into Utilisateur(id, nom, prenom) values(1, "Condat", "Robin");
insert into Utilisateur(id, nom, prenom) values(2, "Bonneveau", "Jean-Baptiste");
insert into Utilisateur(id, nom, prenom) values(3, "François", "Nicolas");

insert into Annonce(id, description, titre, utilisateur_id) values(
	1,
	'Le 106 a été inauguré le 26 novembre 2010 par MM. Laurent FABIUS, président de la CREA, Alain LE VERN, président du Conseil régional de Haute-Normandie, Didier MARIE, président du Conseil général de Seine Maritime, Valérie FOURNEYRON, députée-maire de Rouen, Rémy CARON, préfet de Région et Guy MARSEGUERRA, président du Centre National des Variétés, de la Chanson et du Jazz.<br/><br/>
	Depuis lors, il accueille de nombreux spectateurs et musiciens chaque semaine. On y a vu notamment : Patti Smith, Rodriguo Y Gabriela, Pony Pony Run Run, Cocoon, BB Brunes, Katerine, Tiken Jah Fakoly, Aaron, Cali, Dub Inc, Ayo, Apocalyptica, Angus et Julia Stone, Chinese Man, Yodelice, Catherine Ringer, Camille, Orelsan, Charlie Winston, Brigitte, Birdy Nam Nam, Caravane Palace et Thomas Dutronc ...',
	'Studios de répétition Rouen',
	1
);

insert into Agenda(id) values(1);
insert into DateAgenda(id, date, agenda_id) values (
	1,
	'20160610',
	1
);

insert into DateAgenda(id, date, agenda_id) values (
	2,
	'20160611',
	1
);

insert into DateAgenda(id, date, agenda_id) values (
	3,
	'20160612',
	1
);

insert into Maps(id, latitude, longitude) values (
	1,
	49.4405346,
	1.0729293
);

insert into Salle( id, adresse, nom, tarif, agenda_id, annonce_id, maps_id, proprietaire_id) values (	
	1,
	'106 Quai Jean de Béthencourt, 76100 Rouen',
	'Le 106',
	55.25,
	1,
	1,
	1,
	1
);

insert into Photo(id, url, salle_id) values(
	1,
	'http://www.musiquesactuellesnormandie.com/mediatheque/3/le-106-cabaret-de-l-armada.jpg',
	1
);