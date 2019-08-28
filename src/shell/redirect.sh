#!/usr/bin/env bash


#echo "菜鸟教程：www.runoob.com" >> users
#
#
#echo "菜鸟教程：www.runoob.com" > users
#cat users

echo "菜鸟教程：www.runoob.com11" >> users 2>&1
users > users1 2>&1
echo "菜鸟教程：www.runoob.com11" > /dev/user2


