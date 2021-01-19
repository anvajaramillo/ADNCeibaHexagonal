UPDATE partidos
SET pais1=:pais1, 
	pais2=:pais2, 
	hora_inicio=:horaInicio
WHERE id=:idPartido;