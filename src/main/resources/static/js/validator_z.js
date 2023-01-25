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

function getGatunek() {
    var pies = document.getElementById("Pies");
    var kot = document.getElementById("Kot");
    if(kot.checked) return kot.value;
    else if(pies.checked) return pies.value;
    return "";
}

function getRozmiar() {
    var maly = document.getElementById("mały");
    var sredni = document.getElementById("średni");
    var duzy = document.getElementById("duży");
    if(maly.checked) return maly.value;
    else if(sredni.checked) return sredni.value;
    else if(duzy.checked) return duzy.value;
    return "";
}

function validate(event) {
    event.preventDefault();
    const input = new Map();
    input.set("Imie", document.getElementById("imie").value);
    input.set("Gatunek", getGatunek());
//    input.set("Rasa", document.getElementById("rasa").value);
    input.set("Plec", getPlecValue());
    input.set("Rozmiar", getRozmiar());
    input.set("Koszt_utrzymania", document.getElementById("koszt_utrzymania").value);
    input.set("Umaszczenia", document.getElementById("umaszczenie").value);
    input.set("Nazwa_karmy", document.getElementById("nazwa_karmy").value);
    input.set("Data_przyjecia", document.getElementById("data_przyjecia").value);
    input.set("Zdjecie", document.getElementById("image").value);

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
    console.log("Validation clear");
    alert("Zwierze dodane pomyślnie!");

    document.getElementById('form').submit();
    return true;
}

window.onload = eventListener;
