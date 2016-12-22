# fastdfs-client 客户端的使用方法

# 1 克隆fastdfs-client-java到本地，maven打包

    https://github.com/happyfish100/fastdfs-client-java.git


# 2 mvn安装fastdfs_client.jar，在cmd中执行命令

    mvn install:install-file -DgroupId=org.csource -DartifactId=fastdfs-client-java -Dversion=1.25 -Dpackaging=jar -Dfile=E:\GitHub\fastdfs-client-java\target\fastdfs-client-java.jar

# 3 maven项目，在pom.xml中加入依赖如下
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.csource</groupId>
      <artifactId>fastdfs-client-java</artifactId>
      <version>1.25</version>
    </dependency>
     
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.4</version>
    </dependency>
    
# 4 在src/main/resources中新建fdfs_client.conf文件，内容如下
    connect_timeout = 2
    network_timeout = 30
    charset = UTF-8
    http.tracker_http_port = 80
    http.anti_steal_token = no
    http.secret_key = FastDFS1234567890
    tracker_server = 192.168.17.112:22122
    #tracker_server = 192.168.0.119:22122
    
参考来源于网络 
