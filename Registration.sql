DROP TABLE IF EXISTS test;
CREATE TABLE patients (
patientID int not null,
  FirstName VARCHAR(15) not null,
  Surname varchar(15) NOT NULL,
  PRIMARY KEY (patientID),
  Gender varchar(10),
  Age int (3),
  PhoneNumber varchar(15),
  DoctorChoson varchar(20),
  Details varchar(100)
);