let form = document.getElementById("form");
var elements = document.getElementById("form").elements;

// retrieving elements of the form
let nameInput = elements.item(1);
let locationInput = elements.item(2);
let emailInput = elements.item(3);
let dateInput = elements.item(4);

// elements for printing the error using there ID's
let nameError = document.getElementById("nameError");
let locationError = document.getElementById("locationError");
let emailError = document.getElementById("emailError");
let dateError = document.getElementById("dateError");


form.addEventListener("submit", (event) =>
{
	// prevents the update operation if the form is not validated
	if (!validateForm())
	{
		event.preventDefault();
	}
});

nameInput.addEventListener("blur", (event) =>
{
	validateName();
});

locationInput.addEventListener("blur", (event) =>
{
	validateLocation();
});

emailInput.addEventListener("blur", (event) =>
{
	validateEmail();
});

dateInput.addEventListener("blur", (event) =>
{
	validateDate();
});

function validateForm()
{
	let res = true;
	let isNameValid = validateName();
	let isLocationValid = validateLocation();
	let isEmailValid = validateEmail();
	let isDateValid = validateDate();
	if (!(isNameValid && isLocationValid && isEmailValid && isDateValid))
	{
		res = false;
	}
	return res;
}

function validateName()
{
	let res = true;
	nameError.style.display = "none";
	if (!nameInput.value)
	{
		nameError.style.display = "inherit";
		nameError.innerHTML = "Please provide name !";
		res = false;
	}
	else if (nameInput.value.length > 100)
	{
		nameError.style.display = "inherit";
		nameError.innerHTML = "Maximum Length of name is 100";
		res = false;
	}
	return res;
}

function validateLocation()
{
	let res = true;
	locationError.style.display = "none";
	if (!locationInput.value)
	{
		locationError.style.display = "inherit";
		locationError.innerHTML = "Please provide location !";
		res = false;
	}
	else if (locationInput.value.length > 200)
	{
		locationError.style.display = "inherit";
		locationError.innerHTML = "Maximum Length of location is 500";
		res = false;
	}
	return res;
}


function validateEmail()
{
	let res = true;
	emailError.style.display = "none";
	if (!emailInput.value)
	{
		emailError.style.display = "inherit";
		emailError.innerHTML = "Please provide email !";
		res = false;
	}
	else if (emailInput.value.length > 80)
	{
		emailError.style.display = "inherit";
		emailError.innerHTML = "Maximum Length of email is 100";
		res = false;
	}
	else if (!isValidEmail(emailInput.value))
	{
		emailError.style.display = "inherit";
		emailError.innerHTML = "Invalid Email";
		res = false;
	}
	return res;
}

// compares the email with standard format to validate using regex
function isValidEmail(email)
{
	const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(String(email).toLowerCase());
}

function validateDate()
{
	let res = true;
	dateError.style.display = "none";
	if (!dateInput.value)
	{
		dateError.style.display = "inherit";
		dateError.innerHTML = "Please provide date !";
		res = false;
	}
	return res;
}