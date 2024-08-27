const server_url = process.env.NEXT_PUBLIC_BASE_API_URL

export const getData = async(url: string, token?: string) => {
    const headers = {
        'Content-Type': 'application/json',
        ...(token && { 'Authorization': `Bearer ${token}` })
    };
    const result = await fetch(`${server_url}/${url}`, {
        method: 'GET',
        headers: headers,
    })
    return result.json();
}

export const postData = async(url: string, post: object, token?: string) => {
    const headers = {
        'Content-Type': 'application/json',
        ...(token && { 'Authorization': `Bearer ${token}` })
    };
    const result = await fetch(`${server_url}/${url}`, {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(post)
    })
    return result.json();
}

export const putData = async(url: string, put: object, token: string) => {
    const headers = {
        'Content-Type': 'application/json',
        ...(token && { 'Authorization': `Bearer ${token}` })
    };
    const result = await fetch(`${server_url}/${url}`, {
        method: 'PUT',
        headers: headers,
        body: JSON.stringify(put)
    })
    return result.json();
}

export const patchData = async(url: string, patch: object, token: string) => {
    const headers = {
        'Content-Type': 'application/json',
        ...(token && { 'Authorization': `Bearer ${token}` })
    };
    const result = await fetch(`${server_url}/${url}`, {
        method: 'PATCH',
        headers: headers,
        body: JSON.stringify(patch)
    })
    return result.json();
}

export const deleteData = async(url: string, token: string) => {
    const headers = {
        'Content-Type': 'application/json',
        ...(token && { 'Authorization': `Bearer ${token}` })
    };
    const result = await fetch(`${server_url}/${url}`, {
        method: 'DELETE',
        headers: headers
    })
    return result.json();
}