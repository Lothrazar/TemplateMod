#!/bin/bash
set -euo pipefail

if  [ -z "$1" ]
  then
    echo "Missing argument.  Usage: "
	echo "./copyTemplate.sh <ModNameCamelCase>"
	exit 
fi

github=$1
modid="${github,,}"

echo "modid = ${modid};  github = ${github}"
echo "copying files to folder ../${github}"

mkdir "../${github}"
echo "include '${github}'" >> ../settings.gradle

declare -a arr=(
	"src" ".github" "gradle" ".gitignore" "build.gradle"
	"gradle.properties" "mod.properties" "gradlew" "gradlew.bat" "update.json"
)

for file in "${arr[@]}"
do
	echo "$file"
	cp -r "${file}" "../${github}/${file}"
done

echo "copying src"

cp -r "settings.gradle" "../${github}/settings.gradle"

mkdir "../${github}/run/"
cp -r "options.txt" "../${github}/run/options.txt"

mkdir -p "../${github}/src/main/resources/assets/${modid}/blockstates"
mkdir -p "../${github}/src/main/resources/assets/${modid}/lang"
mkdir -p "../${github}/src/main/resources/assets/${modid}/models/block"
mkdir -p "../${github}/src/main/resources/assets/${modid}/models/item"
mkdir -p "../${github}/src/main/resources/assets/${modid}/textures"
mkdir -p "../${github}/src/main/resources/assets/${modid}/textures/block"
mkdir -p "../${github}/src/main/resources/assets/${modid}/textures/item"

mkdir -p "../${github}/src/main/resources/data/${modid}/recipe"
mkdir -p "../${github}/src/main/resources/data/${modid}/loot_table/blocks"


echo "editing templates in the new folder"

cd "../${github}"

touch "src/main/resources/assets/${modid}/lang/en_us.json"
echo "{ }" >> "src/main/resources/assets/${modid}/lang/en_us.json"

mv src/main/java/com/lothrazar/examplemod "src/main/java/com/lothrazar/${modid}"
sed -i "s/examplemod/${modid}/g" "src/main/java/com/lothrazar/${modid}/ModMain.java"
sed -i "s/examplemod/${modid}/g" "src/main/java/com/lothrazar/${modid}/ModRegistry.java"
sed -i "s/examplemod/${modid}/g" "src/main/java/com/lothrazar/${modid}/ConfigManager.java"

sed -i "s/examplemod/${modid}/g" build.gradle
sed -i "s/examplemod/${modid}/g" mod.properties
sed -i "s/examplemod/${modid}/g" settings.gradle
sed -i "s/examplemod/${modid}/g" update.json
sed -i "s/examplemod/${modid}/g" .github/README.md

sed -i "s/ForgeTemplate/${github}/g" .github/README.md


git init -b trunk/1.21.1
echo ""
echo "####"
echo ""

echo "git add -A"
echo "git commit -am 'initial commit'"
echo "git remote add o git@github.com:Lothrazar/${github}.git"
echo "git push o -u trunk/1.21.1"

