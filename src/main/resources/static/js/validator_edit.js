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
    input.set("Data_urodzenia", document.getElementById("data_urodzenia").value);
    input.set("Plec", getPlecValue());
    input.set("Numer_telefonu", document.getElementById("nr_telefonu").value);
    input.set("Haslo", document.getElementById("password").value);
    input.set("Potwierdz_haslo", document.getElementById("confirmPassword").value);
    input.set("Kraj", document.getElementById("kraj").value);
    input.set("Miasto", document.getElementById("miasto").value);
    input.set("Kod_pocztowy", document.getElementById("kod_pocztowy").value);
    input.set("Ulica", document.getElementById("ulica").value);
    input.set("Numer_domu", document.getElementById("nr_domu").value);

    if(input.get("Imie").length > 20) {
        window.alert("Błąd: pole Imie nie może przekraczać 20 znaków!");
        return false;
    }
    if(input.get("Nazwisko").length > 30) {
        window.alert("Błąd: pole Nazwisko nie może przekraczać 30 znaków!");
        return false;
    }
    if(input.get("Kod_pocztowy").length != 0 && (input.get("Kod_pocztowy").length > 5 || input.get("Kod_pocztowy").length < 5)) {
        window.alert("Błąd: pole Kod pocztowy musi zawierać dokładnie 5 cyfr!");
        return false;
    }
    if(document.getElementById("pesel").value != "" && document.getElementById("pesel").value.length != 11) {
          window.alert("Błąd: pole Pesel musi mieć dokładnie 11 znaków!");
          return false;
    }
    if(input.get("Haslo") != input.get("Potwierdz_haslo")) {
        window.alert("Błąd: hasła muszą być takie same!");
        console.log(input.get("Haslo") + " " + input.get("Potwierdz haslo"));
        return false;
    }
    console.log("Validation clear");
    alert("Edytowano dane");
    document.getElementById('form').submit();
    return true;
}

window.onload = eventListener;
