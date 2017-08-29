$(function () {
    $.ajax({
        type: "post",
        dataType: "json",
        url: 'index.json',
        success: function (data) {
            var htmlStr="<div class='left'>"+data.name+"</div>"
            htmlStr+="<div class='right'>"+data.age+"</div>"
            $(".user").html(htmlStr);
            $(".userInfo").html(data.name+"年龄："+data.age);
        },
        error: function () {
            alert("请求失败");
        }
    });
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        /*feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },*/
        fields: {
            username: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]{8,16}$/,
                        message: '用户名长度为6到10位（大小写字母、数字和下划线）'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    regexp: {
                        regexp: /^[0-9]{6}$/,
                        message: '密码只能是6位数字'
                    }
                }
            }
        }
    });
});