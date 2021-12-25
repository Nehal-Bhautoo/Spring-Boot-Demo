# Spring Boot Application Demo

### Reference Documentation
For further reference, please consider the following sections:


## API Documentation
### User
<details>
<summary><strong>Get Users</strong></summary>

| Method | API                        |
|--------|----------------------------|
| GET    | localhost:8080/api/v1/user |

#### Response
 ```                                                   
    [
        {
            "uuid": "4e4b9a32-f450-4987-b5c9-9c25e9deff0f",
            "firstName": "Nehal",
            "lastName": "Bhautoo",
            "id": 1
        },
        {
            "uuid": "98e1a353-ca95-4275-9c67-75b8bb233587",
            "firstName": "Chandler",
            "lastName": "Bing",
            "id": 4
        }
    ]
```    
</details>

<details>

<summary><strong>Get Users By ID</strong></summary>

| Method | API                             |
|--------|---------------------------------|
| GET    | localhost:8080/api/v1/user/{id} |

``` 
Parameter  - {id}
```
#### Response
```
{
    "uuid": "4e4b9a32-f450-4987-b5c9-9c25e9deff0f",
    "firstName": "Nehal",
    "lastName": "Bhautoo",
    "id": 1
}
```
</details>
