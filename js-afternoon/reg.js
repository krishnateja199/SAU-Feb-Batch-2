
var firstname=document.getElementById("firstname");
var lastname=document.getElementById("lastname");
var dob = document.getElementById("dob");
var gender = document.getElementById("gender") ;
var age= document.getElementById("age");
var rollno=document.getElementById("rollno");

function UserDetails(firstname,lastname,dob, gender,age,rollno) {
    this.firstname=firstname;
    this.lastname=lastname;
    this.dob = dob;
    this.gender=gender;
    this.age=age;
    this.rollno=rollno;

}
dob.onblur = function () {
    var dobPattern = /^\d{2}(\/|\:|\-)\d{2}\1\d{4}$/;
    var dobvalue = dob.value;
    if (dobPattern.test(dobvalue))
        document.getElementById("pdob").innerHTML = "valid";
    else {
        document.getElementById("pdob").innerHTML = "Invalid";
        dob.focus();
        dob.select();
    }
}
gender.onblur=function(){
    var genderpattern=/^male$|^female$/g;
    var gendervalue=gender.value;
    if(genderpattern.test(gendervalue))
       document.getElementById("pgender").innerHTML="valid";
       else
       {
           document.getElementById("pgender").innerHTML="Invalid";
           gender.focus();
           gender.select();
       }
}

age.onblur=function(){
    var agepattern=/^\S[0-9]{0,3}$/;
    var agevalue=age.value;
    if(agepattern.test(agevalue))
       document.getElementById("page").innerHTML="valid";
       else
       {
           document.getElementById("page").innerHTML="Invalid";
           age.focus();
           age.select();
       }
}


rollno.onblur = function () {
    var i; var counter = 0;
    for (i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) == rollno.value) {
            document.getElementById("prollno").innerHTML = "user already exist";
            rollno.focus();
            rollno.select();
            counter = 1;
        }
        else
            break;
    }
    if (counter == 0)
        document.getElementById("prollno").innerHTML = "stored in local memory";
}

function submit() {
   // alert(firstname.value);
     if (firstname.value!="" && lastname.value!="" && age.value != "" && gender.value != "" && dob.value != "" && rollno.value != "") {
        document.getElementById("psb").innerHTML = "You are successfully registered";
        let myObj = new UserDetails(firstname.value,lastname.value, dob.value, gender.value, age.value,rollno.value);
        localStorage.setItem(rollno.value, JSON.stringify(myObj));
    }

    else
        document.getElementById("psb").innerHTML = "fill all details";

}
function get_d()
{
    var roll=document.getElementById("proll");
    var rollno_d=roll.value;
  //  alert(rollno_d);
    document.getElementById("pdetails").innerHTML=localStorage.getItem(rollno_d);
}