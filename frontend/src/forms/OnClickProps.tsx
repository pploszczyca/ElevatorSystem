import { Elevator } from "../elevator/Elevator";

export interface OnClickProps {
    onClick: (elevatorsArray: Array<Elevator>) => void
}
