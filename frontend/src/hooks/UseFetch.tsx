import { useEffect, useState } from "react"

export enum CRUDType {
    GET = 'GET',
    POST = 'POST'
}

export const useFetch = (url: string, method: CRUDType) => {
    const [data, setData] = useState<any>(null)
    const [isLoading, setIsLoading] = useState<boolean>(true)
    const [error, setError] = useState<any>(null)
    const [runFetch, setRunFetch] = useState<boolean>(false)

    // eslint-disable-next-line react-hooks/exhaustive-deps
    const runFetchAgain = () => setRunFetch(!runFetch)

    useEffect(() => {
        const requestOptions: RequestInit = {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            }
        }
    
        if(url !== "") {
            fetch(url, requestOptions)
            .then(async response => await response.json())
            .then(async result => {
                setData(result)
                setIsLoading(false)
            })
            .catch(error => setError(error.toString()))
        }
    }, [url, runFetch, method])

    return [{ data, isLoading, error, runFetchAgain }]
}
