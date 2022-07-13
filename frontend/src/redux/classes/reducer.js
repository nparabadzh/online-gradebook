// import { SubjectsActionTypes } from "./types";
import { stundets6a, stundets6b, stundets7g } from "./constants";

const subjects = [
  "Literature",
  "Mathematics",
  "Biology",
  "Chemistry",
  "Physics",
  "Physical Education",
  "Programming",
  "English",
];

const INITIAL_STATE = {
  "6a": stundets6a,
  "6b": stundets6b,
  "7g": stundets7g,
};

const classesReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    default:
      return state;
  }
};

export default classesReducer;
