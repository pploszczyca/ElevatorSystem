import React from 'react';
import { ElevatorsTable } from './elevator/ElevatorsTable';
import 'bootstrap/dist/css/bootstrap.min.css';
import { CRUDType, useFetch } from './hooks/UseFetch';
import { ELEVATORS_PATH } from './Constants';
import { PickUpForm } from './forms/PickUpForm';

function App() {
  const [{ data, isLoading, error }] = useFetch(ELEVATORS_PATH, CRUDType.GET)

  if(isLoading) {
    return <div>Loading</div>
  }

  return (
    <div className="p-2">
      <h1>Elevators Status</h1>
      <ElevatorsTable elevatorsList={data}/>
      <h1>Pick Up Form</h1>
      <PickUpForm/>
    </div>
  );
}

export default App;
