function send(){
    
    let uname = document.getElementById('uname');
    let id = document.getElementById('roll');
    let pass = document.getElementById('psw');
    let data={
        'uname':uname.value,
        'id':id.value,
        'psw':pass.value
    }
    console.log(uname.textContent)
    
    url="http://127.0.0.1:5000/v1/register"
    options={
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        method:"POST",
        body:JSON.stringify(data)
    }

    fetch(url,options)
    .then(function (response){
        return response.json();
    }).then(function (text){
        let {body} = text 
        alert(body)
    })
  
}