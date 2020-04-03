# codegene
基于spring shell 和 velocity模板引擎的代码生成器

###生成逻辑
#####1.加载classpath下的project.yml
#####2.加载文件夹下的project.yml
#####3.加载classpath下的proj-task.yml
#####4.加载文件夹下的proj-task.yml
#####5.task.yml res 覆盖到 res
#####6.task data下的 res 覆盖到 res
#####7.执行task

1.内置工具内<br/>
du 日期处理工具<br/>
su 字符串处理工具<br/>

2.内置属性定义<br/>
projDir     项目文件夹<br/>
packageName 包名称<br/>
className   类名称<br/>

3.内置命令<br/>
    ab -m 模块 -md 模块描述 --生成atlas项目代码<br/>
    g -t 任务 -d key=value --使用任务模板生成<br/>
