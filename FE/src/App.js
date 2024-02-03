import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login/Login";
import Registration from "./components/Registration/Registration"
import Feedback from './components/Feedback/Feedback';

function App() {
  return (
    <div>
      <Router>
          <Routes>
              <Route path="" element={"dashboard"} />
              <Route path="/feedback" element={<Feedback />} />
              <Route path="/login" element={<Login />} />
              <Route path="/registration" element={<Registration />} />
          </Routes>
      </Router>
    </div>
  );
}

export default App;
