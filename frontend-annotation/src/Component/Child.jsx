import React from 'react';

export const ChildComponent = ({ sendDataToParent }) => {
  const handleClick = () => {
    const data = 'Hello from child component!';
    sendDataToParent(data);
  };

  return (
    <div>
      <h2>Child Component</h2>
      <button onClick={handleClick}>Send Data to Parent</button>
    </div>
  );
};

export default ChildComponent;
