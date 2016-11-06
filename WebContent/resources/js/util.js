function apenasNumeros(e){        
	// Esta fun��o bloqueia a digita��o de teclas diferentes das num�ricas, da v�rgula e do backspace.
    // A fun��o keyCode retorna o n�mero ASCII correspondente da tecla pressionada
    // quando o navegador � o Internet Explorer
    // A fun��o which retorna o n�mero ASCII correspondente da tecla pressionada
    // quando o navegador � o Netscape ou o Firefox
    if (window.event){
    	var tecla = e.keyCode;
    	if((tecla == 8)||(tecla == 127)||(tecla == 46)||(tecla>=48&&tecla<=57)){
    		return true;
    	}else{
    		return false;
    	}
        
    } // Internet Explorer
    else if (e.which){
    	var tecla = e.which;
    	if((tecla == 8)||(tecla == 127)||(tecla == 46)||(tecla>=48&&tecla<=57)){
    		return true;
    	}else{
    		return false;
    	}
    } 
    // Netscape ou Firefox
    // n�mero zero = 48
    // n�mero nove = 57
    // ponto = 46
    // tecla backspace = 8
    // tecla delete = 127
    // alert(tecla)
    //alert(((tecla == 8)||(tecla == 46)||(tecla>=48&&tecla<=57)||(tecla>=96&&tecla<=105)))
    //return ((tecla == 8)||(tecla == 46)||(tecla>=48&&tecla<=57)||(tecla>=96&&tecla<=105));
        
}

function apenasNumerosFoco(e, proximoId){     
	if (window.event){
    	var tecla = e.keyCode;
    	if((tecla == 8)||(tecla == 127)||(tecla>=48&&tecla<=57)||(tecla == 13)){
    		if((tecla == 13)){
    			e.keyCode = 9;
    			document.getElementById(proximoId).focus();
    		}
    		return true;
    	}else{
    		return false;
    	}
        
    } // Internet Explorer
    else if (e.which){
    	var tecla = e.which;
    	if((tecla == 8)||(tecla == 127)||(tecla>=48&&tecla<=57)||(tecla == 13)){
    		if((tecla == 13)){
    			e.which = 9;
    			document.getElementById(proximoId).focus();
    		}
    		return true;
    	}else{
    		return false;
    	}
    } 
    
}

function textCounter(campo, exibir, maxlimit) {
	
	if (document.getElementById(campo).value.length == 0)
		document.getElementById(exibir).value = 1000;
	else if (document.getElementById(campo).value.length > maxlimit) 
		document.getElementById(campo).value = document.getElementById(campo).value.substring(0, maxlimit);
	else
		document.getElementById(exibir).value = maxlimit - document.getElementById(campo).value.length;
} 

function formataHora(Campo, teclapres){
	var tecla = teclapres.keyCode;
	
	var vr = new String(Campo.value);
	vr = vr.replace(":", "");
	vr = vr.replace(":", "");
	
	tam = vr.length + 1;
	
	if (tecla != 9 && tecla != 8){
		if (tam > 2 && tam < 5)
			Campo.value = vr.substr(0, 2) + ':' + vr.substr(2, tam);
	}
} 

function gerar(botao) {
	var formulario = botao.form;
	formulario.target = "_blank";
	
}


function apenasNumerosSemPonto(e){        
	
	if (window.event){
    	var tecla = e.keyCode;
    	if((tecla == 8)||(tecla == 127)||(tecla>=48&&tecla<=57)){
    		return true;
    	}else{
    		return false;
    	}
        
    } // Internet Explorer
    else if (e.which){
    	var tecla = e.which;
    	if((tecla == 8)||(tecla == 127)||(tecla>=48&&tecla<=57)){
    		return true;
    	}else{
    		return false;
    	}
    } 
  
        
}


//JavaScript Document
//adiciona mascara de cnpj
function mascaraCNPJ(cnpj){
      if(mascaraInteiro(cnpj)==false){
              event.returnValue = false;
      }       
      return formataCampo(cnpj, '00.000.000/0000-00', event);
}

//adiciona mascara de cep
function mascaraCep(cep){
              if(mascaraInteiro(cep)==false){
              event.returnValue = false;
      }       
      return formataCampo(cep, '00.000-000', event);
}

//adiciona mascara de data
function mascaraData(data){
      if(mascaraInteiro(data)==false){
              event.returnValue = false;
      }       
      return formataCampo(data, '00/00/0000', event);
}



//adiciona mascara ao CPF
function mascaraCPF(cpf){
      if(mascaraInteiro(cpf)==false){
              event.returnValue = false;
      }       
      return formataCampo(cpf, '000.000.000-00', event);
}



//valida CEP
function validaCep(cep){
      exp = /\d{2}\.\d{3}\-\d{3}/
      if(!exp.test(cep.value))
              alert('Numero de Cep Invalido!');               
}

//valida data
function validaData(data){
      exp = /\d{2}\/\d{2}\/\d{4}/
      if(!exp.test(data.value))
              alert('Data Invalida!');                        
}



//valida numero inteiro com mascara
function mascaraInteiro(){
      if (event.keyCode < 48 || event.keyCode > 57){
              event.returnValue = false;
              return false;
      }
      return true;
}


//formata de forma generica os campos
function formataCampo(campo, Mascara, evento) { 
      var boleanoMascara; 

      var Digitato = evento.keyCode;
      exp = /\-|\.|\/|\(|\)| /g
      campoSoNumeros = campo.value.toString().replace( exp, "" ); 

      var posicaoCampo = 0;    
      var NovoValorCampo="";
      var TamanhoMascara = campoSoNumeros.length;; 

      if (Digitato != 8) { // backspace 
              for(i=0; i<= TamanhoMascara; i++) { 
                      boleanoMascara  = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
                                                              || (Mascara.charAt(i) == "/")) 
                      boleanoMascara  = boleanoMascara || ((Mascara.charAt(i) == "(") 
                                                              || (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " ")) 
                      if (boleanoMascara) { 
                              NovoValorCampo += Mascara.charAt(i); 
                                TamanhoMascara++;
                      }else { 
                              NovoValorCampo += campoSoNumeros.charAt(posicaoCampo); 
                              posicaoCampo++; 
                        }              
                }      
              campo.value = NovoValorCampo;
                return true; 
      }else { 
              return true; 
      }
}


function validarEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    if(!re.test(email.value)){
    	alert("E-mail invalido!");
    }
}