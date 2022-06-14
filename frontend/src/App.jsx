import "./App.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home/index";
import SignIn from "./pages/Authentication/SignIn";
import SignUp from "./pages/Authentication/SignUp";
import Navbar from "./components/NavigationBar";
import { useSelector } from "react-redux";

function App() {
  const currentUser = useSelector((state) => state.user.currentUser);

  return (
    <div className="App">
      <Navbar />
      <p>Online Gradebook</p>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="signin" element={<SignIn />} />
        <Route path="signup" element={<SignUp />} />
      </Routes>
    </div>
  );
}

export default App;
