function login() {
    let userName = document.getElementById("username");
    let password = document.getElementById("password");
    let message = document.getElementById("message");
    let formData = new FormData();
    formData.append("userName", userName.value);
    formData.append("password", password.value);
    $.ajax({
        type: "POST",           //因为是传输文件，所以必须是post
        url: '/api/login',         //对应的后台处理类的地址
        data: formData,
        dataType: "json",
        processData: false,
        contentType: false,
        success: function (data) {
            if (data.code == "1100") {
                layer.msg(data.msg);
                window.location.href = "/personalCenter.html"
            } else if (data.code == "1101") {
                layer.msg(data.msg);
            }
        },
        error: function (data) {
            console.log(data)
        }
    });
}