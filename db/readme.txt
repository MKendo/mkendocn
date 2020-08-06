--��ѯĳ��Ľɷ���˭
select m.name,mv.amount,mv.commitdatetime from members m 
join member_validates mv on mv.memberid=m.id 
where mv.commitdatetime like '2020-06-23%';

--�в���memberû��userid�޸�����֤ʹ��
select m.name,u.name,u.id 
from members m 
left join users u on m.userid=u.id 
where m.name in ('��׿��','������','������');

--����ϰ����
select count(*) from(
select u.name name,count(*) count from calendar_instances ci 
join users u on ci.userid=u.id 
join calendars c on ci.calendarid=c.id 
where c.eventtype='ԤԼ��ϰ' and startdatetime>='2020-06-01 00:00:00' and startdatetime<='2020-06-30 23:59:59'   and ci.enable=1 
group by u.name) ;

--����ϰ����
select * from(
select u.name name,count(*) count from calendar_instances ci 
join users u on ci.userid=u.id 
join calendars c on ci.calendarid=c.id 
where c.eventtype='ԤԼ��ϰ' and startdatetime>='2020-07-01 00:00:00' and startdatetime<='2020-07-31 23:59:59'  and ci.enable=1 
group by u.name) order by count desc;


--����ϰ������
select * from(
select u.name name,count(*) count from calendar_instances ci 
join users u on ci.userid=u.id 
join calendars c on ci.calendarid=c.id 
where c.eventtype='ԤԼ��ϰ' and startdatetime>='2020-07-01 00:00:00' and startdatetime<='2020-07-31 23:59:59'  and ci.enable=0 
group by u.name) order by count desc limit 1;

--�����м������ݿ⣺
sqlite3 mkendo201811.db

--����
.help

--��ѯ���б��
.tables

--��ʽ����ѯ���
.header on
.mode column
.timer on

--��ѯ���б��
SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;

--��ѯ����е��ֶ�
PRAGMA  table_info("members");

*******************************************************
���ݿ���Ƶ�һЩ����
*******************************************************
1 ������ͬ����֮����»��ߣ�ȫСд
2 �ֶ�����ͬ����֮�䲻���»��ߣ�ȫСд


*******************************************************
ԤԼ������صı�
*******************************************************
--bookings ԤԼ�����
--id,name,mobile,wxopenid,placetime,classdate,whereknowus,commitdatetime,enable

create table bookings(
id integer primary key not null,
name ntext not null,
mobile text not null,
wxopenid text,
placetimeid integer not null, 
classdate date not null,
whereknowusid integer,
commitdatetime datetime not null,
description ntext,
enable int,
coursename text
);

placetimeid --simpletypes���
whereknowusid --simpletypes���

alter table bookings add height text;  
alter table bookings add weight text;  

--simpletypes �����ͱ� 
--id,code,name,typecode(�����͵�����),description(����������),1
create table simpletypes(
id integer primary key not null,
code text key not null,
name ntext not null,
typecode text not null,
description text,
enable int
);

insert into simpletypes values(null,'FT01PM','������� ��һ��19:30--21:30','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'FT03PM','������� ������19:30--21:30','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'FT05PM','������� ������19:30--21:30','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'FT06PM','��������ٶ����� �������� 14:00--16:00','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'FT06PM2','������� �������� 16:00--18:00','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'FT07AM','������� ��������9:30--12:30 ���޹�Ħ','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'NS02PM','��ɽ���� �ܶ���20:00--22:00','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'NS04PM','��ɽ���� ������20:00--22:00','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);

