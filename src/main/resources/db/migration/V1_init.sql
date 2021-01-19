create table products (
id bigserial primary key,
title varchar(255),
description varchar(255),
price int,
img_pathname VARCHAR(255),
created_at timestamp default current_timestamp,
updated_at timestamp default current_timestamp
);

insert into products (title, price, description, img_pathname) values
('Black Silicon Strap Watch', 89.00, 'Interactively expedite business materials without holistic information', '/img/products/prod_01.jpg'),
('Blue Silicon Strap Watch', 149.00, 'Competently build 24/7 “outside the box” thinking via excellent paradigms', '/img/products/prod_02.jpg'),
('Golden Watch', 1189.00, 'Seamlessly predominate flexible niches whereas seamless total linkage', '/img/products/prod_03.jpg'),
('Leather Strap Watch', 279.00, 'Uniquely syndicate resource sucking synergy and economically sound e-tailers', '/img/products/prod_04.jpg'),
('Leather Strap Watch', 379.00, 'Proactively unleash customized imperatives whereas timely meta-services', '/img/products/prod_05.jpg'),
('Leather Strap Watch', 259.00, 'Interactively matrix excellent benefits via adaptive e-tailers', '/img/products/prod_06.jpg'),
('Luxury Watch', 689.00, 'Uniquely generate emerging functionalities whereas leveraged e-business', '/img/products/prod_07.jpg'),
('Silicone Strap Watch', 156.00, 'Collaboratively enable multimedia based supply chains for leveraged mindshare', '/img/products/prod_08.jpg'),
('Sports Watch', 169.00, 'Seamlessly develop strategic e-tailers rather than magnetic platforms', '/img/products/prod_09.jpg'),
('Stainless Steel Watch', 499.00, 'Professionally disintermediate revolutionary solutions via best-of-breed', '/img/products/prod_10.jpg');