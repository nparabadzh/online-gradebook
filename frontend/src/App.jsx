import { Routes, Route } from "react-router-dom";
import { useSelector } from "react-redux";
import "./App.css";

import Main from "./layout/Main";
import Home from "./pages/home/index";
import SignIn from "./pages/authentication/SignIn";
import SignUp from "./pages/authentication/SignUp";
import Student from "./pages/student/index";
import Admin from "./pages/admin/index";
import UnderConstruction from "./pages/UnderConstrction";
import Class from "./pages/class";

function App() {
  // const currentUser = useSelector((state) => state.user.currentUser);

  return (
    <div className="App">
      <Main>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/signin" element={<SignIn />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/student" element={<Student />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/classes/:classId" element={<Class />} />
          <Route path="/users" element={<UnderConstruction />} />
          <Route path="/profile" element={<UnderConstruction />} />
          <Route path="/schools" element={<UnderConstruction />} />
          <Route path="/subjects" element={<UnderConstruction />} />
        </Routes>
      </Main>
    </div>
  );
}

export default App;
