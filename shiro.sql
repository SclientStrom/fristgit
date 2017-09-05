drop table if exists user;
create table user(
   id int not null primary key auto_increment,
   username varchar(16) not null,
   password varchar(255) not null,
   r_id int 
);
drop table if exists u_r_relation;
create table u_r_relation(
   r_id int not null ,
   rid int not null
);
drop table if exists role;
create table role(
   rid int not null primary key auto_increment,
   role varchar(20) not null,
   m_id int 
);
drop table if exists r_m_relation;
create table r_m_relation(
   m_id int not null,
   mid int not null
);

drop table if exists permissions;
create table permissions(
   mid int not null primary key auto_increment,
   moudle varchar(20) not null
);
insert into user (username,password,r_id) values("slient","123321",1);
insert into user (username,password,r_id) values("admins","123321",2);
insert into user (username,password,r_id) values("guests","123321",3);
insert into u_r_relation(r_id,rid) values(1,1);
insert into u_r_relation(r_id,rid) values(2,1);
insert into u_r_relation(r_id,rid) values(2,2);
insert into u_r_relation(r_id,rid) values(3,3);
insert into role(rid,role,m_id) values(1,"admin",1);
insert into role(rid,role,m_id)values(2,"user",2);
insert into role(rid,role,m_id)values(3,"guest",3);
insert into r_m_relation(m_id,mid) values(1,1);
insert into r_m_relation(m_id,mid) values(1,2);
insert into r_m_relation(m_id,mid) values(1,3);
insert into r_m_relation(m_id,mid) values(1,4);
insert into r_m_relation(m_id,mid) values(2,1);
insert into r_m_relation(m_id,mid) values(2,2);
insert into r_m_relation(m_id,mid) values(3,1);
insert into permissions (mid,moudle) values(1,"query");
insert into permissions (mid,moudle) values(2,"delete");
insert into permissions (mid,moudle) values(3,"add");   
insert into permissions (mid,moudle) values(4,"modify");

select * from user u1 left join u_r_relation ur1 on ur1.r_id=u1.r_id left join role r1 on r1.rid=ur1.rid left join r_m_relation rm1 on rm1.m_id=r1.m_id left join permissions p1 on p1.mid=rm1.mid;