insert into simpletypes values(null,'FT06PM14','������� �������� 14:30--16:30','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);
insert into simpletypes values(null,'FT07PM14','������� �������� 14:30--16:30','IntroLessonPlaceTime','���Ŀγ��Ͽγ���',1);

insert into simpletypes values(null,'DZMT','�������ſ�����','WhereKnowUs','������֪�����ǵ�',1);
insert into simpletypes values(null,'NETSEARCH','�����ѵ���','WhereKnowUs','������֪�����ǵ�',1);
insert into simpletypes values(null,'FRIEND','�����Ѹ�������','WhereKnowUs','������֪�����ǵ�',1);
insert into simpletypes values(null,'MOMENTS','����Ȧ������','WhereKnowUs','������֪�����ǵ�',1);


update simpletypes set description='��ѱ�׼:2015��֮ǰ����Ľ��Ѻ�����ǰ��' where code='FCPY3000';
update simpletypes set description='��ѱ�׼:2015��֮�����Ľ���' where code='FCPY3500';
update simpletypes set description='��ѱ�׼:2016��֮�����Ľ���' where code='FCPY4500';
update simpletypes set description='��ѱ�׼:2017��֮�����Ľ���' where code='FCPY6000';
update simpletypes set description='��ѱ�׼:2017��֮�����Ľ���' where code='FCHY4000';

insert into simpletypes values(null,'KENDO_MEMBER','������Ա','ROLE','��ɫ',1);
insert into simpletypes values(null,'RESTER_MEMBER','ע���Ա','ROLE','��ɫ',1);
insert into simpletypes values(null,'KENDO_TEACHER','������ʦ','ROLE','��ɫ',1);
insert into simpletypes values(null,'NEWS_EDITOR','����','ROLE','��ɫ',1);
insert into simpletypes values(null,'SUPER_ADMIN','��������Ա','ROLE','��ɫ',1);
insert into simpletypes values(null,'JA_TEACHER','������ʦ','ROLE','��ɫ',1);
insert into simpletypes values(null,'JA_MEMBER','�����Ա','ROLE','��ɫ',1);



--�û���ɫ��ϵ��
create table user_roles(
id integer primary key not null,
userid integer not null,
roleid integer not null,
description ntext,
enable int
);

insert into user_roles(userid,roleid,description,enable) 
values(1, (select id from simpletypes where code='SUPER_ADMIN'), '������ ��������Ա',1);

insert into user_roles(userid,roleid,description,enable) 
values(2, (select id from simpletypes where code='SUPER_ADMIN'), '����� ��������Ա',1);

insert into user_roles(userid,roleid,description,enable) 
values(3, (select id from simpletypes where code='NEWS_EDITOR'), '��˼ ����',1);
insert into user_roles(userid,roleid,description,enable) 
values(3, (select id from simpletypes where code='KENDO_MEMBER'), '��˼ ������Ա',1);

insert into user_roles(userid,roleid,description,enable) 
values(4, (select id from simpletypes where code='KENDO_MEMBER'), '������ ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(4, (select id from simpletypes where code='KENDO_TEACHER'), '������ ������ʦ',1);
insert into user_roles(userid,roleid,description,enable) 
values(6, (select id from simpletypes where code='KENDO_MEMBER'), '��һ ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(7, (select id from simpletypes where code='KENDO_MEMBER'), '��� ������Ա',1);

insert into user_roles(userid,roleid,description,enable) 
values(12, (select id from simpletypes where code='KENDO_TEACHER'), '������ ������ʦ',1);

insert into user_roles(userid,roleid,description,enable) 
values(30, (select id from simpletypes where code='JA_TEACHER'), '�Ŵϴ� ������ʦ',1);


insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='��ӨӨ'), (select id from simpletypes where code='JA_TEACHER'), '��ӨӨ ������ʦ',1);

insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='���º�'), (select id from simpletypes where code='KENDO_TEACHER'), '���º� ������ʦ',1);

insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='����'), (select id from simpletypes where code='KENDO_TEACHER'), '���� ������ʦ',1);

1|1|29|������ ��������Ա|1
2|2|29|����� ��������Ա|1
3|3|28|��˼ ����|1
4|3|25|��˼ ������Ա|1
5|4|25|������ ������Ա|1
6|4|27|������ ������ʦ|1
7|6|25|��һ ������Ա|1
8|7|25|��� ������Ա|1

9|8|25|��� ������Ա|1
10|11|25|���º� ������Ա|1
11|12|25|������ ������Ա|1
12|13|25|���� ������Ա|1
13|14|25|������ ������Ա|1
14|15|25|���� ������Ա|1
15|16|25|������ ������Ա|1
16|18|25|������ ������Ա|1
17|19|25|�ջ��� ������Ա|1
18|20|25|������ ������Ա|1
19|21|25|���� ������Ա|1
20|22|26|С�� ע���Ա|1

