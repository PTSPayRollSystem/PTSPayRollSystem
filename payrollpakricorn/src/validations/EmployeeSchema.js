import * as Yup from "yup";

export const EmployeeSchema = Yup.object().shape({
  firstName: Yup.string()
    .required("First Name is required")
    .max(50, "maximum 50 characters only")
    .matches(/^[A-Za-z\s]+$/, "First name must only contain letters and spaces")

    .test(
      "no-leading-space",
      "First Name cannot start with a space",
      (value) => {
        // Custom validation logic: Check if the value starts with a space
        return value === undefined || !/^ /.test(value);
      }
    ),
  lastName: Yup.string()
    .required("Last Name is required")
    .max(50, "maximum 50 characters only")
    .matches(/^[A-Za-z\s]+$/, "First name must only contain letters and spaces")

    .test(
      "no-leading-space",
      "Last Name cannot start with a space",
      (value) => {
        // Custom validation logic: Check if the value starts with a space
        return value === undefined || !/^ /.test(value);
      }
    ),
  address: Yup.string()
    .required("Address is required")
    .max(100, "maximum 100 characters only")
    .test("no-leading-space", "Address cannot start with a space", (value) => {
      // Custom validation logic: Check if the value starts with a space
      return value === undefined || !/^ /.test(value);
    }),
  contactNumber: Yup.string()
    .required("Contact No is required")

    .matches(/^\d+$/, "Contact number must contain only digits")
    .min(10, "Contact number must be at least 10 digits")
    .max(15, "maximum 15 characters only")
    .test(
      "no-leading-space",
      "Contact number cannot start with a space",
      (value) => {
        // Custom validation logic: Check if the value starts with a space
        return value === undefined || !/^ /.test(value);
      }
    ),
  emailAddress: Yup.string()
    .required("Email Id is required")
    .email("Invalid email format")
    .matches(
      /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/,
      "Invalid email address"
    )
    .test(
      "no-leading-space",
      "email address cannot start with a space",
      (value) => {
        // Custom validation logic: Check if the value starts with a space
        return value === undefined || !/^ /.test(value);
      }
    )
    .max(100, "maximum 100 characters only"),
  dateOfBirth: Yup.date()
    .required("date of  birth is required")
    .max(new Date(2005, 1, 1), "DOB must be before 01/01/2005")
    .test(
      "valid-year",
      "Year must be exactly four digits",
      (value) => value && value.getFullYear().toString().length === 4
    ),
    // .test("four-digit-year", "Year must have 4 digits", (value) => {
    //   if (value) {
    //     const year = value.getFullYear();
    //     return /^\d{4}$/.test(year.toString());
    //   }
    //   return true; // Allow empty value to pass
    // }),
  employmentStartDate: Yup.date().required("employment start date is required"),
  taxIdentificationNumber: Yup.string()
    .required("Tax identification No is required")
    .max(20, "maximum 20 characters only"),
  bankName: Yup.string()
    .required("bank Name is required")
    .matches(/^[A-Za-z\s]+$/, "First name must only contain letters and spaces")

    .max(50, "maximum 50 characters only"),
  bankBranch: Yup.string()
    .required("bank Name is required")
    .max(50, "maximum 50 characters only"),
  accountNumber: Yup.string()
    .required("Account No is required")
    .max(20, "maximum 20 characters only"),
  routingNumber: Yup.string()
    .required("Routing No is required")
    .max(20, "maximum 20 characters only"),

  employeeOfferLetterReleaseDate: Yup.string().required(
    "This field is Required"
  ),
  employeeDesignation: Yup.string().required("This field is Required"),
  joiningDate: Yup.string().required("This field is Required"),
  joiningCtc: Yup.string()
    .required("This field is Required")
    .max(20, "maximum 20 characters only"),
  hikeLetterDate: "",
  hikeCtc: "",
  hikeDesignation: "",
  hikeLetterEffectiveDate: "",
});
