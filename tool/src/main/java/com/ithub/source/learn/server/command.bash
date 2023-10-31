#!/bin/bash
## 清空nohub文件
   cat /dev/null > nohup.out
   echo '' > nohup.out
   
   ## grep 命令
   grep -n 'xxx' xxxx.log  (-n)显示行号
   
   ## tomcat 修改日志输出路径
   if [ -z "$CATALINA_OUT" ] ; then
      CATALINA_OUT="$CATALINA_BASE"/logs/catalina.out
   fi
   ## 为
   if [ -z "$CATALINA_OUT" ] ; then
     CATALINA_OUT="$CATALINA_BASE"/logs/catalina.%Y-%m-%d.out
   fi


## zip命令
   压缩:zip -r filename.zip filesdir
   解压缩:unzip filename.zip
   
   端口查看:netstat -tunpl | grep 端口号

## 项目kill及启动脚本
   #!/bin/sh
   APP_NAME=test.war
   LOG_NAME=test.log 
   APP_PORT=8080
   ps -ef | grep $APP_NAME | grep -v grep
   if [ $? -ne 0 ]
   then
   nohup java  -jar $APP_NAME --server.port=$APP_PORT >> ./$LOG_NAME 2>&1 &
   echo $APP_NAME "start success"
   else
   ps -ef | grep $APP_NAME | grep -v grep |awk '{print $2}' |xargs kill -9
   echo $APP_NAME "stop success"
   nohup java  -jar $APP_NAME  --server.port=$APP_PORT >> ./$LOG_NAME 2>&1 &
   echo $APP_NAME "start success"
   fi
