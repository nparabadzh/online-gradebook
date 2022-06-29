import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { makeStyles, mergeClasses } from "@material-ui/styles";
// import axios from "axios";

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

const Teacher = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const [name, setName] = useState("");
  const [family, setFamily] = useState("");
  const [password, setPassword] = useState("");
  const [pin, setPin] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const role = "Teacher";
  const [school, setSchool] = useState("");
  const [qualification, setQualification] = useState("");

  const handleSchoolChange = (event) => {
    setSchool(event.target.value);
  };

  const handleQualificationChange = (event) => {
    setQualification(event.target.value);
  };

  const createTeacher = () => {
    alert(`
      Name: ${name},
      Family: ${family},
      Password: ${password},
      PIN: ${pin},
      Address: ${address},
      Email: ${email},
      Role: ${role},
      School: ${school},
      Qualification: ${qualification}
    `);
    setName("");
    setFamily("");
    setPassword("");
    setPin("");
    setAddress("");
    setEmail("");
    setSchool("");
    setQualification("");
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
            <InputLabel>Name</InputLabel>
            <Input
              value={name}
              onChange={(e) => {
                setName(e.target.value);
              }}
            />
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Family</InputLabel>
            <Input
              value={family}
              onChange={(e) => {
                setFamily(e.target.value);
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
              value={pin}
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
          <FormControl className={classes.formControl}>
            <InputLabel>Role</InputLabel>
            <Select id="role-select" value={role} disabled>
              <MenuItem value={"Teacher"}>Teacher</MenuItem>
            </Select>
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>School</InputLabel>
            <Select
              id="class-select"
              value={school}
              onChange={handleSchoolChange}
            >
              <MenuItem value={"Italian College"}>Italian College</MenuItem>
              <MenuItem value={"Maria Montesory private school"}>
                Maria Montesory private school
              </MenuItem>
              <MenuItem value={"American College"}>American College</MenuItem>
            </Select>
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Qualification</InputLabel>
            <Select
              id="class-select"
              value={qualification}
              onChange={handleQualificationChange}
            >
              <MenuItem value={"Literature"}>Literature</MenuItem>
              <MenuItem value={"Mathematics"}>Mathematics</MenuItem>
              <MenuItem value={"Chemistry"}>Chemistry</MenuItem>
            </Select>
          </FormControl>
          <FormControl className={classes.formControl}>
            <Button
              style={{ marginTop: 20 }}
              disabled={
                email === "" ||
                password === "" ||
                school === "" ||
                qualification === ""
              }
              variant="contained"
              color="secondary"
              onClick={createTeacher}
            >
              Create Teacher
            </Button>
          </FormControl>
        </form>
      </div>
    </div>
  );
};

export default Teacher;
