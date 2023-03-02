DROP TABLE IF EXISTS patients;
CREATE TABLE patients (
PatientID int not null,
  FirstName VARCHAR(15) not null,
  Surname varchar(15) NOT NULL,
  PRIMARY KEY (patientID),
  Gender varchar(10),
  Age int (3),
  PhoneNumber varchar(15),
  DoctorChosen varchar(20),
  Details varchar(100)
);
SELECT * from patients