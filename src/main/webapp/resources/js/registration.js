

$("#send").on("click",function () {
           if (validate()){
               $("#send").submit()
           }else {

               event.preventDefault()

           }})

       var nameAndSecondNameRegex = /[a-zA-Z \-]/;
var phoneRegex = /[0-9+]{13}/;
var cityRegex=/^[a-zA-Z][a-zA-Z-_\.]{2,20}$/;
var passwordRegex=/(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[a-z]).*$/;
       var emailRegex = /(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
function validate() {
    if (namee==""||!namee.match(nameAndSecondNameRegex) ){
        showErrorMessage("Invalid user name");
        return false
       }
        if (secondname==""||!secondname.match(nameAndSecondNameRegex)){
        showErrorMessage("Invalid user second name");
        return false
    }
    if (cityy==""||!cityy.match(cityRegex)){
            showErrorMessage("invalid user city")
        return false;
    }
    if (phonee == "" || !phonee.match(phoneRegex)) {
        showErrorMessage("Invalid user phone");
        return false;
    }
    if (emaill==""||!emaill.match(emailRegex)){
        showErrorMessage("Invalid user email");
        return false
       }
    if (passwordd==""||!passwordd.match(passwordRegex)){
        showErrorMessage("Invalid user user password");
           return false
       }return true
}
function showErrorMessage(message) {
    $("#errorMessages").text(message);
    $("#errorMessages").css({"display":"block"});
}