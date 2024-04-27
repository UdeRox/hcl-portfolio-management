create sequence instrument_id_seq start with 1 increment by 50;

create table instrument (
id bigint default nextVal('instrument_id_seq') not null,
instrument_name text,
instrument_value numeric,
instrument_type text,
price numeric not null,
primary key (id))