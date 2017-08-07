$(function () {
    $.ajax({
        type: "post",
        dataType: "json",
        url: 'index.json',
        success: function (data) {
            var htmlStr="<div class='left'>"+data.name+"</div>"
            htmlStr+="<div class='right'>"+data.age+"</div>"
            $(".user").html(htmlStr);
        },
        error: function () {
            alert("请求失败");
        }
    });
});