select coalesce(hora_inicio >= current_timestamp,false)  from partidos p 
where id = :idPartido;