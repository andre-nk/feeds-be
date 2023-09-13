# API Spec

## Authentication

All API must use this authentication

Request :
- Header :
    - X-Api-Key : "your secret api key"

## Create Product

Request :
- Method : POST
- Endpoint : `/api/notes`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
  "id": "string, unique",
  "title": "string",
  "description": "string"
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
          "id" : "string, unique",
          "title" : "string",
          "description" : "string",
          "createdAt" : "date",
          "updatedAt" : "date"
     }
}
```

## Get Product

Request :
- Method : GET
- Endpoint : `/api/notes/{note_id}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
          "id" : "string, unique",
          "title" : "string",
          "description" : "string",
          "createdAt" : "date",
          "updatedAt" : "date"
     }
}
```

## Update Product

Request :
- Method : PUT
- Endpoint : `/api/notes/{note_id}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
      "title" : "string",
      "description" : "string"
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
          "id" : "string, unique",
          "title" : "string",
          "description" : "string",
          "createdAt" : "date",
          "updatedAt" : "date"
     }
}
```

## List Product

Request :
- Method : GET
- Endpoint : `/api/notes`
- Header :
    - Accept: application/json
- Query Param :
    - size : number,
    - page : number

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : [
        {
              "id" : "string, unique", 
              "title" : "string",
              "description" : "string",
              "createdAt" : "date",
              "updatedAt" : "date"
        },
        {
              "id" : "string, unique",
              "title" : "string",
              "description" : "string",
              "createdAt" : "date",
              "updatedAt" : "date"
        }
    ]
}
```

## Delete Product

Request :
- Method : DELETE
- Endpoint : `/api/notes/{note_id}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string"
}
```
