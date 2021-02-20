let person = {};

function submit() {
    person.name = document.getElementById("name").value;
    person.rollno = document.getElementById("rollno").value;
    person.email = document.getElementById("email").value;
    person.occupation = document.getElementById("occupation").value;
    person.age = document.getElementById("age").value;

    let ele = document.getElementsByName('gender');

    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked)
            person.gender = ele[i].value;
    }

    person.dob = document.getElementById("dob").value;
    document.getElementById("print1").innerHTML = "Details are added into object!"
    //console.log(person);
}

function get() {
    let x = document.getElementById("get").value;
    if (person.rollno === x) {
        let myString = JSON.stringify(person);
        document.getElementById("print").innerHTML = myString;
    }
    else {
        document.getElementById("print").innerHTML = "Enter Correct RollNo.";
    }
}