#!/bin/bash

# deprecated; use github create repo from template feature
# if using this, move to root folder before using 


if [ -z "$1" ]
  then
    echo "No folder name supplied as first argument"
	echo "Useage: ./_.sh <destination>"
	exit 
fi

dest=$1

echo "creating ../${dest}"

mkdir "../${dest}"

echo "copying to folder ../${dest}"

declare -a arr=(
	"src" ".github" "gradle" ".gitignore" "build.gradle" "build.sh"
	"gradle.properties" "gradlew" "gradlew.bat" "setup.sh" "update.json"
)

# copy each file/folder

for file in "${arr[@]}"
do
	echo "$file"
	cp -r "${file}" "../${dest}/${file}"
done

cp -r "options.txt" "../${dest}/options.txt"

mkdir -p "../${dest}/src/main/resources/assets/${dest}/blockstates"
mkdir -p "../${dest}/src/main/resources/assets/${dest}/lang"
mkdir -p "../${dest}/src/main/resources/assets/${dest}/models/block"
mkdir -p "../${dest}/src/main/resources/assets/${dest}/models/item"
mkdir -p "../${dest}/src/main/resources/assets/${dest}/textures"
mkdir -p "../${dest}/src/main/resources/assets/${dest}/textures/block"
mkdir -p "../${dest}/src/main/resources/assets/${dest}/textures/item"

mkdir -p "../${dest}/src/main/resources/data/${dest}/recipes"
mkdir -p "../${dest}/src/main/resources/data/${dest}/loot_tables/blocks"

touch "../${dest}/src/main/resources/assets/${dest}/lang/en_us.json"

echo "files written"

./setup.sh
