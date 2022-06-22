/*
 * Copyright © 2010-2022, Smule Inc – All Rights Reserved.
 * Reproduction and distribution are forbidden. No part of this code source
 * shall be reproduced, stored in a retrieval system, or
 * transmitted by any other means, electronic, mechanical, photocopying,
 * recording, or otherwise, without written permission from the Company.
 */

import React from "react";
import clsx from "clsx";
import { makeStyles } from "@material-ui/styles";
import { Divider, Drawer } from "@material-ui/core";
import HomeIcon from "@material-ui/icons/Home";
import ClassIcon from "@material-ui/icons/Class";
import PeopleIcon from "@material-ui/icons/People";
import AccountBoxIcon from "@material-ui/icons/AccountBox";
import SchoolIcon from "@material-ui/icons/School";
import SubjectIcon from "@material-ui/icons/Subject";

import Logo from "../components/Logo";
import SidebarNav from "./SidebarNav";

const useStyles = makeStyles(() => ({
  drawer: {
    zIndex: 10001,
    width: 160,
    height: "100%",
  },
  root: {
    backgroundColor: "#fff",
    display: "flex",
    flexDirection: "column",
    height: "100%",
    padding: 2,
  },
  logoContainer: {
    padding: 8,
  },
  divider: {
    margin: 2,
  },
  nav: {
    marginBottom: 2,
  },
}));

const Sidebar = (props) => {
  const { open, variant, onClose, className, ...rest } = props;

  const classes = useStyles();

  const pages = [
    {
      title: "Home",
      href: "/home",
      icon: <HomeIcon />,
    },
    {
      title: "Classes",
      href: "/classes",
      icon: <ClassIcon />,
    },
    {
      title: "Users",
      href: "/users",
      icon: <PeopleIcon />,
    },
    {
      title: "Profile",
      href: "/profile",
      icon: <AccountBoxIcon />,
    },
    {
      title: "Schools",
      href: "/schools",
      icon: <SchoolIcon />,
    },
    {
      title: "Subjects",
      href: "/subjects",
      icon: <SubjectIcon />,
    },
  ];

  return (
    <Drawer
      anchor="left"
      classes={{ paper: classes.drawer }}
      onClose={onClose}
      open={open}
      variant={variant}
    >
      <div {...rest} className={clsx(classes.root, className)}>
        <div className={classes.logoContainer}>
          <Logo />
        </div>
        <Divider className={classes.divider} />
        <SidebarNav className={classes.nav} pages={pages} />
      </div>
    </Drawer>
  );
};

export default Sidebar;
