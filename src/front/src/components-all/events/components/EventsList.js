import React from "react";
import EventItem from "./EventItem";

import "./EventsList.css";

const EventList = (props) => {
  if (Object.keys(props.events).length > 0) {
    return (
      <div>
        <p className="start-title">All events programmed</p>
        <div className="event-list">
          {props.events.map((event) => {
            return (
              <EventItem
                key={event.event_id}
                id={event.event_id}
                title={event.title}
                shortDescription={event.shortDescription}
                longDescription={event.longDescription}
                location={event.location}
                date={event.date}
                status={event.status}
              />
            );
          })}
        </div>
      </div>
    );
  } else {
    return (
      <div>
        <h1>No event found</h1>
      </div>
    );
  }
};

export default EventList;
