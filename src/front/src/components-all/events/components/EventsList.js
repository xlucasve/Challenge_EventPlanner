import React from "react";
import EventItem from "./EventItem";

const EventList = (props) => {
  return (
    <div>
      <h1>All events programmed</h1>
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
  );
};

export default EventList;
