// src/components/ProjectSummary.jsx

const ProjectSummary = () => {
    return (
      <div className="bg-white p-6 rounded-lg shadow col-span-2">
        <h3 className="text-lg font-semibold mb-4">Project Summary</h3>
        <table className="min-w-full bg-white">
          <thead>
            <tr>
              <th className="text-left py-2 px-4 bg-gray-100">Name</th>
              <th className="text-left py-2 px-4 bg-gray-100">Project Manager</th>
              <th className="text-left py-2 px-4 bg-gray-100">Due Date</th>
              <th className="text-left py-2 px-4 bg-gray-100">Status</th>
              <th className="text-left py-2 px-4 bg-gray-100">Progress</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td className="border px-4 py-2">Nelisa web development</td>
              <td className="border px-4 py-2">Om Prakash</td>
              <td className="border px-4 py-2">May 25, 2023</td>
              <td className="border px-4 py-2">
                <span className="text-green-500">Completed</span>
              </td>
              <td className="border px-4 py-2">100%</td>
            </tr>
            <tr>
              <td className="border px-4 py-2">Datascale AI app</td>
              <td className="border px-4 py-2">Neilsan Mando</td>
              <td className="border px-4 py-2">June 20, 2023</td>
              <td className="border px-4 py-2">
                <span className="text-red-500">Delayed</span>
              </td>
              <td className="border px-4 py-2">29%</td>
            </tr>
            <tr>
              <td className="border px-4 py-2">Media channel branding</td>
              <td className="border px-4 py-2">Tiruvely Priya</td>
              <td className="border px-4 py-2">July 13, 2023</td>
              <td className="border px-4 py-2">
                <span className="text-yellow-500">At risk</span>
              </td>
              <td className="border px-4 py-2">50%</td>
            </tr>
            <tr>
              <td className="border px-4 py-2">Corixa iOS app development</td>
              <td className="border px-4 py-2">Matte Hannery</td>
              <td className="border px-4 py-2">December 20, 2023</td>
              <td className="border px-4 py-2">
                <span className="text-green-500">Ongoing</span>
              </td>
              <td className="border px-4 py-2">100%</td>
            </tr>
            <tr>
              <td className="border px-4 py-2">Website builder development</td>
              <td className="border px-4 py-2">Sukumar Rao</td>
              <td className="border px-4 py-2">March 15, 2024</td>
              <td className="border px-4 py-2">
                <span className="text-green-500">Ongoing</span>
              </td>
              <td className="border px-4 py-2">50%</td>
            </tr>
            {/* Add more rows as needed */}
          </tbody>
        </table>
      </div>
    );
  };
  
  export default ProjectSummary;
  