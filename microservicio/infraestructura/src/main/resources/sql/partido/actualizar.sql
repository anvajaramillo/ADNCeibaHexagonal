UPDATE partidos
SET pais1=:pais1, 
	pais2=:pais2, 
	hora_inicio=:horaInicio, 
	hora_fin=:horaFin, 
	puntaje_pais1=:puntajePais1, 
	puntaje_pais2=:puntajePais2
WHERE id=:idPartido;