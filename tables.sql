Create table GROUPS (
ID INT(11) NOT NULL AUTO_INCREMENT,
GROUPID INT(11) NOT NULL,
NAME VARCHAR(100) NOT NULL,
CONSTRAINT groups_pk PRIMARY KEY (ID)
);
INSERT INTO GROUPS (GROUPID, NAME)
VALUES (1,'Управление'), (2,'Финансовый отдел'), (3,'Электрики'), (4,'IT'), (5,'HR'), (6,'Подрядчики');

Create table USERS (
ID INT(11) NOT NULL AUTO_INCREMENT,
NAME VARCHAR(100) NOT NULL,
LOGIN VARCHAR(50) NOT NULL,
GROUPID INT(11) ,
STATUS BOOLEAN NOT NULL,
DOB DATE,
CONSTRAINT users_pk PRIMARY KEY (ID),
CONSTRAINT users_group_fk FOREIGN KEY (GROUPID) REFERENCES GROUPS (GROUPID)
);

INSERT INTO USERS (NAME, LOGIN, GROUPID, STATUS, DOB) 
VALUES ('Баба Яга','yaga',1,true,'1981-02-01'), 
('Конек Горбунок Петрович','twn22',2,true,'1985-01-01'),
('Илья Муромец','wwss1',3,true,'1985-03-01'),
('Змей Горыныч','gor1',4,false,'1923-05-02'),
('Иван Царевич','car5',5,true,'1983-07-01'),
('Марья Искусница','isk33',6,true,'1990-09-01'),
('Кащей Бессмертный','kash',2,true,'1985-12-01'),
('Василиса Премудрая','prem',3,true,'1985-11-01'),
('Доктор Айболит','aaa',4,true,'1912-02-01'),
('Царевна Несмеянна','nes11',2,false,'1933-05-01'),
('Морозко','mor',6,true,'1911-04-01'),
('Соловей Разбойник','solove1',2,true,'1922-10-01');

--DROP TABLE GROUPS;
--DROP TABLE USERS;