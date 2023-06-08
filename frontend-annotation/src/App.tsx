import React from "react";

import SignUp from "./Components/SignUp";
import Login from "./Components/Login";
import RestrictedRoute from "./Auth/RestrictedRoute";
import PrivateRoute from "./Auth/PrivateRoute";
import Navbar from "./Components/Home";
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import Annot from "./Components/textarea";
import Classes from "./Components/classes";
import AdminSession from "./Components/admin_sess";
import ExpertSession from "./Components/expert_sess";
import CandidateSession from "./Components/annotate_sess";
function App() {
  return (
    
    <>
         <BrowserRouter>
         <Switch>
          <PrivateRoute exact path="/" component={ExpertSession}/>
           <PrivateRoute exact path="/classes" component={Classes}/>
           <PrivateRoute exact path="/AdminSession" component={AdminSession}/>
           {/* <PrivateRoute exact path="/ExpertSession" component={Classes}/> */}
           <PrivateRoute exact path="/CandidateSession" component={CandidateSession}/>
           <PrivateRoute exact path="/annot" component={Annot}/>
           <RestrictedRoute exact path="/login" component={Login} />
           <Route exact path="/register" component={SignUp} />
           </Switch>
       </BrowserRouter>
      </>

);
}

export default App;
