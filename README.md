# Criacao de uma API utilizando java utilizando framework Spring utilizando banco H2
Tanto api quanto banco estao armazenados no docker sendo necessario a instalação do Docker e Docker compose para efetuar os testes.
docker-compose
o commando abaixo ira executar o docker-compose.yml e ira subir o docker que sera encarregado 
do banco e api, apos o comando a api ja estara rodando na porta http://127.0.0.1:8080/developers ou http://localhost:8080/developers
gazin_api
```
docker-compose up
```
# API endpoints
Para Fazer a verificação dos dados e endpoint poderá usufruir das consultas prontas, bastando importar no postman o arquivo 'Gazin_api.postman_collection.json'.

Adiciona um novo desenvolvedor:
```
PUT /developer
Codes 200 / 400

{    
    "nome": "Robson Ferreira Cirino",
    "sexo": "M",
    "idade": 30,
    "hobby": "Airsoft",
    "datanascimento": "1991-10-13"
}

```

Retorna todos os desenvolvedores:
```
GET /developer
Codes 200

{
    "id": 1,
    "nome": "Robson Ferreira Cirino",
    "sexo": "M",
    "idade": 30,
    "hobby": "Airsoft",
    "datanascimento": "1991-10-13"
}
```

Retorna desenvolvedor conforme filtros:

```
GET /developer?nome=Robson Ferreira Cirino
Codes 200 / 404


    "id": 1,
    "nome": "Robson Ferreira Cirino",
    "sexo": "M",
    "idade": 30,
    "hobby": "Airsoft",
    "datanascimento": "1991-10-13",
     

```

Retorna desenvolvedor conforme ID:

```
GET /developer/1
Codes 200 / 404


    "id": 1,
    "nome": "Robson Ferreira Cirino",
    "sexo": "M",
    "idade": 30,
    "hobby": "Airsoft",
    "datanascimento": "1991-10-13",
     

```
Atualiza os dados de um desenvolvedor:
```
PUT /developer/{id}
Codes 200 / 400
{
    "nome": "Robson F C",
    "sexo": "M",
    "idade": 31,
    "hobby": "Airsoft e programacao",
    "datanascimento": "1991-10-13",
}    
```
DELETE /developer/{id}
Codes 204 / 400

```
Apaga o registro de um desenvolvedor

