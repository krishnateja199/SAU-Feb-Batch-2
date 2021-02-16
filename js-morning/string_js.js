function submit()
{
    let str=document.getElementById("text");
    let str1=str.value;
    let str2="length of a string is";
    document.getElementById("len").innerHTML = str1.length;
    document.getElementById("blank").innerHTML = str2;
  
}
function checking()
{
    let str=document.getElementById("text");
    let str1=str.value;
    var hasNumber = /\d/;   
    var test=hasNumber.test(str1);
    if(test&&true) 
      
    { 
        document.getElementById("num1").innerHTML = "the given string contains numbers";
    } 
   else
    { 
        document.getElementById("num1").innerHTML = "the given string doesnot    contains numbers";
    }
}
function cases()
{
    let str=document.getElementById("text");
    let str1=str.value;
    var u=str1.toUpperCase();
    var l=str1.toLowerCase();
    document.getElementById("upper").innerHTML = u;
    document.getElementById("lower").innerHTML = l;
    
}
function count()
{
    let str=document.getElementById("text");
    let str1=str.value;
    let tot=str1.length;
    const vow = str1.match(/[aeiou]/gi).length;
    const con = tot-vow;
    document.getElementById("count1").innerHTML = "vowels count is "+vow;
    document.getElementById("count2").innerHTML = "consonents count is "+con;
    
}