#!/usr/bin/env bash
a="abc"
b="efg"

if [ $a = $b ]
then
   echo "$a = $b : a ���� b"
else
   echo "$a = $b: a ������ b"
fi
if [ $a != $b ]
then
   echo "$a != $b : a ������ b"
else
   echo "$a != $b: a ���� b"
fi
if [ -z $a ]
then
   echo "-z $a : �ַ�������Ϊ 0"
else
   echo "-z $a : �ַ������Ȳ�Ϊ 0"
fi
if [ -n "$a" ]
then
   echo "-n $a : �ַ������Ȳ�Ϊ 0"
else
   echo "-n $a : �ַ�������Ϊ 0"
fi
if [ $a ]
then
   echo "$a : �ַ�����Ϊ��"
else
   echo "$a : �ַ���Ϊ��"
fi