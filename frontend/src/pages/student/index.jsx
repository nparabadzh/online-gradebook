import React, { useState } from "react";
import { Grid, Card, Paper, Tabs, Tab, Box, Typography } from "@material-ui/core";
import { useSelector } from "react-redux";
import Grades from "./Grades";
import Absence from "./Absence";

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box p={3}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

const Student = () => {
  const user = useSelector((state) => state.user.currentUser);
  const [currentTab, setCurrentTab] = useState(0);

  const handleTabChange = (event, newValue) => {
    setCurrentTab(newValue);
  };

  return (
    <Grid container item xs={12}>
      <Card style={{ width: "100%" }}>
      <Paper square>
        <Tabs
          value={currentTab}
          indicatorColor="primary"
          textColor="primary"
          onChange={handleTabChange}
          aria-label="disabled tabs example"
        >
          <Tab label="Grades" />
          <Tab label="Absence" />
          <Tab label="School Schedule" />
        </Tabs>
        <TabPanel value={currentTab} index={0}>
          <Grades />
        </TabPanel>
        <TabPanel value={currentTab} index={1}>
          <Absence />
        </TabPanel>
        <TabPanel value={currentTab} index={2}>
          Item Three
        </TabPanel>
      </Paper>
      </Card>
    </Grid>
  );
};

export default Student;
