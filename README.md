# 环境信息
    - idea 2021.2 社区版
    - mac m1 2020
    - jdk liberica-1.8
# idea leetcode插件安装
![](images/img_1.png)
# github同步
  1. 仓库同步

![](images/img.png)

  2. 替换远端源地址 
 发现https方式经常无法连接远端库，所以用ssh方式提交代码
（需要本地生成ssh公钥，保存github个人账户中）
 ```
 git remote remove orgin
 git remote add origin git@github.com:licongyang/leetcode-question.git
 ```
  
  3. 新增
```
git add .
git commit -m "commit message"
```

  4. 提交远端
 ```
 git push -u origin master
 ```