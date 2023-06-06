import React from "react";

import SignUp from "./Components/SignUp";
import Login from "./Components/Login";
import RestrictedRoute from "./Auth/RestrictedRoute";
import PrivateRoute from "./Auth/PrivateRoute";
import Navbar from "./Components/Home";
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import Annot from "./Components/textarea";
import Classes from "./Components/classes";
import Example from "./Components/admin_sess";
import Navbar2 from "./Components/navbar";
import Sidebar from "./Components/sidebar";
function App() {
  return (

    <>
         <BrowserRouter>
         <Switch>
           <PrivateRoute exact path="/" component={Example}/>
           <PrivateRoute exact path="/classes" component={Classes}/>
           <RestrictedRoute exact path="/login" component={Login} />
           <Route exact path="/register" component={SignUp} />
           </Switch>
       </BrowserRouter>
      </>
  );
}

export default App;
