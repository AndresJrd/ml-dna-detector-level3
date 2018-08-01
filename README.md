# Mercadolibre Nivel 3
Para satisfacer el siguiente pedido 

Encontrar mas de una secuencia de 4 letras iguales, de forma oblicua, horizontal o vertical, como la siguiente
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

#Se utilizo
* Java 1.8
* Maven
* Spring Boot 2.0.4
* Amazon AWS - Elastic Beanstalk
* Amazon AWS -DynamoDB


#Funcionamiento
Para ejecutar la deteccion se implemento un servicio Rest (Post) que recibe como parametro un JSON como el siguiente:

{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}

http://mercadolibreandresjesus.us-east-2.elasticbeanstalk.com/mutant

En caso de cumplir con la condicion de ser mutante el servicio responde con el codigo HTTP HttpStatus.OK
caso contrario HttpStatus.FORBIDDEN

Para consultar las estadisticas de evaluacion implemento un servicio rest (GET)

http://mercadolibreandresjesus.us-east-2.elasticbeanstalk.com/stats

El servidor responde con el siguiente formato de ejemplo

{"count_mutant_dna":2,"count_human_dna":4,"ratio":0.5}
