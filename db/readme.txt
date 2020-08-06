--查询某天的缴费是谁
select m.name,mv.amount,mv.commitdatetime from members m 
join member_validates mv on mv.memberid=m.id 
where mv.commitdatetime like '2020-06-23%';

--有部分member没有userid修复后，验证使用
select m.name,u.name,u.id 
from members m 
left join users u on m.userid=u.id 
where m.name in ('李卓林','陈云起','方智绪');

--月练习人数
select count(*) from(
select u.name name,count(*) count from calendar_instances ci 
join users u on ci.userid=u.id 
join calendars c on ci.calendarid=c.id 
where c.eventtype='预约练习' and startdatetime>='2020-06-01 00:00:00' and startdatetime<='2020-06-30 23:59:59'   and ci.enable=1 
group by u.name) ;

--月练习排名
select * from(
select u.name name,count(*) count from calendar_instances ci 
join users u on ci.userid=u.id 
join calendars c on ci.calendarid=c.id 
where c.eventtype='预约练习' and startdatetime>='2020-07-01 00:00:00' and startdatetime<='2020-07-31 23:59:59'  and ci.enable=1 
group by u.name) order by count desc;


--月练习鸽子王
select * from(
select u.name name,count(*) count from calendar_instances ci 
join users u on ci.userid=u.id 
join calendars c on ci.calendarid=c.id 
where c.eventtype='预约练习' and startdatetime>='2020-07-01 00:00:00' and startdatetime<='2020-07-31 23:59:59'  and ci.enable=0 
group by u.name) order by count desc limit 1;

--命令行加载数据库：
sqlite3 mkendo201811.db

--帮助
.help

--查询所有表格
.tables

--格式化查询结果
.header on
.mode column
.timer on

--查询所有表格
SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;

--查询表格中的字段
PRAGMA  table_info("members");

*******************************************************
数据库设计的一些规则：
*******************************************************
1 表名不同单词之间带下划线，全小写
2 字段名不同单词之间不带下划线，全小写


*******************************************************
预约体验相关的表
*******************************************************
--bookings 预约体验表：
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

placetimeid --simpletypes外键
whereknowusid --simpletypes外键

alter table bookings add height text;  
alter table bookings add weight text;  

--simpletypes 简单类型表 
--id,code,name,typecode(简单类型的类型),description(简单类型描述),1
create table simpletypes(
id integer primary key not null,
code text key not null,
name ntext not null,
typecode text not null,
description text,
enable int
);

