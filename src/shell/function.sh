#!/usr/bin/env bash
demoFun(){
    echo "�����ҵĵ�һ�� shell ����!"
}
echo "-----������ʼִ��-----"
demoFun
echo "-----����ִ�����-----"

funWithReturn(){
    echo "����������������������ֽ����������..."
    echo "�����һ������: "
    read aNum
    echo "����ڶ�������: "
    read anotherNum
    echo "�������ֱַ�Ϊ $aNum �� $anotherNum !"
    return $(($aNum+$anotherNum))
}
funWithReturn
echo "�������������֮��Ϊ $? !"