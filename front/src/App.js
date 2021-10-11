import './App.css';
import ExampleDropDown from './ExampleDropDown';
import {Dropdown, DropdownButton} from "react-bootstrap";
import React from "react";
import ReactDropdown from "react-dropdown";

let selectedItem;

function App() {

  return (
      <header>
        환율 계산>
        <p>
          <p>송금국가: 미국(USD)</p>
          <p>수취국가:
            <DropdownButton id="dropdown-basic-button" title="수취국가:" onSelect={SelectItem}>
              <Dropdown.Item eventKey="item1">아이템1</Dropdown.Item>
              <Dropdown.Item eventKey="item2">아이템2</Dropdown.Item>
              <Dropdown.Item eventKey="item3">아이템3</Dropdown.Item>
            </DropdownButton>
          </p>
          <p>환율: {selectedItem}</p>
          <p>송금액: <input className="remittanceAmount"></input></p>
        </p>
      </header>
  );
}

function SelectItem(eventKey) {
  selectedItem = eventKey;
  alert(eventKey+"!!")
  // GetCurrency(eventKey)
}

export default App;