insert into simpletypes values(null,'FT01PM','福田道场 周一晚19:30--21:30','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'FT03PM','福田道场 周三晚19:30--21:30','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'FT05PM','福田道场 周五晚19:30--21:30','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'FT06PM','福田道场少儿剑道 周六下午 14:00--16:00','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'FT06PM2','福田道场 周六下午 16:00--18:00','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'FT07AM','福田道场 周日上午9:30--12:30 仅限观摩','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'NS02PM','南山道场 周二晚20:00--22:00','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'NS04PM','南山道场 周四晚20:00--22:00','IntroLessonPlaceTime','初心课程上课场次',1);

insert into simpletypes values(null,'FT06PM14','福田道场 周六下午 14:30--16:30','IntroLessonPlaceTime','初心课程上课场次',1);
insert into simpletypes values(null,'FT07PM14','福田道场 周日下午 14:30--16:30','IntroLessonPlaceTime','初心课程上课场次',1);

insert into simpletypes values(null,'DZMT','大众美团看到哒','WhereKnowUs','从哪里知道我们的',1);
insert into simpletypes values(null,'NETSEARCH','网上搜到哒','WhereKnowUs','从哪里知道我们的',1);
insert into simpletypes values(null,'FRIEND','好朋友告诉我哒','WhereKnowUs','从哪里知道我们的',1);
insert into simpletypes values(null,'MOMENTS','朋友圈看到哒','WhereKnowUs','从哪里知道我们的',1);


update simpletypes set description='会费标准:2015年之前加入的剑友和所有前辈' where code='FCPY3000';
update simpletypes set description='会费标准:2015年之后加入的剑友' where code='FCPY3500';
update simpletypes set description='会费标准:2016年之后加入的剑友' where code='FCPY4500';
update simpletypes set description='会费标准:2017年之后加入的剑友' where code='FCPY6000';
update simpletypes set description='会费标准:2017年之后加入的剑友' where code='FCHY4000';

insert into simpletypes values(null,'KENDO_MEMBER','剑道会员','ROLE','角色',1);
insert into simpletypes values(null,'RESTER_MEMBER','注册会员','ROLE','角色',1);
insert into simpletypes values(null,'KENDO_TEACHER','带课老师','ROLE','角色',1);
insert into simpletypes values(null,'NEWS_EDITOR','宣传','ROLE','角色',1);
insert into simpletypes values(null,'SUPER_ADMIN','超级管理员','ROLE','角色',1);
insert into simpletypes values(null,'JA_TEACHER','日语老师','ROLE','角色',1);
insert into simpletypes values(null,'JA_MEMBER','日语会员','ROLE','角色',1);



--用户角色关系表
create table user_roles(
id integer primary key not null,
userid integer not null,
roleid integer not null,
description ntext,
enable int
);

insert into user_roles(userid,roleid,description,enable) 
values(1, (select id from simpletypes where code='SUPER_ADMIN'), '黄云松 超级管理员',1);

insert into user_roles(userid,roleid,description,enable) 
values(2, (select id from simpletypes where code='SUPER_ADMIN'), '胡厚存 超级管理员',1);

insert into user_roles(userid,roleid,description,enable) 
values(3, (select id from simpletypes where code='NEWS_EDITOR'), '邹思 宣传',1);
insert into user_roles(userid,roleid,description,enable) 
values(3, (select id from simpletypes where code='KENDO_MEMBER'), '邹思 剑道会员',1);

insert into user_roles(userid,roleid,description,enable) 
values(4, (select id from simpletypes where code='KENDO_MEMBER'), '张美湘 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(4, (select id from simpletypes where code='KENDO_TEACHER'), '张美湘 带课老师',1);
insert into user_roles(userid,roleid,description,enable) 
values(6, (select id from simpletypes where code='KENDO_MEMBER'), '洪一 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(7, (select id from simpletypes where code='KENDO_MEMBER'), '安睿彬 剑道会员',1);

insert into user_roles(userid,roleid,description,enable) 
values(12, (select id from simpletypes where code='KENDO_TEACHER'), '刘晓苗 带课老师',1);

insert into user_roles(userid,roleid,description,enable) 
values(30, (select id from simpletypes where code='JA_TEACHER'), '张聪聪 日语老师',1);


insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='邱莹莹'), (select id from simpletypes where code='JA_TEACHER'), '邱莹莹 日语老师',1);

insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='梁致航'), (select id from simpletypes where code='KENDO_TEACHER'), '梁致航 带课老师',1);

insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='彭新'), (select id from simpletypes where code='KENDO_TEACHER'), '彭新 带课老师',1);

1|1|29|黄云松 超级管理员|1
2|2|29|胡厚存 超级管理员|1
3|3|28|邹思 宣传|1
4|3|25|邹思 剑道会员|1
5|4|25|张美湘 剑道会员|1
6|4|27|张美湘 带课老师|1
7|6|25|洪一 剑道会员|1
8|7|25|安睿彬 剑道会员|1

9|8|25|徐榛 剑道会员|1
10|11|25|梁致航 剑道会员|1
11|12|25|刘晓苗 剑道会员|1
12|13|25|李滔 剑道会员|1
13|14|25|陈文翔 剑道会员|1
14|15|25|雷镇江 剑道会员|1
15|16|25|范贝贝 剑道会员|1
16|18|25|何友宁 剑道会员|1
17|19|25|苏惠文 剑道会员|1
18|20|25|侯治信 剑道会员|1
19|21|25|厉翔 剑道会员|1
20|22|26|小君 注册会员|1

