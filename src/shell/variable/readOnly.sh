#!/usr/bin/env bash

# 使用 readonly 命令可以将变量定义为只读变量，只读变量的值不能被改变。

myUrl="http://www.google.com"
# readonly myUrl
# myUrl="http://www.runoob.com"

#删除变量
#使用 unset 命令可以删除变量。语法：
#
# unset variable_name
#变量被删除后不能再次使用。unset 命令不能删除只读变量。
#
#实例

unset myUrl
echo $myUrl

your_name='runoob'
str="Hello, I know you are $your_name ! \n"


your_name="runoob"
# 使用双引号拼接
greeting="hello, "$your_name" !"
greeting_1="hello, ${your_name} !"
echo $greeting  $greeting_1
# 使用单引号拼接
greeting_2='hello, '$your_name' !'
greeting_3='hello, ${your_name} !'
echo $greeting_2  $greeting_3