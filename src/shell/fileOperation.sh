#!/usr/bin/env bash
#����������
#
#-S: �ж�ĳ�ļ��Ƿ� socket��
#-L: ����ļ��Ƿ���ڲ�����һ���������ӡ�
#ʵ��
#���� file ��ʾ�ļ� /var/www/runoob/test.sh�����Ĵ�СΪ 100 �ֽڣ����� rwx Ȩ�ޡ�����Ĵ��룬�������ļ��ĸ������ԣ�
file="D:/test.sh"
if [ -r $file ]
then
   echo "�ļ��ɶ�"
else
   echo "�ļ����ɶ�"
fi
if [ -w $file ]
then
   echo "�ļ���д"
else
   echo "�ļ�����д"
fi
if [ -x $file ]
then
   echo "�ļ���ִ��"
else
   echo "�ļ�����ִ��"
fi
if [ -f $file ]
then
   echo "�ļ�Ϊ��ͨ�ļ�"
else
   echo "�ļ�Ϊ�����ļ�"
fi
if [ -d $file ]
then
   echo "�ļ��Ǹ�Ŀ¼"
else
   echo "�ļ����Ǹ�Ŀ¼"
fi
if [ -s $file ]
then
   echo "�ļ���Ϊ��"
else
   echo "�ļ�Ϊ��"
fi
if [ -e $file ]
then
   echo "�ļ�����"
else
   echo "�ļ�������"
fi

if [ -r $file ]
then
    echo "�ļ��ǿɶ�"
else
    echo "�ļ����ɶ�"
fi

if [ -x $file ]
then
    echo "�ǿ�ִ��"
else
    echo "����ִ��"
fi
