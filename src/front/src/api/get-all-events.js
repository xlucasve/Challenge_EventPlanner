const getAllEvents = async (setEventsObtained) => {
  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  let response = await fetch(
    "http://localhost:8080/api/v1/planner/event",
    requestOptions
  ).catch((error) => console.log("error", error));
  let responseData = await response.json();
  console.log(responseData);
  setEventsObtained(responseData);
};

export default getAllEvents;
