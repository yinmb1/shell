#!/usr/bin/env bash

int=1
while(( $int<=5 ))
do
    echo $int
    let "int++"
done

echo '���� <CTRL-D> �˳�'
echo -n '��������ϲ������վ��: '
while read FILM
do
    echo "�ǵģ�$FILM ��һ������վ"
done