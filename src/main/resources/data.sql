DROP TABLE IF EXISTS client CASCADE;
CREATE TABLE client (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS card CASCADE;
CREATE TABLE card (
  id INT AUTO_INCREMENT PRIMARY KEY,
  client_id INT NOT NULL,
  number VARCHAR(9) NOT NULL,
  active  NUMBER(1,0) DEFAULT 0 NOT NULL
);

DROP TABLE IF EXISTS payment CASCADE;
CREATE TABLE payment (
  id INT AUTO_INCREMENT PRIMARY KEY,
  card_id INT NOT NULL,
  description VARCHAR(250) NOT NULL,
  value DECIMAL NOT NULL
);

INSERT INTO client (name) VALUES
  ('João'),
  ('Maria');

INSERT INTO card (client_id, number, active) VALUES
  (1, '123456789', 0),
  (2, '987654321', 0);

INSERT INTO payment (card_id, description, value) VALUES
  (1, 'cerveja', 50.05),
  (1, 'picanha', 92.00);
