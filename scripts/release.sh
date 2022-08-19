#!/bin/bash

./gradlew cleanJar build signJar

./scripts/dist.sh
