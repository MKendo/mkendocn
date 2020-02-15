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
insert into simpletypes values(null,'DZMT','大众美团看到哒','WhereKnowUs','从哪里知道我们的',1);
insert into simpletypes values(null,'NETSEARCH','网上搜到哒','WhereKnowUs','从哪里知道我们的',1);
insert into simpletypes values(null,'FRIEND','好朋友告诉我哒','WhereKnowUs','从哪里知道我们的',1);
insert into simpletypes values(null,'MOMENTS','朋友圈看到哒','WhereKnowUs','从哪里知道我们的',1);


*******************************************************
注册登录相关的表
*******************************************************
--users 注册用户表：
--id,name,mobile,password,wxopenid,commitdatetime,description,enable

create table users(
id integer primary key not null,
name ntext not null,
mobile text not null,
wxopenid text,
commitdatetime datetime not null,
description ntext,
memberid integer, --外键，members会员表的id
enable int,
password text not null
);

insert into users values(null,'西瓜','13128855200',null,'20200131',null,null,1,'mkendo.cn');
insert into users values(null,'我不是西瓜','15889489370',null,'20200131',null,null,1,'mkendo.cn');
insert into users values(null,'思思','13417508531',null,'20200204',null,null,1,'mkendo.cn');


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
values('胡正昊','15889489370','身份证','330824197709244911','','','','2020-02-11 15:00:00',1);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='胡正昊'),'2012/09/05','2013/09/05','2012-09-05 09:00:00','第一次缴费报名',22,6500);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='胡正昊'),'2013/09/05','2014/09/05','2013-09-05 09:00:00','续费3000',18,3000);

insert into member_validates(memberid,startValidate,endValidate,commitdatetime,description,feetypeid,amount)
values((select id from members where name='胡正昊'),'2014/09/05','2015/09/05','2014-09-05 09:00:00','续费3000',18,3000);

--查询sql
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


