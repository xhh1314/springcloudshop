create database homepage default character set utf8;
use homepage;

create table category(
id int(11) auto_increment,
uuid varchar(255) not null UNIQUE ,
name varchar(255) not null,
description varchar(255),
primary key(id)
);
create unique index uk_category_uuid on category(uuid(20));

create table subdivide(
id int(11) not null auto_increment,
uuid varchar(255) not null unique,
name varchar(255) not null,
description varchar(255) ,
ct_uuid varchar(255) not null,
primary key(id),
constraint fk_subdivide_category foreign key(ct_uuid) references category(uuid)
);
create index idx_subdivide_name on subdivide(name(20));

create table product(
id int(11) auto_increment,
uuid varchar(255) not null unique,
name varchar(255) not null,
orignalprice float ,
promoteprice float,
stock int(11),
createdate datetime,
sb_uuid varchar(255) not null,
primary key(id),
constraint fk_propduct_subdivide foreign key(sb_uuid) references subdivide(uuid)
);

create index idx_product_name on product(name);
create index idx_product_promoteprice on product(promoteprice);

create table property(
id int(11) auto_increment,
uuid varchar(255) not null unique,
name varchar(255) not null,
sb_uuid varchar(255) not null,
primary key(id),
constraint fk_property_subdivide foreign key(sb_uuid) references subdivide(uuid)
);

create table propertyvalue(
id int(11) auto_increment primary key,
value varchar(255) default null,
pp_uuid varchar(255) not null,
pd_uuid varchar(255) not null
);

CREATE TABLE productimage (
  id int(11) NOT NULL AUTO_INCREMENT,
  pd_uuid varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_productimage_product FOREIGN KEY (pd_uuid) REFERENCES product (uuid)
) ;

CREATE TABLE review (
  id int(11) NOT NULL AUTO_INCREMENT,
  content varchar(4000) DEFAULT NULL,
  u_uuid varchar(255) DEFAULT NULL,
  pd_uuid varchar(255) DEFAULT NULL,
  createDate datetime DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_review_product FOREIGN KEY (pd_uuid) REFERENCES product (uuid),
  CONSTRAINT fk_review_user FOREIGN KEY (u_uuid) REFERENCES user (uuid)
);
