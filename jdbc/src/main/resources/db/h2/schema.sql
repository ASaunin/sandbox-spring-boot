DROP TABLE IF EXISTS persons;

CREATE TABLE persons (
	id bigint NOT NULL,
  email varchar(255),
  nick_name varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  sex varchar(1),
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
	id bigint NOT NULL,
  author_id bigint,
  title varchar(100),
  body varchar(4000),
  description varchar(4000),
  posted_on TIMESTAMP,
  FOREIGN KEY (author_id) REFERENCES persons (id),
	PRIMARY KEY (id)
);

