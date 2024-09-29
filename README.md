Für diese Teilaufgabe haben wir ein Backend in Java (Spring Boot) und Python (Flask) programmiert. Dadurch können wir z. B. sehen, wie Object Relation Mapper in unterschiedlichen Programmiersprachen verwendet werden.

| Name   | Sprache | ORM         |
| ------ | ------- | ----------- |
| Jannik | Java    | Spring Boot |
| Caspar | Python  | SQLAlchemy  |
### Hinzufügen eines Fahrers

#### Create Driver HTTP Post 125ms

```json
{
	"name": "Jannik Brozy",
	"city": "Chicago, United States",
	"licensePlate": "UN-PR 95"
}
``` 

### Response 

```json
{
	"id": 10001,
	"name": "Jannik Brozy",
	"city": "Chicago, United States",
	"licensePlate": "UN-PR 95"
}
```

#### Ändern eines Fahrers

#### Update Driver HTTP Put 57ms

```json
{
	"id": 10001,
	"name": "Jo Brozy",
	"city": "Chicago, United States",
	"licensePlate": "UN-PR 95"
}
```

#### Response

```json
{
	"id": 10001,
	"name": "Jo Brozy",
	"city": "Chicago, United States",
	"licensePlate": "UN-PR 95"
}
```

### Löschen eines Fahrers

#### Delete Driver HTTP Delete 28ms

```
	{{base_url}}/driver/10001
```

Prüfen ob der Driver noch existiert mit Get-Request.

```
	{{base_url}}/driver/10001
```

Server gibt 404 zurück.

### Ausgabe einer Fahrt inkl. Kunde, Fahrer und Wegpunkten (vgl. Wireframe)

#### HTTP Get auf
```
	{{base_url}}/ride/1  : 67ms
```

```json
{
    "id": 1,
    "rideDate": "2020-11-20T23:00:00.000+00:00",
    "distance": 107,
    "price": 187,
    "client": {
        "id": 1,
        "name": "Tobias Poth",
        "gender": "m"
    },
    "driver": {
        "id": 8976,
        "name": "Dean Sroka",
        "city": "Nagoya, Japan",
        "licensePlate": "JA-NA 8976"
    },
    "waypoints": [
        {
            "id": 11,
            "number": 11,
            "latitude": 35.1998,
            "longitude": 136.9714,
            "rideId": 1
        }
        ... (NOCH MEHR WAYPOINTS)
    ]
}
```


### Hinzufügen einer Fahrt mit Client, Driver und Waypoints

#### HTTP Post Request : 140ms

```json
{
	"clientId" : 1,
	"driverId" : 1,
	"rideDate" : "2021-11-09",
	"waypoints": [
		{
			"latitude" : 36.17089660,
			"longitude" : -86.78516411
		},
		{
			"latitude" : 42.31870896,
			"longitude" : -71.08484698
		}
	]
}
```

#### Response
```json
{
    "id": 1117175,
    "rideDate": "2021-11-09T00:00:00.000+00:00",
    "distance": 1511,
    "price": 0,
    "driver": {
        "id": 1,
        "name": "Jonah Gabler",
        "city": "Chicago, United States",
        "licensePlate": "UN-CH 1"
    },
    "client": {
        "id" : 1,
        "name" : "Tobias Poth",
        "gender" : "m"
    },
    "waypoints": [
        {
            "id": 6166943,
            "number": 2,
            "latitude": 42.31870896,
            "longitude": -71.08484698,
        },
        {
            "id": 6166944,
            "number": 1,
            "latitude": 36.1708966,
            "longitude": -86.78516411,
        }
    ]
}

```
### Statistic Query
#### Request auf
```
	{{base_url}}/stats
```

#### Response
```json
[
    {
        "city": "Nashville, United States",
        "anzahl": 9678,
        "umsatz": 1678556.0,
        "avgLat": 36.1708966,
        "avgLong": -86.78516411
    },
    ... (NOCH MEHR)
]
```
