const url = new URL("http://localhost:8080/steam/resources/")
const seriesEndpoint = "series";
const usersEndpoint = "users";

async function signup(username, password){ // TODO PARAMETERS
	let response = await fetch(url + 'users/' + username, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ password: password })
	});

	console.log(response);
}

async function login(username, password){
	let response = await fetch(url + 'users/' + username + '/login', {
		method: 'POST',
		mode:"cors",
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({ password: password })
	});

	if (response.ok){
		sessionStorage.setItem("sessionUser", username);
	}

	console.log(response);
}

async function search(){ // TODO PARAMETERS
	fetch(url + 'search') // TODO CHANGE ENDPOINT
		.then(response => {

		});
}

function isLoggedIn()
{
	let sessionUser = sessionStorage.getItem("sessionUser");

	if (!sessionUser)
	{
		console.log('User not logged in')
		return false;
	}

	return true;
}

async function addOrModifySeries(seriesData)
{
	if (!isLoggedIn())
	{
		return;
	}

	var username = sessionStorage.getItem("sessionUser");

	let response = await fetch(url + seriesEndpoint + '?username=' + username, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(seriesData)
	});

	console.log(response);
}

async function getRating(seriesName)
{
	if (!isLoggedIn())
	{
		return;
	}

	var username = sessionStorage.getItem("sessionUser");

	let response = await fetch(url + seriesEndpoint + '/' + seriesName + '/rating?username=' + username, {
		method: 'GET',
		mode: "cors",
		headers: {
			'Content-Type': 'application/json'
		}
	});

	console.log(response);
	return response;
}

async function getAllSeries()
{
	let response = await fetch(url + seriesEndpoint + '/all', {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	});

	console.log(response);
	return response;
}

async function search(genre, streamingProvider, score)
{
	if (!isLoggedIn())
	{
		return;
	}

	var username = sessionStorage.getItem("sessionUser");

	let endpoint = url + seriesEndpoint + '/search';

	endpoint += '?username=' + username;
	endpoint += '&genre=' + genre;
	endpoint += '&streamingProvider=' + streamingProvider;
	endpoint += '&score=' + score;

	let response = await fetch(endpoint, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	});

	console.log(response);
	return response;
}

async function getAllSeriesWithTitle(title)
{
	let endpoint = url + seriesEndpoint + '/byTitle';

	endpoint += '/' + title;

	console.log(endpoint);
	let response = await fetch(endpoint, {
		method: 'GET',
		mode:"cors",
		headers: {
			'Content-Type': 'application/json'
		}
	});

	console.log(response);
	return response;
}