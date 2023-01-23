function stopSubmit(){
    return false;
}

function eventListener() {
    document.getElementById('form').addEventListener('submit', stopSubmit, false);
    var submitBtn = document.getElementById("sub");
    submitBtn.addEventListener("click", validate, false);
}

function validate(event) {
    event.preventDefault();
    var date = document.getElementById("date_input").value;
    if(date == "" || date == null) {
        alert("Wypełnij pole `Data rozpoczęcia umowy`!");
        return false;
    }

    var data = Date.parse(date);
    var today = new Date();
    today.setHours(23, 59, 59, 998);

    if(data < today) {
        alert("Data rozpoczęcia nie może być w przeszłości!");
        return false;
    }

    var confirmation = confirm("Czy na pewno chcesz zatwierdzić umowę?");
    if(confirmation) {
        console.log("Validation clear");
        document.getElementById('form').submit();
        alert("Umowa złożona! Poczekaj na zatwierdzenie przez pracownika");
        return true;
    }
    return false;
}

window.onload = eventListener;
