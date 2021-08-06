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

select * from restaurants;

insert into restaurants
(restaurant_name, restaurant_phone, restaurant_website, hours, price_range, price_range_num, cuisine_type_1, cuisine_type_2, cuisine_type_3, cuisine_type_4, cuisine_type_5, cuisine_type_6, cuisine_type_7,
city, state, postal_code, street, formatted, lat, lon)
values ('Taco Bell', '(330) 652-1234', 'www.tacobell.com', 'Mon-Sun 6AM-2AM', '$', 1, 'Mexican', 'Fast Food', null, null, null, null, null, 'Niles', 'OH', 44446, '123 Main St', 
'123 Main St, Niles, OH 44446', 40.523687, -2.345678); 

insert into restaurants
(restaurant_name, restaurant_phone, restaurant_website, hours, price_range, price_range_num, cuisine_type_1, cuisine_type_2, cuisine_type_3, cuisine_type_4, cuisine_type_5, cuisine_type_6, cuisine_type_7,
city, state, postal_code, street, formatted, lat, lon)
values ('Wing Stop', '(330) 394-1234', 'www.wingstop.com', 'Mon-Sun 11AM-9PM', '$$', 2, 'Chicken', 'Fast Food', null, null, null, null, null, 'Warren', 'OH', 44482, '456 Market St', 
'456 Market St, Warren, OH 44482', 140.523123, -21.345321); 

insert into restaurants
(restaurant_name, restaurant_phone, restaurant_website, hours, price_range, price_range_num, cuisine_type_1, cuisine_type_2, cuisine_type_3, cuisine_type_4, cuisine_type_5, cuisine_type_6, cuisine_type_7,
city, state, postal_code, street, formatted, lat, lon)
values ('Hot Dog Shoppe', '(330) 555-1234', 'www.originalhotdogshoppe.com', 'Mon-Sun 12PM-9PM', '$', 1, 'American', 'Burgers', null, null, null, null, null, 'Warren', 'OH', 44444, '1 Hot Dog Shoppe Alley', 
'1 Hot Dog Shoppe Alley, Warren, OH 44444', 88.123456, 205.987654); 

insert into restaurants
(restaurant_name, restaurant_phone, restaurant_website, hours, price_range, price_range_num, cuisine_type_1, cuisine_type_2, cuisine_type_3, cuisine_type_4, cuisine_type_5, cuisine_type_6, cuisine_type_7,
city, state, postal_code, street, formatted, lat, lon)
values ('Maccas', '(330) 123-4567', 'www.maccas.nz', 'Mon-Sun 6AM-12AM', '$', 1, 'American', 'Fast Food', 'Burgers', null, null, null, null, 'Glenfield', 'NZ', 12345, '22 Ladies Mile', 
'22 Ladies Mile, Glenfield, NZ 12345', -230.523687, -182.345678); 

insert into restaurants
(restaurant_name, restaurant_phone, restaurant_website, hours, price_range, price_range_num, cuisine_type_1, cuisine_type_2, cuisine_type_3, cuisine_type_4, cuisine_type_5, cuisine_type_6, cuisine_type_7,
city, state, postal_code, street, formatted, lat, lon)
values ('Trattoria', '(440) 123-1234', 'www.trattoriacle.com', 'Mon-Sun 12PM-2AM', '$$$', 3, 'Italian', 'Fine Dining', null, null, null, null, null, 'Cleveland', 'OH', 98765, '1944 Italia Way', 
'1944 Italia Way, Cleveland, OH 98765', 125.523687, -283.345678); 

insert into restaurants
(restaurant_name, restaurant_phone, restaurant_website, hours, price_range, price_range_num, cuisine_type_1, cuisine_type_2, cuisine_type_3, cuisine_type_4, cuisine_type_5, cuisine_type_6, cuisine_type_7,
city, state, postal_code, street, formatted, lat, lon)
values ('Panera Bread', '(123) 456-7890', 'www.panerabread.com', 'Mon-Sun 6AM-9PM', '$$', 2, 'Soup', 'Sandwiches', 'Wraps', 'Coffee', 'Bakery', null, null, 'Cleveland', 'OH', 56234, '886 Bread Ave', 
'886 Bread Ave, Cleveland, OH 56234', 45.523687, -79.345678); 

select * from restaurants;

select * from restaurants_profile;

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (1, 3, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (2, 3, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (3, 3, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (4, 3, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (5, 3, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (6, 3, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (1, 4, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (2, 4, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (3, 4, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (4, 4, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (5, 4, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (6, 4, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (1, 5, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (2, 5, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (3, 5, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (4, 5, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (5, 5, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (6, 5, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (1, 6, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (2, 6, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (3, 6, false);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (4, 6, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (5, 6, true);

insert into restaurants_profile
(restaurant_id, user_id, is_liked)
values (6, 6, true);

select * from restaurants_profile;


commit;