insert into user_roles(userid,roleid,description,enable) 
values(8, 25, '��� ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(11, 25, '���º� ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(12, 25, '������ ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(13, 25, '���� ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(14, 25, '������ ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(15, 25, '���� ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(16, 25, '������ ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(18, 25, '������ ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(19, 25, '�ջ��� ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(20, 25, '������ ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(21, 25, '���� ������Ա',1);
insert into user_roles(userid,roleid,description,enable) 
values(22, 26, 'С�� ������Ա',1);

insert into user_roles(userid,roleid,description,enable) 
values(22, 26, '������ ������Ա',1);


--�鿴�û���ɫ��ϵ
select ur.id urid,u.id uid,u.name,r.name,ur.description from users u 
join user_roles ur on ur.userid=u.id 
join simpletypes r on ur.roleid=r.id where u.name='¬Ӿ��';

--�����û���ɫΪ������Ա
insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='����'), 
(select id from simpletypes where code='KENDO_MEMBER'), '���� ������Ա',1);


delete from user_roles where id=194;

select r.name  from users u 
 left join user_roles ur on ur.userid=u.id  
 left join simpletypes r on ur.roleid=r.id where u.mobile='13128855200';


select r.name  from users u 
 left join user_roles ur on ur.userid=u.id  
 left join simpletypes r on ur.roleid=r.id where u.mobile='13128855200';

*******************************************************
ע���¼��صı�
*******************************************************
--users ע���û���
--id,name,mobile,password,wxopenid,commitdatetime,description,enable

drop table users;
create table users(
id integer primary key not null,
name ntext not null,
mobile text not null,
password text not null,
wxopenid text,
wxunionid text,
wxname text,
wximgurl text,
commitdatetime datetime not null,
description ntext,
enable int
);

insert into users values(null,'����','13128855200','mkendo.cn','','','','','2020-01-31 00:00:00','',1);
insert into users values(null,'�Ҳ�������','15889489370','mkendo.cn','','','','','2020-01-31 00:00:00','',1);
insert into users values(null,'˼˼','13417508531','mkendo.cn','','','','','2020-02-04 00:00:00','',1);
update members set userid=-1 ;


*******************************************************
������صı�
*******************************************************
create table articles(
id integer primary key not null,
code text not null,
typeid integer not null, -- simpletypes���  �������� NEWS���ţ�ACTIVITY�֪ͨ��BOLGblog... Ϊ�˼򵥣�����������²���ϸ��
title ntext not null, --���±���
subtitle ntext not null, --���¸�����
shortcontent ntext ntext not null, --����ժҪ
content ntext not null, --��������
imgurl text , --������ͼurl
eventstartdatetime datetime ,  -- ���ʼ/����ʱ��
eventenddatetime datetime ,  --�����ʱ��
registerstartdatetime datetime , --������ʼʱ��
registerenddatetime  datetime , --��������ʱ��
eventaddress ntext , --�¼������ص�
eventaddressurl text, --�¼������ص�url ���ڵ�ͼ
createdatetime datetime not null, --���´���ʱ��
creatername ntext , --�������� �Ժ���Ժ�member���������
description ntext,
enable int not null
);

insert into simpletypes values(null,'NEWS','����','ARTICLETYPE','�������ͣ�����',1);
insert into simpletypes values(null,'ACTIVITY','�','ARTICLETYPE','�������ͣ��',1);
insert into simpletypes values(null,'COURSE,'�γ�','ARTICLETYPE','�������ͣ��γ�',1);

insert into articles values(
null,
'2019mkendodh',
(select id from simpletypes where code='NEWS'),
'2019�������',
'������������۾���',
'���д���ʦ�ĳ���ʹ����£������ݾ�����2019��11��30�վٰ조�����ݽ�����ᡱ�������ơ�������ᡱ�򡰴�ᡱ��������������Ὣ���ҹ�ȫԱ��������ʢ�ᡣ',
'<p>���δ�����ּ�ǣ�</p>
<p><b>ȫԱ����</b>������һͬ��ϰ�Ľ��ѿ����ؾۣ����չ�ͬŬ���Ļ�����Я�֣�δ����������ı˴˿�����ʶ��</p>
<p><b>��������</b>�����δ�����һĿ�����Ǽ����λ����ƽ�յ���ϰ�ɹ�����ʹ���׷�����澫����Ŀ�ꣻ</p>
<p><b>��������</b>��Ϊ�����ж�ǰ�����ṩһ�ζ�����������֯�����Ļ��ᣬ�������á�</p>',
'2019mkendodh120.jpg',
datetime('now', '+10 day'),
datetime('now', '+11 day'),
datetime('now'),
datetime('now', '+6 day'),
'����������',
'',
datetime('now'),
'����',
'˵��description',
1
);

insert into articles values(
null,
'2019mkendocp',
(select id from simpletypes where code='NEWS'),
'�����ݽ������н�ϰ��',
'�ذ���Ϣ������27�������ݽ������н�ϰ��',
'�˴ν�ϰ�����ǽ�ѧϰ����������ò��У����еĹ������ǣ��Լ�������ͱ��������޶�λ���޻��߽Կɲμӡ�',
'<p>�����м����ǽ���ѧϰ�����к���Ҫ��һ�������ڸ�����˵������ѧ����һЩ�µ�֪ʶ������Ϊ�����ı�����������̵档</p>
<p>���������Ĺٷ����������Ӣ�����ڱ��������ö����еĿ�����ö�������ù����Ǻ���Ҫ�ġ��ڱ����еñ��ı�׼��ʲô������ͻ��״�����Ӧ�ԣ���Щ�Ǳ������������Ϊ����Щ�������ֹ����Ϊ����Щ���۶��ڳ�ѧ����˵�����Ƕ���ǰ���ǣ����Ǻ���Ҫ��֪ʶ������Ҫ�ڱ����м���ע�⡣</p>',
'caipan120.jpg',
datetime('now', '+5 day'),
datetime('now', '+6 day'),
datetime('now'),
datetime('now', '+6 day'),
'����������',
'',
datetime('now'),
'����',
'˵��description',
1
);

*******************************************************
��Ա��صı�
*******************************************************
--���ӷ��ñ�׼
insert into simpletypes values(null,'FCPY6000','����һ��6000','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FCPY4500','����һ��4500','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FCPY3500','����һ��3500','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FCPY3000','����һ��3000','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FCPYVIP0','VIP���','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FCHY3500','���Ѱ���3500','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FCHY4000','���Ѱ���4000','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FNPY10000','�״νɷ�һ��10000','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FNPY6000','�״νɷ�һ��6500','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FNHY4000','�״νɷѰ���4500','MemberFeeType','��ѱ�׼',1);
insert into simpletypes values(null,'FTOTHER','�����Ż�����','MemberFeeType','��ѱ�׼',1);

--��Ա��
create table members(
id integer primary key not null,
name text not null,
mobile text not null,
idtypename text,
idnumber text not null,
userid integer,
wxopenid text,
description ntext,
commitdatetime datetime not null,
enable int
);

insert into members(name,mobile,idtypename,idnumber,userid,wxopenid,description,commitdatetime,enable)
values('������','13128855200','���֤','320305197902150927',1,'','','2020-02-11 15:00:00',1);
 
insert into members(name,mobile,idtypename,idnumber,userid,wxopenid,description,commitdatetime,enable)
values('�����','15889489370','���֤','330824197709244911',2,'','','2020-02-11 15:00:00',1);

--��Աע����Ϣ������ʱ��д�ı��
create table member_registerinfos(
id integer primary key not null,
memberid integer not null,
email text,
wechatno text,
occupation ntext, --ְҵ
company ntext, --������λ
address ntext,
birthday text,
height text,
fromdojo ntext,
commitdatetime datetime not null,
enable int
);

--��Ա���Ա�����Ϣ��

--��Ա����λ��


--��Ա��Ч�ڱ�:
create table member_validates(
id integer primary key not null,
memberid integer not null,
startvalidate text not null,
endvalidate text not null,
feetypeid integer not null,
amount inteter,
description ntext,
commitdatetime datetime not null,
enable int
);


insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values(1,'2010/11/01','9999/12/31','2020-02-11 15:00:00','VIP',19,0);
  
insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values(2,'2010/11/01','9999/12/31','2020-02-11 15:00:00','�ݳ�VIP',19,0);

--�������validate��������
insert into members(name,mobile,idtypename,idnumber,userid,wxopenid,description,commitdatetime,enable)
values('�����','15889489370','���֤','44030520120905911X','','','','2020-02-11 15:00:00',1);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='�����'),'2012/09/05','2013/09/05','2012-09-05 09:00:00','��һ�νɷѱ���',22,6500);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='�����'),'2013/09/05','2014/09/05','2013-09-05 09:00:00','����3000',18,3000);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='�����'),'2014/09/05','2015/09/05','2014-09-05 09:00:00','����3000',18,3000);

