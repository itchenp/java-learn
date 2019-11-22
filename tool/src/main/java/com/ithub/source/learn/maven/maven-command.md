- maven 安装
    - 下载[maven](https://maven.apache.org/download.cgi)包
    - 解压后，配置系统path路径 MAVEN_HOME
    - cmd 查询 maven 是否安装成功: mvn -version
    - 配置repository地址: ..\apache-maven-3.0.4\conf 下settings.xml 配置<localRepository/> 节点
    - 电脑地址: 系统盘:\Users\当前用户民\.m2 下settings.xml 配置<localRepository/> 节点 [^_^]: # (注意，这个配置了，可以不配置maven包下的settings.xml)
- 编译跳过test测试类
mvn clean -Dmaven.test.skip=true
- 指定编译环境
mvn clean -P local [^_^]: # (注意. springboot 项目不需要这里指定)