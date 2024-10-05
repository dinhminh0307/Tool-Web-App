// src/components/Dashboard/Projects.jsx
import React from 'react';
import { FiFolder } from 'react-icons/fi';

const Projects = () => {
  return (
    <div className="bg-white p-6 rounded-lg shadow flex items-center">
      <FiFolder className="text-2xl text-gray-600 mr-4" />
      <div>
        <p className="text-gray-500">Projects</p>
        <h3 className="text-xl font-semibold">95 / 100</h3>
        <p className="text-sm text-red-500">10% decrease from last month</p>
      </div>
    </div>
  );
};

export default Projects;
