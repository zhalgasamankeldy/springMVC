/**
 * 
 */

function show_alert() {
  if(confirm("Do you really want to do this?"))
	  $("form:first").submit();
  else
    return false;
};

$(function(){
	 $('.number_dots').on('input', function(){
         this.value = this.value.replace(/^\.|[^\d\.]|\.(?=.*\.)|^0+(?=\d)/g, '');
     });
});
