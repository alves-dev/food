CREATE TABLE liquid_food (
  id CHAR(36) NOT NULL,
   person_id CHAR(36) NOT NULL,
   datetime datetime DEFAULT NOW() NOT NULL,
   liquid VARCHAR(50) NOT NULL,
   amount INT NOT NULL,
   CONSTRAINT pk_liquid_food PRIMARY KEY (id)
);