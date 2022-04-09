import { useEffect, useState } from "react"

export enum CRUDType {
    GET = 'GET',
    POST = 'POST'
}

export const useFetch = (url: string, method: CRUDType) => {
    const [data, setData] = useState<any>(null)
    const [isLoading, setIsLoading] = useState<boolean>(true)
    const [error, setError] = useState<any>(null)

    const requestOptions: RequestInit = {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        }
    }

    useEffect(() => {
        if(url !== "") {
            fetch(url, requestOptions)
            .then(async response => await response.json())
            .then(async result => {
                setData(result)
                setIsLoading(false)
            })
            .catch(error => setError(error.toString()))
        }
    }, [url])

    return [{ data, isLoading, error }]
}
