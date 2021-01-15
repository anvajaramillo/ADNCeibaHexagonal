select * from apuestas a 
inner join partidos p
on a.id_partido = p.id
where id_partido = :idPartido
and p.hora_fin is not null;