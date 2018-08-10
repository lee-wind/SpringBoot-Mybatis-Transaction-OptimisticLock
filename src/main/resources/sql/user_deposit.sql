create table if not exists user_deposit(
  deposit_id int auto_increment,
  deposit_amount decimal(10, 2) not null,
  version int not null,
  primary key (deposit_id)
)engine=InnoDB default charset=utf8;

insert into user_deposit(deposit_amount, version) values(800.00, 1);

update user_deposit set deposit_amount = 800.00, version = 1 where deposit_id = 1;

select * from user_deposit;

delete from user_deposit;