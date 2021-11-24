use shop;

select id, name from Stores;

delete from Stores where id = 12;
delete from Stores where id = 11;
delete from Stores where id = 10;
delete from Stores where id = 9;
delete from Stores where id = 8;
delete from Stores where id = 7;
delete from Stores where id = 6;
delete from Stores where id = 5;

select name from Stores where name like "%t%"; 
select name from Stores where name like "%pp%"; 
select name from Stores where name in ('Gippo', 'Hit');
select name from Children where age >=18 and age <= 10;
select first_name from Employees where id =1 or id >= 6;

select s.id, s.name, e.id, e.first_name, e.last_name, ch.name, ch.age
from Stores s
left join Employees e
on s.id = e.store_id
left join employee_children ec
on e.id = ec.employee_id
left join Children ch
on ec.child_id = ch.id
 





		