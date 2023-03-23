Create database trabalhoSpring;
Use trabalho;

create table pessoas (
id Integer auto_increment primary key,
Email varchar(200),
Nome varchar(100),
Numero bigint,
Profissao varchar(100)
);
