create table if not exists weather
(
    id long auto_increment,
    country char(255) not null,
    type char(255) not null,
    constraint weather_pk
    primary key (id)
    );

