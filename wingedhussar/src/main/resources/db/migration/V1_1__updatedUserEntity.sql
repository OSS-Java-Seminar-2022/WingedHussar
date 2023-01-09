ALTER TABLE users
    ADD COLUMN email VARCHAR(255) NULL AFTER last_name;

ALTER TABLE users
    ADD COLUMN password VARCHAR(255) NULL AFTER last_name;
