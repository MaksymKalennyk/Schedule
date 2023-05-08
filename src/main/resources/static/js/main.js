const form = document.getElementById("registration-form");
const phone = document.getElementById("exampleInputPhone");
const email = document.getElementById("exampleInputEmail1");
const password = document.getElementById("exampleInputPassword1");
const firstName = document.getElementById("exampleFname");
const lastName = document.getElementById("exampleLname");
const patronymic = document.getElementById("examplePatronymic");
const sex = document.querySelector('input[name="exampleSex"]:checked');
const date = document.getElementById("exampleDate");
const group = document.getElementById("exampleGroup");
const table = document.getElementById("table-registration");

let maskOptions = {
    mask: "+38(000)-000-00-00",
    lazy: false,
};
let phoneMask = new IMask(phone, maskOptions);

form.addEventListener("submit", (e) => {
    e.preventDefault();

    var inputState = {
        emailValue: email.value.trim(),
        phoneValueUnmasked: phoneMask.unmaskedValue,
        phoneValue: phone.value,
        passwordValue: password.value.trim(),
        firstNameValue: firstName.value.trim(),
        lastNameValue: lastName.value.trim(),
        patronymicValue: patronymic.value.trim(),
        sexValue: sex.value,
        dateValue: date.value,
        groupValue: group.value,
    };

    if (!checkInputs(inputState)) {
        form.reset();
        for (const child of form.children) {
            if (child.tagName !== "BUTTON") child.className = "mb-3";
        }

        table.parentElement.style.visibility = "visible";
        let row = 1;
        displayInputs(inputState, row);
    }
});

function checkInputs(inputState) {
    let isError = false;
    if (inputState.firstNameValue === "") {
        //error
        setErrorFor(firstName, "Заповніть поле будь ласка");
        isError = true;
    } else {
        setSuccessFor(firstName);
    }

    if (inputState.lastNameValue === "") {
        //error
        setErrorFor(lastName, "Заповніть поле будь ласка");
        isError = true;
    } else {
        setSuccessFor(lastName);
    }

    if (inputState.patronymicValue === "") {
        //error
        setErrorFor(patronymic, "Заповніть поле будь ласка");
        isError = true;
    } else {
        setSuccessFor(patronymic);
    }

    if (inputState.dateValue === "") {
        //error
        setErrorFor(date, "Заповніть поле будь ласка");
        isError = true;
    } else {
        setSuccessFor(date);
    }

    if (inputState.emailValue === "") {
        //error
        setErrorFor(email, "Заповніть поле будь ласка");
        isError = true;
    } else if (!isEmail(inputState.emailValue)) {
        setErrorFor(email, "Email не валідний");
        isError = true;
    } else {
        setSuccessFor(email);
    }

    if (inputState.passwordValue === "") {
        //error
        setErrorFor(password, "Заповніть поле будь ласка");
        isError = true;
    } else {
        setSuccessFor(password);
    }

    if (inputState.groupValue === "Виберіть группу:") {
        //error
        setErrorFor(group, "Виберіть группу");
        isError = true;
    } else {
        setSuccessFor(group);
    }

    if (
        inputState.phoneValueUnmasked === "" ||
        inputState.phoneValueUnmasked.length != 10
    ) {
        //error
        setErrorFor(phone, "Номер телефону не валідний");
        isError = true;
    } else {
        setSuccessFor(phone);
    }

    return isError;
}

function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector("small");
    small.innerText = message;
    formControl.className = "mb-3 error";
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = "mb-3 success";
}

function isEmail(email) {
    return /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(
        email
    );
}

function displayInputs(inputState, row) {
    let newRow = table.insertRow(row);
    let cell1 = newRow.insertCell(0);
    let cell2 = newRow.insertCell(1);
    let cell3 = newRow.insertCell(2);
    let cell4 = newRow.insertCell(3);
    let cell5 = newRow.insertCell(4);
    let cell6 = newRow.insertCell(5);
    let cell7 = newRow.insertCell(6);
    let cell8 = newRow.insertCell(7);
    let cell9 = newRow.insertCell(8);
    let cell10 = newRow.insertCell(9);
    cell1.innerHTML = inputState.emailValue;
    cell2.innerHTML = inputState.phoneValue;
    cell3.innerHTML = inputState.passwordValue;
    cell4.innerHTML = inputState.lastNameValue;
    cell5.innerHTML = inputState.firstNameValue;
    cell6.innerHTML = inputState.patronymicValue;
    cell7.innerHTML = inputState.sexValue;
    cell8.innerHTML = inputState.dateValue;
    cell9.innerHTML = inputState.groupValue;
    cell10.innerHTML +=
        '<form style="text-align: center;"><input name="myCheckbox" id="myCheckbox" type="checkbox"></form>';
    row++;
}
