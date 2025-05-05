create table categories
(
    id  tinyint auto_increment
        primary key,
    name  varchar(255) not null
);

create table products
(
    id  bigint auto_increment
        primary key,
    name  varchar(255) not null,
    price decimal(10, 2),
    category_id tinyint,
    CONSTRAINT categories_id_fk FOREIGN KEY (category_id) REFERENCES categories(id)
);

