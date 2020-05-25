// $(document).ready(function () {
//
//     $("#NovelFormData").submit(function (event) {
//
//         event.preventDefault();
//
//         var NovelFormData = {}
//         NovelFormData["novel_name"] = $("#novel_name").val();
//         NovelFormData["author"] = $("#author").val();
//         NovelFormData["year"] = $("#year").val();
//
//         $.ajax({
//             type: "POST",
//             contentType: "application/json",
//             url: "/MNA/novel/save",
//             data: JSON.stringify(NovelFormData),
//             dataType: 'json',
//             cache: false,
//             timeout: 600000,
//             success: function (data) {
//
//                 var json = "Successful!"
//                     + JSON.stringify(data, null, 4);
//                 $('#feedback').html(json);
//
//             },
//             error: function (e) {
//
//                 var json = "Ajax Hata"
//                     + e.responseText;
//                 $('#feedback').html(json);
//
//
//             }
//         });
//
//     });
//
// });