create database Hospital_hospital

use Hospital_hospital
use master
drop database Hospital_hospital

create table Hospital(
	cod_hosp integer constraint cod_hosp_pk primary key identity,
	endereco_hosp varchar(30) not null,
	nome_hosp varchar(20) not null
);

create table Convenio(
	cod_conv integer constraint cod_conv_pk primary key identity,
	valor_conv numeric(10,2) not null,
	nome_conv varchar(20) not null
);

create table Paciente(
	cpf_pac integer constraint cpf_pac_pk primary key,
	cod_conv integer constraint pac_conv_cod_fk foreign key (cod_conv) references Convenio (cod_conv),
	dtnasc_pac date not null,
	endereco_pac varchar(30) not null,
	fone_pac char(9) not null,
	nome_pac varchar(30) not null,
	peso_pac numeric(5,2) not null,
	altura_pac numeric(5,2) not null
);

create table Medico(
	crm_med integer constraint crm_med_pk primary key identity,
	cod_hosp integer constraint med_hosp_cod_fk foreign key (cod_hosp) references Hospital (cod_hosp),
	endereco_med varchar(30) not null,
	dtnasc_med date not null,
	nome_med varchar(30) not null,
	cpf_med char(11) not null,
	ativo_med varchar(25) not null,
	salario_med numeric(10,2) not null,
	fone_med char(11) not null
);

create table Prontuario(
	cod_pron integer constraint cod_pron_pk primary key identity,
	crm_med integer constraint crm_med_fk foreign key (crm_med) references Medico (crm_med),
	cod_hosp integer constraint pron_hosp_cod_fk foreign key (cod_hosp) references Hospital (cod_hosp),
	cpf_pac integer constraint pron_pac_cpd_fk foreign key (cpf_pac) references Paciente (cpf_pac),
	observacao_pron varchar(50) not null,
	dtemissao_pron datetime not null,
	hist_fam_pac varchar(30) not null,
	doenca_pac varchar(20) not null
);

create table Cirurgia(
	cod_cirur integer constraint cod_cirur_pk primary key identity,
	cod_pron integer constraint cirur_pron_cod_fk foreign key (cod_pron) references Prontuario (cod_pron),
	dthora_cirur datetime not null,
	tipo_cirur varchar(10) not null,
);

create table Internacao(
	cod_inter integer constraint cod_inter_pk primary key identity,
	cod_pron integer constraint inter_pron_cod_fk foreign key (cod_pron) references Prontuario (cod_pron),
	dthora_inter datetime not null,
	tipo_inter varchar(20) not null
);

create table Hist_cons(
	cod_hist integer constraint cod_hist_pk primary key identity,
	cod_pron integer constraint hcons_pron_con_fk foreign key (cod_pron) references Prontuario (cod_pron),
	assi_hist varchar(30) not null,
	prescricao_hist varchar(30) not null
);

create table Remedio(
	cod_reme integer constraint cod_reme_pk primary key identity,
	cod_hist integer constraint reme_hist_cod_fk foreign key (cod_hist) references Hist_cons (cod_hist),
	dtvali_reme date not null,
	nome_reme varchar(30) not null,
	fabri_reme varchar(20) not null,
	dtfabri_reme date not null
);

create table Exame(
	cod_exame integer constraint cod_exame_pk primary key identity,
	cod_pron integer constraint exa_pron_cod_fk foreign key (cod_pron) references Prontuario (cod_pron),
	dthora_exame datetime not null,
	nome_exame varchar(30) not null,
	tipo_exame varchar(20) not null
);

create table Enfermeiro(
	matri_enf integer constraint matri_enf_pk primary key identity,
	cod_hosp integer constraint enf_hosp_cod_fk foreign key (cod_hosp) references Hospital (cod_hosp),
	cod_cirur integer constraint enf_cirur_cod_fk foreign key (cod_cirur) references Cirurgia (cod_cirur),
	endereco_enf varchar(30) not null,
	dtnasc_enf date not null,
	nome_enf varchar(30) not null,
	cpf_enf char(11) not null,
	ativo_enf varchar(25) not null,
	salario_enf numeric(10,2) not null,
	fone_enf char(11) not null
);

create table Inter_Enf(
	matri_enf integer constraint intenf_enf_matri_fk foreign key (matri_enf) references Enfermeiro (matri_enf),
	cod_inter integer constraint intenf_inter_cod_fk foreign key (cod_inter) references Internacao (cod_inter),
);

create table Consulta(
	cod_cons integer constraint cod_cons_pk primary key identity,
	crm_med integer constraint cons_med_crm_fk foreign key (crm_med) references Medico (crm_med),
	cod_pron integer constraint cons_pron_cod_fk foreign key (cod_pron) references Prontuario (cod_pron),
	data_cons date not null,
	hora_cons time not null,
);