insert into user_roles(userid,roleid,description,enable) 
values(8, 25, '徐榛 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(11, 25, '梁致航 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(12, 25, '刘晓苗 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(13, 25, '李滔 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(14, 25, '陈文翔 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(15, 25, '雷镇江 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(16, 25, '范贝贝 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(18, 25, '何友宁 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(19, 25, '苏惠文 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(20, 25, '侯治信 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(21, 25, '厉翔 剑道会员',1);
insert into user_roles(userid,roleid,description,enable) 
values(22, 26, '小君 剑道会员',1);

insert into user_roles(userid,roleid,description,enable) 
values(22, 26, '钟棂骜 剑道会员',1);


--查看用户角色关系
select ur.id urid,u.id uid,u.name,r.name,ur.description from users u 
join user_roles ur on ur.userid=u.id 
join simpletypes r on ur.roleid=r.id where u.name='卢泳宏';

--增加用户角色为剑道会员
insert into user_roles(userid,roleid,description,enable) 
values((select id from users where name='李冰瑜'), 
(select id from simpletypes where code='KENDO_MEMBER'), '李冰瑜 剑道会员',1);


delete from user_roles where id=194;

select r.name  from users u 
 left join user_roles ur on ur.userid=u.id  
 left join simpletypes r on ur.roleid=r.id where u.mobile='13128855200';


select r.name  from users u 
 left join user_roles ur on ur.userid=u.id  
 left join simpletypes r on ur.roleid=r.id where u.mobile='13128855200';

*******************************************************
注册登录相关的表
*******************************************************
--users 注册用户表：
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

insert into users values(null,'西瓜','13128855200','mkendo.cn','','','','','2020-01-31 00:00:00','',1);
insert into users values(null,'我不是西瓜','15889489370','mkendo.cn','','','','','2020-01-31 00:00:00','',1);
insert into users values(null,'思思','13417508531','mkendo.cn','','','','','2020-02-04 00:00:00','',1);
update members set userid=-1 ;


*******************************************************
文章相关的表
*******************************************************
create table articles(
id integer primary key not null,
code text not null,
typeid integer not null, -- simpletypes外键  文章类型 NEWS新闻，ACTIVITY活动通知，BOLGblog... 为了简单，活动和其它文章不做细分
title ntext not null, --文章标题
subtitle ntext not null, --文章副标题
shortcontent ntext ntext not null, --文章摘要
content ntext not null, --文章内容
imgurl text , --文章主图url
eventstartdatetime datetime ,  -- 活动开始/发生时间
eventenddatetime datetime ,  --活动结束时间
registerstartdatetime datetime , --报名开始时间
registerenddatetime  datetime , --报名结束时间
eventaddress ntext , --事件发生地点
eventaddressurl text, --事件发生地点url 用于地图
createdatetime datetime not null, --文章创建时间
creatername ntext , --文章作者 以后可以和member表关联起来
description ntext,
enable int not null
);

insert into simpletypes values(null,'NEWS','新闻','ARTICLETYPE','文章类型：新闻',1);
insert into simpletypes values(null,'ACTIVITY','活动','ARTICLETYPE','文章类型：活动',1);
insert into simpletypes values(null,'COURSE,'课程','ARTICLETYPE','文章类型：课程',1);

insert into articles values(
null,
'2019mkendodh',
(select id from simpletypes where code='NEWS'),
'2019明剑大会',
'明剑喊你回来聚聚了',
'在中村老师的倡议和带领下，明剑馆决定于2019年11月30日举办“明剑馆剑道大会”（下面简称“明剑大会”或“大会”）。本次明剑大会将是我馆全员参与的年度盛会。',
'<p>本次大会的宗旨是：</p>
<p><b>全员参与</b>。昔日一同练习的剑友可以重聚，今日共同努力的伙伴可以携手，未来互相鼓励的彼此可以相识；</p>
<p><b>检验自我</b>。本次大会的另一目的则是检验各位剑友平日的练习成果，促使大家追求增益精进的目标；</p>
<p><b>审判试炼</b>。为馆内有段前辈们提供一次锻炼审判与组织比赛的机会，皆有所得。</p>',
'2019mkendodh120.jpg',
datetime('now', '+10 day'),
datetime('now', '+11 day'),
datetime('now'),
datetime('now', '+6 day'),
'深圳明剑馆',
'',
datetime('now'),
'西瓜',
'说明description',
1
);

insert into articles values(
null,
'2019mkendocp',
(select id from simpletypes where code='NEWS'),
'明剑馆剑道裁判讲习会',
'重磅消息！本月27号明剑馆剑道裁判讲习会',
'此次讲习会我们将学习到，如何做好裁判，裁判的规则，礼仪，以及如何欣赏比赛。有无段位有无护具皆可参加。',
'<p>本裁判技能是剑道学习生涯中很重要的一环，对于个人来说不仅是学到了一些新的知识，更是为将来的比赛做充足的铺垫。</p>
<p>剑道比赛的官方语言是日语、英语，如何在比赛中听得懂裁判的口令，看得懂旗语，懂得规则是很重要的。在比赛中得本的标准是什么，遇到突发状况如何应对，哪些是比赛中允许的行为，哪些是明令禁止的行为？这些无论对于初学者来说，还是对于前辈们，都是很重要的知识，亦需要在比赛中加以注意。</p>',
'caipan120.jpg',
datetime('now', '+5 day'),
datetime('now', '+6 day'),
datetime('now'),
datetime('now', '+6 day'),
'深圳明剑馆',
'',
datetime('now'),
'西瓜',
'说明description',
1
);

*******************************************************
会员相关的表
*******************************************************
--增加费用标准
insert into simpletypes values(null,'FCPY6000','续费一年6000','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FCPY4500','续费一年4500','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FCPY3500','续费一年3500','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FCPY3000','续费一年3000','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FCPYVIP0','VIP免费','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FCHY3500','续费半年3500','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FCHY4000','续费半年4000','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FNPY10000','首次缴费一年10000','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FNPY6000','首次缴费一年6500','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FNHY4000','首次缴费半年4500','MemberFeeType','会费标准',1);
insert into simpletypes values(null,'FTOTHER','其它优惠类型','MemberFeeType','会费标准',1);

--会员表
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
values('黄云松','13128855200','身份证','320305197902150927',1,'','','2020-02-11 15:00:00',1);
 
insert into members(name,mobile,idtypename,idnumber,userid,wxopenid,description,commitdatetime,enable)
values('胡厚存','15889489370','身份证','330824197709244911',2,'','','2020-02-11 15:00:00',1);

--会员注册信息表（报名时填写的表格）
create table member_registerinfos(
id integer primary key not null,
memberid integer not null,
email text,
wechatno text,
occupation ntext, --职业
company ntext, --工作单位
address ntext,
birthday text,
height text,
fromdojo ntext,
commitdatetime datetime not null,
enable int
);

--会员考试报名信息表

--会员级段位表


--会员有效期表:
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
values(2,'2010/11/01','9999/12/31','2020-02-11 15:00:00','馆长VIP',19,0);

--更多多行validate测试数据
insert into members(name,mobile,idtypename,idnumber,userid,wxopenid,description,commitdatetime,enable)
values('胡正昊','15889489370','身份证','44030520120905911X','','','','2020-02-11 15:00:00',1);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='胡正昊'),'2012/09/05','2013/09/05','2012-09-05 09:00:00','第一次缴费报名',22,6500);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='胡正昊'),'2013/09/05','2014/09/05','2013-09-05 09:00:00','续费3000',18,3000);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='胡正昊'),'2014/09/05','2015/09/05','2014-09-05 09:00:00','续费3000',18,3000);

