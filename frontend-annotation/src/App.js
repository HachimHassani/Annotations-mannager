import Classes from "./Component/classes";
import Annot from "./Component/textarea";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
export default function App() {
  return (
    <BrowserRouter>
        <Routes>  
            <Route path="/" element={<Annot/>} />
            <Route path="/classes" element={<Classes/>} />
        </Routes>
    </BrowserRouter>
    )
}


