# Criação de API utilizando java com framework Spring Boot e banco de dados H2.
Tanto API quanto banco estão armazenados no docker sendo necessário a instalação do Docker e Docker compose para efetuar os testes.
docker-compose.
O comando abaixo irá executar o docker-compose.yml e irá subir o docker que será encarregado do banco e api, após o comando a api ja estará rodando na porta http://127.0.0.1:8080/developer ou http://localhost:8080/developer
gazin_api
```
docker-compose up
```
# API endpoints
Para fazer a verificação dos dados e endpoint poderá usufruir das consultas prontas, bastando importar no postman o arquivo 'Gazin_api.postman_collection.json'.

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