--查询sql
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
where name like '测试%'
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


----------------为所有2020年2月1日之后到期的会员增加一个月有效期（新冠疫情）----------------------------
--修复两个错误数据
update member_validates set startvalidate='2020/06/01' where startvalidate='2020//06/01';
update member_validates set endvalidate='2021/06/01' where endvalidate='2021//06/01';

--查询所有2020年2月1日之后到期的
 select m.id memberid,m.name membername,mv.startvalidate startvalidate,mv.endvalidate endvalidate,
ft.id feetypeid,ft.code feetypecode,ft.name feetypename
 from members m 
 left join member_validates mv on mv.memberid=m.id
 left join simpletypes ft on ft.id=mv.feetypeid 
where endvalidate>='2020/02/01' and endvalidate<='9999/01/01'
 group by m.id
 having mv.startvalidate=max(mv.startvalidate) 
 ;

--存起来
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

--增加一个新的end有效期
ALTER TABLE temp_mvalidates ADD COLUMN newendvalidate text;
--计算好新的有效期
update temp_mvalidates set newendvalidate=replace(date(replace(temp_mvalidates.endvalidate,'/','-'), '+1 month'),'-','/');
--插入新记录到member_validates
insert into member_validates(memberid,startvalidate,endvalidate,feetypeid,amount,description,commitdatetime,enable) 
select memberid, endvalidate, newendvalidate, feetypeid, 0, '新冠疫情期间每位会员免费送一个月', datetime('now') , 1 from temp_mvalidates ;
--------------------------------------------------------------------------------------------------------------

