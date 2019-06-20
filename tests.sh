#!/bin/bash
./gradlew -Dgeb.env=htmlUnit test --console=plain
./gradlew -Dgeb.env=chrome test --console=plain
./gradlew -Dgeb.env=chromeHeadless test --console=plain
./gradlew -Dgeb.env=firefox test --console=plain
./gradlew -Dgeb.env=firefoxHeadless test --console=plain
./gradlew -Dgeb.env=safari test --console=plain
