create table "users" (
  "id" VARCHAR(1024) PRIMARY KEY NOT NULL,
  "name" VARCHAR(1024) NOT NULL,
  "email" VARCHAR(1024) NOT NULL,
  "addressline1" VARCHAR(1024) NOT NULL,
  "addressline2" VARCHAR(1024),
  "towncity" VARCHAR(1024) NOT NULL,
  "postalcode" VARCHAR(1024),
  "country" VARCHAR(1024) NOT NULL,
  "telephone1" VARCHAR(1024),
  "telephone2" VARCHAR(1024),
  "telephone3" VARCHAR(1024)
);
