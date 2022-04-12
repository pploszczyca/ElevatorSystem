import { useEffect, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { MAX_FLOOR_LEVEL, MIN_FLOOR_LEVEL, UPDATE_PATH } from "../Constants";
import { CRUDType, useFetch } from "../hooks/UseFetch";
import { OnClickProps } from "./OnClickProps";

export function UpdateForm({onClick}: OnClickProps) {
    const [url, setUrl] = useState<string>("")
    const [elevatorId, setElevatorId] = useState<number>(0)
    const [destinationFloor, setDestinationFloor] = useState<number>(0)
    const [{ data, runFetchAgain }] = useFetch(url, CRUDType.POST)
    
    const onButtonClick = () => {
        setUrl(`${UPDATE_PATH}/${elevatorId}/${destinationFloor}`)
        runFetchAgain()
    }

    useEffect(() => {
        onClick(data)
    }, [data])


    return (
        <div className="p-2">
            <h1>Update Form</h1>
            <Row className="mb-3">
                <Form.Group as={Col} controlId="updateElevatorId">
                    <Form.Label>Elevator ID</Form.Label>
                    <Form.Control type="number" value={elevatorId} onChange={newElevatorId => setElevatorId(Number(newElevatorId.target.value))}/>
                </Form.Group>

                <Form.Group as={Col} controlId="updateDestinationFloor">
                    <Form.Label>Destination Floor</Form.Label>
                    <Form.Control type="number" value={destinationFloor} min={MIN_FLOOR_LEVEL} max={MAX_FLOOR_LEVEL} onChange={newDestinationFloor => setDestinationFloor(Number(newDestinationFloor.target.value))}/>
                </Form.Group>
            </Row>

            <Button variant="primary" type="submit" onClick={onButtonClick}>
                Make update
            </Button>
        </div>
    )
}