--��ѯsql
 select m.id,m.name,m.mobile,m.idtypename,m.idnumber,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName
 from members m 
 left join member_validates mv on mv.memberid=m.id
 left join simpletypes ft on ft.id=mv.feetypeid
 group by m.id
 having mv.startvalidate=max(mv.startvalidate) 
 ;

select * from (
 select m.id,m.name,m.description,m.mobile,m.idtypename,m.idnumber,mv.startvalidate,mv.endvalidate,mv.description,ft.code feeTypeCode,ft.name feeTypeName
 from members m 
 left join member_validates mv on mv.memberid=m.id
 left join simpletypes ft on ft.id=mv.feetypeid
 group by m.id
 having mv.startvalidate=max(mv.startvalidate) )
where name like '����%'
 ;

select * from 
 (select m.idnumber idnumber,m.name,m.mobile,m.idtypename,m.idnumber,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName
 from members m 
 left join member_validates mv on mv.memberid=m.id
 left join simpletypes ft on ft.id=mv.feetypeid
 group by m.id
 having mv.startvalidate=max(mv.startvalidate)  
)
 where idnumber='44030520120905911X'
 ;


----------------Ϊ����2020��2��1��֮���ڵĻ�Ա����һ������Ч�ڣ��¹����飩----------------------------
--�޸�������������
update member_validates set startvalidate='2020/06/01' where startvalidate='2020//06/01';
update member_validates set endvalidate='2021/06/01' where endvalidate='2021//06/01';

