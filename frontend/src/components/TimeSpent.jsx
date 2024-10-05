// src/components/Dashboard/TimeSpent.jsx
import React from 'react';
import { FiClock } from 'react-icons/fi';

const TimeSpent = () => {
  return (
    <div className="bg-white p-6 rounded-lg shadow flex items-center">
      <FiClock className="text-2xl text-gray-600 mr-4" />
      <div>
        <p className="text-gray-500">Time Spent</p>
        <h3 className="text-xl font-semibold">1022 / 1300 hrs</h3>
        <p className="text-sm text-green-500">8% increase from last month</p>
      </div>
    </div>
  );
};

export default TimeSpent;
