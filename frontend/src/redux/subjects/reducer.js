// import { SubjectsActionTypes } from "./types";

const INITIAL_STATE = {
  subjects: {
    0: "Literature",
    1: "Mathematics",
    2: "Biology",
    3: "Chemistry",
    4: "English",
    5: "Pogramming",
  },
};

const subjectsReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    default:
      return state;
  }
};

export default subjectsReducer;
