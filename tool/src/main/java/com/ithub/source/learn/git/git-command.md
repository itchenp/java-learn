- 拉取远程项目
git clone git地址(https或者git 开头，两者互相切换)
<<<<<<< HEAD
###### 拉取远程项目到本地切换新分支
git checkout -b 本地分支 origin/<branchname>
###### 查看git项目地址
git remote -v
###### 删除本地分支
git branch -d <branchname>
###### 强制删除本地分支
git branch -D <branchname>
###### 删除远程分支
git push origin :dev
或者： git push origin --delete <branchname>
###### 创建新分支
git checkout -b <branchname> [^_^]: # (在当前分支下创建<branchname>的本地分支分支)
git push origin <branchname> [^_^]: # (将<branchname>分支推送到远程)
git branch --set-upstream-to=origin/<branchname> [^_^]: # (将本地分支<branchname>t关联到远程分支my-test上)
###### 合并分支
git checkout <feature-branchname>
git merge <master-branchname>
或者：git merge <master-branchname> <feature-branchname>
###### 查看分支来源
git reflog --date=local | grep <branchname>
###### 远程拉取新分支
git fetch origin 远程分支名称:新分支名称
###### 查看配置
git com.ithub.source.learn.spring.config --list
###### 查看修改项
git status