--更新数据
delete from members where id=157;
insert into members(name,mobile,idtypename,idnumber,description,commitdatetime,enable) values('王旭2','18351925259','身份证','321183199506270036','','2020-02-15 17:34:53',1);
update members set idnumber='440304199009130018' where name='王旭';
update members set mobile='18988781500' where name='王旭';
update members set idnumber='440303199004206611' where name='张亚驰';
update members set idnumber='440301199306187716' where name='连宗盛';
update members set idnumber='362232199203080626' where name='胡圣子';
update members set idnumber='440301198902093818' where name='刘澈';
update members set idnumber='362201199206270420' where name='陈潇';
update members set idnumber='440304200105253515' where name='孙续峰';
update members set idnumber='440307198610250218' where name='马贵钊';
update members set idnumber='440183199401110323' where name='黄璐';
update members set idnumber='440221199708121613' where name='肖懿';
update members set idnumber='440301199011147813' where name='黄宇钦';
update members set idnumber='440301198309231538' where name='欧阳山';
update members set idnumber='440306198802030088' where name='罗蕾';
update members set idnumber='440301198804038014' where name='蒋灏';
update members set idnumber='440221198807010033' where name='陈智勇';
update members set idnumber='440306199503131828' where name='潘晓欣';
update members set idnumber='440301199305085427' where name='张美湘';
update members set idnumber='440301198707115110' where name='林文杰';


*******************************************************
日历功能相关的表（可用于老师定义上课时间，老师上课打卡，学生预约上课，学生上课打卡等）
*******************************************************
--calendars 表
create table calendars(
id integer primary key not null,
roleid integer null,
recurrencerule text null, --Recurrence Rule递归规则 时间重复规则 RFC2445标准中的Recurrence Rule（https://www.cnblogs.com/jcli/p/calendar_recur_rule.html）
starttime text,
endtime text,
event ntext,
eventtype ntext null,
eventplace ntext ,
actorlessthan inteter,
description ntext,
enable int
);

--每周一三五晚
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=MO,WE,FR','19:30:00','21:30:00','上甲新人练习场','预约练习','福保道场',12,'',1);
--每周二四晚
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=TU,TH','19:30:00','21:30:00','前辈练习场','预约练习','福保道场',12,'',1);
--每周四晚南山道场练习
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=TH','20:00:00','22:00:00','南山综合练习场','预约练习','南山道场',15,'',1);
--每周六
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','上甲新人练习场','预约练习','福保道场',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=SA','14:00:00','16:00:00','少儿剑道班','预约练习','福保道场',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=SA','16:30:00','18:30:00','新人练习场','预约练习','福保道场',12,'',1);
--每周日
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=SU','09:30:00','12:30:00','前辈练习场','预约练习','福保道场',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=SU','16:30:00','18:30:00','新人练习场','预约练习','福保道场',12,'',1);

--每周四晚改为中村老师综合练习场
update calendars set recurrencerule='WEEKLY;BYDAY=TU' where id=2;
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=TH','19:30:00','21:30:00','中村老师综合练习场','预约练习','福保道场',15,'',1);

