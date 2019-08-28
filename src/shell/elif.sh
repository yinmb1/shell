#!/usr/bin/env bash
echo  "is  it  morning? Please  answer  yes  or  no"

read  timeofday

if [ $timeofday = "yes" ] ; then

      echo  "good morning"
elif [ $timeofday = "no" ]
then
    echo "Good afternoon"
else
    echo "sorry ,$timeofday not recognized. Enter yes or no"

fi


if [ "sds" = "231" ] ; then
    echo "hao hao xue xi"
else
    echo "tian tian xiang shang"
fi

exit 0