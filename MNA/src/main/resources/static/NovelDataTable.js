
$(document).ready( function () {
    var table = $('#NovelTable').DataTable({
        "sAjaxSource": "/MNA/novel/list",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "novel_name" },
            { "mData": "author" },
            { "mData": "year" },
            {
                "mRender": function (data, type, row) {
                    return '<button type="button" data-id="'+ row.id +' " class="btn btn-info btn-lg novel-edit-btn">Edit</button>'
                }

            },
            {
                "mRender": function (data, type, row) {
                    return '<button type="button"  data-id="'+ row.id +' " class="btn btn-info btn-lg novel-delete-btn">Delete</button>'
                }

            }

        ]

    })
    $('body').on('click', '.novel-save-btn', function() {
        // Get the id of the row from the data-id attribute of the button
        $("#myModal").modal("show");
        $("#NovelFormData").submit(function (event) {

            event.preventDefault();

            var NovelFormData = {}
            NovelFormData["novel_name"] = $("#novel_name").val();
            NovelFormData["author"] = $("#author").val();
            NovelFormData["year"] = $("#year").val();

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/MNA/novel/save",
                data: JSON.stringify(NovelFormData),
                dataType: 'json',
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#myModal").modal("hide");
                    window.location.reload();
                },
                error: function (e) {

                    var json = "Ajax Hata"
                        + e.responseText;
                    $('#feedback').html(json);


                }
            });

        });
    });
    $('body').on('click', '.novel-delete-btn', function() {
        // Get the id of the row from the data-id attribute of the button
        var id = $(this).attr('data-id');
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            url: "/MNA/novel/delete/"+id,
            success: function (data) {
                window.location.reload();

            }
        });
    });

    $('body').on('click', '.novel-edit-btn', function() {
        // Get the id of the row from the data-id attribute of the button
        var id = $(this).attr('data-id');
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/MNA/novel/"+id,
            success: function (data) {
                $("#novel_id").val(id);
                $("#novel_name").val(data.novel_name);
                $("#author").val(data.author);
                $("#year").val(data.year);
                $("#myModal").modal("show");
            }
        });

    });
    $("#NovelFormData").submit(function (event) {

        event.preventDefault();

        var NovelFormData = {}
        NovelFormData["novel_name"] = $("#novel_name").val();
        NovelFormData["author"] = $("#author").val();
        NovelFormData["year"] = $("#year").val();

        $.ajax({
            type: "PUT",
            contentType: "application/json",
            url: "/MNA/novel/update/"+$("#novel_id").val(),
            data: JSON.stringify(NovelFormData),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $("#myModal").modal("hide");
                window.location.reload();
            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });

    });
});



