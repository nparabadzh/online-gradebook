import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
// import { createStructuredSelector } from 'reselect';
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import MenuItem from "@material-ui/core/MenuItem";
import Menu from "@material-ui/core/Menu";
import AccountCircle from "@material-ui/icons/AccountCircle";

import { setCurrentUser } from "../redux/user/actions";

const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    display: "none",
    [theme.breakpoints.up("sm")]: {
      display: "block",
    },
  },

  sectionDesktop: {
    display: "none",
    [theme.breakpoints.up("md")]: {
      display: "flex",
    },
  },
  navlinks: {
    marginLeft: theme.spacing(5),
  },
  link: {
    marginLeft: 20,
    textDecoration: "none",
    color: "white",
    fontSize: 20,
    "&:hover": {
      color: "pink",
    },
  },
  flex: {
    display: "flex",
    flexDirection: "column",
    justifyContent: "flex-start",
    alignItems: "flex-start",
  },
}));

export default function Topbar() {
  const classes = useStyles();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const currentUser = useSelector((state) => state.user.currentUser);

  const isMenuOpen = Boolean(anchorEl);

  const handleProfileMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMenuClose = () => {
    setAnchorEl(null);
  };

  const signOut = () => {
    dispatch(setCurrentUser(null));
    navigate("/");
  };

  const signIn = () => {
    navigate("/signin");
  };

  const menuId = "primary-search-account-menu";

  const renderSignOutMenu = (
    <Menu
      anchorEl={anchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={menuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMenuOpen}
      onClose={handleMenuClose}
    >
      <MenuItem onClick={signOut}>Sign out</MenuItem>
    </Menu>
  );

  const renderSignInMenu = (
    <Menu
      anchorEl={anchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={menuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMenuOpen}
      onClose={handleMenuClose}
    >
      <MenuItem onClick={signIn}>Sign in</MenuItem>
    </Menu>
  );

  return (
    <div className={classes.grow}>
      <AppBar style={{ background: "#2E3B55" }} position="static">
        <Toolbar>
          <Typography className={classes.title} variant="h6" noWrap>
            Online Gradebook
          </Typography>
          <div className={classes.grow} />
          {currentUser && (
            <div className={classes.flex}>
              <div>
                Name: {currentUser.firstName} {currentUser.lastName}
              </div>
              <div>Role: {currentUser.role}</div>
            </div>
          )}
          <div className={classes.sectionDesktop}>
            <IconButton
              edge="end"
              aria-label="account of current user"
              aria-controls={menuId}
              aria-haspopup="true"
              onClick={handleProfileMenuOpen}
              color="inherit"
            >
              <AccountCircle />
            </IconButton>
          </div>
        </Toolbar>
      </AppBar>
      {currentUser ? renderSignOutMenu : renderSignInMenu}
    </div>
  );
}
