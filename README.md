# ElevatorSystem
Simple client-server app that simulates Elevator System.
## Technologies
### Backend
* [Scala 3](https://docs.scala-lang.org/scala3/new-in-scala3.html)
* [Http4s](https://http4s.org/)
* [json4s](https://github.com/json4s/json4s)
* [scalatest](https://www.scalatest.org/)

### Frontend
* [React](https://pl.reactjs.org/)
* [TypeScript](https://www.typescriptlang.org/)
* [React Boostrap](https://react-bootstrap.github.io/)

## Ports
* Backend - 9000
* Frontend - 3000

## How to run
### With docker
#### Both backend and frontend
Build backend image:
```
$ sudo docker build backend/. -t pploszczyca/elevators-system-backend
```
Build frontend image:
```
$ sudo docker build frontend/. -t pploszczyca/elevators-system-frontend
```
Run both:
```
$ sudo docker-compose -f docker-compose.yml up
```
To see frontend page go to: http://localhost:3000

#### Only Backend
Go to `backend` folder and build image:
```
$ sudo docker build . -t pploszczyca/elevators-system-backend
```
To run:
```
$ sudo docker run -p 9000:9000 -d pploszczyca/elevators-system-backend
```

#### Only Frontend
Go to `frontend` folder and build image
```
$ sudo docker build . -t pploszczyca/elevators-system-frontend
```
To run:
```
$ sudo docker run -p 3000:3000 -d pploszczyca/elevators-system-frontend
```

### Without docker
#### Backend
Go to `backend` folder and run:
```
$ sbt compile
$ sbt run
```

#### Frontend
Go to `frontend` folder and run:
```
$ npm install
$ npm run
```

## API
### Get Elevators Status
```http
GET /elevators
```
#### Response
Json, list of elevators status
```json
[
    {
    "elevatorID": 0,
    "currentFloor": 2,
    "destinationFloor": 3
    }, ...
]
```

### Pickup elevator
```http
POST /elevators/pickup/{floor}/{direction}
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `floor` | `int` | **Required**. Floor where we press the button |
| `direction` | `-1 or 1` | **Required**. Direction, 1 is UP, -1 is DOWN|

#### Example
```http
POST /elevators/pickup/10/1
```
#### Response
Json, list of elevators status
```json
[
    {
    "elevatorID": 0,
    "currentFloor": 2,
    "destinationFloor": 3
    }, ...
]
```

### Update elevator
```http
POST /elevators/update/{elevatorId}/{destinationFloor}
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `elevatorId` | `int` | **Required**. Id of elevator |
| `destinationFloor` | `int` | **Required**. Destination floor|

#### Example
```http
POST /elevators/update/1/5
```

#### Response
Json, list of elevators status
```json
[
    {
    "elevatorID": 0,
    "currentFloor": 2,
    "destinationFloor": 3
    }, ...
]
```

### Make step
```http
POST /elevators/step
```

#### Response
Json, list of elevators status
```json
[
    {
    "elevatorID": 0,
    "currentFloor": 2,
    "destinationFloor": 3
    }, ...
]
```