drop table if exists conti;

create table conti(
CIN varchar(1) not null,
ABI int(5) not null,
CAB int(5) not null,
numeroConto bigint(12) auto_increment primary key,
nomeTitolare varchar(100) not null,
cognomeTitolare varchar(100) not null,
codiceFiscaleTitolare varchar(16) not null check(LENGTH(codiceFiscaleTitolare)=16)
);

alter table conti auto_increment = 100000000001;

insert into conti(CIN, ABI, CAB, nomeTitolare, cognomeTitolare, codiceFiscaleTitolare)
values("I", 11111, 22222, "A", "K", "KH24H2H4J3J1J2J1");
insert into conti(CIN, ABI, CAB, nomeTitolare, cognomeTitolare, codiceFiscaleTitolare)
values("I", 11111, 22222, "EE", "BB", "BB24H2H4J3J1J2J2");

