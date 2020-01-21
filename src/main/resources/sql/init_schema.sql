DROP TABLE IF EXISTS school;
CREATE TABLE school(
   id serial PRIMARY KEY,
   name VARCHAR (255) NOT NULL
);

DROP TABLE IF EXISTS student;
CREATE TABLE student(
   id serial PRIMARY KEY,
   name VARCHAR (255) NOT NULL,
   school_id int4
);

DROP TABLE IF EXISTS subject;
CREATE TABLE subject(
   id serial PRIMARY KEY,
   name VARCHAR (255) NOT NULL,
   category VARCHAR (25) NOT NULL,
   student_id int4
);
