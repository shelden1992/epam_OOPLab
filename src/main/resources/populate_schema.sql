insert into Transport (name_transport) values ('Airplane');
insert into Transport (name_transport) values ('Bus');
insert into Transport (name_transport) values ('Car');
insert into Transport (name_transport) values ('Ship');
insert into Transport (name_transport) values ('Train');

insert into City (name_city) values ('Budapest');
insert into City (name_city) values ('Istanbul');
insert into City (name_city) values ('Milan');
insert into City (name_city) values ('Tbilisi');
insert into City (name_city) values ('TelAviv');
insert into City (name_city) values ('Tokyo');

insert into Food_type (name_food_type, coeficient) values ('ALL INCLUSIVE', 0.3);
insert into Food_type (name_food_type, coeficient) values ('FULL BOARD', 0.2);
insert into Food_type (name_food_type, coeficient) values ('HALF BOARD', 0.15);
insert into Food_type (name_food_type, coeficient) values ('BED AND BREAKFAST', 0.1);
insert into Food_type (name_food_type, coeficient) values ('ROOM ONLY', 0.0);

insert into Tour_type (name_tour, days, price, idFood_type, idTransport)  values ('CruiseTour', 5,1500,1,4);
insert into Tour_type (name_tour, days, price, idFood_type, idTransport)  values ('ExcursionTour', 6,1500,2,1);
insert into Tour_type (name_tour, days, price, idFood_type, idTransport)  values ('RecreationTour', 7,2000,3,1);
insert into Tour_type (name_tour, days, price, idFood_type, idTransport)  values ('ShoppingTour', 7,2100,4,1);
insert into Tour_type (name_tour, days, price, idFood_type, idTransport)  values ('TreatmentTour', 7,1800,4,1);

insert into Tour_type_and_city (idTour, idCity) values (1,1);
insert into Tour_type_and_city (idTour, idCity) values (2,1);
insert into Tour_type_and_city (idTour, idCity) values (3,1);
insert into Tour_type_and_city (idTour, idCity) values (4,1);
insert into Tour_type_and_city (idTour, idCity) values (1,2);
insert into Tour_type_and_city (idTour, idCity) values (2,2);
insert into Tour_type_and_city (idTour, idCity) values (2,3);
insert into Tour_type_and_city (idTour, idCity) values (2,4);
insert into Tour_type_and_city (idTour, idCity) values (2,5);
insert into Tour_type_and_city (idTour, idCity) values (2,6);
insert into Tour_type_and_city (idTour, idCity) values (3,2);
insert into Tour_type_and_city (idTour, idCity) values (3,3);
insert into Tour_type_and_city (idTour, idCity) values (3,4);
insert into Tour_type_and_city (idTour, idCity) values (3,5);
insert into Tour_type_and_city (idTour, idCity) values (4,3);
insert into Tour_type_and_city (idTour, idCity) values (5,5);

insert into City_and_Transport (idCity, idTransport) VALUES (1,1);
insert into City_and_Transport (idCity, idTransport) VALUES (1,2);
insert into City_and_Transport (idCity, idTransport) VALUES (1,3);
insert into City_and_Transport (idCity, idTransport) VALUES (1,4);
insert into City_and_Transport (idCity, idTransport) VALUES (2,1);
insert into City_and_Transport (idCity, idTransport) VALUES (2,4);
insert into City_and_Transport (idCity, idTransport) VALUES (3,1);
insert into City_and_Transport (idCity, idTransport) VALUES (3,2);
insert into City_and_Transport (idCity, idTransport) VALUES (3,3);
insert into City_and_Transport (idCity, idTransport) VALUES (4,1);
insert into City_and_Transport (idCity, idTransport) VALUES (4,3);
insert into City_and_Transport (idCity, idTransport) VALUES (5,1);
insert into City_and_Transport (idCity, idTransport) VALUES (6,1);

insert into Client (name, surname, birthday, married, idTour) values ('Den', 'Shelupets', '2019-10-23', 0, '1');
insert into Client (name, surname, birthday, married, idTour) values ('Vasia', 'Berezudskia', '2019-10-03', 1, '5');
insert into Client (name, surname, birthday, married, idTour) values ('Dasha', 'Rurak', '2019.10.12', 1, '4');