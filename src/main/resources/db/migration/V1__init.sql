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
                          description             varchar(255),
                          price                   int,
                          pathname                varchar(255),
                          created_at              timestamp default current_timestamp,
                          updated_at              timestamp default current_timestamp
);

insert into products (title, description, price, pathname)
values
('Black Silicon Strap Watch', 'Interactively expedite business materials without holistic information', 89, 'img/products/img1.jpg'),
('Blue Silicon Strap Watch', 'Competently build 24/7 “outside the box” thinking via excellent paradigms', 149, 'img/products/img2.jpg'),
('Golden Watch', 'Seamlessly predominate flexible niches whereas seamless total linkage', 1189, 'img/products/img3.jpg'),
('Leather Strap Watch', 'Uniquely syndicate resource sucking synergy and economically sound e-tailers', 279, 'img/products/img4.jpg'),
('Leather Strap Watch', 'Proactively unleash customized imperatives whereas timely meta-services', 379, 'img/products/img5.jpg'),
('Leather Strap Watch', 'Interactively matrix excellent benefits via adaptive e-tailers', 259, 'img/products/img6.jpg'),
('Luxury Watch', 'Uniquely generate emerging functionalities whereas leveraged e-business', 689, 'img/products/img7.jpg'),
('Silicone Strap Watch', 'Collaboratively enable multimedia based supply chains for leveraged mindshare', 156, 'img/products/img8.jpg'),
('Sports Watch', 'Seamlessly develop strategic e-tailers rather than magnetic platforms', 169, 'img/products/img9.jpg'),
('Stainless Steel Watch', 'Professionally disintermediate revolutionary solutions via best-of-breed', 499, 'img/products/img10.jpg');

create table orders (
                        id                      bigserial primary key,
                        owner_id                bigint references users (id),
                        price                   int,
                        address                 varchar(255),
                        created_at              timestamp default current_timestamp,
                        updated_at              timestamp default current_timestamp
);

create table order_items (
                             id                      bigserial primary key,
                             order_id                bigint references orders (id),
                             product_id              bigint references products (id),
                             title                   varchar(255),
                             quantity                int,
                             price_per_product       int,
                             price                   int,
                             created_at              timestamp default current_timestamp,
                             updated_at              timestamp default current_timestamp
);