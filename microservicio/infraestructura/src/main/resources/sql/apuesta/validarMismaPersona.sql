select count(*) > 0 from apuestas 
where id <> :idApuesta and cedula = :cedula
and id_partido = :idPartido;