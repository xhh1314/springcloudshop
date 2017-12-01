create database orderservice default character set utf8;
create table Orders(
  uuid varchar(255) not null,
  ordercode varchar(255) not null,
  address varchar(255),
  post varchar(255),
  receiver varchar(255),
  mobile varchar(255),
  usermessage varchar(255),
  createDate datetime ,
  paydate datetime ,
  deliveryDate datetime ,
  confirmDate datetime ,
  status varchar(255) ,
  u_uuid varchar(255) not null,
  primary key(uuid)
);
create index idx_u_uuid on orders(u_uuid);

create  table OrderItem (
  id int(11) not null auto_increment,
  pd_uuid varchar(255) not null,
  o_uuid varchar(255) not null,
  u_uuid varchar(255) not null,
  number int(11),
  primary key(id)

);
create INDEX idx_order_itemu_uuid ON OrderItem(u_uuid);
create INDEX idx_order_itemu_pd_uuid ON OrderItem(pd_uuid);
create INDEX idx_order_itemu_o_uuid ON OrderItem(o_uuid);