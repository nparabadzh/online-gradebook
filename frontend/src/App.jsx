import { Routes, Route } from "react-router-dom";
import { useSelector } from "react-redux";
import "./App.css";

import Home from "./pages/home/index";
import SignIn from "./pages/authentication/SignIn";
import SignUp from "./pages/authentication/SignUp";
import Main from "./layout/Main";
import Student from "./pages/student/index";


function App() {
  const currentUser = useSelector((state) => state.user.currentUser);

  return (
    <div className="App">
      <Main>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/signin" element={<SignIn />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/student" element={<Student />} />
        </Routes>
      </Main>
    </div>
  );
}

export default App;
