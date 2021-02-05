
create table users (
                       id                      bigserial primary key,
                       username                varchar(30) not null unique,
                       password                varchar(80) not null,
                       email                   varchar(50) unique,
                       created_at              timestamp default current_timestamp,
                       updated_at              timestamp default current_timestamp
);

create table roles (
                       id                      bigserial primary key,
                       name                    varchar(50) not null unique,
                       created_at              timestamp default current_timestamp,
                       updated_at              timestamp default current_timestamp
);

CREATE TABLE users_roles (
                             user_id                 bigint not null references users (id),
                             role_id                 bigint not null references roles (id),
                             primary key (user_id, role_id)
);

insert into roles (name)
values
('ROLE_USER'),
('ROLE_ADMIN');

insert into users (username, password, email)
values
('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 2);

create table products (
                          id                      bigserial primary key,
                          title                   varchar(255),
                          price                   int,
                          created_at              timestamp default current_timestamp,
                          updated_at              timestamp default current_timestamp
);

insert into products (title, price)
values
('Black Silicon Strap Watch', 89),
('Blue Silicon Strap Watch', 149),
('Golden Watch', 1189),
('Leather Strap Watch'),
('Leather Strap Watch'),
('Leather Strap Watch'),
('Luxury Watch', 689),
('Silicone Strap Watch', 156),
('Sports Watch', 169),
('Stainless Steel Watch', 499);

create table order_items (
                             id                      bigserial primary key,
                             title                   varchar(255),
                             quantity                int,
                             price_per_item          int,
                             price                   int
);