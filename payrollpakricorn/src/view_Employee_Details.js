import React, { useState, useEffect } from "react";
import "./ViewEmployeeDetails.css";

const ViewEmployeeDetails = () => {
  const [value, setValue] = useState("");
  const [data, setData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [showTable, setShowTable] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");

  useEffect(() => {
    fetch("http://localhost:8081/api/list")
      .then((response) => response.json())
      .then((jsondata) => setData(jsondata));
  }, []);

  const buttonfunction = () => {
    const details = data.filter(
      (obj) => obj.id.toString() === value || obj.firstName === value
    );

    if (details.length > 0) {
      setFilteredData(details);
      setShowTable(true);
      setErrorMessage("");
    } else {
      setFilteredData([]);
      setShowTable(false);
      setErrorMessage("Invalid Employee ID or Employee Name");
    }
  };

  return (
    <div className="container">
      <h1 className="title">
        <u>VIEW EMPLOYEE DETAILS</u>
      </h1>
      <div className="search-container">
        <label htmlFor="fname" className="search-label">
          SEARCH :
        </label>
        <input
          type="text"
          id="fname"
          name="fname"
          value={value}
          placeholder="Enter EmployeeID or Name"
          onChange={(e) => {
            setValue(e.target.value);
          }}
          autoComplete="off"
          className="search-input"
        />
        <button className="search-button" onClick={buttonfunction}>
          SUBMIT
        </button>
      </div>
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      {showTable && filteredData.length > 0 && (
        <table className="data-table">
          <thead>
            <tr>
              <th>Employee ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Address</th>
              <th>Contact Number</th>
              <th>Email Address</th>
              <th>Date Of Birth</th>
              <th>Employment Start Date</th>
              <th>Tax Identification Number</th>
              <th>Bank Name</th>
              <th>Account Number</th>
              <th>Routing Number</th>
              <th>Employee OfferLetter ReleaseDate</th>
              <th>Employee Designation</th>
              <th>Joining Date</th>
              <th>Joining Ctc</th>
              <th>HikeLetter Date</th>
              <th>Hike Ctc</th>
              <th>Hike Designation</th>
              <th>HikeLetter EffectiveDate</th>
            </tr>
          </thead>
          <tbody>
            {filteredData.map((user) => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.firstName}</td>
                <td>{user.lastName}</td>
                <td>{user.contactNumber}</td>
                <td>{user.emailAddress}</td>
                <td>{user.dateOfBirth}</td>
                <td>{user.employmentStartDate}</td>
                <td>{user.taxIdentificationNumber}</td>
                <td>{user.bankName}</td>
                <td>{user.accountNumber}</td>
                <td>{user.routingNumber}</td>
                <td>{user.employeeOfferLetterReleaseDate}</td>
                <td>{user.employeeDesignation}</td>
                <td>{user.joiningDate}</td>
                <td>{user.joiningCtc}</td>
                <td>{user.hikeLetterDate}</td>
                <td>{user.hikeCtc}</td>
                <td>{user.hikeDesignation}</td>
                <td>{user.hikeLetterEffectiveDate}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default ViewEmployeeDetails;
