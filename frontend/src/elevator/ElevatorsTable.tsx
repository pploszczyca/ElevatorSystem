import { Table } from "react-bootstrap";
import { Elevator } from "./Elevator";

interface ElevatorsTableProps {
    elevatorsList: Array<Elevator>
}

export function ElevatorsTable ({elevatorsList}: ElevatorsTableProps) {
    return (
        <Table striped bordered variant="dark">
            <thead>
                <tr>
                    <th>Elevator ID</th>
                    <th>Current Floor</th>
                    <th>Destination Floor</th>
                </tr>
            </thead>
            <tbody>
                {
                    elevatorsList.map((val, index) => 
                        <tr>
                            <td>{val.elevatorID}</td>
                            <td>{val.currentFloor}</td>
                            <td>{val.destinationFloor}</td>
                        </tr>
                    )
                }
            </tbody>
        </Table>
    );
}