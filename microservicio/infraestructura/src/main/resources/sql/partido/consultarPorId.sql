select *, (select count(*) > 0 from apuestas a where a.id_partido = p.id) tiene_apuestas
from partidos p where id = :idPartido;