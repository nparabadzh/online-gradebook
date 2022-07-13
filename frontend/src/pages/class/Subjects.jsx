import React from "react";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import { makeStyles } from "@material-ui/core/styles";
import {
  List,
  Card,
  ListItem,
  ListItemIcon,
  ListItemText,
  Divider,
  Typography,
} from "@material-ui/core";
import SubjectIcon from "@material-ui/icons/Subject";

const useStyles = makeStyles((theme) => ({
  root: {
    width: "100%",
    maxWidth: 360,
  },
  title: {
    margin: 10,
  },
  icon: {
    color: "#0000FF",
    marginRight: -10,
  },
}));

function ListItemLink(props) {
  return <ListItem button component="a" {...props} />;
}

const Subjects = ({ selectedIndex, setSelectedIndex }) => {
  const classes = useStyles();
  let { classId } = useParams();
  const subjects = useSelector((state) => state.subjects.subjects);

  const handleListItemClick = (index) => {
    setSelectedIndex(index);
  };

  return (
    <Card style={{ width: "100%" }}>
      <div className={classes.title}>
        <Typography variant="body" noWrap>
          Class: {classId}
        </Typography>
      </div>
      <Divider />
      <List component="nav" aria-label="main mailbox folders">
        {Object.keys(subjects).map((key) => (
          <ListItem
            button
            selected={selectedIndex === key}
            onClick={() => handleListItemClick(key)}
          >
            <ListItemIcon className={classes.icon}>
              <SubjectIcon />
            </ListItemIcon>
            <ListItemText primary={subjects[key]} />
          </ListItem>
        ))}
      </List>
      <Divider />
      {/* <List component="nav" aria-label="secondary mailbox folders">
        <ListItem button>
          <ListItemText primary="Trash" />
        </ListItem>
        <ListItemLink href="#simple-list">
          <ListItemText primary="Spam" />
        </ListItemLink>
      </List> */}
    </Card>
  );
};

export default Subjects;
