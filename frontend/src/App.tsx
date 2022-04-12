import React, { useEffect, useState } from 'react';
import { ElevatorsTable } from './elevator/ElevatorsTable';
import 'bootstrap/dist/css/bootstrap.min.css';
import { CRUDType, useFetch } from './hooks/UseFetch';
import { ELEVATORS_PATH } from './Constants';
import { PickUpForm } from './forms/PickUpForm';
import { UpdateForm } from './forms/UpdateForm';
import { StepForm } from './forms/StepForm';
import { Col, Container, Row } from 'react-bootstrap';
import { Elevator } from './elevator/Elevator';

function App() {
  const [{ data, isLoading }] = useFetch(ELEVATORS_PATH, CRUDType.GET)
  const [ elevatorsList, setElevatorsList] = useState<Elevator[] | []>([])

  useEffect(() => {
    if(data != null) {
      setElevatorsList(data)
    }
  }, [data])

  if(isLoading) {
    return <div>Loading</div>
  }

  const changeData = (newElevatorsArray: Array<Elevator>) => {
    if (newElevatorsArray != null) {
      setElevatorsList(newElevatorsArray)
    } 
  }

  return (
    <Container className="p-2">
      <Row>
        <Col>
          <h1>Elevators Status</h1>
          <ElevatorsTable elevatorsList={elevatorsList}/>
        </Col>
        <Col>
          <PickUpForm onClick={changeData}/>
          <UpdateForm onClick={changeData}/>
          <StepForm onClick={changeData}/>
        </Col>
      </Row>
    </Container>
  );
}

export default App;
