create sequence portfolio_id_seq start with 1 increment by 50;

create table portfolio (
id bigint default nextVal('portfolio_id_seq') not null,
customer_id text not null unique,
customer_name text not null,
portfolio_number text not null,
portfolio_value numeric,
current_performance numeric,
investment_strategy text,
primary key (id))