--��ѯ����2020��2��1��֮���ڵ�
 select m.id memberid,m.name membername,mv.startvalidate startvalidate,mv.endvalidate endvalidate,
ft.id feetypeid,ft.code feetypecode,ft.name feetypename
 from members m 
 left join member_validates mv on mv.memberid=m.id
 left join simpletypes ft on ft.id=mv.feetypeid 
where endvalidate>='2020/02/01' and endvalidate<='9999/01/01'
 group by m.id
 having mv.startvalidate=max(mv.startvalidate) 
 ;

--������
create table temp_mvalidates as 
 select m.id memberid,m.name membername,mv.startvalidate startvalidate,mv.endvalidate endvalidate,
ft.id feetypeid,ft.code feetypecode,ft.name feetypename
 from members m 
 left join member_validates mv on mv.memberid=m.id
 left join simpletypes ft on ft.id=mv.feetypeid 
where endvalidate>='2020/02/01' and endvalidate<='9999/01/01'  
 group by m.id
 having mv.startvalidate=max(mv.startvalidate) 
;

--����һ���µ�end��Ч��
ALTER TABLE temp_mvalidates ADD COLUMN newendvalidate text;
--������µ���Ч��
update temp_mvalidates set newendvalidate=replace(date(replace(temp_mvalidates.endvalidate,'/','-'), '+1 month'),'-','/');
--�����¼�¼��member_validates
insert into member_validates(memberid,startvalidate,endvalidate,feetypeid,amount,description,commitdatetime,enable) 
select memberid, endvalidate, newendvalidate, feetypeid, 0, '�¹������ڼ�ÿλ��Ա�����һ����', datetime('now') , 1 from temp_mvalidates ;
--------------------------------------------------------------------------------------------------------------

