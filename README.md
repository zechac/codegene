# codegene
基于groovy模板引擎的代码生成器

###生成逻辑
#####1.加载classpath下的project.yml
#####2.加载文件夹下的project.yml
#####3.加载classpath下的proj-task.yml
#####4.加载文件夹下的proj-task.yml
#####5.task.yml res 覆盖到 res
#####6.task data下的 res 覆盖到 res
#####7.执行task
