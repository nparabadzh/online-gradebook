import React, { forwardRef } from "react";
import { NavLink as RouterLink, useLocation } from "react-router-dom";
import { makeStyles } from "@material-ui/styles";
import { List, ListItem, Button, colors } from "@material-ui/core";

const useStyles = makeStyles(() => ({
  root: {},
  item: {
    display: "flex",
    paddingTop: 0,
    paddingBottom: 0,
    paddingLeft: 10,
    paddingRight: 10,
  },
  nested: {
    paddingLeft: 8,
  },
  button: {
    color: colors.blueGrey[800],
    padding: "10px 8px",
    justifyContent: "flex-start",
    textTransform: "none",
    letterSpacing: 0,
    width: "100%",
    fontWeight: 500,
  },
  subButton: {
    color: colors.blueGrey[800],
    padding: "10px 12px",
    justifyContent: "flex-start",
    textTransform: "none",
    letterSpacing: 0,
    width: "100%",
    fontWeight: 500,
  },
  subItemText: {
    display: "flex",
    justifyContent: "flex-start",
  },
  icon: {
    color: "#0000FF",
    width: 24,
    height: 24,
    display: "flex",
    alignItems: "center",
    marginRight: 2,
  },
  subIcon: {
    color: "#0000FF",
    width: 24,
    height: 24,
    display: "flex",
    alignItems: "center",
    marginRight: 2,
    marginLeft: -4,
  },
  active: {
    backgroundColor: "#0000FF",
    color: "#fff",
    fontWeight: 500,
    "& $icon": {
      color: "#fff",
      fill: "#fff",
    },
    "&:hover": {
      backgroundColor: "#ADD8E6",
    },
  },
  expandButton: {
    display: "flex",
    justifyContent: "space-between",
  },
  selected: {
    color: "#6137E7",
    fill: "#6137E7",
  },
}));

const CustomRouterLink = forwardRef((props, ref) => (
  <div ref={ref} style={{ flexGrow: 1 }}>
    <RouterLink {...props} />
  </div>
));

const SidebarNav = (props) => {
  const { pages, className, currentUserRole, ...rest } = props;
  const classes = useStyles();
  const location = useLocation();
  // const currentBaseUrl = location.pathname.split("/")[1];

  const handleClick = (id) => {
    setExpanded({
      ...expanded,
      [id]: !expanded[id],
    });
  };

  const isActive = (href, activeUrlList) => {
    if (href === undefined) {
      return false;
    }
    if (activeUrlList && activeUrlList.length) {
      return activeUrlList.reduce((acc, url) => {
        if (location.pathname.includes(url)) {
          acc = true;
        }
        return acc;
      }, false);
    }
    return location.pathname.includes(href);
  };

  const renderPage = (page) => {
    return (
      <ListItem
        className={classes.item}
        disableGutters
        key={`${page.title}-${page.href}`}
        id={page.title}
      >
        <Button
          // activeClassName={classes.active}
          // isActive={() => isActive(page.href, page.activeUrlList)}
          className={classes.button}
          component={CustomRouterLink}
          to={page.href ? page.href : ""}
        >
          <div className={classes.icon}>{page.icon}</div>
          {page.title}
        </Button>
      </ListItem>
    );
  };

  return (
    <List {...rest} className={className}>
      {pages.map((page) => {
        if (page.requiredRole) {
          if (page.requiredRole.includes(currentUserRole)) {
            return renderPage(page);
          } else {
            return null;
          }
        } else {
          return renderPage(page);
        }
      })}
    </List>
  );
};

export default SidebarNav;
