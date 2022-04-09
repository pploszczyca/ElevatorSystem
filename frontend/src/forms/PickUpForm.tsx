import { useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { PICKUP_PATH } from "../Constants";
import { CRUDType, useFetch } from "../hooks/UseFetch";

export function PickUpForm() {
    const [url, setUrl] = useState<string>("")
    const [floor, setFloor] = useState<number>(0)
    const [direction, setDirection] = useState<number>(1)

    useFetch(url, CRUDType.POST)

    const pickUpFormSubmit = (evt: any) => setUrl(`${PICKUP_PATH}/${floor}/${direction}`)

    return (
        <Form className="p-2">
            <h1>Pick Up Form</h1>
            <Row className="mb-3">
                <Form.Group as={Col} controlId="pickUpFloor">
                    <Form.Label>Floor</Form.Label>
                    <Form.Control type="number" value={floor} onChange={newFloor => setFloor(Number(newFloor.target.value))}/>
                </Form.Group>

                <Form.Group as={Col} controlId="pickUpDirection">
                    <Form.Label>Direction</Form.Label>
                    <Form.Select onChange={newDirection => setDirection(Number(newDirection.target.value))}>
                        <option value="1">UP</option>
                        <option value="-1">DOWN</option>
                    </Form.Select>
                </Form.Group>
            </Row>

            <Button variant="primary" type="submit" onClick={pickUpFormSubmit}>
                Submit
            </Button>
        </Form>
    )
}

