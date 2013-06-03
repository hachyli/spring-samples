

function alertErrorMsg(msg, e){
	alert(msg);
	e.preventDefault();
}

function validateEmail(email) { 
    var re = /^\s*[\w\-\+_]+(\.[\w\-\+_]+)*\@[\w\-\+_]+\.[\w\-\+_]+(\.[\w\-\+_]+)*\s*$/;
    return re.test(email);
}
