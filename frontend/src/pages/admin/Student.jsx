import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { makeStyles, mergeClasses } from "@material-ui/styles";
import axios from "axios";

import {
  Select,
  MenuItem,
  Button,
  FormControl,
  Input,
  InputLabel,
} from "@material-ui/core";
import { setCurrentUser } from "../../redux/user/actions";

const useStyles = makeStyles(() => ({
  formControl: {
    margin: 5,
  },
}));

const Student = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [password, setPassword] = useState("");
  const [egn, setPin] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const role = "STUDENT";
  const [studentClass, setStudentClass] = useState(null);
  const [error, setError] = useState(false);

  const handleClassChange = (event) => {
    setStudentClass(event.target.value);
  };

  const createStudent = () => {
    axios
      .post(`/api/users/user`, {
        email,
        password,
        firstName: firstName,
        lastName: lastName,
        egn: egn,
        address: address,
        role: role,
      })
      .then((res) => {
        if (res.data.message === "Created") {
          alert(`
            First Name: ${firstName},
            Last Name: ${lastName},
            Password: ${password},
            PIN: ${egn},
            Address: ${address},
            Email: ${email},
            Class: ${studentClass},
            Role: ${role}
          `);
          setFirstName("");
          setLastName("");
          setPassword("");
          setPin("");
          setAddress("");
          setEmail("");
          setStudentClass("");
          setError(false);
        }
      })
      .catch((error) => {
        setError(true);
        console.log(error);
      });
  };

  return (
    <div style={{ display: "flex", justifyContent: "center" }}>
      <div style={{ width: "60%", margin: 30 }}>
        <form
          style={{
            padding: 30,
            backgroundColor: "white",
            display: "flex",
            flexDirection: "column",
          }}
          noValidate
          autoComplete="off"
        >
          <FormControl className={classes.formControl}>
            <InputLabel>First Name</InputLabel>
            <Input
              value={firstName}
              onChange={(e) => {
                setFirstName(e.target.value);
              }}
            />
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Last Name</InputLabel>
            <Input
              value={lastName}
              onChange={(e) => {
                setLastName(e.target.value);
              }}
            />
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Email</InputLabel>
            <Input
              value={email}
              onChange={(e) => {
                setEmail(e.target.value);
              }}
            />
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Password</InputLabel>
            <Input
              type="password"
              value={password}
              onChange={(e) => {
                setPassword(e.target.value);
              }}
              aria-describedby="component-helper-text"
            />
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Personal Identification Number</InputLabel>
            <Input
              value={egn}
              onChange={(e) => {
                setPin(e.target.value);
              }}
            />
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Address</InputLabel>
            <Input
              value={address}
              onChange={(e) => {
                setAddress(e.target.value);
              }}
            />
          </FormControl>
          {/* <FormControl className={classes.formControl}>
            <InputLabel>Role</InputLabel>
            <Select id="role-select" value={role} onChange={handleRoleChange}>
              <MenuItem value={"Student"}>Student</MenuItem>
              <MenuItem value={"Teacher"}>Teacher</MenuItem>
              <MenuItem value={"Parent"}>Parent</MenuItem>
              <MenuItem value={"Director"}>Director</MenuItem>
              <MenuItem value={"Admin"}>Admin</MenuItem>
            </Select>
          </FormControl> */}
          <FormControl className={classes.formControl}>
            <InputLabel>Role</InputLabel>
            <Select id="role-select" value={role} disabled>
              <MenuItem value={"STUDENT"}>STUDENT</MenuItem>
            </Select>
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Class</InputLabel>
            <Select
              id="class-select"
              value={studentClass}
              onChange={handleClassChange}
            >
              <MenuItem value={1}>1</MenuItem>
              <MenuItem value={2}>2</MenuItem>
              <MenuItem value={3}>3</MenuItem>
              <MenuItem value={4}>4</MenuItem>
              <MenuItem value={5}>5</MenuItem>
              <MenuItem value={6}>6</MenuItem>
              <MenuItem value={7}>7</MenuItem>
              <MenuItem value={8}>8</MenuItem>
              <MenuItem value={9}>9</MenuItem>
              <MenuItem value={10}>10</MenuItem>
              <MenuItem value={11}>11</MenuItem>
              <MenuItem value={12}>12</MenuItem>
            </Select>
          </FormControl>
          <FormControl className={classes.formControl}>
            <Button
              style={{ marginTop: 20 }}
              disabled={
                email === "" || password === "" || studentClass === null
              }
              variant="contained"
              color="secondary"
              onClick={createStudent}
            >
              Create Student
            </Button>
          </FormControl>
        </form>
      </div>
    </div>
  );
};

export default Student;
