CREATE TABLE flights
(
    id      BIGINT       NOT NULL,
    `from`  VARCHAR(255) NULL,
    `to`    VARCHAR(255) NULL,
    time    datetime     NULL,
    gate    VARCHAR(255) NULL,
    remarks VARCHAR(255) NULL,
    CONSTRAINT pk_flights PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255)          NULL,
    last_name  VARCHAR(255)          NULL,
    username   VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    password   VARCHAR(255)          NULL,
    `role`     VARCHAR(255)          NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE luggage
(
    id     BIGINT NOT NULL,
    weight FLOAT  NOT NULL,
    CONSTRAINT pk_luggage PRIMARY KEY (id)
);

CREATE TABLE `user-flights`
(
    id         BIGINT       NOT NULL,
    flight_class      VARCHAR(255) NULL,
    seat       VARCHAR(255) NULL,
    price      FLOAT        NOT NULL,
    discount   FLOAT        NOT NULL,
    user_id    BIGINT       NOT NULL,
    flight_id  BIGINT       NOT NULL,
    luggage_id BIGINT       NOT NULL,
    CONSTRAINT `pk_user-flights` PRIMARY KEY (id)
);

ALTER TABLE `user-flights`
    ADD CONSTRAINT `FK_USER-FLIGHTS_ON_FLIGHT` FOREIGN KEY (flight_id) REFERENCES flights (id);

ALTER TABLE `user-flights`
    ADD CONSTRAINT `FK_USER-FLIGHTS_ON_LUGGAGE` FOREIGN KEY (luggage_id) REFERENCES luggage (id);

ALTER TABLE `user-flights`
    ADD CONSTRAINT `FK_USER-FLIGHTS_ON_USER` FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE invoices
(
    id          BIGINT NOT NULL,
    full_amount FLOAT  NOT NULL,
    user_id     BIGINT NOT NULL,
    flight_id   BIGINT NOT NULL,
    CONSTRAINT pk_invoices PRIMARY KEY (id)
);

ALTER TABLE invoices
    ADD CONSTRAINT FK_INVOICES_ON_FLIGHT FOREIGN KEY (flight_id) REFERENCES flights (id);

ALTER TABLE invoices
    ADD CONSTRAINT FK_INVOICES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);