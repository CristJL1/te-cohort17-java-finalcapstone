begin transaction;

select * from users;

insert into users
(username, password_hash, role)
values ('clubber', 'mohawk', 'ROLE_USER');

insert into users
(username, password_hash, role)
values ('tswift', 'red', 'ROLE_USER');

insert into users
(username, password_hash, role)
values ('carlyslayjepsen', 'maybe', 'ROLE_USER');

insert into users
(username, password_hash, role)
values ('dagger', 'goose', 'ROLE_USER');

select * from users;

select * from profile;

insert into profile
(user_id, first_name, last_name, date_of_birth, email, zip_code)
values ((select user_id from users where username = 'clubber'), 'Mr.', 'T', '1952-05-21', 'ipitythefool@mailinator.com', 44446);

insert into profile
(user_id, first_name, last_name, date_of_birth, email, zip_code)
values ((select user_id from users where username = 'tswift'), 'Taylor', 'Swift', '1989-12-13', 'wenevergooutofstyle1989@mailinator.com', 44473);

insert into profile
(user_id, first_name, last_name, date_of_birth, email, zip_code)
values ((select user_id from users where username = 'carlyslayjepsen'), 'Carly Rae', 'Jepsen', '1985-11-21', 'ididntjustcomeheretodance@mailinator.com', 44118);

insert into profile
(user_id, first_name, last_name, date_of_birth, email, zip_code)
values ((select user_id from users where username = 'dagger'), 'Israel', 'Dagg', '1988-06-06', 'daggertotheheart@mailinator.com', 44444);

select * from profile;

select * from preferences;

insert into preferences
(user_id, cuisine_style_1, cuisine_style_2, cuisine_style_3, price_point, vegan, vegetarian, gluten_free)
values ((select user_id from users where username = 'clubber'), 'Italian', 'Chinese', 'American', '$$', false, false, true);

insert into preferences
(user_id, cuisine_style_1, cuisine_style_2, cuisine_style_3, price_point, vegan, vegetarian, gluten_free)
values ((select user_id from users where username = 'tswift'), 'Mexican', 'Indian', 'Italian', '$$$$', true, true, false);

insert into preferences
(user_id, cuisine_style_1, cuisine_style_2, cuisine_style_3, price_point, vegan, vegetarian, gluten_free)
values ((select user_id from users where username = 'carlyslayjepsen'), 'BBQ', 'Sushi', 'Indian', '$$$', false, true, false);

insert into preferences
(user_id, cuisine_style_1, cuisine_style_2, cuisine_style_3, price_point, vegan, vegetarian, gluten_free)
values ((select user_id from users where username = 'dagger'), 'Thai', 'Italian', 'American', '$', false, false, false);

select * from preferences;

--select * from preferences where profile_id = (select profile_id from profile where last_name = 'swift');
--select * from preferences where profile_id = (select profile_id from profile where last_name = 'T');

--select * from user_profile;
--
--insert into user_profile
--(user_id, profile_id)
--values ((select user_id from users where username = 'clubber'),
--(select profile_id from profile where last_name = 'T'));
--
--insert into user_profile
--(user_id, profile_id)
--values ((select user_id from users where username = 'tswift'),
--(select profile_id from profile where last_name = 'Swift'));
--
--select * from user_profile;

--select * from profile_preferences;
--
--insert into profile_preferences
--(profile_id, preference_id)
--values ((select profile_id from profile where last_name = 'T'),
--(select preference_id from preferences where vegan = false));
--
--insert into profile_preferences
--(profile_id, preference_id)
--values ((select profile_id from profile where last_name = 'Swift'),
--(select preference_id from preferences where vegan = true));
--
--select * from profile_preferences;

commit;