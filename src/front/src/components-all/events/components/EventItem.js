import React from "react";
import "./EventItem.css";

const EventItem = (props) => {
  return (
    <div className="event-item">
      <img
        src="https://picsum.photos/300/300"
        alt="Card Image"
        className="card-image"
      ></img>
      <p className="title">{props.title}</p>
      <div>
        <p className="date">{props.date}</p>
      </div>
      <div>
        <p className="short-description">{props.shortDescription}</p>
      </div>
      <div>
        <p className="location">{props.location}</p>
      </div>
    </div>
  );
};

export default EventItem;
