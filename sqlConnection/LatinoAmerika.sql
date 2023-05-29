create schema LatinoAmerika;
use LatinoAmerika;

CREATE TABLE users (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  username VARCHAR(50) NOT NULL unique,
  password VARCHAR(50) NOT NULL,
  mail VARCHAR(100) NOT NULL,
  balance DECIMAL(10, 2) NOT NULL
);

select username, name, surname, mail, balance, phone_number from users;





DELIMITER //

CREATE PROCEDURE update_user_balance(
  IN p_username VARCHAR(50),
  IN p_balance DECIMAL(10, 2)
)
BEGIN
  UPDATE users
  SET balance = balance + p_balance 
  WHERE username = p_username;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE divide_and_subtract_balance(
  IN p_input DECIMAL(10, 2)
)
BEGIN
  DECLARE total_users INT;
  
  -- Get the total number of users
  SELECT COUNT(*) INTO total_users FROM users;
  
  -- Divide the input by the number of users
  SET @subtraction_amount = p_input / total_users;
  
  -- Subtract the calculated amount from every user's balance
  UPDATE users
  SET balance = balance - @subtraction_amount;
END //

DELIMITER ;