HOST: http://ec2-18-191-31-214.us-east-2.compute.amazonaws.com:8080/api/v1/mutante

#INSTRUCCIONES

Abrir un terminal, donde este el permiso 36165347.pem y ejecutar el sigiente comando

~ ssh -i "35165347.pem" ec2-user@ec2-18-191-31-214.us-east-2.compute.amazonaws.com

Se conectará a la maquina virtual de linux, una vez adentro ejecutar el siguiente comando para ejecutar la aplicación

~  java -jar MELI_EXAMEN-0.0.1-SNAPSHOT.jar

Conectarse a Postman con el host indicado sin ningún tipo de credenciales.
Para realizar un POST se debe enviar un Json como el descripto,
según sea el caso será la respuesta.

# API REST Mutant

Se implementa una REST API en spring boot, con base de datos en AWS con motor mySQL,
el cual esta deployado en una maquina virtual en Linux en AWS.
El trafico de información se hace mediante JSON.
La API podra interactura con elementos externos que requieran del servicio.

# HTTP Request soportadas
<table>
<tr><td>POST:</td><td>Crear recurso. </td></tr>
<tr><td>GET: </td><td>Obtener un recurso de una lista de recursos.</td></tr>
</table>


## Responses erroneos típicos

<table>
<tr><td>400 Bad Request</td><td>The input values are incorrect</td></tr>
</table>

## Operaciones disponibles [/]
### Insertar mutante [POST]
+ Request (application/json)

{
"adn":["TTGCTA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"]
}
+ Response 200 (application/json)
{
Mutant insert
}

### Insertar humano [POST]
{
"adn":["TTGCTA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"]
}
+ Response 403 (application/json)
{
Human insert
}
## Operaciones disponibles [/stash]
### Consultar proporción de mutantes y humanos [GET]
+ Response 200
{
    "count_mutant_dna": 5,
    "count_human_dna": 3,
    "ratio": "1,67"
}
