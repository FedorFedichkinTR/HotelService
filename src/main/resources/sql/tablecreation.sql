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
VALUES ('ff@epam.com', '81dc9bdb52d04dc20036dbd8313ed055', 'first_name', 'last_name', 'USER');
/* 81dc9bdb52d04dc20036dbd8313ed055 is MD5 encrypted password "1234". */
INSERT INTO Users (email, password, first_name, last_name, role)
VALUES ('gg@epam.com', '827ccb0eea8a706c4c34a16891f84e7b', 'first_name1', 'last_name1', 'ADMINISTRATOR');
/* 827ccb0eea8a706c4c34a16891f84e7b is MD5 encrypted password "12345". */
INSERT INTO Users (email, password, first_name, last_name, role)
VALUES ('rr@epam.com', 'e10adc3949ba59abbe56e057f20f883e', 'first_name2', 'last_name2', 'USER');
/* e10adc3949ba59abbe56e057f20f883e is MD5 encrypted password "123456". */
INSERT INTO Users (email, password, first_name, last_name, role)
VALUES ('tt@epam.com', 'fcea920f7412b5da7be0cf42b8c93759', 'first_name3', 'last_name3', 'USER');
/* fcea920f7412b5da7be0cf42b8c93759 is MD5 encrypted password "1234567". */


INSERT INTO Rooms (capacity, type, price) VALUES (1, 'STANDARD', 150);
INSERT INTO Rooms (capacity, type, price) VALUES (2, 'STANDARD', 170);
INSERT INTO Rooms (capacity, type, price) VALUES (3, 'STANDARD', 190);
INSERT INTO Rooms (capacity, type, price) VALUES (1, 'STANDARD', 150);
INSERT INTO Rooms (capacity, type, price) VALUES (2, 'STANDARD', 170);
INSERT INTO Rooms (capacity, type, price) VALUES (3, 'STANDARD', 190);
INSERT INTO Rooms (capacity, type, price) VALUES (1, 'SUITE', 300);
INSERT INTO Rooms (capacity, type, price) VALUES (2, 'SUITE', 350);
INSERT INTO Rooms (capacity, type, price) VALUES (3, 'SUITE', 400);
INSERT INTO Rooms (capacity, type, price) VALUES (1, 'SUITE', 300);
INSERT INTO Rooms (capacity, type, price) VALUES (2, 'SUITE', 350);
INSERT INTO Rooms (capacity, type, price) VALUES (3, 'SUITE', 400);
INSERT INTO Rooms (capacity, type, price) VALUES (1, 'JUNIOR', 200);
INSERT INTO Rooms (capacity, type, price) VALUES (2, 'JUNIOR', 250);
INSERT INTO Rooms (capacity, type, price) VALUES (3, 'JUNIOR', 300);
INSERT INTO Rooms (capacity, type, price) VALUES (1, 'JUNIOR', 200);
INSERT INTO Rooms (capacity, type, price) VALUES (2, 'JUNIOR', 250);
INSERT INTO Rooms (capacity, type, price) VALUES (3, 'JUNIOR', 300);

INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (1, 1, 1, 'STANDARD', '2017-10-13', '2017-10-15', 2, 360, true);
INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (1, 1, 1, 'STANDARD', '2017-10-17', '2017-10-20', 2, 720, true);
INSERT INTO Orders (user_id, room_id, capacity, type, start_date, end_date, admin_id, price, status)
VALUES (1, 1, 1, 'STANDARD', '2017-10-23', '2017-10-25', 1, 720, false);

