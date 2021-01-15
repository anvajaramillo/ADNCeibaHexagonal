UPDATE apuestas
SET dinero=:dinero, 
	nombre=:nombre, 
	cedula=:cedula, 
	puntajepais1=:puntajePais1,
	puntajepais2=:puntajePais2, 
	is_ganador=:isGanador,
	dinero_ganado=:dineroGanado, 
	id_partido=:idPartido
WHERE id=:id;