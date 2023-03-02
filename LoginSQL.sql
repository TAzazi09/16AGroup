DROP TABLE IF EXISTS test;
CREATE TABLE test (
  username int NOT NULL,
  password varchar(45) NOT NULL,
  PRIMARY KEY (username,password)
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into test
values ('0', 't0'), ('1', 't1'), ('2', 'otest')