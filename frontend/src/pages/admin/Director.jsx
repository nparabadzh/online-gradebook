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

const Director = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const [name, setName] = useState("");
  const [family, setFamily] = useState("");
  const [password, setPassword] = useState("");
  const [pin, setPin] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const role = "Director";
  const [school, setSchool] = useState("");

  const handleSchoolChange = (event) => {
    setSchool(event.target.value);
  };

  const createDirector = () => {
    alert(`
      Name: ${name},
      Family: ${family},
      Password: ${password},
      PIN: ${pin},
      Address: ${address},
      Email: ${email},
      Role: ${role},
      School: ${school},
    `);
    setName("");
    setFamily("");
    setPassword("");
    setPin("");
    setAddress("");
    setEmail("");
    setSchool("");
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
              <MenuItem value={"Director"}>Director</MenuItem>
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
            <Button
              style={{ marginTop: 20 }}
              disabled={email === "" || password === "" || school === ""}
              variant="contained"
              color="secondary"
              onClick={createDirector}
            >
              Create Director
            </Button>
          </FormControl>
        </form>
      </div>
    </div>
  );
};

export default Director;
