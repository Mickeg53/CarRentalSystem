const submitButton = document.getElementById("btnSubmit");
const input1 = document.getElementById("emailInput");
const input2 = document.getElementById("inputID");

input1.addEventListener("keypress", (e) =>{
   const value = e.currentTarget.valueOf();
    submitButton.disabled = false;

    if(value === ""){
        submitButton.disabled = true;
    }
});