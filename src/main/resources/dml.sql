use shop;

insert into Addresses (country, city, street, entrance) values
	('Belarus', 'Minsk', 'Moskovskaja', 1),
	('Belarus', 'Brest', 'Brestkaja', 6),
	('Belarus', 'Minsk', 'Zaslavskaja', 2),
    ('Belarus', 'Minsk', 'Nimiga', 25),
    ('Belarus', 'Brest', 'Nimiga', 5),
    ('Belarus', 'Vitebsk', 'Nimiga', 15),
    ('Belarus', 'Grodno', 'Nimiga', 55),
    ('Belarus', 'Minsk', 'Moskovskaja', 11),
    ('Russia','Moscow', 'Arbat', 21),
    ('Poland','Minsk', 'Moskovskaja', 41),
    ('USA', 'Miami', 'Ocean Drive', 13),
    ('England', 'Minsk', 'Moskovskaja', 16),
    ('Spain', 'Madrid', 'Gran Vía', 17),
    ('Japan', 'Tokyo', 'Takeshita', 12),
    ('Belarus', 'Brest', 'Brestkaja', 66),
    ('USA', 'California', 'Alpha', 46),
    ('USA', 'California', 'Beta', 46),
    ('USA', 'Los Angles', 'Hollywood Boulevard', 46),
    ('USA', 'Los Angles', 'Sunset Boulevard', 46),
    ('USA', 'Los Angles', 'Rodeo Drive', 46);
    

insert into Stores (address_id, name) values
	(1, 'Euroopt'),
	(2, 'Hit'),
	(3, 'Gippo'),
	(4, 'Sosedi');

insert into Passports (number, expire_date) values
	('A123456', str_to_date('01-01-2026', '%d-%m-%Y')),
	('B321456', str_to_date('01-01-2026', '%d-%m-%Y')),
	('C123654', str_to_date('01-01-2026', '%d-%m-%Y')),
	('D123465', str_to_date('01-01-2026', '%d-%m-%Y')),
	('E123546', str_to_date('01-01-2026', '%d-%m-%Y')),
	('F132456', str_to_date('01-01-2026', '%d-%m-%Y')),
	('G213456', str_to_date('01-01-2026', '%d-%m-%Y'));
    
insert into Visas (passport_id, number, expire_date) values
	(1, '000123', str_to_date('01-01-2023', '%d-%m-%Y')),
	(1, '000321', str_to_date('01-01-2023', '%d-%m-%Y')),
	(1, '987000', str_to_date('01-01-2023', '%d-%m-%Y'));
    
insert into Employees (store_id, passport_id, address_id, first_name, last_name, date_of_birth) values
	(2, 1, 5, 'John', 'Hardson', str_to_date('01-01-1978', '%d-%m-%Y')),
	(3, 2, 6, 'Sara', 'Hamilton', str_to_date('11-07-2000', '%d-%m-%Y')),
	(1, 3, 7, 'Sam', 'Jackson', str_to_date('21-11-1988', '%d-%m-%Y')),
	(4, 4, 8, 'Tom', 'Hart', str_to_date('06-04-2001', '%d-%m-%Y')),
	(2, 5, 9, 'Alexia', 'Becker', str_to_date('01-01-1985', '%d-%m-%Y')),
	(4, 6, 10, 'Emily', 'Blunt', str_to_date('22-12-1998', '%d-%m-%Y')),
	(1, 7, 11, 'Mike', 'Arthur', str_to_date('16-05-1997', '%d-%m-%Y'));
        
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
    
insert into Suppliers (store_id, address_id, name) values
	(1, 12, 'Santa Bremor'),
    (2, 13, 'Babushkina Krynka'),
    (3, 14, 'Petrukha'),
    (4, 15, 'Barjomi');
    
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

insert into Warehouses (store_id, address_id, name) values
	(1, 16,'Warehouse 1'),
	(1, 17,'Warehouse 2'),
	(1, 18,'Warehouse 3'),
	(1, 19,'Warehouse 4');