--��������
delete from members where id=157;
insert into members(name,mobile,idtypename,idnumber,description,commitdatetime,enable) values('����2','18351925259','���֤','321183199506270036','','2020-02-15 17:34:53',1);
update members set idnumber='440304199009130018' where name='����';
update members set mobile='18988781500' where name='����';
update members set idnumber='440303199004206611' where name='���ǳ�';
update members set idnumber='440301199306187716' where name='����ʢ';
update members set idnumber='362232199203080626' where name='��ʥ��';
update members set idnumber='440301198902093818' where name='����';
update members set idnumber='362201199206270420' where name='����';
update members set idnumber='440304200105253515' where name='������';
update members set idnumber='440307198610250218' where name='�����';
update members set idnumber='440183199401110323' where name='���';
update members set idnumber='440221199708121613' where name='Фܲ';
update members set idnumber='440301199011147813' where name='������';
update members set idnumber='440301198309231538' where name='ŷ��ɽ';
update members set idnumber='440306198802030088' where name='����';
update members set idnumber='440301198804038014' where name='���';
update members set idnumber='440221198807010033' where name='������';
update members set idnumber='440306199503131828' where name='������';
update members set idnumber='440301199305085427' where name='������';
update members set idnumber='440301198707115110' where name='���Ľ�';


*******************************************************
����������صı���������ʦ�����Ͽ�ʱ�䣬��ʦ�Ͽδ򿨣�ѧ��ԤԼ�ϿΣ�ѧ���Ͽδ򿨵ȣ�
*******************************************************
--calendars ��
create table calendars(
id integer primary key not null,
roleid integer null,
recurrencerule text null, --Recurrence Rule�ݹ���� ʱ���ظ����� RFC2445��׼�е�Recurrence Rule��https://www.cnblogs.com/jcli/p/calendar_recur_rule.html��
starttime text,
endtime text,
event ntext,
eventtype ntext null,
eventplace ntext ,
actorlessthan inteter,
description ntext,
enable int
);

--ÿ��һ������
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=MO,WE,FR','19:30:00','21:30:00','�ϼ�������ϰ��','ԤԼ��ϰ','��������',12,'',1);
--ÿ�ܶ�����
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=TU,TH','19:30:00','21:30:00','ǰ����ϰ��','ԤԼ��ϰ','��������',12,'',1);
--ÿ��������ɽ������ϰ
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=TH','20:00:00','22:00:00','��ɽ�ۺ���ϰ��','ԤԼ��ϰ','��ɽ����',15,'',1);
--ÿ����
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','�ϼ�������ϰ��','ԤԼ��ϰ','��������',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=SA','14:00:00','16:00:00','�ٶ�������','ԤԼ��ϰ','��������',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=SA','16:30:00','18:30:00','������ϰ��','ԤԼ��ϰ','��������',12,'',1);
--ÿ����
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=SU','09:30:00','12:30:00','ǰ����ϰ��','ԤԼ��ϰ','��������',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=SU','16:30:00','18:30:00','������ϰ��','ԤԼ��ϰ','��������',12,'',1);

--ÿ�������Ϊ�д���ʦ�ۺ���ϰ��
update calendars set recurrencerule='WEEKLY;BYDAY=TU' where id=2;
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=TH','19:30:00','21:30:00','�д���ʦ�ۺ���ϰ��','ԤԼ��ϰ','��������',15,'',1);

--��һ��������ʦ����ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=MO,WE,FR','19:30:00','21:30:00','�ϼ�������ϰ��','����ǩ��','��������',2,'',1);
--ÿ��������ɽ������ϰ��ʦ����ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=TH','20:00:00','22:00:00','��ɽ�ۺ���ϰ��','����ǩ��','��ɽ����',2,'',1);
--������ʦ����ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','�ϼ�������ϰ��','����ǩ��','��������',2,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=SA','14:00:00','16:00:00','�ٶ�������','����ǩ��','��������',2,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=SA','16:30:00','18:30:00','������ϰ��','����ǩ��','��������',2,'',1);
--����������ʦ����ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=SU','09:30:00','12:30:00','ǰ����ϰ��','����ǩ��','��������',1,'',1);
--����������ʦ����ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=SU','16:30:00','18:30:00','������ϰ��','����ǩ��','��������',12,'',1);

--��һ��������ʦ�Ͽ�ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=MO,TH','22:00:00','22:30:00','��������ֱ����','����ǩ��','��������',1,'',1);

--��������������ʦ�Ͽ�ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=WE,SU','22:00:00','22:30:00','��������ֱ����','����ǩ��','��������',1,'',1);


