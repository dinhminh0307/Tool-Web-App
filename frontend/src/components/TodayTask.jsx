// src/components/TodayTask.jsx

const TodayTask = () => {
    const tasks = [
      {
        name: "Create a user flow of social application design",
        status: "Approved",
      },
      {
        name: "Create a user flow of social application design",
        status: "In review",
      },
      {
        name: "Landing page design for Fintech project of Singapore",
        status: "On going",
      },
      {
        name: "Interactive prototype for app screens of determinate project",
        status: "Approved",
      },
      {
        name: "Interactive prototype for app screens of determinate project",
        status: "On going",
      },
    ];
  
    return (
      <div className="bg-white p-6 rounded-lg shadow">
        <h3 className="text-lg font-semibold mb-4">Today's Tasks</h3>
        <ul className="list-disc pl-5">
          {tasks.map((task, index) => (
            <li key={index} className="mb-2">
              <span>{task.name}</span>
              <span className={`ml-4 text-sm ${task.status === 'Approved' ? 'text-green-500' : task.status === 'In review' ? 'text-yellow-500' : 'text-red-500'}`}>
                {task.status}
              </span>
            </li>
          ))}
        </ul>
      </div>
    );
  };
  
  export default TodayTask;
  