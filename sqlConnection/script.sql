use latinoamerika;

DELIMITER //

CREATE PROCEDURE check_user_exists(
  IN p_username VARCHAR(50),
  IN p_password VARCHAR(50),
  OUT p_user_exists INT
)
BEGIN
  DECLARE user_count INT;
  
  -- Check if the user exists in the table
  SELECT COUNT(*) INTO user_count
  FROM users
  WHERE username = p_username AND password = p_password;
  
  -- Set the output parameter based on the result
  IF user_count > 0 THEN
    SET p_user_exists = 1;
  ELSE
    SET p_user_exists = 0;
  END IF;
  
END //

DELIMITER ;

