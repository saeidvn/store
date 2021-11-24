create database if not exists shop;
use shop;

create table if not exists Stores (
	id serial,
    name varchar(45) not null,
    primary key (id)
);

create table if not exists Passports (
	id serial,
	number varchar(45) not null,
	expire_date date not null,
	primary key (id),
	unique index Passports(number)
);
-- create unique index unique_idx_passports_number on Passports(number);

create table if not exists Visas (
	id serial,
    passport_id bigint unsigned not null,
    number varchar(45) not null,
    expire_date date not null,
    primary key (id),
    constraint fk_visas_passport_id foreign key (passport_id) references Passports(id)
    on update no action
    on delete cascade,
    unique index Visas(number)
);
-- create unique index unique_idx_visas_number on Visas(number);

create table if not exists Employees (
	id serial,
    store_id bigint unsigned not null,
    passport_id bigint unsigned not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    date_of_birth timestamp not null,
    primary key (id),
    constraint fk_employees_store_id foreign key (store_id) references Stores(id)
    on update no action
    on delete cascade,
    constraint fk_employees_passport_id foreign key (passport_id) references Passports(id)
    on update no action
    on delete cascade,
    unique index(passport_id) 
);
-- create unique index unique_idx_Employees_passport_id on Employees(passport_id);

create table if not exists Children (
	id serial,
    name varchar(45) not null,
    age int not null,
    primary key (id)
);

create table if not exists employee_children (
	id serial,
    employee_id bigint unsigned not null,
    child_id bigint unsigned not null,
    primary key (id),
    constraint fk_employee_children_employee_id foreign key (employee_id) references Employees(id)
    on update no action
    on delete cascade,
    constraint fk_employee_children_child_id foreign key (child_id) references Children(id)
    on update no action
    on delete cascade
);

create table if not exists Sections (
	id serial,
    store_id bigint unsigned not null,
    name varchar(45) not null,
    number varchar(20) not null,
    primary key (id),
    constraint fk_sections_store_id foreign key (store_id) references Stores(id)
    on update no action
    on delete cascade
);

create table if not exists employee_sections (
	id serial,
    employee_id bigint unsigned not null,
    section_id bigint unsigned not null,
    primary key (id),
    constraint fk_employye_sections_employee_id foreign key (employee_id) references Employees(id)
    on update no action
    on delete cascade,
    constraint fk_employee_sections_section_id foreign key (section_id) references Sections(id)
    on update no action
    on delete cascade
);

create table if not exists Suppliers (
	id serial,
    store_id bigint unsigned not null,
    name varchar(45) not null,
    primary key (id),
    constraint fk_suppliers_store_id foreign key (store_id) references Stores(id)
    on update no action
    on delete cascade
);

create table if not exists Products (
	id serial,
    store_id bigint unsigned not null,
    name varchar(45) not null,
    create_date date not null,
    expire_date date not null,
    primary key (id),
    constraint fk_products_store_id foreign key (store_id) references Stores(id)
    on update no action
    on delete cascade
);

create table if not exists product_suppliers (
	id serial,
    product_id bigint unsigned not null,
    supplier_id bigint unsigned not null,
    primary key (id),
    constraint fk_product_suppliers_product_id foreign key (product_id) references Products(id)
    on update no action
    on delete cascade,
    constraint fk_product_suppliers_supplier_id foreign key (supplier_id) references Suppliers(id)
    on update no action
    on delete cascade
);

create table if not exists Warehouses (
	id serial,
    store_id bigint unsigned not null,
    name varchar(45) not null,
    primary key (id),
    constraint fk_warehouses_store_id foreign key (store_id) references Stores(id)
    on update no action
    on delete cascade
);

create table if not exists Addresses (
	id serial,
    store_id bigint unsigned not null,
    employee_id bigint unsigned not null,
    warehouse_id bigint unsigned not null,
    country varchar(45) not null,
    city varchar(45) not null,
    street varchar(45) not null,
    entrance varchar(45) not null,
    primary key (id),
    constraint fk_addresses_store_id foreign key (store_id) references Stores(id)
    on update no action
    on delete cascade,
    constraint fk_addresses_employee_id foreign key (employee_id) references Employees(id)
    on update no action
    on delete cascade,
    constraint fk_addresses_warehouse_id foreign key (warehouse_id) references Warehouses(id)
    on update no action
    on delete cascade
);




