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

## How to run
### With docker
#### Backend
Go to `backend` folder and build image:
```
$ sudo docker build . -t pploszczyca/elevators-system-backend
```
To run:
```
$ sudo docker run -p 9000:9000 -d pploszczyca/elevators-system-backend
```

#### Frontend
Go to `frontend` folder and build image
```
$ sudo docker build . -t pploszczyca/elevators-system-frontend
```
To run:
```
$ sudo docker run -p 3000:3000 -d pploszczyca/elevators-system-frontend
```