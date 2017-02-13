DROP TABLE DOCTOR;
DROP TABLE PATIENT;

CREATE table DOCTOR (
	DID					INT				NOT NULL,
	Name				VARCHAR(50)		NOT NULL,
	Address				VARCHAR(100)	NOT NULL,
	Contact				BIGINT			NOT NULL,
	Specialization		VARCHAR(50)		NOT NULL,
	WorkFrom			INT				NOT NULL,
	WorkTo				INT				NOT NULL,
	PRIMARY KEY (DID)
);

CREATE table PATIENT (
	PID 			INT 				NOT NULL,
	Name			VARCHAR(50)			NOT NULL,
	Address			VARCHAR(100),
	Contact			BIGINT,
	BloodGroup		VARCHAR(5)			NOT NULL,
	History			VARCHAR(1000),
	DoB				DATE				NOT NULL,
	Diagnostic		VARCHAR(100)		NOT NULL,
	RoomNo			INT,
	DateAdd			DATE				NOT NULL,
	rType			VARCHAR(50),		
	Gender			VARCHAR(50)			NOT NULL,
	Docname			VARCHAR(50)			NOT NULL,
	PRIMARY KEY (PID)
);