#!/usr/bin/env bash

int=1
while(( $int<=5 ))
do
    echo $int
    let "int++"
done

echo '按下 <CTRL-D> 退出'
echo -n '输入你最喜欢的网站名: '
while read FILM
do
    echo "是的！$FILM 是一个好网站"
done