use shop;

select id, name from Stores;

delete from Stores where id in (5, 6, 7, 8, 9, 10, 11);
delete from Stores where id = 12;

select name from Stores where name like "%t%"; 
select name from Stores where name like "%pp%"; 
select name from Stores where name in ('Gippo', 'Hit');
select name from Children where age >=18;
select first_name from Employees where id =1 or id >= 6;

select s.id, s.name, e.id, e.first_name, e.last_name, ch.name, ch.age
from Stores s
left join Employees e
on s.id = e.store_id
left join employee_children ec
on e.id = ec.employee_id
left join Children ch
on ec.child_id = ch.id;

select id, first_name from Employees 
where store_id in (select id from Stores where name = 'Hit');

select store_id, passport_id, address_id, first_name, last_name, date_of_birth from Employees
where store_id in (select id from Stores where name = 'Sosedi');

select country, city, street, entrance from Addresses;
select country, city, street, entrance from Addresses where country = 'USA';





		