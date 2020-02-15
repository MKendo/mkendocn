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
insert into simpletypes values(null,'DZMT','�������ſ�����','WhereKnowUs','������֪�����ǵ�',1);
insert into simpletypes values(null,'NETSEARCH','�����ѵ���','WhereKnowUs','������֪�����ǵ�',1);
insert into simpletypes values(null,'FRIEND','�����Ѹ�������','WhereKnowUs','������֪�����ǵ�',1);
insert into simpletypes values(null,'MOMENTS','����Ȧ������','WhereKnowUs','������֪�����ǵ�',1);


*******************************************************
ע���¼��صı�
*******************************************************
--users ע���û���
--id,name,mobile,password,wxopenid,commitdatetime,description,enable

create table users(
id integer primary key not null,
name ntext not null,
mobile text not null,
wxopenid text,
commitdatetime datetime not null,
description ntext,
memberid integer, --�����members��Ա���id
enable int,
password text not null
);

insert into users values(null,'����','13128855200',null,'20200131',null,null,1,'mkendo.cn');
insert into users values(null,'�Ҳ�������','15889489370',null,'20200131',null,null,1,'mkendo.cn');
insert into users values(null,'˼˼','13417508531',null,'20200204',null,null,1,'mkendo.cn');


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
values('�����','15889489370','���֤','330824197709244911','','','','2020-02-11 15:00:00',1);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='�����'),'2012/09/05','2013/09/05','2012-09-05 09:00:00','��һ�νɷѱ���',22,6500);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='�����'),'2013/09/05','2014/09/05','2013-09-05 09:00:00','����3000',18,3000);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='�����'),'2014/09/05','2015/09/05','2014-09-05 09:00:00','����3000',18,3000);

--��ѯsql
 select m.name,m.mobile,m.idtypename,m.idnumber,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName
 from members m 
 join member_validates mv on mv.memberid=m.id
 join simpletypes ft on ft.id=mv.feetypeid
 group by m.id
 having mv.startvalidate=max(mv.startvalidate) 
 ;

 select m.name,m.mobile,m.idtypename,m.idnumber,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName
 from members m 
 left join member_validates mv on mv.memberid=m.id
 left join simpletypes ft on ft.id=mv.feetypeid
 group by m.id
 having mv.startvalidate=max(mv.startvalidate) 
 ;

select * from 
 (select m.idnumber idnumber,m.name,m.mobile,m.idtypename,m.idnumber,mv.startvalidate,mv.endvalidate,ft.code feeTypeCode,ft.name feeTypeName
 from members m 
 join member_validates mv on mv.memberid=m.id
 join simpletypes ft on ft.id=mv.feetypeid
 group by m.id
 having mv.startvalidate=max(mv.startvalidate)  
)
 where idnumber='44030520120905911X'
 ;


