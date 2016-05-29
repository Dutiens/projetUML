
    create table Agenda (
        id bigint not null,
        primary key (id)
    );

    create table Annonce (
        id bigint not null,
        description varchar(255) not null,
        titre varchar(255) not null,
        utilisateur_id bigint not null,
        primary key (id)
    );

    create table DateAgenda (
        id bigint not null,
        date date not null,
        agenda_id bigint not null,
        primary key (id)
    );

    create table Maps (
        id bigint not null,
        latitude double not null,
        longitude double not null,
        primary key (id)
    );

    create table Photo (
        id bigint not null,
        url varchar(255) not null,
        salle_id bigint not null,
        primary key (id)
    );

    create table Salle (
        id bigint not null,
        adresse varchar(255) not null,
        nom varchar(255) not null,
        tarif double not null,
        agenda_id bigint,
        annonce_id bigint,
        maps_id bigint,
        proprietaire_id bigint not null,
        primary key (id)
    );

    create table Utilisateur (
        id bigint not null,
        nom varchar(255) not null,
        prenom varchar(255) not null,
        primary key (id)
    );

    alter table Annonce 
        add constraint FK306C57C25B15C6BA 
        foreign key (utilisateur_id) 
        references Utilisateur;

    alter table DateAgenda 
        add constraint FK7713D97AE86525A 
        foreign key (agenda_id) 
        references Agenda;

    alter table Photo 
        add constraint FK4984E12788F9E3A 
        foreign key (salle_id) 
        references Salle;

    alter table Salle 
        add constraint FK4BF59B7E86525A 
        foreign key (agenda_id) 
        references Agenda;

    alter table Salle 
        add constraint FK4BF59B7C3A88BB9 
        foreign key (proprietaire_id) 
        references Utilisateur;

    alter table Salle 
        add constraint FK4BF59B7C994665A 
        foreign key (annonce_id) 
        references Annonce;

    alter table Salle 
        add constraint FK4BF59B73211CA7A 
        foreign key (maps_id) 
        references Maps;
