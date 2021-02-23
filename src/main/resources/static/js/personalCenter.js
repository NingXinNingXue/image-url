function hideBody(noHideNameByID) {
    document.getElementById("up-image-div").style.display = 'none';
    document.getElementById("image-manage-div").style.display = 'none';
    // document.getElementById("statistics-div").style.display = 'none';
    document.getElementById(noHideNameByID).style.display = 'block';
}

function getUserImage() {
    let formData = new FormData();
    formData.append("userName", "tourist");
    $.ajax({
        type: "POST",           //因为是传输文件，所以必须是post
        url: '/api/userImage',         //对应的后台处理类的地址
        data: formData,
        dataType: "json",
        processData: false,
        contentType: false,
        success: function (data) {
            console.log(data);
            let imageManage = "";
            // $(".LAY_demo3").removeClass(image-div);
            $("#LAY_demo3").empty();
            for (let i = 0; i < data.length; i++) {
                let imageName = data[i].imageName;
                let imageId = "image-url" + i;
                let imageURL = data[i].imageURL;
                let image = "                    <div class=\"image-div\">\n" +
                    "                        <img class=\"image-preview\" style=\"display: block\"\n" +
                    "                             src=\"" + data[i].imageURL + "\">\n" +
                    "                        <div class=\"information\">\n" +
                    "                            <div class=\"image-name-div\"><p class=\"image-name\">" + imageName + "</p></div>\n" +
                    "                            <div class=\"image-url-div\"><p class=\"hint-link\">链接:<input id=\"" + imageId + "\"\n" +
                    "                                                                             value=\"" + imageURL + "\" class=\"link\"></input></p>\n" +
                    "                                <button class=\"copy-link\" onclick=\"copyImageURL(\'" + imageId + "\');\">复制</button>\n" +
                    "                            </div>\n" +
                    "                            <button class=\"copy-link\" onclick=\"\">更换图片</button>\n" +
                    "                            <div style=\"text-align: right\">\n" +
                    "                                <button class=\"delete\" onclick=\"\">删除</button>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>";
                $("#LAY_demo3").append(image);
            }
            layui.use('flow', function () {
                let flow = layui.flow;
                //按屏加载图片
                flow.lazyimg({
                    elem: '#LAY_demo3 img'
                    , scrollElem: '#LAY_demo3' //一般不用设置，此处只是演示需要。
                });

            });
        },
        error: function (data) {
            console.log(data)
        }
    });
}

function copyImageURL(imageId) {
    console.log(imageId);
    let link = document.getElementById(imageId);
    link.select(); // 选中文本
    document.execCommand("copy"); // 执行浏览器复制命令
}