function stopSubmit(){
    return false;
}

function eventListener() {
    document.getElementById('form1').addEventListener('submit', stopSubmit, false);
    var submitBtn = document.getElementById("sub");
    submitBtn.addEventListener("click", validate, false);
}

function validate(event) {
    event.preventDefault();
    var conf = confirm("Czy na pewno chcesz wyrzucić tego pracownika?");
    if(conf) {
        alert("Pracownik wyrzucony");
        return true;
    }
    else {
        return false;
    }
}

window.onload = eventListener;
