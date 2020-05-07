<!DOCTYPE html>
<html>
<head>
<title>Springboot21</title>
<script>
function initialize() {
	// var eventSourceUrl = window.location.protocol +"//" + window.location.host + "${pageContext.request.contextPath}/sampleJob/subscribe";
	var eventSourceUrl = "${pageContext.request.contextPath}/sampleJob/subscribe";
	const eventSource = new EventSource(eventSourceUrl);

	eventSource.onmessage = e => {
		const msg = JSON.parse(e.data);
		console.log(msg);
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
	<h1>EventSource SampleJob Subscriber</h1>
</body>
</html>