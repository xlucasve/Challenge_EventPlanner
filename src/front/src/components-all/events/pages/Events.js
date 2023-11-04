import React, { useState, useEffect } from "react";
import EventList from "../components/EventsList";
import getAllEvents from "../../../api/get-all-events";

import "./Events.css";

const Events = () => {
  const [eventsObtained, setEventsObtained] = useState([{}]);

  useEffect(() => {
    getAllEvents(setEventsObtained);
  }, []);

  return (
    <div className="event-site">
      <EventList events={eventsObtained} />
    </div>
  );
};

export default Events;
