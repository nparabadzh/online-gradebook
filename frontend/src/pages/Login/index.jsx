import React, { useState } from "react";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import SignIn from "../authentication/SignIn";
import SignUp from "../authentication/SignUp";
import { useSelector } from "react-redux";

const Login = () => {
  const [hasAccount, setHasAccount] = useState(true);

  const navigateForm = () => {
    setHasAccount((previous) => {
      setHasAccount(!previous);
    });
  };
  const user = useSelector((state) => state.user.currentUser);

  return (
    <Box>
      <div>Login</div>
      {hasAccount ? <SignIn></SignIn> : <SignUp></SignUp>}
      <Button variant="outlined" onClick={navigateForm}>
        {hasAccount
          ? "Don't have an account? Sign up!"
          : "Already have an account? Sign in!"}
      </Button>
    </Box>
  );
};

export default Login;
