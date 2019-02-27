create table user (
    id varchar(32) primary key,
    user_name varchar(50),
    email varchar(50),
    phone_number varchar(50),
    user_password varchar(50),
    user_status char(1),
    create_time timestamp DEFAULT CURRENT_TIMESTAMP,
    last_login_time timestamp,
    last_update_time timestamp DEFAULT CURRENT_TIMESTAMP ,
    avatar varchar(300)
);