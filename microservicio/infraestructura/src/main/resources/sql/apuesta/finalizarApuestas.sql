UPDATE apuestas a
SET is_ganador = case a.puntajepais1 = p.puntaje_pais1 and a.puntajepais2 = p.puntaje_pais2 when true then true else false end,
	dinero_ganado = case a.puntajepais1 = p.puntaje_pais1 and a.puntajepais2 = p.puntaje_pais2 when true then a.dinero + :excedente else 0 end
from partidos p 
where a.id_partido = p.id and p.id  = :idPartido;