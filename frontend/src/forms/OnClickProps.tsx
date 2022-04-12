import { MAX_FLOOR_LEVEL, MIN_FLOOR_LEVEL } from "../Constants";
import { Elevator } from "../elevator/Elevator";

export interface OnClickProps {
    onClick: (elevatorsArray: Array<Elevator>) => void
}

export const isFloorProper = (floor: number) => MIN_FLOOR_LEVEL <= floor && floor <= MAX_FLOOR_LEVEL
