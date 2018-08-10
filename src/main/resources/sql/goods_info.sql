create table if not exists goods_info(
    goods_id int unsigned auto_increment,
    goods_name varchar(20) not null,
    goods_quantity int not null,
    primary key(goods_id)
)engine=InnoDB default charset=utf8;

insert into goods_info(goods_name, goods_quantity) values ('牙膏', 2), ('牙刷', 3);

update goods_info set goods_quantity = 2 where goods_id = 1;

select * from goods_info;