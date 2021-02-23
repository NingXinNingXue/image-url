function upload() {
    let fileInput = document.getElementById('image-file');
    let file = fileInput.files[0];
    // let name = "pic";     //后台接收时需要的参数名称，自定义即可
    let id = "image-file";         //即input的id，用来寻找值
    let formData = new FormData();
    let imageName = file.name;
    formData.append("imageFile", $("#" + id)[0].files[0]);    //生成一对表单属性
    formData.append("imageName", imageName);    //生成一对表单属性
    $.ajax({
        type: "POST",           //因为是传输文件，所以必须是post
        url: '/api/upload',         //对应的后台处理类的地址
        data: formData,
        processData: false,
        contentType: false,
        dataType: "json",
        success: function (data) {
            let link = document.getElementById("link");
            $("#link").val(data.data);
            layer.msg("图片上传成功");
            // console.log(data.data)
        },
        error: function (data) {
            layer.msg("图片上传失败");
        }
    });
}

function imagePreview() {
    let fileInput = document.getElementById('image-file');
    let image = document.getElementById('image-preview');
    fileInput.addEventListener('change', function () {
        // console.log('change...');
        // if (!fileInput.value) {
        //     info.innerHTML = '没有选择文件';
        //     return;
        // }
        let file = fileInput.files[0];
        // info.innerHTML = '文件:' + file.name + '<br>' + '大小:' + file.size + '<br>' + '修改:' + file.lastModifiedDate;
        let reader = new FileReader();
        reader.onload = function (res) {
            let data = res.target.result;
            image.src = res.target.result;
        };
        reader.readAsDataURL(file);
    });

}

function copyLink() {
    let link = document.getElementById("link");
    link.select(); // 选中文本
    document.execCommand("copy"); // 执行浏览器复制命令
}