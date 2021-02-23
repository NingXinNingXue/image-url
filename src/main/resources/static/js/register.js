function upRegisterInfo() {
    let userName = document.getElementById("username");
    let password = document.getElementById("password");
    let confirmPassword = document.getElementById("confirm-password");
    if (password.value == confirmPassword.value) {
        let formData = new FormData();
        formData.append("userName", userName.value);
        formData.append("password", password.value);
        formData.append("confirmPassword", confirmPassword.value);
        $.ajax({
            type: "POST",           //因为是传输文件，所以必须是post
            url: '/api/register',         //对应的后台处理类的地址
            data: formData,
            dataType: "json",
            processData: false,
            contentType: false,
            success: function (data) {
                console.log(data);
                if (data.code == "1000") {
                    layer.msg(data.msg);
                    window.location.href = "/login.html"
                } else if (data.code == "1001") {
                    layer.msg(data.msg);
                } else if (data.code == "1002") {
                    layer.msg(data.msg);
                } else if (data.code == "1003") {
                    layer.msg(data.msg);
                } else if (data.code == "1004") {
                    layer.msg(data.msg);
                }
            },
        });
    } else if (password.value != confirmPassword.value) {
        layer.msg("密码不一致");
    }
}