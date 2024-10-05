// src/components/Dashboard/Sidebar.jsx
import React from 'react';
import { FiFolder, FiList, FiClock, FiUsers, FiSettings, FiDollarSign } from 'react-icons/fi'; // Add more icons

const Sidebar = () => {
  return (
    <aside className="w-1/5 bg-gray-900 text-white p-6">
      <div className="flex items-center mb-10">
        {/* Logo Placeholder */}
        <div className="w-8 h-8 bg-orange-600 rounded-full mr-3"></div>
        <h1 className="text-xl font-bold">Promage</h1>
      </div>
      <ul className="space-y-6">
        <li className="flex items-center space-x-3">
          <FiFolder className="text-gray-400" />
          <a href="#" className="text-gray-400 hover:text-white">Projects</a>
        </li>
        <li className="flex items-center space-x-3">
          <FiList className="text-gray-400" />
          <a href="#" className="text-gray-400 hover:text-white">Tasks</a>
        </li>
        <li className="flex items-center space-x-3">
          <FiClock className="text-gray-400" />
          <a href="#" className="text-gray-400 hover:text-white">Time Log</a>
        </li>
        <li className="flex items-center space-x-3">
          <FiUsers className="text-gray-400" />
          <a href="#" className="text-gray-400 hover:text-white">Users</a>
        </li>
        <li className="flex items-center space-x-3">
          <FiSettings className="text-gray-400" />
          <a href="#" className="text-gray-400 hover:text-white">Settings</a>
        </li>
      </ul>
    </aside>
  );
};

export default Sidebar;
