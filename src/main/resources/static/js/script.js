
let elements = document.querySelectorAll(".inputs *:not(select)");

let lang = {
	EN: [
		"To",
		"Message (optional)",
		"Happy Birthday!",
		"All the Best!",
		"Many More Happy Returns!",
		"Generate"
	],
	TR: [
		"Kime",
		"Mesaj (isteğe bağlı)",
		"Doğum Günün Kutlu Olsun!",
		"İyi ki Doğdun!",
		"Nice Yıllara!",
		"Oluştur"
	]
};

document.querySelectorAll(".languages *").forEach(i => {
	i.addEventListener("click", e => {
		for (let j = 0; j < elements.length; j++) {
			if (elements[j].type && elements[j].placeholder) {
				elements[j].placeholder = lang[i.innerText][j];
			} else if (elements[j].type) {
				elements[j].value = lang[i.innerText][j];	
			} else {
				elements[j].innerText = lang[i.innerText][j];
			}
		}
	});
});

document.getElementById("generate").addEventListener("click", e => {
	if (!elements[0].value.trim()) return;
	let params = "to=" + elements[0].value.trim() + "&birthday-message=" +
		document.querySelector("select").selectedOptions[0].innerText.trim();
	let msg = elements[1].value.trim();
	if (msg) {
		params += "&message=" + msg
	}
	window.location = "/api/generate/?" + params;
});

elements[0].addEventListener("input", function(e) {
	if (!this.value.trim()) {
		elements[elements.length - 1].setAttribute("disabled", "");
	} else {
		elements[elements.length - 1].removeAttribute("disabled", "");
	}
});

document.body.addEventListener("keypress", e => {
	if (e.key == "Enter") {
		e.preventDefault();
		document.getElementById("generate").click();
	}
});