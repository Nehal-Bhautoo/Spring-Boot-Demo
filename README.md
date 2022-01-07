# Spring Boot Application Demo

### Reference Documentation

<a href="https://github.com/Nehal-Bhautoo/Spring-Boot-Demo/tree/master/postman%20collection">Get Postman collection</a>

For further reference, please consider the following sections:

## API Documentation
### ![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) User
<details>
<summary>Get Users</summary>

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
            "password": "2OBbmWY8DRP1r3rWxRT+z84ocX+30S7x",
            "id": 1
        },
        {
            "uuid": "98e1a353-ca95-4275-9c67-75b8bb233587",
            "firstName": "Chandler",
            "lastName": "Bing",
            "password": "Qq6VHscANNkY6Kv9vu3PAQ==",
            "id": 4
        },
        {
            "uuid": "eb0ec31c-7f59-4a4a-8c44-7cc1a55fddee",
            "firstName": "firstName",
            "lastName": "lastName",
            "password": "+emdiEKUw1cdELiuB1PmyyEj3jRKaC1e",
            "id": 5
        },
        {
            "uuid": "d8d254d7-7299-4d7b-917c-689703957e31",
            "firstName": "new",
            "lastName": "user",
            "password": "a+4utOm8b9toFykuACiW/f6+6O2w5X/r",
            "id": 6
        },
        {
            "uuid": "3b624ac5-6612-43f6-8e58-29fde3f8046e",
            "firstName": "test",
            "lastName": "test",
            "password": "7fS7OCPzDhQWdYvxF5gojw==",
            "id": 7
        }
    ]
```    
</details>

<details>

<summary>Get Users By ID</summary>

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
    "password": "2OBbmWY8DRP1r3rWxRT+z84ocX+30S7x",
    "id": 1
}
```
</details>

<details>

<summary>Create new user</summary>

| Method | API                        |
|--------|----------------------------|
| POST   | localhost:8080/api/v1/user |

``` 
Body - JSON
    {
        "firstName": "firstName",
        "lastName": "lastName",
        "password": "password"
    }
```

The password will be encrypted before saving in database.
Method used: Jasypt (Java Simplified Encryption)

#### Response
```
Status: 200 OK
```
</details>

<details>

<summary>Update user</summary>

| Method | API                        |
|--------|----------------------------|
| POST   | localhost:8080/api/v1/user |

``` 
Body - JSON
    {
        "firstName": "firstName",
        "lastName": "lastName",
        "password": "password"
    }

```
#### Response
```
Status: 200 OK
```
</details>

<details>

<summary>Delete user</summary>

| Method | API                             |
|--------|---------------------------------|
| POST   | localhost:8080/api/v1/user/{id} |

#### Response
```
Status: 200 OK
```
</details>

### ![#1589F0](https://via.placeholder.com/15/1589F0/000000?text=+) Profile
<details>
<summary>Get Profile By User Id</summary>
</details>

<details>
<summary>Create User Profile</summary>
</details>