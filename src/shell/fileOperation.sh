#!/usr/bin/env bash
#其他检查符：
#
#-S: 判断某文件是否 socket。
#-L: 检测文件是否存在并且是一个符号链接。
#实例
#变量 file 表示文件 /var/www/runoob/test.sh，它的大小为 100 字节，具有 rwx 权限。下面的代码，将检测该文件的各种属性：
file="D:/test.sh"
if [ -r $file ]
then
   echo "文件可读"
else
   echo "文件不可读"
fi
if [ -w $file ]
then
   echo "文件可写"
else
   echo "文件不可写"
fi
if [ -x $file ]
then
   echo "文件可执行"
else
   echo "文件不可执行"
fi
if [ -f $file ]
then
   echo "文件为普通文件"
else
   echo "文件为特殊文件"
fi
if [ -d $file ]
then
   echo "文件是个目录"
else
   echo "文件不是个目录"
fi
if [ -s $file ]
then
   echo "文件不为空"
else
   echo "文件为空"
fi
if [ -e $file ]
then
   echo "文件存在"
else
   echo "文件不存在"
fi

if [ -r $file ]
then
    echo "文件是可读"
else
    echo "文件不可读"
fi

if [ -x $file ]
then
    echo "是可执行"
else
    echo "不可执行"
fi
