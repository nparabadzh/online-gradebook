import React, { forwardRef, useState } from "react";
import clsx from 'clsx';
import { NavLink as RouterLink, useLocation } from "react-router-dom";
import { makeStyles } from "@material-ui/styles";
import { List, ListItem, Button, colors } from "@material-ui/core";
import ExpandLess from '@material-ui/icons/ExpandLess';
import ExpandMore from '@material-ui/icons/ExpandMore';
import Collapse from '@material-ui/core/Collapse';

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
    justifyContent: "center",
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
  const currentBaseUrl = location.pathname.split("/")[1];

  const [expanded, setExpanded] = useState(() => {
    const result = {};
    const pagesWithSubPages = pages.filter((pg) => pg.subPages.length);
    pagesWithSubPages.forEach((pg) => {
      result[`${pg.title}`] = currentBaseUrl === pg.baseUrl;
    });
    return result;
  });

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
          activeClassName={classes.active}
          isActive={() => isActive(page.href, page.activeUrlList)}
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

  const renderMenu = (page) => {
    if (page.subPages.length) {
      return (
        <div key={`parent-${page.title}-${page.href}`}>
          <ListItem
            className={classes.item}
            disableGutters
            key={`${page.title}-${page.href}`}
            id={`${page.title}-${page.href}`}
            onClick={() => handleClick(page.title)}
          >
            <Button
              className={clsx(
                classes.subButton,
                page.baseUrl === currentBaseUrl && classes.selected,
              )}
              classes={{ label: classes.expandButton }}
            >
              <div className={classes.subItemText}>
                <div
                  className={clsx(classes.subIcon, {
                    [classes.selected]: page.baseUrl === currentBaseUrl,
                  })}
                >
                  {page.icon}
                </div>
                <span>{page.title}</span>
              </div>

              {expanded[page.title] ? <ExpandLess /> : <ExpandMore />}
            </Button>
          </ListItem>
          <Collapse in={expanded[page.title]} timeout="auto" unmountOnExit>
            <List component="div" disablePadding>
              {page.subPages.map((subPage, index) => (
                <ListItem
                  className={classes.item}
                  disableGutters
                  id={`${page.title}-${subPage.title}-${index}`}
                  key={`${page.title}-${subPage.title}-${index}`}
                >
                  <Button
                    activeClassName={classes.active}
                    isActive={() =>
                      isActive(subPage.href, subPage.activeUrlList)
                    }
                    className={classes.button}
                    component={CustomRouterLink}
                    to={subPage.href ? subPage.href : '/'}
                  >
                    <span className={classes.nested}>{subPage.title}</span>
                  </Button>
                </ListItem>
              ))}
            </List>
          </Collapse>
        </div>
      );
    }
  };

  return (
    <List {...rest} className={className}>
      {pages.map((page) => {
        if (page.requiredRole) {
          if (page.requiredRole.includes(currentUserRole)) {
            return page.subPages.length ? renderMenu(page) : renderPage(page);
          } else {
            return null;
          }
        } else {
          return page.subPages.length ? renderMenu(page) : renderPage(page);
        }
      })}
    </List>
  );
};

export default SidebarNav;
