import React from "react";
import { Grid, Card, CardContent, Typography } from "@material-ui/core";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";

const Home = () => {
  const user = useSelector((state) => state.user.currentUser);

  const renderHello = () => {
    return (
      <CardContent>
        <Typography variant="h4">Hello {user.name}!</Typography>
      </CardContent>
    );
  };

  const renderProceedToLogin = () => {
    return (
      <CardContent>
        <Typography variant="h4">
          Hello! In order to use the Online Gradebook you must either{" "}
          <Link to="/signin">sign in</Link> or <Link to="/signup">sign up</Link>
        </Typography>
      </CardContent>
    );
  };

  return (
    <Grid container item xs={12}>
      <Card style={{ width: "100%" }}>
        {user ? renderHello() : renderProceedToLogin()}
      </Card>
    </Grid>
  );
};

export default Home;
