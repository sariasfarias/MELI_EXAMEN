HOST: http://ec2-18-191-31-214.us-east-2.compute.amazonaws.com:8080/api/v1/mutante

# API REST Mutant

Se implementa una REST API usando JSON.
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
