DROP TABLE IF EXISTS Exl_EMPLOYEES;
 
CREATE TABLE Exl_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  job_title VARCHAR(250) DEFAULT NULL,
  age int(20) DEFAULT NULL,
  start_date DATE DEFAULT NULL,
  end_date DATE DEFAULT NULL
);