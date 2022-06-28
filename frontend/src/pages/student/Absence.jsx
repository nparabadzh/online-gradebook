import React from "react";
import clsx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
// import { useSelector } from "react-redux";
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Grid, Card, Paper} from '@material-ui/core'

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
  grade: {
    width: 30,
    height: 20,
    color: '#000',
    margin: 5,
    textAlign: 'center'
  },
  poor: {
    backgroundColor: '#FF0000',
  },
  mediocre: {
    backgroundColor: '#FFB347',
  },
  good: {
    backgroundColor: '#FFE338',
  },
  veryGood: {
    backgroundColor: '#CEFB02',
  },
  excelent: {
    backgroundColor: '#00ED01',
  }
});

const rows = [
  { subject: 'Mathematics', totalDelays: 3, totalAbsence: 15  },
  { subject: 'Literature', totalDelays: 3, totalAbsence: 15 },
  { subject: 'English',  totalDelays: 3, totalAbsence: 15},
  { subject: 'Chemistry',  totalDelays: 3, totalAbsence: 15 },
  { subject: 'Physical Education ',  totalDelays: 3, totalAbsence: 15 },
  { subject: 'Biology ',  totalDelays: 3, totalAbsence: 15 },
  { subject: 'Physics ',  totalDelays: 3, totalAbsence: 15 },
  { subject: 'Programing',  totalDelays: 3, totalAbsence: 15 }
];

const Absence = () => {
  const classes = useStyles();
  // const user = useSelector((state) => state.user.currentUser);

  return (
    <Grid container style={{marginTop: 10}} item xs={12}>
      <Card style={{ width: "100%" }}>
        <TableContainer component={Paper}>
          <Table className={classes.table} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell><b>Subject</b></TableCell>
                <TableCell><b>Total Delays</b></TableCell>
                <TableCell><b>Total Absences</b></TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.subject}>
                  <TableCell component="th" scope="row">
                    {row.subject}
                  </TableCell>
                  <TableCell style={{width: 200, backgroundColor: '#EBECF0'}}>{row.totalDelays}</TableCell>
                  <TableCell style={{width: 200, backgroundColor: '#EBECF0'}}>{row.totalAbsence}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
      </TableContainer>
      </Card>
    </Grid>
  );
};

export default Absence;
