#!/usr/bin/env bash
while :
do
    echo -n "���� 1 �� 5 ֮�������:"
    read aNum
    case $aNum in
        1|2|3|4|5) echo "�����������Ϊ $aNum!"
        ;;
        *) echo "����������ֲ��� 1 �� 5 ֮���! ��Ϸ����"
            break
        ;;
    esac
done

while :
do
    echo -n "���� 1 �� 5 ֮�������: "
    read aNum
    case $aNum in
        1|2|3|4|5) echo "�����������Ϊ $aNum!"
        ;;
        *) echo "����������ֲ��� 1 �� 5 ֮���!"
            continue
            echo "��Ϸ����"
        ;;
    esac
done