--�ܶ���һ��һ������ʦ�Ͽ�ǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=TU,FR','20:00:00','20:45:00','��������һ��һ','����ǩ��','��ҵ΢�� ��������һ��һ�����㣩',1,'',1);

--��һ�ڲ���
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','��һ�����ϼ���ϰ��','ԤԼ��ϰ','��������',12,'',1);
--�������ϰ
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'ONTIME;2020-06-27','09:30:00','12:30:00','�������ǰ����ϰ��','ԤԼ��ϰ','��������',12,'',1);

--ÿ�����һ����δ��8-2������
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'MONTHLY;BYDAY=-1SU','14:30:00','16:30:00','8-2��������λ���','ԤԼ��ϰ','��������',12,'',1);

--��ʱ���ӵ�8-2������
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'ONTIME;2020-05-03','14:30:00','16:30:00','8-2��������λ���','��������','��������',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'ONTIME;2020-06-07','14:30:00','16:30:00','8-2��������λ���','��������','��������',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'ONTIME;2020-07-05','14:30:00','16:30:00','8-2��������λ���','��������','��������',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'ONTIME;2020-08-23','14:30:00','16:30:00','8-2��������λ���','��������','��������',15,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'ONTIME;2020-08-23','09:00:00','12:00:00','1��������λ���','��������','��������',66,'',1);

--���̴����ϰ
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������Ա'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','���̴���ϰ(�ϼ�)','ԤԼ��ϰ','��������',20,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','���̴���ϰ(�ϼ�)','����ǩ��','��������',2,'',1);

--�����һ��һ����ʦǩ��
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-05-10','22:00:00','22:45:00','��������һ��һ','����ǩ��','��ҵ΢�� ��������һ��һ������棩',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-05-13','22:00:00','22:45:00','��������һ��һ','����ǩ��','��ҵ΢�� ��������һ��һ������棩',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-05-17','22:00:00','22:45:00','��������һ��һ','����ǩ��','��ҵ΢�� ��������һ��һ������棩',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-05-20','22:00:00','22:45:00','��������һ��һ','����ǩ��','��ҵ΢�� ��������һ��һ������棩',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-05-24','22:00:00','22:45:00','��������һ��һ','����ǩ��','��ҵ΢�� ��������һ��һ������棩',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-05-31','22:00:00','22:45:00','��������һ��һ','����ǩ��','��ҵ΢�� ��������һ��һ������棩',1,'',1);

--ӨӨ���漪����һ�ڿ�
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-05-29','22:00:00','23:00:00','��������ѵ����','����ǩ��','���漪����ʦ',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='������ʦ'),'ONTIME;2020-06-25','22:00:00','23:00:00','��������ѵ����','����ǩ��','���漪����ʦ',1,'',1);


--calendar_instances��
create table calendar_instances(
id integer primary key not null,
calendarid integer not null,
userid inteter,
startdatetime text,
enddatetime text,
description ntext,
commitdatetime datetime not null,
enable int
);

select *,cr.code roleCode,cr.name coleName from calendars c 
left join simpletypes cr on c.roleid=cr.id where cr.id in (25,28) and c.enable=1;

--��ѯָ����ʼʱ��ĳ������
select ci.startdatetime,ci.calendarid,u.name,c.event ,c.recurrencerule,ci.enable  
from calendar_instances ci 
left join users u on ci.userid=u.id 
left join calendars c on ci.calendarid=c.id 
where ci.enable=1 and ci.startdatetime like '2020-06-03%';
--where ci.enable=1 and ci.startdatetime='2020-06-05 19:30:00';

--��ѯ��ʦ�γ�ǩ����ϸ
select u.name,ci.startdatetime,c.event,c.eventtype,c.enable from calendar_instances ci 
left join calendars c on ci.calendarid=c.id 
left join simpletypes r on c.roleid=r.id 
left join users u on ci.userid=u.id 
where (r.code='KENDO_TEACHER' or r.code='JA_TEACHER') and ci.enable=1 
and startdatetime>='2020-04-01 00:00:00' 
and startdatetime<='2020-06-30 23:59:59' 
and u.name='��ӨӨ' 
order by ci.startdatetime asc;

