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

mkdir "../${dest}/src/main/resources/assets/${dest}/blockstates"
mkdir "../${dest}/src/main/resources/assets/${dest}/lang"
mkdir "../${dest}/src/main/resources/assets/${dest}/models/block"
mkdir "../${dest}/src/main/resources/assets/${dest}/models/item"
mkdir "../${dest}/src/main/resources/assets/${dest}/textures"
mkdir "../${dest}/src/main/resources/assets/${dest}/textures/block"
mkdir "../${dest}/src/main/resources/assets/${dest}/textures/item"

mkdir "../${dest}/src/main/resources/data/${dest}/recipes"
mkdir "../${dest}/src/main/resources/data/${dest}/loot_tables/blocks"

touch "../${dest}/src/main/resources/assets/${dest}/lang/en_us.json"

echo "files written"