insert into Hospital values('Rua dos Bobos, 0','Jaiminho, o carteiro');

insert into Convenio values(420, 520.69,'SSSSSans');
insert into Convenio values(024, 960.25,'Snasssss');
insert into Convenio values(294, 9,'Pobrevênios');
insert into Convenio values(83, 99999999.98,'Moto Moto');
insert into Convenio values(1, 1700.00,'GNDI Easy');

insert into Paciente values('159753456-78', 420, '02-01-1456', '-23.522548, -46.716620', 11123469859, 'Yanexy Naranjo Hechavarria', 80, 1.80);
insert into Paciente values('159444456-58', 294, '02-02-1999', 'Avenida Bady Bassit, 3268', 77147145632, 'Joaquim de Souza Barbeiro', 60, 1.60);
insert into Paciente values('157777456-68', 83, '02-05-2000', '-23.449924, -46.548778', 11774561243, 'Franco Heringer de Oliveira', 70, 1.65);
insert into Paciente values('153333456-48', 1, '02-09-3000', '31.728660, 35.261016', 44123469859, 'Anderson Mendes de Vasconsellos', 75, 1.90);
insert into Paciente values('155555456-98', 1, '02-07-1898', '28.958115, -36.159398', 77123469859, 'Thais Giulia de Melo Schreiner', 90, 2.00);

insert into Medico values(69, 1,'No Morro', '01-01-1789', 'Cleudo', '214356315-14', 'Regular', 3500.00, 11945461234);
insert into Medico values(42, 1,'Na Colina', '05-02-1990', 'Jéssica', '214444447-15', 'Regular', 4500.00, 11955467894);
insert into Medico values(1, 1,'Rua Rua Rua Avenida', '01-26-1959', 'Flaminio Favero', '789456321-00', 'Falecido', 0000.00, 21956665444);
insert into Medico values(172000, 1,'Rua Inglaterra', '12-31-1986', 'Julia Heyden Boczar', '111111111-11', 'Regular', 5000.00, 55945047892);
insert into Medico values(201764, 1,'Avenida Rua', '07-21-1992', 'Vitoria Arbulu Pitol', '555222333-78', 'Regular', 3500.00, 33945461234);
insert into Medico values(36993, 1,'Avenida Celso Garcia, 2477-Belenzinho', '03-17-1964', 'Margarete Zonzini Maximo de Carvalho', '777888999-78', 'Irregular', 2000.00, 11944445555);
insert into Medico values(12867, 1,'Rua Jj Seabra, 50', '06-07-1973', 'Margarete Pereira Amorim', '111222333-78', 'Transferido', 3000.00, 7734512030);

insert into Prontuario values(21, 69, 1, '159753456-78', 'Internação', '02-20-2020', 'Sem Histórico Famíliar', 'Nada encontrado');
insert into Prontuario values(46, 36993, 1, '153333456-48', 'Cirurgia', '05-05-2022', 'Sem Histórico Famíliar', 'Nada encontrado');
insert into Prontuario values(55, 172000, 1, '157777456-68', 'Bem', '02-20-2021', 'Família possui Diabete alto', 'Possui Diabete');
insert into Prontuario values(88, 172000, 1, '159444456-58', 'Bem', '02-20-2020', 'Sem Histórico Famíliar', 'Possui Conjuntivite');
insert into Prontuario values(38, 69, 1, '155555456-98', 'Exame', '02-20-2020', 'Histórico de Alzheimer na família', 'Incerto');

insert into Cirurgia (cod_cirur, cod_pron, dthora_cirur, tipo_cirur) values(123, 46, GETDATE(), 'Reimplante');
insert into Cirurgia (cod_cirur, cod_pron, dthora_cirur, tipo_cirur) values(800, 21, DATEADD(YEAR, -90, GETDATE()), 'Remoção de Cancer de mama');
insert into Cirurgia (cod_cirur, cod_pron, dthora_cirur, tipo_cirur) values(71, 21, DATEADD(YEAR, -67, GETDATE()), 'Reimplante');

insert into Internacao (cod_inter, cod_pron, dthora_inter, tipo_inter) values(1, 21, DATEADD(YEAR, -89, GETDATE()), 'Internação Involuntária');
insert into Internacao (cod_inter, cod_pron, dthora_inter, tipo_inter) values(2, 21, DATEADD(YEAR, -66, GETDATE()), 'Internação Involuntária');

