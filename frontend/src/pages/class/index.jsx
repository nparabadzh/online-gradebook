import React from "react";
import { Grid, Card, CardContent, Typography } from "@material-ui/core";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import Subjects from "./Subjects";
import ClassTable from "./ClassTable";

const Class = () => {
  let { classId } = useParams();
  const [selectedSubjectIndex, setSelectedSubjectIndex] = React.useState(0);
  const selectedClass = useSelector((state) => state.classes[classId]);
  const studentsWithSelectedSubject = selectedClass.reduce((acc, value) => {
    const studentsWithSubject = {
      name: value.name,
      grades: { ...value.subjects[selectedSubjectIndex] },
    };
    const newAcc = [...acc, studentsWithSubject];
    return newAcc;
  }, []);

  return (
    <Card style={{ width: "100%" }}>
      <Grid container xs={12}>
        <Grid container item xs={2}>
          <Subjects
            selectedIndex={selectedSubjectIndex}
            setSelectedIndex={setSelectedSubjectIndex}
          />
        </Grid>
        <Grid container item xs={10}>
          <ClassTable students={studentsWithSelectedSubject} />
        </Grid>
      </Grid>
    </Card>
  );
};

export default Class;
