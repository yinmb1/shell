#!/usr/bin/env bash
echo '���� 1 �� 4 ֮�������:'
echo '�����������Ϊ:'
read aNum
case $aNum in
    1)  echo '��ѡ���� 1'
    ;;
    2)  echo '��ѡ���� 2'
    ;;
    3)  echo '��ѡ���� 3'
    ;;
    4)  echo '��ѡ���� 4'
    ;;
    *)  echo '��û������ 1 �� 4 ֮�������'
    ;;
esac