[Lotharschulz.info video list](https://www.lotharschulz.info/videos/) inspired by [Building Web Applications with React and Kotlin/JS](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/01_Introduction).

## Local Development
```shell script
./gradlew browserDevelopmentRun
```

```shell script
./gradlew browserDevelopmentRun --continuous
```

## Test
```shell script
./gradlew browserTest
```

```shell script
./gradlew check
```

## Lint
```shell script
./gradlew clean --continue ktlintCheck
```

## Dependency check
```shell script
./gradlew clean dependencyCheckAnalyze
```
more [dependency check tasks](https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/configuration.html)

## Pack
```shell script
./gradlew browserDevelopmentWebpack
```

```shell script
./gradlew browserProductionWebpack
```
find the files in `output` directory and upload it to your website.
More deployment methods [8 ways to deploy a React app for free](https://blog.logrocket.com/8-ways-to-deploy-a-react-app-for-free/).