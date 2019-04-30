# mutants-l3
MeLi Challenge - Level 3 (WIP)

Pendientes:
- Embeber MongoDB, actualmente intenta conectarse a una BD mongo local.
- Completar los tests de integración.
- Automatizar los test y reportarlos a un sonarqube.

Estado:
- Para persistir los registros de verificaciones de ADNs se optó por mongoDB, se lo ingregó con spring data.
- El servicio "/stats" consulta directamente con un count sobre la BD, dado que como podría ser necesario escalar con multiples instancias según el tráfico era la única forma de tener la información más actualizada.
- Para el servicio "/mutant" se propiorizó el tiempo de respuesta, por lo cual, si bien verifica el ADN, no lo guarda en el mismo thread, lo encola para que un scheduler lo atienda periódicamente, éste va tomarlo los registros de la cola y verificando que aún no exista en la BD (para reducir al máximo los updates innecesarios sobre la BD).
  Considerando que podrían haber multiples instancia pegándole a la misma BD, se intenta minimizar el uso de la BD.
  Una vez que se verificó un registro y aún no está en la BD, se lo pasa a otra cola para que la agarre (tambiénn periódicamente) otro scheduler que es quien se encarga de guardarlo.
  Por supuesto que el registro podría existir al momento de intentar guardarlo si algún balancer en el medio envió un pedido con los mismos datos a otra instancia de la aplicación, pero la idea es reducir las tareas de inserción que son más lentas.
  Cara uno de los scheduler debería tener su propia conexión a Mongo, para evitar bloqueos.
