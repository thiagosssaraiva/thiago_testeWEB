/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateDriver() {
        var nome = document.getElementById("nome").value;
        var dt_nasc = document.getElementById("dt_nasc").value;
        var cpf = document.getElementById("cpf").value;
        var modelCar = document.getElementById("modelCar").value;

        if(nome == null || nome ==""){
            alert("Preencha o Nome");
            return false;
        }else if (dt_nasc == null || dt_nasc ==""){
            alert("Preencha a Data de Nascimento");
            return false;
        }else if (cpf == null || cpf ==""){
            alert("Preencha o CPF");
            return false;
        }else if (modelCar == null || modelCar ==""){
            alert("Preencha o modelo do carro");
            return false;
        }else{
            return true;
        }     
}

function validatePassenger() {
        var nome = document.getElementById("nome").value;
        var dt_nasc = document.getElementById("dt_nasc").value;
        var cpf = document.getElementById("cpf").value;

        if(nome == null || nome ==""){
            alert("Preencha o Nome");
            return false;
        }else if (dt_nasc == null || dt_nasc ==""){
            alert("Preencha a Data de Nascimento");
            return false;
        }else if (cpf == null || cpf ==""){
            alert("Preencha o CPF");
            return false;
        }else{
            return true;
        }     
}