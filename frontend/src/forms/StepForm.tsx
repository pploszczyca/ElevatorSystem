import { useState } from "react";
import { Form, Button } from "react-bootstrap";
import { STEP_PATH } from "../Constants";
import { CRUDType, useFetch } from "../hooks/UseFetch";

export function StepForm() {
    const [url, setUrl] = useState<string>("")

    useFetch(url, CRUDType.POST)

    const stepFormSubmit = (evt: any) => setUrl(STEP_PATH)

    return (
        <Form className="p-2">
            <h1>Step Form</h1>
            <Button variant="primary" type="submit" onClick={stepFormSubmit}>
                Submit
            </Button>
        </Form>
    )
}