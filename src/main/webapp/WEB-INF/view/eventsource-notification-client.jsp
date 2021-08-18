<!DOCTYPE html>
<html>
<head>
<title>springboot25 - EventSource</title>
<script>
function initialize() {
	// var eventSourceUrl = window.location.protocol +"//" + window.location.host + "${pageContext.request.contextPath}/notification-message/subscribe";
	var eventSourceUrl = "${pageContext.request.contextPath}/notification-message/subscribe";
	const eventSource = new EventSource(eventSourceUrl);

	eventSource.onmessage = e => {
		const msg = JSON.parse(e.data);
		console.log(msg);
		document.getElementById("title").innerHTML = msg.title;
		document.getElementById("count").innerHTML = msg.count;
		document.getElementById("desc").innerHTML = msg.desc;
	};
	
	eventSource.onopen = e => console.log("open");

	eventSource.onerror = e => {
		if (e.readyState == EventSource.CLOSED) {
			console.log("close");
		}
		else {
			console.log(e);
		}
	};
}

window.onload = initialize;
</script>
</head>
<body>
	<h1>EventSource Notification-Message Subscriber</h1>
	<h3>title</h3>
	<div id="title"></div>
	<h3>count</h3>
	<div id="count"></div>
	<h3>desc</h3>
	<div id="desc"></div>
</body>
</html>