# ElevatorSystem
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