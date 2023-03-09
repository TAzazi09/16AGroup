DROP TABLE IF EXISTS patients;
CREATE TABLE patients (
PatientID int not null auto_increment,
  FirstName VARCHAR(15) not null,
  Surname varchar(15) NOT NULL,
  PRIMARY KEY (patientID),
  Gender varchar(10) not null,
  Age int (3) not null,
  PhoneNumber varchar(15),
  DoctorChosen varchar(20) not null,
  Details varchar(100)
);
SELECT * from patients