import React, { useState } from "react";
import clsx from "clsx";
import { makeStyles } from "@material-ui/styles";
import { CssBaseline } from "@material-ui/core";
import Box from "@material-ui/core/Box";
import Paper from "@material-ui/core/Paper";
import Sidebar from "./Sidebar";
import Topbar from "./Topbar";

const useStyles = makeStyles(() => ({
  root: {
    height: "100%",
  },
  shiftContent: {
    paddingLeft: 160,
  },
  content: {
    height: "100%",
    padding: 8,
    overflow: "auto",
  },
}));

const Main = (props) => {
  const { children } = props;

  const classes = useStyles();

  return (
    <>
      <CssBaseline />
      <div
        className={clsx({
          [classes.root]: true,
          [classes.shiftContent]: true,
        })}
      >
        <Topbar />
        <Sidebar variant={"persistent"} />
        <main className={classes.content}>
          <Box>
            <Paper>{children}</Paper>
          </Box>
        </main>
      </div>
    </>
  );
};

export default Main;
