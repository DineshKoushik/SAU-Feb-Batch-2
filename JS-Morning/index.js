function submit(){
    document.getElementById("length").innerHTML = "Finding the length :  " + document.getElementById("text").value.length;
    document.getElementById("convert").innerHTML = "converting to upper : " + document.getElementById("text").value.toUpperCase() + " converting to lower : " + document.getElementById("text").value.toLowerCase();
    let str = document.getElementById("text").value;
    document.getElementById("seperate").innerHTML = "Separate Vowels and Consonants : " + foo(str);
    document.getElementById("check").innerHTML = "Whether number present or not : " + check(str);


    function foo(str) {
        let v = 'AEIOUaeiou';
        let n = '0123456789';
        let vowels = '';
        let cons = '';
        for(let i = 0; i < str.length; i++){
            if(v.includes(str[i])){
                vowels += str[i];
            }
            else{
                if(!n.includes(str[i])){
                    cons += str[i];
                }
            }
        }
        return (vowels +" " +cons);
    }

    function check(str){
        let num = '0123456789';
        for(let i=0; i<str.length;i++)
        {
            if(num.includes(str[i])){
                return "String has number(s)"
            }
        }
        return "String has no number"
    }
}