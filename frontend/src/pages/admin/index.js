import React, { useState } from "react";
import {
  Grid,
  Card,
  Paper,
  Tabs,
  Tab,
  Box,
  Typography,
} from "@material-ui/core";
import { useSelector } from "react-redux";
import Student from "./Student";
import Teacher from "./Teacher";
import Director from "./Director";
import Parent from "./Parent";
import School from "./School";

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

const Admin = () => {
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
            <Tab label="Student" />
            <Tab label="Teacher" />
            <Tab label="Parent" />
            <Tab label="Director" />
            <Tab label="School" />
          </Tabs>
          <TabPanel value={currentTab} index={0}>
            <Student />
          </TabPanel>
          <TabPanel value={currentTab} index={1}>
            <Teacher />
          </TabPanel>
          <TabPanel value={currentTab} index={2}>
            <Parent />
          </TabPanel>
          <TabPanel value={currentTab} index={3}>
            <Director />
          </TabPanel>
          <TabPanel value={currentTab} index={4}>
            <School />
          </TabPanel>
        </Paper>
      </Card>
    </Grid>
  );
};

export default Admin;
