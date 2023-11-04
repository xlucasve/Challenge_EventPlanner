import React from "react";

const EventItem = (props) => {
  return (
    <div className="event-item">
      <h1 className="title">{props.title}</h1>
      <div>
        <span className="texto">Short description: </span>
        <span className="short_descriptino">{props.shortDescription}</span>
      </div>
      <div>
        <span className="texto">Long description: </span>
        <span className="long_description">{props.longDescription}</span>
      </div>
      <div>
        <span className="texto">Location: </span>
        <span className="location">{props.location}</span>
      </div>
      <div>
        <span className="texto">Date: </span>
        <span className="date">{props.date}</span>
      </div>
    </div>
  );
};

export default EventItem;
