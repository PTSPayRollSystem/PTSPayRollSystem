package com.pakrikorn.Employee.Information.Management.employee;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    
    private String emailAddress;
    @JsonFormat(pattern="dd-mm-yyyy")
    private LocalDate dateOfBirth;
    @JsonFormat(pattern="dd-mm-yyyy")
    private LocalDate employmentStartDate;
    private String taxIdentificationNumber;
    private String bankName;
    private String accountNumber;
    private String routingNumber;
    private String bankBranch;
    @JsonFormat(pattern="dd-mm-yyyy")
    private String employeeOfferLetterReleaseDate;
    private String employeeDesignation;
    @JsonFormat(pattern="dd-mm-yyyy")
    private String joiningDate;
    private String joiningCtc;
    @JsonFormat(pattern="dd-mm-yyyy")
    private String hikeLetterDate;
    private String hikeCtc;
    private String hikeDesignation;
    @JsonFormat(pattern="dd-mm-yyyy")
    private String hikeLetterEffectiveDate;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", emailAddress=" + emailAddress + ", dateOfBirth=" + dateOfBirth
				+ ", employmentStartDate=" + employmentStartDate + ", taxIdentificationNumber="
				+ taxIdentificationNumber + ", bankName=" + bankName + ", accountNumber=" + accountNumber
				+ ", routingNumber=" + routingNumber + ", bankBranch=" + bankBranch
				+ ", employeeOfferLetterReleaseDate=" + employeeOfferLetterReleaseDate + ", employeeDesignation="
				+ employeeDesignation + ", joiningDate=" + joiningDate + ", joiningCtc=" + joiningCtc
				+ ", hikeLetterDate=" + hikeLetterDate + ", hikeCtc=" + hikeCtc + ", hikeDesignation=" + hikeDesignation
				+ ", hikeLetterEffectiveDate=" + hikeLetterEffectiveDate + "]";
	}
    
    

}
