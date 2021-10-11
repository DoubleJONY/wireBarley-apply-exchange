import React, { Component, useState, useEffect} from 'react'
import {DropdownButton, Dropdown} from 'react-bootstrap'

class ExampleDropDown extends Component {
    render() {
        return (
            <div className="ex">
                <DropdownButton id="dropdown-basic-button" title="수취국가:" onSelect={SelectItem}>
                    <Dropdown.Item eventKey="item1">아이템1</Dropdown.Item>
                    <Dropdown.Item eventKey="item2">아이템2</Dropdown.Item>
                    <Dropdown.Item eventKey="item3">아이템3</Dropdown.Item>
                </DropdownButton>
            </div>
        )
    }
};

function SelectItem(eventKey) {
    alert(eventKey+"!!")
    GetCurrency(eventKey)
}

function GetCurrency({ country }) {
    const [loading, setLoading] = useState(true);
    const [user, setUser] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        window
            .fetch(`https://localhost:8080/exchange/info?country=${country}`)
            .then((res) => res.json())
            .then((user) => {
                setUser(user);
                setLoading(false);
            })
            .catch((error) => {
                setError(error);
                setLoading(false);
            });
    }, [country]);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error!</p>;

    return (
        <ul>
            <li>id: {user.id}</li>
            <li>email: {user.email}</li>
            <li>name: {user.name}</li>
            <li>phone: {user.phone}</li>
            <li>website: {user.website}</li>
        </ul>
    );
}

export default ExampleDropDown