--周一三五晚老师带课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=MO,WE,FR','19:30:00','21:30:00','上甲新人练习场','带课签到','福保道场',2,'',1);
--每周四晚南山道场练习老师带课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=TH','20:00:00','22:00:00','南山综合练习场','带课签到','南山道场',2,'',1);
--周六老师带课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','上甲新人练习场','带课签到','福保道场',2,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=SA','14:00:00','16:00:00','少儿剑道班','带课签到','福保道场',2,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=SA','16:30:00','18:30:00','新人练习场','带课签到','福保道场',2,'',1);
--周日下午老师带课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=SU','09:30:00','12:30:00','前辈练习场','带课签到','福保道场',1,'',1);
--周日下午老师带课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=SU','16:30:00','18:30:00','新人练习场','带课签到','福保道场',12,'',1);

--周一四日语老师上课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'WEEKLY;BYDAY=MO,TH','22:00:00','22:30:00','明剑日语直播课','讲课签到','福保道场',1,'',1);

--周三周日日语老师上课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'WEEKLY;BYDAY=WE,SU','22:00:00','22:30:00','明剑日语直播课','讲课签到','福保道场',1,'',1);


--周二五一对一日语老师上课签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'WEEKLY;BYDAY=TU,FR','20:00:00','20:45:00','明剑日语一对一','讲课签到','企业微信 明剑日语一对一（金鱼）',1,'',1);

--五一节补班
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','五一补班上甲练习场','预约练习','福保道场',12,'',1);
--端午节练习
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'ONTIME;2020-06-27','09:30:00','12:30:00','端午调课前辈练习场','预约练习','福保道场',12,'',1);

--每月最后一个周未的8-2级考试
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'MONTHLY;BYDAY=-1SU','14:30:00','16:30:00','8-2级剑道级位审查','预约练习','福保道场',12,'',1);

--临时增加的8-2级考试
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'ONTIME;2020-05-03','14:30:00','16:30:00','8-2级剑道级位审查','报名考试','福保道场',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'ONTIME;2020-06-07','14:30:00','16:30:00','8-2级剑道级位审查','报名考试','福保道场',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'ONTIME;2020-07-05','14:30:00','16:30:00','8-2级剑道级位审查','报名考试','福保道场',12,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'ONTIME;2020-08-23','14:30:00','16:30:00','8-2级剑道级位审查','报名考试','福保道场',15,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'ONTIME;2020-08-23','09:00:00','12:00:00','1级剑道级位审查','报名考试','福保道场',66,'',1);

--福教大版练习
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='剑道会员'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','福教大练习(上甲)','预约练习','福保道场',20,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='带课老师'),'WEEKLY;BYDAY=SA','09:30:00','12:30:00','福教大练习(上甲)','带课签到','福保道场',2,'',1);

--日语课一对一，老师签到
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-05-10','22:00:00','22:45:00','明剑日语一对一','讲课签到','企业微信 明剑日语一对一（胡厚存）',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-05-13','22:00:00','22:45:00','明剑日语一对一','讲课签到','企业微信 明剑日语一对一（胡厚存）',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-05-17','22:00:00','22:45:00','明剑日语一对一','讲课签到','企业微信 明剑日语一对一（胡厚存）',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-05-20','22:00:00','22:45:00','明剑日语一对一','讲课签到','企业微信 明剑日语一对一（胡厚存）',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-05-24','22:00:00','22:45:00','明剑日语一对一','讲课签到','企业微信 明剑日语一对一（胡厚存）',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-05-31','22:00:00','22:45:00','明剑日语一对一','讲课签到','企业微信 明剑日语一对一（胡厚存）',1,'',1);

--莹莹代替吉吉上一节课
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-05-29','22:00:00','23:00:00','明剑日语训练课','讲课签到','代替吉吉老师',1,'',1);
insert into calendars(roleid,recurrencerule,starttime,endtime,event,eventtype,eventplace,actorlessthan,description,enable) 
values((select id from simpletypes where name='日语老师'),'ONTIME;2020-06-25','22:00:00','23:00:00','明剑日语训练课','讲课签到','代替吉吉老师',1,'',1);


--calendar_instances表
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

