import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import axios from "axios";
import Button from "@material-ui/core/Button";
import FormControl from "@material-ui/core/FormControl";
import Input from "@material-ui/core/Input";
import InputLabel from "@material-ui/core/InputLabel";
import { setCurrentUser } from "../../redux/user/actions";

// const USERS = [
//   {
//     name: "Natali Arabadzhiyska",
//     email: "admin@admin.com",
//     password: "admin",
//     role: "Admin",
//     id: 2,
//   },
//   {
//     name: "Pencho Ivanov",
//     email: "student@student.com",
//     password: "student",
//     role: "Student",
//     id: 1,
//   },
// ];

const SignUp = () => {
  const [email, setEmail] = useState("");
  const [password, setpassword] = useState("");
  const [error, setError] = useState(false);

  const navigate = useNavigate();

  const dispatch = useDispatch();

  const signIn = () => {
    axios
      .post(`/api/users/login`, {
        email,
        password,
      })
      .then((res) => {
        if (res.data.message === "logged in") {
          dispatch(setCurrentUser(res.data.user));
          setError(false);
          navigate("/");
        }
      })
      .catch((error) => {
        setError(true);
        console.log(error);
      });
    // const foundUser = findUser(email, password);
    // if (foundUser) {
    //   dispatch(
    //     setCurrentUser({
    //       name: foundUser.name,
    //       email: foundUser.email,
    //       role: foundUser.role,
    //       id: foundUser.id,
    //     })
    //   );
    //   setError(false);
    //   navigate("/");
    // } else {
    //   setError(true);
    // }
  };

  // const findUser = (email, password) => {
  //   const foundUser = USERS.find(
  //     (el) => el.email === email && el.password === password
  //   );
  //   return foundUser;
  // };

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
          {error && (
            <span style={{ color: "red" }}>
              The email or password is incorrect!
            </span>
          )}
          <FormControl>
            <Button
              style={{ marginTop: 20 }}
              disabled={email === "" || password === ""}
              variant="contained"
              color="secondary"
              onClick={signIn}
            >
              Sign in
            </Button>
          </FormControl>
        </form>
      </div>
    </div>
  );
};

export default SignUp;
