select coalesce(current_timestamp >= hora_inicio,false)  from partidos p 
where id = :idPartido;