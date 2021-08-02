begin transaction;

drop table if exists user_profile cascade;
drop table if exists profile cascade;
drop table if exists profile_preferences cascade;
drop table if exists preferences cascade;

create table profile
(profile_id serial not null,
first_name character varying(50) not null,
last_name character varying(50) not null,
date_of_birth date not null,
email character varying(100) not null,
zip_code numeric(5,0) not null,
constraint pk_profile_profile_id Primary Key (profile_id));

create table preferences
(preference_id serial not null,
cuisine_style_1 character varying(50) not null,
cuisine_style_2 character varying(50) not null,
cuisine_style_3 character varying(50) not null,
price_point character varying(4) not null,
vegan boolean,
vegetarian boolean,
gluten_free boolean,
constraint pk_preferences_preference_id Primary Key (preference_id));

create table user_profile
(user_id integer not null,
profile_id integer not null,
constraint pk_user_profile_user_id_profile_id Primary Key (user_id, profile_id));

create table profile_preferences
(profile_id integer not null,
preference_id integer not null,
constraint pk_profile_preferences_profile_id_preference_id Primary Key (profile_id, preference_id));

alter table user_profile add foreign key (profile_id) references profile (profile_id);
alter table user_profile add foreign key (user_id) references users (user_id);

alter table profile_preferences add foreign key (profile_id) references profile (profile_id);
alter table profile_preferences add foreign key (preference_id) references preferences (preference_id);


commit;