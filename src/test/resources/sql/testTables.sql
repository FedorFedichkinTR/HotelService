CREATE TABLE Users (
  user_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
  email      VARCHAR(35)  NOT NULL UNIQUE,
  password   VARCHAR(256) NOT NULL,
  first_name VARCHAR(60),
  last_name  VARCHAR(60),
  role       VARCHAR(60)
);

CREATE TABLE Rooms (
  room_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
  capacity INT,
  type     VARCHAR(15),
  price    INT NOT NULL
);

CREATE TABLE Orders (
  order_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id    BIGINT    NOT NULL,
  room_id    BIGINT,
  capacity   INT       NOT NULL,
  type       VARCHAR(15),
  start_date TIMESTAMP NOT NULL,
  end_date   TIMESTAMP NOT NULL,
  admin_id   BIGINT,
  price      INT,
  status     BIT,
  FOREIGN KEY (user_id) REFERENCES Users (user_id),
  FOREIGN KEY (room_id) REFERENCES Rooms (room_id)
);

INSERT INTO Users (email, password, first_name, last_name, role)
VALUES ('ff@epam.com', '1234', 'first_name', 'last_name', 'USER');
INSERT INTO Users (email, password, first_name, last_name, role)
VALUES ('gg@epam.com', '12345', 'first_name1', 'last_name1', 'ADMINISTRATOR');
INSERT INTO Users (email, password, first_name, last_name, role)
VALUES ('rr@epam.com', '123456', 'first_name2', 'last_name2', 'USER');
INSERT INTO Users (email, password, first_name, last_name, role)
VALUES ('tt@epam.com', '1234567', 'first_name3', 'last_name3', 'USER');

INSERT INTO Rooms (capacity, type, price)
VALUES (3, 'STANDARD', 2000);
INSERT INTO Rooms (capacity, type, price)
VALUES (2, 'STANDARD', 1200);
INSERT INTO Rooms (capacity, type, price)
VALUES (1, 'STANDARD', 2200);
INSERT INTO Rooms (capacity, type, price)
VALUES (4, 'STANDARD', 4200);
INSERT INTO Rooms (capacity, type, price)
VALUES (2, 'STANDARD', 2000);
INSERT INTO Rooms (capacity, type, price)
VALUES (3, 'STANDARD', 2000);
INSERT INTO Rooms (capacity, type, price)
VALUES (3, 'STANDARD', 2000);
INSERT INTO Rooms (capacity, type, price)
VALUES (3, 'STANDARD', 2000);
INSERT INTO Rooms (capacity, type, price)
VALUES (3, 'STANDARD', 2000);

INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (3, 1, 3, 'STANDARD', '2004-10-26', '2004-11-05', 2, 3000, FALSE);

INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (1, 3, 1, 'STANDARD', '2004-10-17 ', '2004-10-19', 2, 3000, FALSE);

INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (3, 4, 3, 'STANDARD', '2004-10-20', '2004-10-30', 2, 3000, FALSE);

INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (1, 1, 3, 'STANDARD', '2004-10-19', '2004-10-27', 2, 3000, FALSE);

INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (1, 2, 3, 'STANDARD', '2004-10-19', '2004-10-27', 2, 3000, FALSE);
