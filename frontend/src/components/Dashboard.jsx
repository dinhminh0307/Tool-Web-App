// src/components/Dashboard/Dashboard.jsx
import React from 'react';
import Sidebar from './Sidebar'; // Import the Sidebar component
import TotalRevenue from './TotalRevenue';
import Projects from './Projects';
import TimeSpent from './TimeSpent';
import Resources from './Resources';
import ProjectSummary from './ProjectSummary'; // Import ProjectSummary component
import OverallProgress from './OverallProgress'; // Import OverallProgress component
import TodayTask from './TodayTask'; // Import TodayTask component

const Dashboard = () => {
  return (
    <div className="flex min-h-screen">
      {/* Sidebar */}
      <Sidebar />

      {/* Main Content */}
      <main className="flex-1 bg-gray-100 p-8">
        <h2 className="text-3xl font-semibold mb-6">Dashboard Overview</h2>

        {/* Overview Cards */}
        <div className="grid grid-cols-4 gap-6 mb-6">
          <TotalRevenue />
          <Projects />
          <TimeSpent />
          <Resources />
        </div>

        {/* Project Summary, Overall Progress, and Today's Tasks */}
        <div className="grid grid-cols-3 gap-6">
          <ProjectSummary />
          <OverallProgress />
          <TodayTask /> {/* Add TodayTask component */}
        </div>
      </main>
    </div>
  );
};

export default Dashboard;