--��ѯĳһ����˭����
select u.name,ci.startdatetime,c.event,c.eventtype,c.enable from calendar_instances ci 
left join calendars c on ci.calendarid=c.id 
left join simpletypes r on c.roleid=r.id 
left join users u on ci.userid=u.id 
where (r.code='KENDO_TEACHER' or r.code='JA_TEACHER') and ci.enable=1 
and startdatetime>='2020-06-27 00:00:00' 
and startdatetime<='2020-06-27 23:59:59' 
order by ci.startdatetime asc;

--��ѯ��λ��ʦĳ��ʱ��Ŀγ�ǩ��������
select name,count(*)  from (
select u.name name,ci.startdatetime,c.event,c.eventtype,c.enable from calendar_instances ci 
left join calendars c on ci.calendarid=c.id 
left join simpletypes r on c.roleid=r.id 
left join users u on ci.userid=u.id 
where (r.code='KENDO_TEACHER' or r.code='JA_TEACHER') and ci.enable=1 
and startdatetime>='2020-07-01 00:00:00' 
and startdatetime<='2020-07-31 23:59:59' 
) group by name;


*****************************************
��Ҫ���͵Ķ�ʱ����
*****************************************
create table scheduled_tasks(
id integer primary key not null,
userid integer not null, 
wxtemplateid text,
wxtemplate ntext,
msgurl text,
keywords ntext, -- �ԡ�__���ָ�Ķ���ؼ���
description ntext,
senddatetime datetime,
issent int, --0:δ���� 1:�ѷ���
enable int
);



*****************************************
�γ�Ӫ��������� ----��δʵ��
*****************************************
--�γ�������Ϣ��articles����
insert into simpletypes values(null,'COURSE,'�γ�','ARTICLETYPE','�������ͣ��γ�',1);
--Ӫ������ͷ�simpletypes����
--���磺�����Ż� des=9.5��   �Ż�ȯ drs=100Ԫ   ƴ�� des=3��
insert into simpletypes values(null,'FD001','�����Ż�','MarketingType','9',1); --�����Ż�9��

--�γ̶��۹�ϵ �� ��Ʒ��Ϣ products
create table products(
id integer primary key not null,
articlesid integer not null, --�γ�������Ϣ
price real, --�۸�
realprice real, --ʵ�ʼ۸�
description ntext,
commitdatetime datetime,
enable int
);

--������һ����������һ�ſγ̣�
create table orders(
id integer primary key not null,
productid integer, --��Ʒid
userid integer not null, --�û�id
marketingid integer, --�μӵ�Ӫ���id(simpletypes.id)
price real, --ʵ�����
paymentchannel ntext, --֧������
pchannelorderid text, --֧����ˮ�ţ�ĳ������֧����ˮ��
ispaied int, --֧��״̬����֧����δ֧��
description ntext,
commitdatetime datetime,
enable int
);

--����Ա���������sales��û������Ա��ɫ��ȫԱ��������Ա��
create table orders(
id integer primary key not null,
userid integer not null, --�û�id
orderid integer, --����id
marketingid integer, --�μӵ�Ӫ���id(simpletypes.id)
description ntext,
commitdatetime datetime,
enable int
);


--����
0 �õ��Լ���ר������֮�󣬺�����ͨ��������ӹ�����9���Ż�
1 ��������γ̣��μ�ƴ�Ż��ƴ�������󣬵õ��Żݼ۸�֧����������ָ���γ�
�Ҵ�����ƴ�ţ����������Ҳμӵ�ƴ�ţ���������
2 ���򽣵�����Σ�����ԤԼ
3 ֱ�ӹ�������γ̣�������ָ���γ�


****************************
��Ӫ֧��sql
****************************
-- �����ڵ�ԤԼ����ͳ�Ʊ�
select commitdate,count(commitdate) count  from (
select substr(commitdatetime,0,11) commitdate
from bookings ) 
group by commitdate 
order by commitdate asc
;

-- ��ʱ����ԤԼ����ͳ�Ʊ�
select commitdate,count(commitdate) count  from (
select substr(commitdatetime,12,2) commitdate
from bookings ) 
group by commitdate 
order by commitdate desc
;

