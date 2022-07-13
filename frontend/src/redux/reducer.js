import { combineReducers } from "redux";
import classesReducer from "./classes/reducer";
import subjectsReducer from "./subjects/reducer";

import userReducer from "./user/reducer";

const rootReducer = combineReducers({
  user: userReducer,
  subjects: subjectsReducer,
  classes: classesReducer,
});

export default rootReducer;
