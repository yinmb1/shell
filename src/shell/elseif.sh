#!/usr/bin/env bash
echo  "is  it  morning? Please  answer  yes  or  no"

read  timeofday

if [ $timeofday = "yes" ]

then
   echo  "good morning"
   else
   echo "Good afternoon"
fi

exit 0