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

const Parent = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const [name, setName] = useState("");
  const [family, setFamily] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const role = "Parent";
  const [student, setStudent] = useState(null);
  const [error, setError] = useState(false);

  const handleStudentChange = (event) => {
    setStudent(event.target.value);
  };

  const createParent = () => {
    alert(`
      Name: ${name},
      Family: ${family},
      Password: ${password},
      Address: ${address},
      Email: ${email},
      Student: ${student},
      Role: ${role}
    `);
    setName("");
    setFamily("");
    setPassword("");
    setAddress("");
    setEmail("");
    setStudent(null);
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
              <MenuItem value={"Parent"}>Parent</MenuItem>
            </Select>
          </FormControl>
          <FormControl className={classes.formControl}>
            <InputLabel>Student</InputLabel>
            <Select
              id="class-select"
              value={student}
              onChange={handleStudentChange}
            >
              <MenuItem value={"Andrey Nikolov"}>Andrey Nikolov</MenuItem>
              <MenuItem value={"Ivan Geshev"}>Ivan Geshev</MenuItem>
              <MenuItem value={"Boyko Borisov"}>Boyko Borisov</MenuItem>
            </Select>
          </FormControl>
          <FormControl className={classes.formControl}>
            <Button
              style={{ marginTop: 20 }}
              disabled={email === "" || password === "" || student === null}
              variant="contained"
              color="secondary"
              onClick={createParent}
            >
              Create Parent
            </Button>
          </FormControl>
        </form>
      </div>
    </div>
  );
};

export default Parent;
