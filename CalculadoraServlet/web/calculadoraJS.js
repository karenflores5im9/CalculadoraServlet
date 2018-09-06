/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function () {
    pantalla = document.getElementById("textoPantalla");
}
par = 0; //numero digitado
x = "0"; //numero pantalla
xi = 1; //inicio numero
coma = 0;
ni = 0; //número oculto o en espera.
op = "no";

function numero(num) {
    if (par == 1) {
        coma = 0;
        par = 0;
    }

    if (x == "0" || xi == 1) { // inicio numero, 
        pantalla.innerHTML = num;
        x = num;
        if (num == ".") {
            pantalla.innerHTML = "0.";
            x = num;
            coma = 1;
        }
    } else { //continua escribiendo
        if (num == "." && coma == 0) { //primera coma
            pantalla.innerHTML += num;
            x += num;
            coma = 1;
        } else if (num == "." && coma == 1) {
        } //si hay segunda coma 
        else {
            pantalla.innerHTML += num;
            x += num
        }
    }
    xi = 0 //numero en curso
}

function igualar() {
    if (op == "no") { //op pendiente.
        pantalla.innerHTML = x;
    } else {
        sl = ni + op + x; //cadena de op
        sol = eval(sl) //convertir cadena a código
        pantalla.innerHTML = sol
        x = sol;
        op = "no"; //no op pendientes
        xi = 1;//nuevo num
    }
}

function operar(oper) {
    par = 1; //ya hay un numero
    igualar();
    op = oper; //guarda op
    ni = x //guarda numero
    xi = 1; //nuevo num
}

function borradoParcial() {
    pantalla.innerHTML = 0;
    x = 0;
    coma = 0;
}

function borradoTotal() {
    pantalla.innerHTML = 0;
    x = "0";//reiniciar todo
    coma = 0;
    ni = 0
    op = "no"
    par = 0;
}

function raiz(){
    
}