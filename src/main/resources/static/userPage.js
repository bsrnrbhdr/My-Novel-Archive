$(document).ready( function () {
    var table = $('#NovelListTable').DataTable({
        "sAjaxSource": "/MNA/novel_lists/lists",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id","visible" : false},
            { "mData": "novel_id.novel_name"},
            { "mData": "user_id","visible" : false},
            { "mData": "status" },
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
    $.getJSON("/MNA/novel/list", function(return_data){
        $.each(return_data, function(key,value){
            $("#optionList_novel").append(
                "<option data-id="+ value.id +">"+value.novel_name+"</option>"

            );
        });
    });

    var novel_id = {};
    var status_id = {};
    $("#optionList_novel").change(function() {
         novel_id = $(this).children(":selected").attr("data-id");
    });
    $("#optionList_status").change(function() {
        status_id = $(this).children(":selected").attr("data-id");
    });

    $('body').on('click', '.novel-list-save-btn', function() {
        $("#myModal").modal("show");

        $('body').on('click', '.novel-list-save-form-btn', function() {

            var NovelFormData = {}
            NovelFormData["novel_id"] = novel_id;
            NovelFormData["status"] = status_id

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/MNA/novel_lists/save",
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
            url: "/MNA/novel_lists/delete/"+id,
            success: function (data) {
                window.location.reload();

            }
        });
    });
    $('body').on('click', '.gotonovel-btn', function() {
        window.location.href='/list-novel';
    })
    //
    // $('body').on('click', '.novel-edit-btn', function() {
    //     // Get the id of the row from the data-id attribute of the button
    //     var id = $(this).attr('data-id');
    //     $.ajax({
    //         type: "GET",
    //         contentType: "application/json",
    //         url: "/MNA/novel/"+id,
    //         success: function (data) {
    //             $("#novel_id").val(id);
    //             $("#novel_name").val(data.novel_name);
    //             $("#author").val(data.author);
    //             $("#year").val(data.year);
    //             $("#myModal").modal("show");
    //         }
    //     });
    //
    // });
    // $("#NovelFormData").submit(function (event) {
    //
    //     event.preventDefault();
    //
    //     var NovelFormData = {}
    //     NovelFormData["novel_name"] = $("#novel_name").val();
    //     NovelFormData["author"] = $("#author").val();
    //     NovelFormData["year"] = $("#year").val();
    //
    //     $.ajax({
    //         type: "PUT",
    //         contentType: "application/json",
    //         url: "/MNA/novel/update/"+$("#novel_id").val(),
    //         data: JSON.stringify(NovelFormData),
    //         dataType: 'json',
    //         cache: false,
    //         timeout: 600000,
    //         success: function (data) {
    //             $("#myModal").modal("hide");
    //             window.location.reload();
    //         },
    //         error: function (e) {
    //
    //             var json = "Ajax Hata"
    //                 + e.responseText;
    //             $('#feedback').html(json);
    //
    //
    //         }
    //     });
    //
    // });
});
