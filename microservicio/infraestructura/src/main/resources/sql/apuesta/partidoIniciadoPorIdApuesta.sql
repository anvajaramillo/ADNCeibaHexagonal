select coalesce(current_timestamp >= hora_inicio,false)
from apuestas a inner join partidos p on a.id_partido = p.id
where a.id = :idApuesta;