/*
 * Copyright © 2010-2022, Smule Inc – All Rights Reserved.
 * Reproduction and distribution are forbidden. No part of this code source
 * shall be reproduced, stored in a retrieval system, or
 * transmitted by any other means, electronic, mechanical, photocopying,
 * recording, or otherwise, without written permission from the Company.
 */

import React, { useState } from "react";
import clsx from "clsx";
import { makeStyles } from "@material-ui/styles";
import { CssBaseline } from "@material-ui/core";

import NavigationBar from "./NavigationBar";
import Sidebar from "./Sidebar";

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
  const isDesktop = true;

  const [openSidebar, setOpenSidebar] = useState(false);

  const handleSidebarOpen = () => {
    setOpenSidebar(true);
  };

  const handleSidebarClose = () => {
    setOpenSidebar(false);
  };

  const shouldOpenSidebar = isDesktop ? true : openSidebar;

  return (
    <>
      <CssBaseline />
      <div
        className={clsx({
          [classes.root]: true,
          [classes.shiftContent]: isDesktop,
        })}
      >
        <NavigationBar />
        <Sidebar
          onClose={handleSidebarClose}
          open={shouldOpenSidebar}
          variant={isDesktop ? "persistent" : "temporary"}
        />
        <main className={classes.content}>{children}</main>
      </div>
    </>
  );
};

export default Main;
