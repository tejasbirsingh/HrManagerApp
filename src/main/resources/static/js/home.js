  
// this function will show the selected file name 
function setfilename(val)
  {	
	  var fileName = $('input[type=file]').val().split('\\').pop();
	  $('#divFileName').html(fileName);	// this function sets the text to file name
  }