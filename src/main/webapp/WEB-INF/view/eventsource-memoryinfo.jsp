<!DOCTYPE html>
<html>
<head>
<title>Server Memory Monitor</title>
<script>
function initialize() {
	var eventSourceUrl = window.location.protocol +"//" + window.location.host + '${pageContext.request.contextPath}/memory';
	const eventSource = new EventSource(eventSourceUrl);

	eventSource.onmessage = e => {
		const msg = JSON.parse(e.data);
		console.log(msg);
		document.getElementById("timestamp").innerHTML = new Date(msg.ts);
		document.getElementById("heap").innerHTML = msg.heap;
		document.getElementById("nonheap").innerHTML = msg.nonHeap;
	};
	
	eventSource.onopen = e => console.log('open');

	eventSource.onerror = e => {
		if (e.readyState == EventSource.CLOSED) {
			console.log('close');
		}
		else {
			console.log(e);
		}
	};
	
	eventSource.addEventListener('second', function(e) {
			console.log('second', e.data);
		}, false);	
}

window.onload = initialize;
</script>
</head>
<body>
	<h1>Memory Observer</h1>
	<h3>Timestamp</h3>
	<div id="timestamp"></div>
	<h3>Heap Memory Usage</h3>
	<div id="heap"></div>
	<h3>Non Heap Memory Usage</h3>
	<div id="nonheap"></div>
</body>
</html>