insert into Hist_cons (cod_hist, cod_pron, assi_hist, prescricao_hist) values(1, 46, 'Nada', 'Orfenadrina');
insert into Hist_cons (cod_hist, cod_pron, assi_hist, prescricao_hist) values(2, 21, 'Nada', 'Ácido acetilsalicílico');
insert into Hist_cons (cod_hist, cod_pron, assi_hist, prescricao_hist) values(3, 21, 'Nada', 'Metamizol');
insert into Hist_cons (cod_hist, cod_pron, assi_hist, prescricao_hist) values(4, 38, 'Nada', 'Metamizol');

insert into Remedio (cod_reme, cod_hist, nome_reme, fabri_reme, dtvali_reme, dtfabri_reme) values(3, 'Metamizol', 'Dia', DATEADD(YEAR, 2, GETDATE()), GETDATE());
insert into Remedio (cod_reme, cod_hist, nome_reme, fabri_reme, dtvali_reme, dtfabri_reme) values(4, 'Metamizol', 'Rihappy', DATEADD(YEAR, 1, GETDATE()), DATEADD(YEAR, -1, GETDATE()));
insert into Remedio (cod_reme, cod_hist, nome_reme, fabri_reme, dtvali_reme, dtfabri_reme) values(2, 'Ácido acetilsalicílico', 'Jairo Brinquedos', DATEADD(YEAR, 1, GETDATE()), DATEADD(YEAR, -2, GETDATE()));
insert into Remedio (cod_reme, cod_hist, nome_reme, fabri_reme, dtvali_reme, dtfabri_reme) values(1, 'Orfenadrina', 'Ebay', DATEADD(YEAR, 2, GETDATE()), GETDATE());

insert into Exame (cod_exame, cod_pron, nome_exame, tipo_exame, dthora_exame) values(1, 21, 'Raio X', 'Raio X', GETDATE());
insert into Exame (cod_exame, cod_pron, nome_exame, tipo_exame, dthora_exame) values(2, 21, 'Raio X', 'Raio X', GETDATE());
insert into Exame (cod_exame, cod_pron, nome_exame, tipo_exame, dthora_exame) values(3, 38, 'Raio X', 'Raio X', GETDATE());
insert into Exame (cod_exame, cod_pron, nome_exame, tipo_exame, dthora_exame) values(4, 46, 'Raio X', 'Raio X', GETDATE());

insert into Enfermeiro values(11, 1, 71,'Rua dos Bobos, 0', GETDATE(),'Jaiminho, o carteiro', '159753497-78', 'Regular', 1900.00, '11944445555');
insert into Enfermeiro values(157, 1, 800,'Rua do Além, 8', GETDATE(),'Astolfo', '159753497-78', 'Regular', 1900.00, '11944445555');
insert into Enfermeiro values(211, 1, 800,'O Vazio, 999999999', GETDATE(),'NecoArc', '159753497-78', 'Regular', 1900.00, '11944445555');
insert into Enfermeiro values(420, 1, 123,'Rua sem Retorno, 78', GETDATE(),'Rodolfo', '159753497-78', 'Regular', 1900.00, '11944445555');
insert into Enfermeiro values(777, 1, 123,'Rua dos Bobos, 0', GETDATE(), 'Leptospirose', '159753497-78', 'Regular', 1900.00, '11944445555');

insert into Inter_Enf values(157, 21);
insert into Inter_Enf values(11, 21);

insert into Consulta(cod_cons, crm_med, cod_pron, data_cons, hora_cons) values(1, 69, 21, GETDATE(), SYSDATETIME());
insert into Consulta(cod_cons, crm_med, cod_pron, data_cons, hora_cons) values(2, 69, 21, GETDATE(), SYSDATETIME());
insert into Consulta(cod_cons, crm_med, cod_pron, data_cons, hora_cons) values(3, 1, 55, GETDATE(), SYSDATETIME());
insert into Consulta(cod_cons, crm_med, cod_pron, data_cons, hora_cons) values(4, 201764, 88, GETDATE(), SYSDATETIME());
insert into Consulta(cod_cons, crm_med, cod_pron, data_cons, hora_cons) values(5, 12867, 38, GETDATE(), SYSDATETIME());

select Prontuario.cod_pron, Paciente.cpf_pac, nome_pac from Prontuario inner join Paciente on Prontuario.cpf_pac = Paciente.cpf_pac;
select crm_med, cpf_pac from Prontuario where crm_med between 1000 and 13000;
select * from Medico where not ativo_med = 'Regular';
select nome_enf, nome_pac, i.cod_inter from Inter_Enf ie 
	inner join Enfermeiro e on e.matri_enf = ie.matri_enf
	inner join Internacao i on i.cod_inter = ie.cod_inter
	inner join Prontuario p on p.cod_pron = i.cod_pron
	inner join Paciente pac on pac.cpf_pac = p.cpf_pac;
