
function validate(frm){
	alert("js");
	alert("1");
	frm.vflag.value="yes";
	
	let ename=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	let flag=true;
	
	
	
	document.getElementById("enameId").innerHTML="";
	document.getElementById("jobId").innerHTML="";
	document.getElementById("salId").innerHTML="";
	
	
	
	if(ename=""){
		flag=false;
		document.getElementById("enameId").innerHTML="Employee name is required(js)"
	}
	else if(ename.length<5 || ename.length>10){
		flag=false;
		document.getElementById("enameId").innerHTML="Employee name must have min 5 and max 10 charecters(js)"
	}
	
	if(job=""){
		flag=false;
		document.getElementById("jobId").innerHTML="Employee job is required(js)"
	}
	else if(job.length<5 || job.length>10){
		flag=false;
		document.getElementById("jobId").innerHTML="Employee job must have min 5 and max 10 charecters(js)"
	}
	
	if(sal=""){
		flag=true;
		document.getElementById("salId").innerHTML="Employee sal is required(js)"
	}
	else if(isNaN(sal)){
		flag=false;
		document.getElementById("salId").innerHTML="salary must be numeric value"
	}
	
	else if(sal<100 || sal>10000){
		flag=true;
		document.getElementById("salId").innerHTML="Employee sal must be in range of 100 to 10000(js)"
	}
	
	return flag;

}