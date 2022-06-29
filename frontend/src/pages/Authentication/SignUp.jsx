import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import axios from "axios";
import Button from "@material-ui/core/Button";
import FormControl from "@material-ui/core/FormControl";
import Input from "@material-ui/core/Input";
import InputLabel from "@material-ui/core/InputLabel";

const SignUp = () => {
  const [email, setEmail] = useState("");
  const [password, setpassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [error, setError] = useState(false);

  const egn = "1234567890";
  const navigate = useNavigate();

  const dispatch = useDispatch();

  const signIn = () => {
    axios
      .post(`/api/users/user`, {
        email,
        password,
        firstName: firstName,
        lastName: lastName,
        egn,
      })
      .then((res) => {
        if (res.data.message === "Created") {
          dispatch(setCurrentUser(res.data.user));
          setError(false);
          navigate("/");
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
          <FormControl>
            <InputLabel htmlFor="component-simple">Email</InputLabel>
            <Input
              value={email}
              onChange={(e) => {
                setEmail(e.target.value);
              }}
            />
          </FormControl>
          <FormControl>
            <InputLabel htmlFor="component-helper">Password</InputLabel>
            <Input
              type="password"
              value={password}
              onChange={(e) => {
                setpassword(e.target.value);
              }}
              aria-describedby="component-helper-text"
            />
          </FormControl>
          <FormControl>
            <InputLabel htmlFor="component-simple">First Name</InputLabel>
            <Input
              value={firstName}
              onChange={(e) => {
                setFirstName(e.target.value);
              }}
            />
          </FormControl>
          <FormControl>
            <InputLabel htmlFor="component-helper">LastName</InputLabel>
            <Input
              value={lastName}
              onChange={(e) => {
                setLastName(e.target.value);
              }}
              aria-describedby="component-helper-text"
            />
          </FormControl>
          {error && (
            <span style={{ color: "red" }}>The email is already taken!</span>
          )}
          <FormControl>
            <Button
              style={{ marginTop: 20 }}
              disabled={
                email === "" ||
                password === "" ||
                firstName === "" ||
                lastName === ""
              }
              variant="contained"
              color="primary"
              onClick={signIn}
            >
              Sign up
            </Button>
          </FormControl>
        </form>
      </div>
    </div>
  );
};

export default SignUp;
