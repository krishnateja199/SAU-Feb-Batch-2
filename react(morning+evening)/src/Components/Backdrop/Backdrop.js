import React from 'react'
import Module from '../Module/Module';


const Backdrop = (props) => {
    return (
        <div style={{display:props.modelToggle}} onClick={props.hideModel}>
             <Module description={props.description} infoLink={props.infoLink} bookTitle={props.bookTitle}/>
        </div>
    )
}

export default Backdrop;
