#!/bin/bash

echo "Useage: ./_.sh <destination>"

dest=$1

declare -a arr=("dist.bat" "README.md" "gradle" "src" "build.gradle" ".gitignore" 
"gradle.properties" "gradlew" "gradlew.bat" "refresh.bat")

## now loop through the above array
for file in "${arr[@]}"
do
	echo "$file"
	cp -r "${file}" "../${dest}/${file}"
done


echo "copying to folder ../${dest}"

# create the files





echo "files written"
