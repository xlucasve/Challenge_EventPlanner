import React, { useState, useEffect } from "react";
import EventList from "../components/EventsList";
import getAllEvents from "../../../api/get-all-events";

const Events = () => {
  const [eventsObtained, setEventsObtained] = useState([{}]);

  useEffect(() => {
    getAllEvents(setEventsObtained);
  }, []);

  return (
    <div>
      <EventList events={eventsObtained} />
    </div>
  );
};

export default Events;
