import React from 'react'
import ThemeContext from '../ThemeContext';
import './Form.css'
import 'bootstrap/dist/css/bootstrap.min.css'

function Form() {
    const {bgColor,textColor,setBgColor,setTextColor} = React.useContext(ThemeContext);
  return (
    <>
          <div className={`landing-page bg-${bgColor} text-bg-${textColor}`}>
        <header>
          <div className={`container bg-${bgColor}`}>
            <a href="#" className={`logo text-${textColor}`}>Your <b>Website</b></a>
            <ul className={`links text-${textColor}`}>
              <li>Home</li>
              <li>About Us</li>
              <li>Work</li>
              <li>Info</li>
              <li onClick={()=>{
                  if(textColor==='dark'){
                      setBgColor('dark')
                      setTextColor('light')
                  }
                  else{
                    setBgColor('light')
                    setTextColor('dark')
                  }
              }} value={'Change'}>Toggle</li>
            </ul>
          </div>
        </header>
        <div className={`content bg-${bgColor} text-${textColor}`}>
          <div className="container">
            <div className={`info text-${textColor}`}>
              <h1 className={`text-${textColor}`}>Looking For Inspiration</h1>
              <p className={`text-${textColor}`}>Lorem ipsum dolor sit amet consectetur adipisicing elit. Repellendus odit nihil ullam nesciunt quidem iste, Repellendus odit nihil</p>
              <button className={`text-${textColor}`}>Button name</button>
            </div>
            <div className="image">
              <img src="https://cdn.dribbble.com/users/1217289/screenshots/5410942/media/e03fb1ceba50ad9dea2fa2e54977641a.jpg?compress=1&resize=1000x750&vertical=center"/>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Form