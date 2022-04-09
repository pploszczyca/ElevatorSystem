import React from 'react';
import './App.css';
import { ElevatorsTable } from './elevator/ElevatorCard';
import 'bootstrap/dist/css/bootstrap.min.css';
import { CRUDType, useFetch } from './hooks/UseFetch';
import { ELEVATORS_PATH } from './Constants';

function App() {
  const [{ data, isLoading, error }] = useFetch(ELEVATORS_PATH, CRUDType.GET)

  if(isLoading) {
    return <div>Loading</div>
  }

  return (
    <div className="App m-1">
      <ElevatorsTable elevatorsList={data}/>
    </div>
  );
}

export default App;
