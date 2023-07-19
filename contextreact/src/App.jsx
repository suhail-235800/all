import React from 'react'
import Form from './components/Form';
import ThemeContext from './ThemeContext';
function App() {
    const [textColor, setTextColor] = React.useState('light');
    const [bgColor, setBgColor] = React.useState('dark');
    return (
      <ThemeContext.Provider value={{ textColor, setTextColor, bgColor, setBgColor }}>
        <Form />
      </ThemeContext.Provider>
    );
}
export default App