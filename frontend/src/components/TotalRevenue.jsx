// src/components/Dashboard/TotalRevenue.jsx
import React from 'react';
import { FiDollarSign } from 'react-icons/fi';

const TotalRevenue = () => {
  return (
    <div className="bg-white p-6 rounded-lg shadow flex items-center">
      <FiDollarSign className="text-2xl text-gray-600 mr-4" />
      <div>
        <p className="text-gray-500">Total Revenue</p>
        <h3 className="text-xl font-semibold">$53,009.89</h3>
        <p className="text-sm text-green-500">12% increase from last month</p>
      </div>
    </div>
  );
};

export default TotalRevenue;
