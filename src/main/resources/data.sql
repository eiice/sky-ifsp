INSERT INTO airplanes (code, seats, plane)
VALUES ('ABC123', 200, 'Boeing 747');

INSERT INTO airplanes (code, seats, plane)
VALUES ('XYZ789', 150, 'Airbus A320');

INSERT INTO airports (code, country, country_code, city, airport, latitude, longitude)
VALUES ('JFK', 'United States', 'US', 'New York', 'John F. Kennedy International Airport', 40.6413, -73.7781);

INSERT INTO airports (code, country, country_code, city, airport, latitude, longitude)
VALUES ('LHR', 'United Kingdom', 'UK', 'London', 'Heathrow Airport', 51.4700, -0.4543);

INSERT INTO flights (departure_date, arrival_date)
VALUES ('2023-06-08 10:00:00', '2023-06-08 12:00:00');

INSERT INTO flights (departure_date, arrival_date)
VALUES ('2023-06-09 14:30:00', '2023-06-09 18:00:00');

INSERT INTO passengers (name, cpf, birthdate, airplane_id, passport, flight_date, airline)
VALUES ('homem legal', '123456789', '1990-01-01', 1, 'ABC123', '2023-06-08', 'Example Airlines');

INSERT INTO passengers (name, cpf, birthdate, airplane_id, passport, flight_date, airline)
VALUES ('homem divertido', '987654321', '1985-05-15', 2, 'XYZ789', '2023-06-09', 'Sample Airways');