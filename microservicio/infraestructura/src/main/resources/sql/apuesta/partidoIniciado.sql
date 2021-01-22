select coalesce(current_timestamp >= hora_inicio,false)
from partidos
where id = :idPartido;