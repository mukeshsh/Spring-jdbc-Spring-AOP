
  CREATE TABLE "RONALDO"."RAILWAY_RESERVATION" 
   (	"TKTID" NUMBER(10,0) NOT NULL ENABLE, 
	"PASSENGERNAME" VARCHAR2(20 BYTE), 
	"AGE" NUMBER(3,0), 
	"SOURCEPLACE" VARCHAR2(20 BYTE), 
	"DESTINATIONPLACE" VARCHAR2(20 BYTE), 
	"PRICE" FLOAT(126), 
	"GENDER" VARCHAR2(10 BYTE), 
	 CONSTRAINT "RAILWAY_RESERVAION_PK" PRIMARY KEY ("TKTID");
	 CREATE SEQUENCE  "RONALDO"."TKID_SEQ"  MINVALUE 100 MAXVALUE 1000 INCREMENT BY 1 START WITH 100 CACHE 20 NOORDER  NOCYCLE ;