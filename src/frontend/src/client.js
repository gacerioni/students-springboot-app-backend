import fetch from 'unfetch';

const apiUrlHost = process.env.REACT_APP_API_URI;
const studentsFullAPI = ''.concat(apiUrlHost,'/api/v1/students')
console.log("This is the Students full API URI for this environment: " + studentsFullAPI);

const checkStatus = response => {

    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);

}

export const getAllStudents = () =>
    fetch(studentsFullAPI, {
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    })
        .then(checkStatus);

export const addNewStudent = student =>
    fetch(studentsFullAPI,
        {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(student)
        }).then(checkStatus);

export const deleteStudent = studentId =>
    fetch(`${studentsFullAPI}/${studentId}`,
        {method: 'DELETE'})
        .then(checkStatus);