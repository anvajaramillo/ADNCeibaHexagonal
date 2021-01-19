UPDATE apuestas a
SET is_ganador = case a.puntajepais1 = :puntajePais1 and a.puntajepais2 = :puntajePais2 when true then true else false end,
	dinero_ganado = case a.puntajepais1 = :puntajePais1 and a.puntajepais2 = :puntajePais2 when true then a.dinero + :excedente else 0 end
where a.id_partido = :idPartido;