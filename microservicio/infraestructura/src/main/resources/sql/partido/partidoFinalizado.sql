select coalesce(hora_fin >= current_timestamp,false)  from partidos p 
where id = :idPartido;