
CREATE TABLE localization_description
(
	id BIGINT PRIMARY KEY NOT NULL,
	en VARCHAR(255),
	kk VARCHAR(255),
	ru VARCHAR(255)
);

CREATE TABLE resource_description
(
	id BIGINT PRIMARY KEY NOT NULL,
	type VARCHAR(255),
	name_id BIGINT,
	CONSTRAINT fktfrmxpc3t547eelhl14101hct FOREIGN KEY (name_id) REFERENCES localization_description (id)
);

CREATE TABLE field_description
(
	id BIGINT PRIMARY KEY NOT NULL,
	data_type VARCHAR(255),
	default_value VARCHAR(255),
	type VARCHAR(255),
	name_id BIGINT,
	resource_type VARCHAR(255),
	resource_type_id BIGINT,
	CONSTRAINT fksr81oah29vcajmcpntpqdlm17 FOREIGN KEY (name_id) REFERENCES localization_description (id),
	CONSTRAINT fkgwvvv4w1kf11kee4blkx2cy09 FOREIGN KEY (resource_type_id) REFERENCES resource_description (id)
);

CREATE TABLE constraint_description
(
	id BIGINT PRIMARY KEY NOT NULL,
	type VARCHAR(255),
	name_id BIGINT,
	CONSTRAINT fkq8vrgb559a9png2rf2cbm2a81 FOREIGN KEY (name_id) REFERENCES localization_description (id)
);
CREATE TABLE document_description
(
	id BIGINT PRIMARY KEY NOT NULL,
	name_id BIGINT,
	CONSTRAINT fkl5py9fdbsuu4r4gje2gi42bcf FOREIGN KEY (name_id) REFERENCES localization_description (id)
);
CREATE TABLE document_description_fields
(
	document_description_id BIGINT NOT NULL,
	fields_id BIGINT NOT NULL,
	CONSTRAINT fk8sqovxbdraoj7umw5bqc24yhq FOREIGN KEY (document_description_id) REFERENCES document_description (id),
	CONSTRAINT fk71mpq4pcda1x0pkrsyvmgqeri FOREIGN KEY (fields_id) REFERENCES field_description (id)
);
CREATE UNIQUE INDEX uk_p5dwgj88akf1y9ccgnw4yh09i ON document_description_fields (fields_id);

CREATE TABLE field_description_constraints
(
	field_description_id BIGINT NOT NULL,
	constraints_id BIGINT NOT NULL,
	CONSTRAINT fke1nwdtvrflldp5fhsdvf6es0y FOREIGN KEY (field_description_id) REFERENCES field_description (id),
	CONSTRAINT fkq0a4wb2ywhev9nx98y9yayvq2 FOREIGN KEY (constraints_id) REFERENCES constraint_description (id)
);
CREATE UNIQUE INDEX uk_mplcb53y9oier346k31wc2ch1 ON field_description_constraints (constraints_id);