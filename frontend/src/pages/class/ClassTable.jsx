import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Card,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@material-ui/core";
import clsx from "clsx";

const useStyles = makeStyles({
  table: {
    minWidth: 700,
  },
  teacherInfo: {
    padding: 10,
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

const ClassTable = ({ students }) => {
  const classes = useStyles();

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
    <Card style={{ width: "100%" }}>
      <div className={classes.teacherInfo}>
        <Typography variant="h6" noWrap>
          Teacher : Teacher Name
        </Typography>
      </div>
      <TableContainer>
        <Table className={classes.table}>
          <TableHead>
            <TableRow>
              <TableCell colSpan={2}></TableCell>
              <TableCell colSpan={2}>
                <b>First Semester</b>
              </TableCell>
              <TableCell colSpan={2}>
                <b>Second Semester</b>
              </TableCell>
              <TableCell colSpan={1}></TableCell>
            </TableRow>
            <TableRow>
              <TableCell>
                <b>No</b>
              </TableCell>
              <TableCell>
                <b>Student</b>
              </TableCell>
              <TableCell>
                <b>Grades</b>
              </TableCell>
              <TableCell>
                <b>Term Grade</b>
              </TableCell>
              <TableCell>
                <b>Grades</b>
              </TableCell>
              <TableCell>
                <b>Term Grade</b>
              </TableCell>
              <TableCell>
                <b>Final Grade</b>
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {students.map((student, index) => (
              <TableRow key={index}>
                <TableCell>{index}</TableCell>
                <TableCell style={{ minWidth: 120 }}>{student.name}</TableCell>
                <TableCell>
                  {renderGrades(student.grades.firstSemester)}
                </TableCell>
                <TableCell>
                  {renderGrades([student.grades.firstSemesterGrade])}
                </TableCell>
                <TableCell>
                  {renderGrades(student.grades.secondSemester)}
                </TableCell>
                <TableCell>
                  {renderGrades([student.grades.secondSemesterGrade])}
                </TableCell>
                <TableCell>
                  {renderGrades([student.grades.finalGrade])}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Card>
  );
};

export default ClassTable;
