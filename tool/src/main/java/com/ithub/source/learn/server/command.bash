#!/bin/bash
## 清空nohub文件
cat /dev/null > nohup.out
echo '' > nohup.out

## grep 命令
grep -n 'xxx' xxxx.log （-n）显示行号

## tomcat 修改日志输出路径
if [ -z "$CATALINA_OUT" ] ; then
   CATALINA_OUT="$CATALINA_BASE"/logs/catalina.out
fi
## 为
if [ -z "$CATALINA_OUT" ] ; then
  CATALINA_OUT="$CATALINA_BASE"/logs/catalina.%Y-%m-%d.out
fi


## zip命令
压缩：zip -r filename.zip filesdir
解压缩：unzip filename.zip
