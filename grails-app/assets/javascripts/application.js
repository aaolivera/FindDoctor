// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require knockout-3.4.0
//= require bootstrap
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
