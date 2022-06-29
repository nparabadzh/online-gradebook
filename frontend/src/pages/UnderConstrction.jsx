import React from "react";
import { Grid, Card, Typography } from "@material-ui/core";

const UnderConstruction = () => {
  return (
    <Grid container item xs={12}>
      <Card style={{ width: "100%" }}>
        <Typography variant="h4" noWrap>
          Under Construction :)
        </Typography>
      </Card>
    </Grid>
  );
};

export default UnderConstruction;
