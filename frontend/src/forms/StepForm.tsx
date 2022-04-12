import { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { STEP_PATH } from "../Constants";
import { CRUDType, useFetch } from "../hooks/UseFetch";
import { OnClickProps } from "./OnClickProps";

export function StepForm({onClick}: OnClickProps) {
    const [url, setUrl] = useState<string>("")
    const [{ data, runFetchAgain }] = useFetch(url, CRUDType.POST)

    const onButtonClick = () => {
        setUrl(STEP_PATH)
        runFetchAgain()
    }

    useEffect(() => {
        onClick(data)
    }, [data, onClick])

    return (
        <div className="p-2">
            <h1>Make Elevators Step</h1>
            <Button variant="primary" type="submit" onClick={onButtonClick}>
                Make Step
            </Button>
        </div>
    )
}