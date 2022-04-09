import { useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { UPDATE_PATH } from "../Constants";
import { CRUDType, useFetch } from "../hooks/UseFetch";

export function UpdateForm() {
    const [url, setUrl] = useState<string>("")
    const [elevatorId, setElevatorId] = useState<number>(0)
    const [destinationFloor, setDestinationFloor] = useState<number>(0)

    useFetch(url, CRUDType.POST)

    const updateFormSubmit = (evt: any) => setUrl(`${UPDATE_PATH}/${elevatorId}/${destinationFloor}`)

    return (
        <Form className="p-2">
            <h1>Update Form</h1>
            <Row className="mb-3">
                <Form.Group as={Col} controlId="updateElevatorId">
                    <Form.Label>Elevator ID</Form.Label>
                    <Form.Control type="number" value={elevatorId} onChange={newElevatorId => setElevatorId(Number(newElevatorId.target.value))}/>
                </Form.Group>

                <Form.Group as={Col} controlId="updateDestinationFloor">
                    <Form.Label>Destination Floor</Form.Label>
                    <Form.Control type="number" value={destinationFloor} onChange={newDestinationFloor => setDestinationFloor(Number(newDestinationFloor.target.value))}/>
                </Form.Group>
            </Row>

            <Button variant="primary" type="submit" onClick={updateFormSubmit}>
                Submit
            </Button>
        </Form>
    )
}