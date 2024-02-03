import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login/Login";
import Registration from "./components/Registration/Registration"
import Feedback from './components/Feedback/Feedback';
import Dashboard from './components/Dashboard/Dashboard';

function App() {
  return (
    <div>
      <Router>
          <Routes>
              <Route path="" element={<Dashboard />} />
              <Route path="/feedback/:id" element={<Feedback />} />
              <Route path="/login" element={<Login />} />
              <Route path="/registration" element={<Registration />} />
          </Routes>
      </Router>
    </div>
  );
}

export default App;
