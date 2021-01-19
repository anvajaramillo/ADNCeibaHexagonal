select *, true tiene_apuestas from apuestas a inner join partidos p 
on a.id_partido = p.id
where a.id = :idApuesta;