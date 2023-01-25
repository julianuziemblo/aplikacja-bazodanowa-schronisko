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
    if(k.checked) return k.value;
    else if(m.checked) return m.value;
    return "";
}

function getStanowiskoValue() {
    var z = document.getElementById("1");
    var r = document.getElementById("2");
    var w = document.getElementById("3");
    if(z.checked) return z.value;
    else if(r.checked) return r.value;
    else if(w.checked) return w.value;
    return "";
}

function getSposobWyplaty() {
    var k = document.getElementById("K1");
    var g = document.getElementById("G");
    if(k.checked) return k;
    else if(g.checked) return g;
    return "";
}

function validate(event) {
    event.preventDefault();
    const input = new Map();
    input.set("Imie", document.getElementById("imie").value);
    input.set("Nazwisko", document.getElementById("nazwisko").value);
    input.set("Data_urodzenia", document.getElementById("data_urodzenia").value);
    input.set("Data_zatrudnienia", document.getElementById("data_zatrudnienia").value);
    input.set("Plec", getPlecValue());
    input.set("Sposob_wyplaty", getSposobWyplaty());
    input.set("Numer_telefonu", document.getElementById("nr_telefonu").value);
    input.set("Email", document.getElementById("email").value);
    input.set("Stanowisko", getStanowiskoValue());
    input.set("Kraj", document.getElementById("kraj").value);
    input.set("Miasto", document.getElementById("miasto").value);
    input.set("Kod_pocztowy", document.getElementById("kod_pocztowy").value);
    input.set("Ulica", document.getElementById("ulica").value);
    input.set("Numer_domu", document.getElementById("nr_domu").value);

    for(const key of input.keys()) {
        if(input.get(key) == "") {
            window.alert("Błąd: pole " + key + " nie może być puste!");
            return false;
        }
        if(input.get(key) == undefined) {
            window.alert("Błąd: pole " + key + " nie może być puste!");
            return false;
        }
        if(input.get(key) == null) {
            window.alert("Błąd: pole " + key + " nie może być puste!");
            return false;
        }
    }
    if(input.get("Imie").length > 20) {
        window.alert("Błąd: pole Imie nie może przekraczać 20 znaków!");
        return false;
    }
    if(input.get("Nazwisko").length > 30) {
        window.alert("Błąd: pole Nazwisko nie może przekraczać 30 znaków!");
        return false;
    }
    if(document.getElementById("pesel").value != "" && document.getElementById("pesel").value.length != 11) {
          window.alert("Błąd: pole Pesel musi mieć dokładnie 11 znaków!");
          return false;
    }
    console.log("Validation clear");
    alert("Pracownik pomyślnie dodany");
    document.getElementById('form').submit();
    return true;
}

window.onload = eventListener;
