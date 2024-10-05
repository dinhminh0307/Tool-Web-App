// src/components/OverallProgress.jsx

const OverallProgress = () => {
    return (
      <div className="bg-white p-6 rounded-lg shadow">
        <h3 className="text-lg font-semibold mb-4">Overall Progress</h3>
        <div className="relative pt-1">
          <div className="flex justify-between mb-1">
            <span>Progress</span>
            <span>72%</span>
          </div>
          <div className="w-full bg-gray-200 rounded-full h-2.5">
            <div className="bg-orange-600 h-2.5 rounded-full" style={{ width: '72%' }}></div>
          </div>
        </div>
        <p className="mt-4">Total projects: 95</p>
        <p>Completed: 26</p>
        <p>Delayed: 35</p>
        <p>Ongoing: 35</p>
      </div>
    );
  };
  
  export default OverallProgress;
  