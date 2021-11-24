use shop;

insert into Stores (name) values
	('Euroopt'),
	('Hit'),
	('Gippo'),
	('Sosedi');

insert into Passports (number, expire_date) values
	('123456', str_to_date('01-01-2026', '%d-%m-%Y')),
	('321456', str_to_date('01-01-2026', '%d-%m-%Y')),
	('123654', str_to_date('01-01-2026', '%d-%m-%Y')),
	('123465', str_to_date('01-01-2026', '%d-%m-%Y')),
	('123546', str_to_date('01-01-2026', '%d-%m-%Y')),
	('132456', str_to_date('01-01-2026', '%d-%m-%Y')),
	('213456', str_to_date('01-01-2026', '%d-%m-%Y'));
    
insert into Visas (passport_id, number, expire_date) values
	(1, '000123', str_to_date('01-01-2023', '%d-%m-%Y')),
	(1, '000321', str_to_date('01-01-2023', '%d-%m-%Y')),
	(1, '987000', str_to_date('01-01-2023', '%d-%m-%Y'));
    
insert into Employees (store_id, passport_id, first_name, last_name, date_of_birth) values
	(2, 1, 'John', 'Hardson', str_to_date('01-01-1978', '%d-%m-%Y')),
	(3, 2, 'Sara', 'Hamilton', str_to_date('11-07-2000', '%d-%m-%Y')),
	(1, 3, 'Sam', 'Jackson', str_to_date('21-11-1988', '%d-%m-%Y')),
	(4, 4, 'Tom', 'Hart', str_to_date('06-04-2001', '%d-%m-%Y')),
	(2, 5, 'Alexia', 'Becker', str_to_date('01-01-1985', '%d-%m-%Y')),
	(4, 6, 'Emily', 'Blunt', str_to_date('22-12-1998', '%d-%m-%Y')),
	(1, 7, 'Mike', 'Arthur', str_to_date('16-05-1997', '%d-%m-%Y'));
        
insert into Children (name, age) values
	('Amelia', 7),
	('Noah', 22),
	('Ava', 20),
	('Olivia', 18),
	('Harper', 11),
	('Emma', 26);
    
insert into employee_children (employee_id, child_id) values
	(1, 6),
	(3, 2),
	(2, 1),
	(5, 6),
	(6, 5),
	(7, 3),
	(7, 4);
    
insert into Sections (store_id, name, number) values
	(4, 'Manager room', '01'),
	(4, 'Security room', '02'),
	(4, 'Meat', '03'),
	(1, 'Bread', '04'),
	(1, 'Beverage', '05'),
	(3, 'Household goods', '06'),
	(2, 'Dairy product', '07');
    
insert into employee_sections (employee_id, section_id) values
	(5, 01),
	(4, 02),
	(1, 03),
	(6, 04),
	(3, 05),
	(1, 06),
	(1, 07);
    
insert into Suppliers (store_id, name) values
	(1, 'Santa Bremor'),
    (2, 'Babushkina Krynka'),
    (3, 'Petrukha'),
    (4, 'Barjomi');
    
insert into Products (store_id, name, create_date, expire_date) values
	(1, 'Pork', str_to_date('21-11-2021', '%d-%m-%Y'), str_to_date('01-12-2021', '%d-%m-%Y')),
	(2, 'Banana', str_to_date('23-11-2021', '%d-%m-%Y'), str_to_date('01-12-2021', '%d-%m-%Y')),
	(3, 'Salt', str_to_date('21-11-2021', '%d-%m-%Y'), str_to_date('21-11-2023', '%d-%m-%Y')),
	(4, 'Milk', str_to_date('21-01-2021', '%d-%m-%Y'), str_to_date('21-12-2022', '%d-%m-%Y')),
	(1, 'Water', str_to_date('21-11-2021', '%d-%m-%Y'), str_to_date('21-11-2022', '%d-%m-%Y'));
    
insert into product_suppliers (product_id, supplier_id) values
	(1, 3),
	(5, 4),
	(4, 2),
	(3, 2),
	(2, 1);

insert into Warehouses (store_id, name) values
	(1, 'Warehouse 1'),
	(1, 'Warehouse 2'),
	(1, 'Warehouse 3'),
	(1, 'Warehouse 4');
    
insert into Addresses (store_id, employee_id, warehouse_id, country, city, street, entrance) values
	(1, 3, 1, 'Belarus', 'Minsk', 'Nimiga', 5),
	(2, 5, 2, 'Belarus', 'Minsk', 'Moskovskaja', 1),
	(3, 7, 3, 'Belarus', 'Brest', 'Brestkaja', 6),
	(4, 2, 4, 'Belarus', 'Minsk', 'Zaslavskaja', 2);