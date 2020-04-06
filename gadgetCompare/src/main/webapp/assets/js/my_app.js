


$(function(){
//Solving the Active Menu problem

switch(menu){

   case 'About Us':
         $('#about').addClass('active');
         break;

   case 'Contact':
         $('#contact').addClass('active');
         break;

   case 'Service':
       $('#service').addClass('active');
         break;
default:
      $('#home').addClass('active');
         break; 

  }
});