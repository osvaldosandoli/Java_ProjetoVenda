
SELECT * FROM JAVA_FUNCIONARIO

SELECT * FROM JAVA_VENDA

/* apaga as sequences, caso elas existam */
drop sequence funcionario_sequence; commit;
drop sequence venda_sequence; commit;

create sequence funcionario_sequence
    START WITH 1000
    INCREMENT BY 10
    CACHE 50;
    
commit;

create sequence venda_sequence
    START WITH 100
    INCREMENT BY 1
    CACHE 50;
    
commit;

/* cria??o da tabela java_cargo */
drop table java_cargo; commit;
create table java_cargo (
    id_cargo integer,
    cargo varchar2(50),
    primary key(id_cargo)
);
commit;

/* inserindo dados na tabela java_cargo */
insert into java_cargo values(1, 'Atendente'); commit;
insert into java_cargo values(2, 'Vendedor'); commit;
insert into java_cargo values(3, 'Gerente'); commit;

/* cria??o da tabela java_funcionario */
drop table java_funcionario; commit;
create table java_funcionario (
    id_funcionario integer,
    nome varchar2(50),
    salario number(10, 2),
    id_cargo integer,
    primary key (id_funcionario),
    FOREIGN KEY (id_cargo) REFERENCES java_cargo(id_cargo)
);
commit;

/* cria??o da tabela java_venda */
drop table java_venda; commit;
create table java_venda (
    id_venda integer,
    id_funcionario integer,
    valor number(10, 2),
    comissao number(10, 2),
    primary key (id_venda),
    FOREIGN key (id_funcionario) REFERENCES java_funcionario(id_funcionario)
);



select f.nome, f.salario, sum(v.comissao) as total_comissao from java_funcionario f
left join java_venda v 
on f.id_funcionario = v.id_funcionario group by f.nome, f.salario
order by f.salario;
