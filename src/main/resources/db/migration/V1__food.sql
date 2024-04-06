CREATE TABLE food (
  id CHAR(36) NOT NULL,
   person_id CHAR(36) NOT NULL,
   datetime datetime DEFAULT NOW() NOT NULL,
   food VARCHAR(50) NOT NULL,
   weight INT NOT NULL,
   CONSTRAINT pk_food PRIMARY KEY (id)
);