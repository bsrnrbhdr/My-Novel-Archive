$(document).ready(function () {

    $("#UserFormData").submit(function (event) {

        event.preventDefault();

        var UserFormData = {}
        UserFormData["username"] = $("#username").val();
        UserFormData["email"] = $("#email").val();
        UserFormData["password"] = $("#password").val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/MNA/user/save",
            data: JSON.stringify(UserFormData),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "Registration successful!"
                    + JSON.stringify(data.username, data.email, null, 4);
                $('#feedback').html(json);
                window.location = "/user_page"
            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });

    });

});