--查询指定起始时间的场次情况
select ci.startdatetime,ci.calendarid,u.name,c.event ,c.recurrencerule,ci.enable  
from calendar_instances ci 
left join users u on ci.userid=u.id 
left join calendars c on ci.calendarid=c.id 
where ci.enable=1 and ci.startdatetime like '2020-06-03%';
--where ci.enable=1 and ci.startdatetime='2020-06-05 19:30:00';

--查询老师课程签到明细
select u.name,ci.startdatetime,c.event,c.eventtype,c.enable from calendar_instances ci 
left join calendars c on ci.calendarid=c.id 
left join simpletypes r on c.roleid=r.id 
left join users u on ci.userid=u.id 
where (r.code='KENDO_TEACHER' or r.code='JA_TEACHER') and ci.enable=1 
and startdatetime>='2020-04-01 00:00:00' 
and startdatetime<='2020-06-30 23:59:59' 
and u.name='邱莹莹' 
order by ci.startdatetime asc;

--查询某一天是谁带课
select u.name,ci.startdatetime,c.event,c.eventtype,c.enable from calendar_instances ci 
left join calendars c on ci.calendarid=c.id 
left join simpletypes r on c.roleid=r.id 
left join users u on ci.userid=u.id 
where (r.code='KENDO_TEACHER' or r.code='JA_TEACHER') and ci.enable=1 
and startdatetime>='2020-06-27 00:00:00' 
and startdatetime<='2020-06-27 23:59:59' 
order by ci.startdatetime asc;

--查询各位老师某段时间的课程签到总数量
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
需要发送的定时任务
*****************************************
create table scheduled_tasks(
id integer primary key not null,
userid integer not null, 
wxtemplateid text,
wxtemplate ntext,
msgurl text,
keywords ntext, -- 以“__”分割的多个关键词
description ntext,
senddatetime datetime,
issent int, --0:未发送 1:已发送
enable int
);



*****************************************
课程营销策略相关 ----尚未实现
*****************************************
--课程描述信息放articles表中
insert into simpletypes values(null,'COURSE,'课程','ARTICLETYPE','文章类型：课程',1);
--营销活动类型放simpletypes表中
--例如：朋友优惠 des=9.5折   优惠券 drs=100元   拼团 des=3人
insert into simpletypes values(null,'FD001','好友优惠','MarketingType','9',1); --好友优惠9折

--课程定价关系 即 产品信息 products
create table products(
id integer primary key not null,
articlesid integer not null, --课程描述信息
price real, --价格
realprice real, --实际价格
description ntext,
commitdatetime datetime,
enable int
);

--订单（一个订单购买一门课程）
create table orders(
id integer primary key not null,
productid integer, --产品id
userid integer not null, --用户id
marketingid integer, --参加的营销活动id(simpletypes.id)
price real, --实付金额
paymentchannel ntext, --支付渠道
pchannelorderid text, --支付流水号，某渠道的支付流水号
ispaied int, --支付状态：已支付，未支付
description ntext,
commitdatetime datetime,
enable int
);

--销售员的销售情况sales（没有销售员角色，全员都是销售员）
create table orders(
id integer primary key not null,
userid integer not null, --用户id
orderid integer, --订单id
marketingid integer, --参加的营销活动id(simpletypes.id)
description ntext,
commitdatetime datetime,
enable int
);


--场景
0 拿到自己的专属链接之后，好朋友通过这个连接购买有9折优惠
1 订购日语课程，参加拼团活动，拼满人数后，得到优惠价格，支付，可以上指定课程
我创建的拼团（日历），我参加的拼团（日历）？
2 购买剑道体验课，进行预约
3 直接购买日语课程，可以上指定课程


****************************
运营支持sql
****************************
-- 按日期的预约人数统计表
select commitdate,count(commitdate) count  from (
select substr(commitdatetime,0,11) commitdate
from bookings ) 
group by commitdate 
order by commitdate asc
;

-- 按时间点的预约人数统计表
select commitdate,count(commitdate) count  from (
select substr(commitdatetime,12,2) commitdate
from bookings ) 
group by commitdate 
order by commitdate desc
;

