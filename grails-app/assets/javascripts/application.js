// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require_self

$(document).ready(function() {
    $(".loginform").submit(function(e) {
        $.ajax({
            type: "POST",
            url: "/login/authenticate",
            data: $(".loginform").serialize(), // serializes the form's elements.
            success: function(data)
            {
                if(data.error != null){
                    $(".loginError").removeClass('hide');
                    $(".loginError").html(data.error);
                }else{
                    window.location.reload(true);
                }
            }
        });

        e.preventDefault(); // avoid to execute the actual submit of the form.
    });

    $(".limpiarError").keydown(function() {
        $(".loginError").addClass('hide');
    });

});

function BloquearPantalla(mensaje) {
    $.blockUI({
        blockMsgClass: 'blocuiBox',
        message: '<h5>' + mensaje + '</h5>'
    });
}

function MostrarAlertaError(mensaje){
    // set the message to display: none to fade it in later.
    var message = $('<div class="alert alert-danger error-message" style="display: none;">');
    // a close button
    var close = $('<button type="button" class="close" data-dismiss="alert">&times</button>');
    message.append(close); // adding the close button to the message
    message.append('<strong>Error: </strong>' + mensaje); // adding the error response to the message
    // add the message element to the body, fadein, wait 3secs, fadeout
    message.appendTo($('body')).fadeIn(300).delay(3000).fadeOut(1000);
}