# API Documentation

This API uses `GET`, `POST`, & `PUT` methods to communicate. This API returns HTTP response codes to indicate any error; on successful requests, custom responses are returned to verify the success. All requests must have a body that is valid JSON. All responses are returned as standard JSON.

## Response Codes

```
409: Conflict
500: Internal Server Error
```

## Error Reasons

```
409: Product Already Exists
500: "java.lang.NullPointerException: Name cannot be null or empty ..."
500: "java.lang.IllegalArgumentException: Invalid quantity: -19 ..."
```

## Example Error Message

```
{
    "timestamp": 2020-08-06 19:58:32.293,
    "status": 409,
    "error": Conflict,
    "message": Product is already in inventory,
    "path": uri=/products
}
```

---

## Creating a new product

- **You send:** The required product details
- **You receive:** A response about the requested product

### Example `POST` Request URL

```
<API URL>/products
```

### Example `POST` Request Body

```
{
    "name": "Ghost Pepper",
    "stock": 10
}
```

### Successful Response:

```
{
    "sku": "hEjoZJVt67K3AJ6hdKtt",
    "name": "Ghost Pepper",
    "stock": 10
}
```

### Failed Response:

```
{
    "timestamp": 2020-08-06 20:01:43.255,
    "status": 409,
    "error": Conflict,
    "message": Product is already in inventory,
    "path": uri=/products
}
```

---

## Updating an existing product

- **You send:** The required product details
- **You receive:** A response about the requested product

### Example `PUT` Request URL

```
<API URL>/products/Ghost%20Pepper
```

### Example `PUT` Request Body

```
{
    "name": "Ghost Pepper",
    "stock": 20
}
```

### Successful Response:

```
{
    "sku": "hEjoZJVt67K3AJ6hdKtt",
    "name": "Ghost Pepper",
    "stock": 20
}
```

### Failed Response:

```
{
    "timestamp": "2020-08-07T01:30:55.608+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "trace": "java.lang.IllegalArgumentException: Invalid quantity: -20 ... ",
    "message": "Invalid quantity: -20",
    "path": "/products/Ghost%20Pepper"
}
```

---

## Retrieving all products

- **You send:** The required product details
- **You receive:** A response about the requested product

### Example `GET` Request URL

```
<API URL>/products
```

### Example `GET` Request Body

- **A request body is not required**

```
{

}
```

### Successful Response:

- **An array of JSON objects is returned**

```
[
    {
        "sku": "hEjoZJVt67K3AJ6hdKtt",
        "name": "Ghost Pepper",
        "stock": 20
    }
]
```

### Failed Response:

- **No failure code will be returned - if there are no products in the database, an empty array is returned.**

```
[ ]
```

---

_Project By:_ Code 4 World Peace (Nancy, Zach, Julian, George, Tyler)
