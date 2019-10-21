create database tour_agency charset utf8 COLLATE utf8_general_ci;
use tour_agency;

create table Transport(idTransport int auto_increment, name_transport varchar(32), primary key (idTransport));

create table Food_type(idFood_type int auto_increment, name_food_type varchar(20),coeficient double, primary key (idFood_type));

create table Tour_type(idTour int auto_increment, name_tour varchar(256) not null, days int not null, price double, idFood_type int, idTransport int,foreign key (idFood_type) references Food_type (idFood_type), foreign key (idTransport) references Transport(idTransport),primary key (idTour));

create table City(idCity int auto_increment, name_city varchar(60), primary key (idCity));

create table City_and_Transport(idCity int, idTransport int, foreign key (idCity) references City(idCity), foreign key (idTransport) references Transport (idTransport), primary key (idCity, idTransport));

create table Tour_type_and_city (idTour int, idCity int,foreign key (idTour) references Tour_type (idTour), foreign key (idCity) references City (idCity), primary key (idCity, idTour));

create table Client(idClient int auto_increment, name varchar(50) not null , surname varchar(50) not null , birthdat date not null, married bit, idTour int, foreign key (idTour) references Tour_type (idTour), primary key (idClient));
