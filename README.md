这是学了一点springboot搞出来的一个图床网站（未完成），图片的存储位置目前只能是本机目录。
注意！注意！注意！
该图床网站只开发了一点，千万别搭建到线上。
目前只完成了一些功能----登录注册,上传图片,图片管理.
效果图：
[![yLa8Vs.md.png](https://s3.ax1x.com/2021/02/23/yLa8Vs.md.png)](https://imgchr.com/i/yLa8Vs)
[![yLaJ5q.md.png](https://s3.ax1x.com/2021/02/23/yLaJ5q.md.png)](https://imgchr.com/i/yLaJ5q)
[![yLaGan.md.png](https://s3.ax1x.com/2021/02/23/yLaGan.md.png)](https://imgchr.com/i/yLaGan)
部署使用说明
需要软件： (1)Oracle JDK版本1.8.0_271  (2) MySQL Server 8.0.22
部署步骤：
提示：该项目必须在有网络情况下部署
1. MySQL里面新建一个数据库，数据库名字image-url，字符集utf8，排序顺序utf8_general_ci，把项目里面sql文件夹里面的
image-url.sql文件导入新建的这个数据库。
2. 用IntelliJ IDEA打开该项目，请等待一段时间让maven把包下载到本地。
包加载完成后，在项目里面找到src=>main=>resources=>application.properties,
修改application.properties里面的内容：
spring.datasource.username填写数据库的账号；
spring.datasource.password填写数据库的密码；
修改spring.datasource.url的ip和端口；
user.ip填写服务器的ip；
user.file.path填写图片存储的路径，路径最后一定要带/；例如是Windows部署,想在F:\image处存储,就应该填F:/image/  例如是Linux部署,想在/image处存储,就应该填/image/
serverport设置端口;
设置完成后，在terminal运行mvn clean package命令打包成jar，
打包完成后去资源管理器去该项目文件夹下寻找target文件夹，这里面会有打包好的jar，名字是url-0.0.1-SNAPSHOT.jar。
3. 把打包好的url-0.0.1-SNAPSHOT.jar文件移动到你想要的位置，不要留在项目文件夹里面，然后去shell运行
java  –jar  url-0.0.1-SNAPSHOT.jar文件所在的路径
之后通过ip加端口就可以访问网站了。