function stopSubmit(){
    return false;
}

function eventListener() {
    document.getElementById('form').addEventListener('submit', stopSubmit, false);
    var submitBtn = document.getElementById("sub");
    submitBtn.addEventListener("click", validate, false);
}

function checkIfBlank(input) {
    return input=="";
}

function getPlecValue() {
    var k = document.getElementById("K");
    var m = document.getElementById("M");
    if(k.checked) return k;
    else if(m.checked) return m;
    return "";
}

function validate(event) {
    event.preventDefault();
    const input = new Map();
    input.set("Imie", document.getElementById("imie").value);
    input.set("Nazwisko", document.getElementById("nazwisko").value);
    input.set("Data urodzenia", document.getElementById("data_urodzenia").value);
    input.set("Plec", getPlecValue());
    input.set("Numer telefonu", document.getElementById("nr_telefonu").value);
    input.set("PESEL", document.getElementById("pesel").value);
    input.set("Haslo", document.getElementById("password").value);
    input.set("Potwierdz haslo", document.getElementById("confirmPassword").value);
    input.set("Kraj", document.getElementById("kraj").value);
    input.set("Miasto", document.getElementById("miasto").value);
    input.set("Kod pocztowy", document.getElementById("kod_pocztowy").value);
    input.set("Ulica", document.getElementById("ulica").value);
    input.set("Numer domu", document.getElementById("nr_domu").value);
    input.set("Numer mieszkania", document.getElementById("nr_mieszkania").value);

    for(const key of input.keys()) {
        if(input.get(key) == "") {
            window.alert("Błąd: pole " + key + " nie może być puste!");
            return false;
        }
        if(input.get(key) == undefined) {
            window.alert("Błąd: pole " + key + " nie może być puste!");
            return false;
        }
    }
    if(input.get("Haslo") != input.get("Potwierdz haslo")) {
        window.alert("Błąd: hasła muszą być takie same!");
        return false;
    }
    console.log("Validation clear");
    // document.getElementById('form').submit();
    return true;
}

window.onload = eventListener;
