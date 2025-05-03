create table profiles
(
    id  bigint primary key,
    bio  varchar(255) not null,
    phone_number    varchar(255) null,
    date_of_birth   date null,
    loyalty_points  integer UNSIGNED DEFAULT 0,
    CONSTRAINT profiles_id_fk FOREIGN KEY (id) REFERENCES store.users(id)
);