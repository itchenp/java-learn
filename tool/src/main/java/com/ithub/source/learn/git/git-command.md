- 拉取远程项目
git clone git地址(https或者git 开头，两者互相切换)
- 拉取远程项目到本地切换新分支
git checkout -b 本地分支 origin/远程分支
- 查看git项目地址
git remote -v
- 删除本地分支
git branch -d 本地分支
- 删除远程分支
git branch -d 远程分支
- 创建新分支
git checkout -b my-test [^_^]: # (在当前分支下创建my-test的本地分支分支)<br/>
git push origin my-test [^_^]: # (将my-test分支推送到远程)<br/>
git branch --set-upstream-to=origin/my-test [^_^]: # (将本地分支my-test关联到远程分支my-test上)
###### 
