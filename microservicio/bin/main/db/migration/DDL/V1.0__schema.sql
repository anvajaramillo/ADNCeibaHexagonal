create table usuario (
 id serial,
 nombre varchar(100),
 clave varchar(45),
 fecha_creacion timestamp null,
 PRIMARY KEY (id)
);

CREATE TABLE partidos (
	id serial,
	pais1 varchar(50),
	pais2 varchar(50),
	hora_inicio timestamp,
	hora_fin timestamp,
	puntaje_pais1 int4,
	puntaje_pais2 int4,
	PRIMARY KEY (id)
);

CREATE TABLE apuestas (
	id serial,
	dinero int4,
	nombre varchar(100),
	cedula varchar(20),
	puntajePais1 int4,
	puntajePais2 int4,
	is_ganador boolean,
	dinero_ganado int4,
	id_partido int4,
	PRIMARY KEY (id),
	CONSTRAINT fk_partidos FOREIGN KEY(id_partido) REFERENCES partidos(id)
);