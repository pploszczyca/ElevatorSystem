import React from 'react';
import { ElevatorsTable } from './elevator/ElevatorsTable';
import 'bootstrap/dist/css/bootstrap.min.css';
import { CRUDType, useFetch } from './hooks/UseFetch';
import { ELEVATORS_PATH } from './Constants';
import { PickUpForm } from './forms/PickUpForm';
import { UpdateForm } from './forms/UpdateForm';
import { StepForm } from './forms/StepForm';
import { Col, Container, Row } from 'react-bootstrap';

function App() {
  const [{ data, isLoading, runFetchAgain }] = useFetch(ELEVATORS_PATH, CRUDType.GET)
  var elevatorsList = data

  if(isLoading) {
    return <div>Loading</div>
  }

  return (
    <Container className="p-2">
      <Row>
        <Col>
          <h1>Elevators Status</h1>
          <ElevatorsTable elevatorsList={elevatorsList}/>
        </Col>
        <Col>
          <PickUpForm onClick={runFetchAgain}/>
          <UpdateForm onClick={runFetchAgain}/>
          <StepForm onClick={runFetchAgain}/>
        </Col>
      </Row>
    </Container>
  );
}

export default App;
