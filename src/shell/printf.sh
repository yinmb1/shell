#!/usr/bin/env bash
printf  format-string  [arguments...]
echo -e "\n"
echo "Hello, Shell"

printf "Hello, Shell\n"

printf "%-10s %-8s %-4s\n" ���� �Ա� ����kg
printf "%-10s %-8s %-4.2f\n" ���� �� 66.1234
printf "%-10s %-8s %-4.2f\n" ��� �� 48.6543
printf "%-10s %-8s %-4.2f\n" ��ܽ Ů 47.9876


# format-stringΪ˫����
printf "%d %s\n" 1 "abc"

# ��������˫����Ч��һ��
printf '%d %s\n' 1 "abc"

# û������Ҳ�������
printf %s abcdef

# ��ʽָֻ����һ��������������Ĳ�����Ȼ�ᰴ�ոø�ʽ�����format-string ������
printf %s abc def

printf "%s\n" abc def

printf "%s %s %s\n" a b c d e f g h i j

# ���û�� arguments����ô %s ��NULL���棬%d �� 0 ����
printf "%s and %d \n"

 printf "a string, no processing:<%s>\n" "A\nB"

printf "a string, no processing:<%b>\n" "A\nB"
printf "www.runoob.com \a"
www.runoob.com $                  #������