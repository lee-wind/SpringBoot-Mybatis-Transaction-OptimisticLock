create table if not exists goods_record(
  record_id int auto_increment,
  goods_id int not null,
  user_name varchar(20) not null unique,
  primary key (record_id)
)engine=InnoDB default charset=utf8;

delete from goods_record;

select * from goods_record;