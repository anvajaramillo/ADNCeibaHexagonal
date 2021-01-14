create table usuario (
 id serial,
 nombre varchar(100),
 clave varchar(45),
 fecha_creacion timestamp null,
 PRIMARY KEY (id)
);