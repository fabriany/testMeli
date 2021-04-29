# Operación Fuego de Quasar

Desafío
Como jefe de comunicaciones rebelde, tu misión es crear un programa en Java que retorne
la fuente y contenido del mensaje de auxilio. Para esto, cuentas con tres satélites que te
permitirán triangular la posición, ¡pero cuidado! el mensaje puede no llegar completo a cada
satélite debido al campo de asteroides frente a la nave.


## Instalación y ejecución 

Primero Descargar Código del proyecto testMeli y
vamos a la ruta de descarga + \testMeli-master\

-Generar compilado JAR:

```bash
mvn clean install
```

-Ejecución del JAR
Vamos a la ruta de descarga + testMeli-master\target
y ejecutamos:

```bash
java -jar FuegoQuasar-0.0.1-SNAPSHOT.jar
```

## Documentacion de servicio web (Local) 

Request topsecret

```json
Method = POST
Url = http://localhost:8080/topsecret
Content-Type = application/json
Body = 
{
    "satelites": [
            {
                "name": "kenobi",
                "distance": 400,
                "message": ["este", " ", " ", "mensaje", " "]
            },
            {
                "name": "skywalker",
                "distance": 200,
                "message": [" ", "es", " ", " ", "secreto"]
            },
            {
                "name": "sato",
                "distance": 600,
                "message": ["este", " ", "un", " ", " "]
            }
    ]
}
```

Response topsecret  
```json
{
    "position": {
        "x": -137.5,
        "y": 75.0
    },
    "message": "este es un mensaje secreto"
}
```

Request topsecret_split POST
```json
Method = POST
Url = http://localhost:8080/topsecret_split/kenobi
Content-Type = application/json
Body = 
{
    "distance": 500,
    "message": ["este", " ", " ", "mensaje", " "]
}
```
Response topsecret_split POST
```json
Status: 201 Created
```

Request topsecret_split GET
```json
Method = GET
Url = http://localhost:8080/topsecret_split
```

Response topsecret_split GET
```json
{
    "position": {
        "x": -37.5,
        "y": -325.0
    },
    "message": "este es un mensaje secreto"
}
```

## Documentacion de servicio web (heroku) 

Request topsecret

```json
Method = POST
Url = http://meli-faby-dev.herokuapp.com/topsecret
Content-Type = application/json
Body = 
{
    "satelites": [
            {
                "name": "kenobi",
                "distance": 400,
                "message": ["este", " ", " ", "mensaje", " "]
            },
            {
                "name": "skywalker",
                "distance": 200,
                "message": [" ", "es", " ", " ", "secreto"]
            },
            {
                "name": "sato",
                "distance": 600,
                "message": ["este", " ", "un", " ", " "]
            }
    ]
}
```

Response topsecret  
```json
{
    "position": {
        "x": -137.5,
        "y": 75.0
    },
    "message": "este es un mensaje secreto"
}
```

Request topsecret_split POST
```json
Method = POST
Url = http://meli-faby-dev.herokuapp.com/topsecret_split/kenobi
Content-Type = application/json
Body = 
{
    "distance": 500,
    "message": ["este", " ", " ", "mensaje", " "]
}
```
Response topsecret_split POST
```json
Status: 201 Created
```

Request topsecret_split GET
```json
Method = GET
Url = http://meli-faby-dev.herokuapp.com/topsecret_split
```
Response topsecret_split GET
```json
{
    "position": {
        "x": -37.5,
        "y": -325.0
    },
    "message": "este es un mensaje secreto"
}
```
