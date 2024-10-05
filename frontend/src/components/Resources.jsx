// src/components/Dashboard/Resources.jsx
import React from 'react';
import { FiUsers } from 'react-icons/fi';

const Resources = () => {
  return (
    <div className="bg-white p-6 rounded-lg shadow flex items-center">
      <FiUsers className="text-2xl text-gray-600 mr-4" />
      <div>
        <p className="text-gray-500">Resources</p>
        <h3 className="text-xl font-semibold">101 / 120</h3>
        <p className="text-sm text-green-500">2% increase from last month</p>
      </div>
    </div>
  );
};

export default Resources;
