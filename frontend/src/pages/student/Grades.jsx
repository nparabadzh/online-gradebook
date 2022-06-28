import React, { useEffect, useState } from "react";
import clsx from "clsx";
import axios from "axios";
import { makeStyles } from "@material-ui/core/styles";
import { useSelector } from "react-redux";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Grid,
  Card,
  Paper,
} from "@material-ui/core";

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
  grade: {
    width: 30,
    height: 20,
    color: "#000",
    margin: 5,
    textAlign: "center",
  },
  poor: {
    backgroundColor: "#FF0000",
  },
  mediocre: {
    backgroundColor: "#FFB347",
  },
  good: {
    backgroundColor: "#FFE338",
  },
  veryGood: {
    backgroundColor: "#CEFB02",
  },
  excelent: {
    backgroundColor: "#00ED01",
  },
});

const rows = [
  { subject: "Mathematics", grades: [6, 5, 5, 6] },
  { subject: "Literature", grades: [3, 5, 4] },
  { subject: "English", grades: [6, 6, 4] },
  { subject: "Chemistry", grades: [5, 5, 5.8, 3] },
  { subject: "Physical Education ", grades: [6, 5.4, 6] },
  { subject: "Biology ", grades: [2, 4.4, 4] },
  { subject: "Physics ", grades: [6, 5.4, 4] },
  { subject: "Programing", grades: [6, 5.5] },
];

const Grades = () => {
  const classes = useStyles();
  const user = useSelector((state) => state.user.currentUser);
  const studentId = user.id;
  const url = `/subjects/student/${studentId}`;
  const [error, setError] = useState(false);

  const getSubjects = () => {
    axios
      .get(url)
      .then((res) => {
        if (subjects.length > 0) {
        }
      })
      .catch((error) => {
        setError(true);
        console.log(error);
      });
  };

  useEffect(() => {
    getSubjects();
  }, [studentId]);

  const renderGrade = (grade) => {
    if (grade >= 2 && grade < 3) {
      return <div className={clsx(classes.poor, classes.grade)}>{grade}</div>;
    } else if (grade >= 3 && grade < 4) {
      return (
        <div className={clsx(classes.mediocre, classes.grade)}>{grade}</div>
      );
    } else if (grade >= 4 && grade < 5) {
      return <div className={clsx(classes.good, classes.grade)}>{grade}</div>;
    } else if (grade >= 5 && grade < 5.5) {
      return (
        <div className={clsx(classes.veryGood, classes.grade)}>{grade}</div>
      );
    } else {
      return (
        <div className={clsx(classes.excelent, classes.grade)}>{grade}</div>
      );
    }
  };

  const renderGrades = (grades) => {
    return (
      <div style={{ width: 200, display: "flex", flexDirection: "row" }}>
        {grades.map((grade) => renderGrade(grade))}
      </div>
    );
  };

  return (
    <Grid container style={{ marginTop: 10 }} item xs={12}>
      <Card style={{ width: "100%" }}>
        <TableContainer component={Paper}>
          <Table className={classes.table} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>
                  <b>Subject</b>
                </TableCell>
                <TableCell>
                  <b>Grades</b>
                </TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.subject}>
                  <TableCell component="th" scope="row">
                    {row.subject}
                  </TableCell>
                  <TableCell>{renderGrades(row.grades)}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Card>
    </Grid>
  );
};

export default Grades;
