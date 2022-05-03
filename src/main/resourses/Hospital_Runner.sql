SHOW databases;
USE Hospital;
SHOW tables;

INSERT INTO Doctors (name, position, age) VALUES ('Tom Nuke', 'therapist', 25);
INSERT INTO Doctors (name, position, age) VALUES ('Robb Stark', 'otolaryngologist', 40);
INSERT INTO Doctors (name, position, age) VALUES ('Trevor Philips', 'surgeon', 45);
INSERT INTO Doctors (name, position, age) VALUES ('Devin Weston', 'neurologist', 45);
INSERT INTO Doctors (name, position, age) VALUES ('John Marston', 'therapist', 18);
SELECT * FROM Doctors;

INSERT INTO Nurses (name, age) VALUES ('Amanda De Santa', 30);
INSERT INTO Nurses (name, age) VALUES ('Abigail Marston', 25);
INSERT INTO Nurses (name, age) VALUES ('Tilly Jackson', 40);
INSERT INTO Nurses (name, age) VALUES ('Jill Valentine', 17);
INSERT INTO Nurses (name, age) VALUES ('Claire Redfield', 22);
INSERT INTO Nurses (name, age) VALUES ('Rebecca Chambers', 18);
SELECT * FROM Nurses;

INSERT INTO Patients (name, email, age) VALUES ('Leopold Strauss', 'Leopold_Strauss@gmail.com', 40);
INSERT INTO Patients (name, email, age) VALUES ('Andrew Milton', 'Andrew_Milton@gmail.com', 45);
INSERT INTO Patients (name, email, age) VALUES ('Mary Linton', 'Mary_Linton@gmail.com', 30);
INSERT INTO Patients (name, email, age) VALUES ('Mary Dragonborn', 'mary.dragon@gmail.com', 45);
SELECT * FROM Patients;

INSERT INTO Departments (name) VALUES ('Neurology');
INSERT INTO Departments (name) VALUES ('Surgery');
INSERT INTO Departments (name) VALUES ('Otolaryngology');
INSERT INTO Departments (name) VALUES ('Therapy');
SELECT * FROM Departments;

INSERT INTO Medicines (medicine_name) VALUES ('Ceftriaxone');
INSERT INTO Medicines (medicine_name) VALUES ('Mafosfamide');
SELECT * FROM Medicines;

UPDATE Doctors SET name='Drake Nuke' WHERE id=1;
UPDATE Doctors SET age=35 WHERE id=1;
UPDATE Doctors SET name='Robb Strike' WHERE id=2;
UPDATE Doctors SET name='Robb Strike' WHERE id=2;
UPDATE Patients SET email='leopold.strauss@gmail.com' WHERE id=1;
UPDATE Patients SET email='andrew.milton@gmail.com' WHERE id=2;
UPDATE Patients SET email='mary.linton@gmail.com' WHERE id=3;
UPDATE Nurses SET age=20 WHERE id=1;
UPDATE Nurses SET age=26 WHERE id=2;
UPDATE Nurses SET age=41 WHERE id=3;

ALTER TABLE Patients ADD Address VARCHAR(50) NULL;
UPDATE Patients SET Address='New York' WHERE id=1;
UPDATE Patients SET Address='Cleveland' WHERE id=2;
UPDATE Patients SET Address='Grand Rapids' WHERE id=3;
ALTER TABLE Patients RENAME COLUMN Address to address;

ALTER TABLE Departments ADD City VARCHAR(45) NULL;
ALTER TABLE Departments RENAME COLUMN City to location;
ALTER TABLE Departments ALTER COLUMN location SET DEFAULT 'New York';

ALTER TABLE Medicines ADD used VARCHAR(45) DEFAULT 'not used';

SELECT avg(age) AS avg_age FROM Doctors WHERE name != 'Drake Nuke';
SELECT avg(age) AS avg_age FROM Doctors;
SELECT min(age) AS min_age FROM Doctors;
SELECT max(age) AS max_age FROM Doctors;
SELECT sum(age) AS sum_age FROM Doctors;
SELECT count(name) AS count_name FROM Doctors;
SELECT count(*) AS count_age FROM Doctors WHERE age > 35;

SELECT min(age), name AS min_age FROM Patients GROUP BY name HAVING min(age) > 32;
SELECT max(age), name AS avg_age FROM Patients GROUP BY name HAVING max(age) < 35;
SELECT count(*), name AS count_age FROM Patients GROUP BY name HAVING name != 'Leopold Strauss';
SELECT count(id), name AS count_name FROM Patients GROUP BY name HAVING name != 'Mary Dragonborn';
SELECT count(id), name FROM Patients GROUP BY name HAVING count(id) < 3 ORDER BY count(id) DESC;
SELECT id, name, count(age) age FROM Patients GROUP BY age HAVING max(age) < 40;
SELECT id, name, avg(age) age FROM Patients GROUP BY name HAVING age BETWEEN 30 AND 40;

SELECT * FROM Patients JOIN Doctors USING(id);
SELECT * FROM Patients RIGHT JOIN Doctors USING(id);
SELECT Patients.name, Doctors.name FROM Patients LEFT JOIN Doctors ON Patients.id=Doctors.id ORDER BY Patients.name;
SELECT Patients.name, Doctors.position FROM Patients INNER JOIN Doctors ON Patients.id=Doctors.id ORDER BY Patients.name;
SELECT Patients.name, Doctors.id, Doctors.name FROM Patients RIGHT OUTER JOIN Doctors ON Patients.id=Doctors.id ORDER BY Patients.name;

SELECT p.id, p.name, p.email, p.age, d.id, d.name, d.position, n.id, n.name, n.age, m.id, m.medicine_name FROM Patients p JOIN Doctors d ON p.id=d.id JOIN Nurses n ON d.id=n.id JOIN Medicines m ON n.id=m.id;

DELETE FROM Patients WHERE address IS NULL;
DELETE FROM Nurses WHERE id=4;
DELETE FROM Nurses WHERE age=5;
DELETE FROM Nurses WHERE age=6;
DELETE FROM Doctors WHERE id<2;
DELETE FROM Departments WHERE id=1;
DELETE FROM Departments WHERE id=2;
DELETE FROM Doctors WHERE id=5;
DELETE FROM Doctors WHERE id>3;
DELETE FROM Doctors WHERE age=45;
