select * from member;
create table memiot(
	num number primary key,
	id varchar2(20) not null,
	pass varchar2(20) not null,
	mname varchar2(20) not null,
	mage number(3),
	memail varchar2(50),
	mtel varchar2(20)
);
create sequence num_seq;

insert into memiot values(num_seq.nextval, 'admin', 'admin', '관리자', 40, 'admin@admin.com', '010-1111-2222');

select * from memiot;
select * from user_sequences;