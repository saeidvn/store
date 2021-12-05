use store;

select id, name from Stores;

select first_name, date_of_birth from Employees where last_name = 'Hamilton';

select store_id, passport_id, address_id, first_name, last_name, date_of_birth from Employees;

select first_name, last_name from Employees order by first_name, last_name DESC;

select count(address_id), first_name, last_name from Employees group by first_name, last_name;

select count(address_id), first_name from Employees group by first_name having count(address_id) < 7;

select name from Stores where name like "%t%"; 
select name from Stores where name like "%pp"; 
select name from Stores where name in ('Gippo', 'Hit');
select name from Children where age >= 18;
select first_name from Employees where id = 1 or id >= 6;
select passport_id, number, expire_date from Visas;
select country, city, street, entrance from Addresses;
select country, city, street, entrance from Addresses where country = 'USA';
select country from Addresses order by Country;
select id, first_name from Employees 
where store_id in (select id from Stores where name = 'Hit');
select store_id, passport_id, address_id, first_name, last_name, date_of_birth from Employees
where store_id in (select id from Stores where name = 'Sosedi');

delete from Stores where id in (5, 6, 7, 8, 9, 10, 11);
delete from Stores where id = 12;

update Employees set first_name = 'Jill', last_name = 'Valentine' 
where first_name = 'Sara' and last_name = 'Hamilton';
update Employees set date_of_birth = str_to_date('07-07-1979', '%d-%m-%Y') 
where first_name = 'John' and last_name = 'Hardson';
update Visas set passport_id = 2 where number = '000321';
update Visas set passport_id = 3 where number = '987000';

select s.id, s.name, e.id, e.first_name, e.last_name, ch.name, ch.age
from Stores s
left join Employees e
on s.id = e.store_id
left join employee_children ec
on e.id = ec.employee_id
left join Children ch
on ec.child_id = ch.id;

select * from Stores;