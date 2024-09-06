const form = document.getElementById("f1");
form.addEventListener("submit", async (e)=>{
	e.preventDefault();
	const [Fname, Lname, age, gender, phone, email ] = form;
	const infoDate = form.infoDate;
	await fetch(`InsertInformationServlet?Fname=${Fname.value}&Lname=${Lname.value}&age=${age.value}&gender=${gender.value}&phone=${phone.value}&email=${email.value}&date=${infoDate.value}`,{
		method: "POST"
	})
	alert("Your Information inserted success!" );
	alert("Now we will Phone or Email to you to comfirm your token number. ");

	window.location.href = "/clinic_pj/home.html";
})