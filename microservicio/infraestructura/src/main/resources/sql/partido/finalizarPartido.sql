UPDATE partidos
SET hora_fin=:horaFin, 
	puntaje_pais1=:puntajePais1, 
	puntaje_pais2=:puntajePais2
WHERE id=:idPartido;