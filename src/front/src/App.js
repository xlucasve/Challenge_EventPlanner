import { Routes, Route, Navigate } from "react-router-dom";
import Events from "./components-all/events/pages/Events";

import "./App.css";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Events />
      </header>
    </div>
  );
}

export default App;
