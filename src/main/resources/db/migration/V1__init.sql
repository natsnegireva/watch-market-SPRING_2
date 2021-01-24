CREATE TABLE products (
                          id                      bigserial primary key,
                          title                   varchar(255),
                          description             varchar(255),
                          price                   int,
                          pathname                varchar(255),
                          created_at              timestamp default current_timestamp,
                          updated_at              timestamp default current_timestamp
);