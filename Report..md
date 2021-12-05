[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=6521930&assignment_repo_type=AssignmentRepo)
# jw08

## 代码

请**综合jw04-jw07所有要求**，完成一个完整的**图形化**网络对战游戏。所有提交的作业将统一展出，由各位同学相互打分。


## 报告

在此基础之上，请以《Developing a Java Game from Scratch》为题撰写文章一篇，内容涵盖但不限于：
- 开发目标（我写的游戏是个什么样的游戏，灵感来源是什么）；
- 设计理念（代码总体设计是什么？这样设计的好处是什么？）；
- 技术问题（通信效率、并发控制、输入输出等问题我是怎么解决和优化的，面向对象设计方法带来了什么好处，等）；
- 工程问题（如何采用各种设计方法、工程方法来提高开发效率和代码质量）；
- 课程感言（对课程形式、内容等方面提出具体的意见和建议）
- 等

请使用《中国科学》的[latex模板](http://scis.scichina.com/download/ssi-template.zip)进行排版（不少于6页），输出pdf文件提交。



灵感来源：小时候玩的游戏

先构思游戏的基本机制和内容，设计基本的游戏框架(玩家、怪物、道具等类)和基本逻辑（胜利条件、战斗中的攻击和生命值机制等），在原始的UI下完成实现最原始的游戏版本

逐步从如下方面进行版本迭代，优化和改进游戏：
可玩性，游戏机制，各种道具，不同地图
保存功能，通过文件IO
BGM和UI

UI优化：如何paint？
Main.repaint()合适调用-》

AsciiPanel的使用：
以下均可以指定字体颜色(forground)和背景颜色(background)，和坐标
write函数

`public AsciiPanel writeCenter(String string, int y, Color foreground, Color background) `：写到屏幕居中位置（指定y）
`public AsciiPanel write(String string, int x, int y, Color foreground, Color background) {`
clear函数
