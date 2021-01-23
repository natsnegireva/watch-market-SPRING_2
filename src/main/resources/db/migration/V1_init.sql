create table products (
                        id bigserial primary key,
                        title varchar(255),
                        description varchar(255),
                        price int,
                        pathname VARCHAR(255),
                        created_at timestamp default current_timestamp,
                        updated_at timestamp default current_timestamp
);
insert into products (title, description, price, pathname)
values
('Black Silicon Strap Watch', 'Interactively expedite business materials without holistic information', 89, '/img/products/prod_01.jpg'),
('Blue Silicon Strap Watch', 'Competently build 24/7 “outside the box” thinking via excellent paradigms', 149, '/img/products/prod_02.jpg'),
('Golden Watch', 'Seamlessly predominate flexible niches whereas seamless total linkage', 1189, '/img/products/prod_03.jpg'),
('Leather Strap Watch', 'Uniquely syndicate resource sucking synergy and economically sound e-tailers', 279, '/img/products/prod_04.jpg'),
('Leather Strap Watch', 'Proactively unleash customized imperatives whereas timely meta-services', 379, '/img/products/prod_05.jpg'),
('Leather Strap Watch', 'Interactively matrix excellent benefits via adaptive e-tailers', 259, '/img/products/prod_06.jpg'),
('Luxury Watch', 'Uniquely generate emerging functionalities whereas leveraged e-business', 689, '/img/products/prod_07.jpg'),
('Silicone Strap Watch', 'Collaboratively enable multimedia based supply chains for leveraged mindshare', 156, '/img/products/prod_08.jpg'),
('Sports Watch', 'Seamlessly develop strategic e-tailers rather than magnetic platforms', 169, '/img/products/prod_09.jpg'),
('Stainless Steel Watch', 'Professionally disintermediate revolutionary solutions via best-of-breed', 499, '/img/products/prod_10.jpg');

create table users (
                       id                      bigserial primary key,
                       username                varchar(30) not null,
                       password                varchar(80) not null,
                       email                   varchar(50) unique,
                       created_at              timestamp default current_timestamp,
                       updated_at              timestamp default current_timestamp
);

create table roles (
                       id                      bigserial primary key,
                       name                    varchar(50) not null,
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
('sneg', '$2y$10$cQtnmie4rsl33k4LpzF7Z.xV0M2t6TuO6smw2F45IiExaOjUOo2tG', 'sneg@gmail.com'),
('admin', '$2y$10$cQtnmie4rsl33k4LpzF7Z.xV0M2t6TuO6smw2F45IiExaOjUOo2tG', 'admin_shop@gmail.com');

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 2);