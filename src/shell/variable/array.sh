#!/usr/bin/env bash

my_array=(A B "C" D)

echo "��һ��Ԫ��Ϊ: ${my_array[0]}"
echo "�ڶ���Ԫ��Ϊ: ${my_array[1]}"
echo "������Ԫ��Ϊ: ${my_array[2]}"
echo "���ĸ�Ԫ��Ϊ: ${my_array[3]}"

my_array[0]=A
my_array[1]=B
my_array[2]=C
my_array[3]=D

echo "�����Ԫ��Ϊ: ${my_array[*]}"
echo "�����Ԫ��Ϊ: ${my_array[@]}"

my_array[0]=A
my_array[1]=B
my_array[2]=C
my_array[3]=D

echo "����Ԫ�ظ���Ϊ: ${#my_array[*]}"
echo "����Ԫ�ظ���Ϊ: ${#my_array[@]}"

myarray=(Q QW WEQ WQEWQ)
echo ${myarray[3]}

 grep -c -v in arry.sh parm.sh

 grep -c in arry.sh parm.sh