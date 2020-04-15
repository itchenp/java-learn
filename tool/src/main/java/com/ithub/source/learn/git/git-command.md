#### 拉取远程项目
    git clone git地址(https或者git 开头，两者互相切换)
#### 拉取远程项目到本地切换新分支
    git checkout -b 本地分支 origin/<branchname>
#### 查看git项目地址
    git remote -v
#### 删除本地分支
    git branch -d <branchname>
#### 强制删除本地分支
    git branch -D <branchname>
#### 删除远程分支
    git push origin :dev
    或者： git push origin --delete <branchname>
#### 创建新分支
    git checkout -b <branchname> : # (在当前分支下创建<branchname>的本地分支分支)
    git push origin <branchname> : # (将<branchname>分支推送到远程)
    git branch --set-upstream-to=origin/<branchname> : # (将本地分支<branchname>t关联到远程分支my-test上)
#### 合并分支
    git checkout <feature-branchname>
    git merge <master-branchname>
    或者：git merge <master-branchname> <feature-branchname>
#### 查看分支来源
    git reflog --date=local | grep <branchname>
#### 远程拉取新分支
    git fetch origin 远程分支名称:新分支名称
#### 查看配置
    git com.ithub.source.learn.spring.config --list
#### 查看修改项
    git status
#### 回退
    git reset --hard commit的hash值
    会重置暂存区和工作区，完全重置为指定的commit节点。当前分支没有commit的代码必然会被清除。

    git reset --soft commit的hash值 （推荐使用这个）
    会保留工作目录，并把指定的commit节点与当前分支的差异都存入暂存区。也就是说，没有被commit的代码也能够保留下来。

    git reset commit的hash值
    不带参数，也就是mixed模式。将会保留工作目录，并且把工作区，暂存区以及与reset的差异都放到工作区，然后清空暂存区。因此执行后，只要有所差异，文件都会变成红色，变得难以区分。

#### 错误问题
    $git push origin dev
    fatal: remote error:
    You can't push to git://github.com//name_of_repo.git
    Use https:://github.com//name_of_repo.git

    解决方法: git remote set-url origin <THE-URL-HERE>   