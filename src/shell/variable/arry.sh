#!/usr/bin/env bash
array_name=(value0 value1 value2 value3)

echo ${array_name[1]}

length=${#array_name[@]}

# echo $length "注释1"
,
:<<EOF
echo "注释2"
echo "zhushi"
echo "zhushi"
EOF

:<<!
"注释3"
echo "zhushi"

!
