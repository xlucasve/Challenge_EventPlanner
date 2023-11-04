const getAllEvents = async (setEventsObtained) => {
  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  try {
    let response = await fetch(
      "http://localhost:8080/api/v1/planner/event",
      requestOptions
    );
    let responseData = await response.json();
    console.log(responseData);
    setEventsObtained(responseData);
  } catch (error) {
    console.log(error);
  }
};

export default getAllEvents;
