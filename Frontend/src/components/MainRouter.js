import React from 'react';
import {
    BrowserRouter as Router,
    Route,
    Routes
} from "react-router-dom";
import Login from './Login/Login';
import Register from './Registration/Registration';
import StuSidebar from './Dashboards/Student/StuSidebar';
import InsSidebar from './Dashboards/Instructor/InsSidebar';

function MainRouter() {
    return (
        <>
            <Router>
                <Routes>
                    <Route path="/" element={<Login />} />
                    <Route path="/signup" element={<Register />} />
                    <Route path="/studashboard" element={<StuSidebar />} />
                    <Route path="/insdashboard" element={<InsSidebar />} />
                </Routes>
            </Router>
        </>
    );

}

export default MainRouter;