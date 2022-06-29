import React from "react";
import clsx from "clsx";
import { useSelector } from "react-redux";
import { makeStyles } from "@material-ui/styles";
import { Divider, Drawer } from "@material-ui/core";
import HomeIcon from "@material-ui/icons/Home";
import ClassIcon from "@material-ui/icons/Class";
import PeopleIcon from "@material-ui/icons/People";
import AccountBoxIcon from "@material-ui/icons/AccountBox";
import SchoolIcon from "@material-ui/icons/School";
import SubjectIcon from "@material-ui/icons/Subject";
import AccessibilityIcon from "@material-ui/icons/Accessibility";
import SupervisorAccountIcon from "@material-ui/icons/SupervisorAccount";

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
  const { variant, className, ...rest } = props;
  const currentUser = useSelector((state) => state.user.currentUser);

  const classes = useStyles();

  const pages = [
    {
      title: "Home",
      href: "/home",
      icon: <HomeIcon />,
    },
    {
      title: "Student",
      href: "/student",
      icon: <AccessibilityIcon />,
      requiredRole: ["STUDENT", "PARENT"],
    },
    {
      title: "Classes",
      href: "/classes",
      icon: <ClassIcon />,
      requiredRole: ["ADMIN", "DIRECTOR", "TEACHER"],
    },
    {
      title: "Users",
      href: "/users",
      icon: <PeopleIcon />,
      requiredRole: ["ADMIN"],
    },
    {
      title: "Profile",
      href: "/profile",
      icon: <AccountBoxIcon />,
      requiredRole: ["ADMIN", "USER", "DIRECTOR", "PARENT", "TEACHER"],
    },
    {
      title: "Schools",
      href: "/schools",
      icon: <SchoolIcon />,
      requiredRole: ["ADMIN"],
    },
    {
      title: "Subjects",
      href: "/subjects",
      icon: <SubjectIcon />,
      requiredRole: ["ADMIN"],
    },
    {
      title: "Admin",
      href: "/admin",
      icon: <SupervisorAccountIcon />,
      requiredRole: ["ADMIN"],
    },
  ];

  return (
    <Drawer
      anchor="left"
      classes={{ paper: classes.drawer }}
      open={true}
      variant={variant}
    >
      <div {...rest} className={clsx(classes.root, className)}>
        <div className={classes.logoContainer}>
          <Logo />
        </div>
        <Divider className={classes.divider} />
        <SidebarNav
          className={classes.nav}
          pages={pages}
          currentUserRole={currentUser && currentUser.role}
        />
      </div>
    </Drawer>
  );
};

export default Sidebar;
