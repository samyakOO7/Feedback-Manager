import './App.css';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Feedback from './components/Feedback';

function App() {
  return (
    <div>
      <Router>
          <Routes>
              <Route path="" element={"dashboard"} />
              <Route path="/feedback" element={<Feedback />} />
              <Route path="/login" element={<Login />} />
          </Routes>
      </Router>
    </div>
  );
}

export default App;
