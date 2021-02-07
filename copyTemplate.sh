#!/bin/bash

if  [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ] 
  then
    echo "Missing argument ($1 $2 $3) Useage: "
	echo "./copyTemplate.sh <modid> <github> <curseslug>"
	exit 
fi

modid=$1
github=$2
curseslug=$3

echo "modid = ${modid};  github = ${github}; curse = ${curseslug}"
echo "copying files to folder ../${github}"

declare -a arr=(
	"src" "scripts" ".github" "gradle" ".gitignore" "build.gradle" 
	"gradle.properties" "gradlew" "gradlew.bat" "update.json"
)

sed -i "s/examplemod/${modid}/g" src/main/java/com/lothrazar/examplemod/ExampleMod.java
mkdir "../${github}"

for file in "${arr[@]}"
do
	echo "$file"
	cp -r "${file}" "../${modid}/${file}"
done

mkdir "../${modid}/run/"
cp -r "options.txt" "../${modid}/run/options.txt"

mkdir -p "../${github}/src/main/resources/assets/${modid}/blockstates"
mkdir -p "../${github}/src/main/resources/assets/${modid}/lang"
mkdir -p "../${github}/src/main/resources/assets/${modid}/models/block"
mkdir -p "../${github}/src/main/resources/assets/${modid}/models/item"
mkdir -p "../${github}/src/main/resources/assets/${modid}/textures"
mkdir -p "../${github}/src/main/resources/assets/${modid}/textures/block"
mkdir -p "../${github}/src/main/resources/assets/${modid}/textures/item"

mkdir -p "../${github}/src/main/resources/data/${modid}/recipes"
mkdir -p "../${github}/src/main/resources/data/${modid}/loot_tables/blocks"

touch "../${github}/src/main/resources/assets/${modid}/lang/en_us.json"

echo "editing templates"

cd "../${github}"
sed -i "s/examplemod/${modid}/g" build.gradle
sed -i "s/examplemod/${modid}/g" src/main/resources/pack.mcmeta
sed -i "s/examplemod/${modid}/g" src/main/resources/META-INF/mods.toml

sed -i "s/ForgeTemplate/${github}/g" src/main/resources/META-INF/mods.toml

sed -i "s/_curseslug_/${curseslug}/g" src/main/resources/META-INF/mods.toml
sed -i "s/_curseslug_/${curseslug}/g" update.json
sed -i "s/_curseslug_/${curseslug}/g" gradle.properties

git init
git add -A
git checkout -b trunk/1.16

echo "create a curse project with the url https://www.curseforge.com/minecraft/mc-mods/${curseslug}"
echo "then run the following three commands to finish setup:"

echo "./scripts/setup.sh"
echo "git commit -am 'initial commit'"
echo "git remote add o git@github.com:Lothrazar/${github}.git"
echo "git push o -u trunk/1.16"
