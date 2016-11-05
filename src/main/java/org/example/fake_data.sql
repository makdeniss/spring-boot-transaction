-- create customer data
insert into customer (name, balance, bank_id) values ('tom', 1000, 1);
insert into customer (name, balance, bank_id) values ('peter', 1000, 1);
insert into customer (name, balance, bank_id) values ('dor', 1000, 1);
insert into customer (name, balance, bank_id) values ('thor', 1000, 1);
insert into customer (name, balance, bank_id) values ('corey', 1000, 1);
insert into customer (name, balance, bank_id) values ('deniss', 1000, 1);
insert into customer (name, balance, bank_id) values ('daniel', 1000, 1);
insert into customer (name, balance, bank_id) values ('kathy', 1000, 1);
insert into customer (name, balance, bank_id) values ('berry', 1000, 1);
insert into customer (name, balance, bank_id) values ('therry', 1000, 1);
insert into customer (name, balance, bank_id) values ('batman', 1000, 1);
insert into customer (name, balance, bank_id) values ('brent', 1000, 1);
insert into customer (name, balance, bank_id) values ('wayne', 1000, 1);
insert into customer (name, balance, bank_id) values ('brice', 1000, 1);
insert into customer (name, balance, bank_id) values ('scored', 1000, 1);
insert into customer (name, balance, bank_id) values ('oksana', 1000, 1);
insert into customer (name, balance, bank_id) values ('emily', 1000, 1);
insert into customer (name, balance, bank_id) values ('igor', 1000, 1);
insert into customer (name, balance, bank_id) values ('clark', 1000, 1);
insert into customer (name, balance, bank_id) values ('willem', 1000, 1);
insert into customer (name, balance, bank_id) values ('steve', 1000, 2);
insert into customer (name, balance, bank_id) values ('bro', 1000, 2);
insert into customer (name, balance, bank_id) values ('drone', 1000, 2);
insert into customer (name, balance, bank_id) values ('stepan', 1000, 2);
insert into customer (name, balance, bank_id) values ('viktor', 1000, 2);
insert into customer (name, balance, bank_id) values ('trevor', 1000, 2);
insert into customer (name, balance, bank_id) values ('joshua', 1000, 2);
insert into customer (name, balance, bank_id) values ('berg', 1000, 2);
insert into customer (name, balance, bank_id) values ('slava', 1000, 2);
insert into customer (name, balance, bank_id) values ('inna', 1000, 2);
insert into customer (name, balance, bank_id) values ('portal', 1000, 2);
insert into customer (name, balance, bank_id) values ('slevin', 1000, 2);
insert into customer (name, balance, bank_id) values ('erba', 1000, 2);
insert into customer (name, balance, bank_id) values ('iribis', 1000, 2);
insert into customer (name, balance, bank_id) values ('kreme', 1000, 2);
insert into customer (name, balance, bank_id) values ('opp', 1000, 2);
insert into customer (name, balance, bank_id) values ('sergei', 1000, 2);

-- new table banks
create table public.banks (
  bank_id VARCHAR(20),
  bank_name varchar(200)
);

--populate banks
INSERT INTO banks (bank_id, bank_name) VALUES (1, 'swedbank');
INSERT INTO banks (bank_id, bank_name) VALUES (2, 'seb bank');



alter table customer add COLUMN bank_id varchar(20);

create table public.transactions (
  transaction_id varchar(20),
  amount varchar(20),
  customer_id varchar(20)
);

insert into transactions (amount, customer_id) values ('200', 25);
insert into transactions (amount, customer_id) values ('300', 25);
insert into transactions (amount, customer_id) values ('200', 25);
insert into transactions (amount, customer_id) values ('200', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2060', 25);
insert into transactions (amount, customer_id) values ('2060', 25);
insert into transactions (amount, customer_id) values ('2050', 25);
insert into transactions (amount, customer_id) values ('2040', 25);
insert into transactions (amount, customer_id) values ('2040', 25);
insert into transactions (amount, customer_id) values ('2040', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2040', 25);
insert into transactions (amount, customer_id) values ('2040', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2200', 25);
insert into transactions (amount, customer_id) values ('2200', 25);
insert into transactions (amount, customer_id) values ('21100', 25);
insert into transactions (amount, customer_id) values ('2200', 25);
insert into transactions (amount, customer_id) values ('2100', 25);
insert into transactions (amount, customer_id) values ('2010', 25);
insert into transactions (amount, customer_id) values ('2020', 25);
insert into transactions (amount, customer_id) values ('20430', 25);
insert into transactions (amount, customer_id) values ('2040', 25);
insert into transactions (amount, customer_id) values ('2040', 25);
insert into transactions (amount, customer_id) values ('2050', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2050', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2500', 25);
insert into transactions (amount, customer_id) values ('2050', 25);
insert into transactions (amount, customer_id) values ('2050', 25);
insert into transactions (amount, customer_id) values ('2050', 25);
insert into transactions (amount, customer_id) values ('2050', 25);
