#!/usr/bin/env bash
funWithParam(){
    echo "��һ������Ϊ $1 !"
    echo "�ڶ�������Ϊ $2 !"
    echo "��ʮ������Ϊ $10 !"
    echo "��ʮ������Ϊ ${10} !"
    echo "��ʮһ������Ϊ ${11} !"
    echo "���������� $# ��!"
    echo "��Ϊһ���ַ���������в��� $* !"
}
funWithParam 1 2 3 4 5 6 7 8 9 34 73