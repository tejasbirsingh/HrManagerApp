// get the elements from there ID's
let form = document.getElementById("form");
var elements = document.getElementById("form").elements;
// retrieving elements from form
let usernameInput = elements.item(0);
let passwordInput = elements.item(1);
let usernameError = document.getElementById("usernameError");
let passwordError = document.getElementById("passwordError");

// this function works when the user presses login button
form.addEventListener("submit", (event) =>
{
	if (!validateForm())
	{
		// if the validation is not passed then prevent login event
		event.preventDefault();
	}
});

usernameInput.addEventListener("blur", (event) =>
{
	validateUsername();
});

passwordInput.addEventListener("blur", (event) =>
{
	validatePassword();
});

function validateForm()
{
	let res = true;
	let isUserValid = validateUsername();
	let isPasswordValid = validatePassword();
	if (!(isUserValid && isPasswordValid))
	{
		res = false;
	}
	return res;
}

function validateUsername()
{
	let res = true;
	usernameError.style.display = "none";
	if (!usernameInput.value)
	{
		usernameError.style.display = "inherit";
		usernameError.innerHTML = "Please provide username !";
		res = false;
	}
	else if (usernameInput.value.length < 5)
	{
		usernameError.style.display = "inherit";
		usernameError.innerHTML = "Minimum Length of username is 5";
		res = false;
	}
	else if (usernameInput.value.length > 50)
	{
		usernameError.style.display = "inherit";
		usernameError.innerHTML = "Maximum Length of username is 50";
		res = false;
	}
	return res;
}

function validatePassword()
{
	let res = true;
	passwordError.style.display = "none";
	if (!passwordInput.value)
	{
		passwordError.style.display = "inherit";
		passwordError.innerHTML = "Please provide the password !";
		res = false;
	}
	else if (passwordInput.value.length < 5)
	{
		passwordError.style.display = "inherit";
		passwordError.innerHTML = "Minimum Length of the password is 5";
		res = false;
	}
	else if (passwordInput.value.length > 30)
	{
		passwordError.style.display = "inherit";
		passwordError.innerHTML = "Maximum Length of the password is 30";
		res = false;
	}
	return res;
}