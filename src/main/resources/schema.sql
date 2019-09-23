create table Devices ( 
	device_id varchar(25) not null, 
	device_name varchar(255) not null, 
	primary key(device_id) 
);
create table Usage( 
	device_id varchar(25) not null, 
	year integer(4) not null,
	rate double(4), 
	primary key(device_id,year) 
);