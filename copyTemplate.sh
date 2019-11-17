#!/bin/bash

echo "Useage: ./_.sh <destination>"

if [ -z "$1" ]
  then
    echo "No folder name supplied as first argument"
	exit 
fi

dest=$1

echo "copying to folder ../${dest}"

declare -a arr=("dist.bat" "gradle" "src" "build.gradle" ".gitignore" ".github" 
"gradle.properties" "gradlew" "gradlew.bat" "refresh.bat" "update.json")

# copy each file/folder

for file in "${arr[@]}"
do
	echo "$file"
	cp -r "${file}" "../${dest}/${file}"
done

cp -r "options.txt" "../${dest}/options.txt"


echo "files written"
