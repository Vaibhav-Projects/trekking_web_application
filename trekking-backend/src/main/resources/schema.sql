DROP TABLE IF EXISTS TREKKING_DETAILS;

CREATE TABLE TREKKING_DETAILS(
	trek_id INT AUTO_INCREMENT PRIMARY KEY,
	trek_name varchar(255) NOT NULL,
	trek_desc varchar(255) NOT NULL,
	trek_price varchar(255) NOT NULL,
	trek_start_time varchar(355) NOT NULL,
	trek_end_time varchar(255) NOT NULL
);