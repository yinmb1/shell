#!/usr/bin/env bash
num1=100
num2=100
if test $[num1] -eq $[num2]
then
    echo '��������ȣ�'
else
    echo '����������ȣ�'
fi

num1="ru1noob"
num2="runoob"
if test $num1 = $num2
then
    echo '�����ַ������!'
else
    echo '�����ַ��������!'
fi