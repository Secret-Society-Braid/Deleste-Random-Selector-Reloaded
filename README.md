# Deleste Random Selector -Reloaded-

日本語READMEは [こちら](doc/README_JP.md).

## Table of Content

- [Introduction](#introduction)
- [How to use](#how-to-use)
- [How to install](#how-to-install)
- [How to build](#how-to-build)
- [How to contribute](#how-to-contribute)
- [License](#license)
- [Acknowledgements](#acknowledgements)
- [Contact](#contact)
- [Changelog](#changelog)
- [Disclaimer](#disclaimer)
- [References](#references)

## Introduction

This app allows you to select a random song!

A Few steps are required to select a random song, get detailed song information, and share what you
played!

## How to use

**disclaimer**: This project is still under development. usages below might be changed in the future
without any notice.
And, Complete information about usages will be provided in the wiki section on this repository.

## How to install

**disclaimer**: This project is still under development. usages below might be changed in the future
without any notice.
And, Complete information about usages will be provided in the wiki section on this repository.

1. Download the latest artifacts
   from [release page](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/releases).
2. Extract the downloaded artifacts.
3. There you go! You can use this application.

## How to build

This project uses gradle ecosystem to build. Please following these steps below after cloning this
repository.

```bash
  $ cd [path/to/your/repository]
  $ ./gradlew build
```

To build artifact that is the same as production artifact, Please use the `jpackageImage` task.

```bash
  $ ./gradlew jpackageImage
```

**disclaimer**: If you have a problem with building the image, please check the gradle official
documentation first. We cannot provide any support for gradle ecosystem.
Also, we recommend you to read the [CONTRIBUTING.md](doc/CONTRIBUTING.md) to work with this
repository.

## How to contribute

If you look for the complete information about contributing, please
read [CONTRIBUTING.md](doc/CONTRIBUTING.md).
Below is the brief information.

### coding part

If you have experienced something wrong or wanted new feature, you can file
the [issue or feature request](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/issues/new/choose)
on this repository. If you want to contribute to this project, please fork this repository and
create a pull request. We will review your pull request as soon as possible.

### translation part

If you wish to add translates to this project, please file
the [Translating Request](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/issues/new/choose)
on this repository.
We will check the requests, and we provide the translation

## License

### About this app

This app is licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE) for the full license text.

### About OSS libraries

All OSS libraries used in this app are licensed under their own respective licenses.

### About the `Fujiwarahaji.me API` and `HajimeAPI4J`

<img src="https://api.fujiwarahaji.me/logo" width="40" alt="Fujiwarahaji.me API logo">

This app uses the [`Fujiwarahaji.me API`](https://fujiwarahaji.me/api/doc/) to get the Song properties. The `Fujiwarahaji.me API` is licensed under CC BY-NC-SA 4.0.
Details of the license can be found [here](https://fujiwarahaji.me/api/doc/)

Also, This app uses the [`HajimeAPI4J`](https://github.com/Secret-Society-Braid/HajimeAPI4J) Java library to access the `Fujiwarahaji.me API`. The `HajimeAPI4J` is licensed under the Apache License, Version 2.0.
Details of the license can be found [here](https://github.com/Secret-Society-Braid/HajimeAPI4J/blob/master/LICENSE).

## Acknowledgements

- Big thanks to people who file the issue and pull request to this repository.
- Big thanks to people who translate this app to other languages.
- Big thanks to supporters of this project.
- Big thanks to the `Fujiwarahaji.me API` developer to be able to get song properties easily.
- Big thanks to the all contributors who are something to do with the IDOLM@STER Project.

## Contact

Start a
new [discussion](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/discussions)
thread or file
an [issue](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/issues/new/choose).

## Changelog

See [release page](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/releases).

## Disclaimer

This app and repository owner both have nothing to do with BANDAI NAMCO Entertainment Inc,
IDOLM@STER project, and any other related parties.

This app is considered as a derivative work of the IDOLM@STER project. Repository owner might
delete, be private, be archived (either temporarily or permanently), or stop developing this work
without any notices or announcements if the IDOLM@STER project team or BANDAI NAMCO Entertainment
Inc. requests to do so.

`The iDOLM@STER`, `アイドルマスター`, `アイマス` and all related titles, logos, images and characters are
trademark and copyright of BANDAI NAMCO Entertainment Inc. and/or its subsidiaries.

`Fujiwarahaji.me`, `ふじわらはじめAPI` and all related names and logos are copyright
of [`デレマス・ミリマス・シャニマス楽曲DB ふじわらはじめ (Deremas, MilliMas, ShinyMas Song DB Fujiwara hajime)`](https://fujiwarahaji.me).

## References

- [The iDOLM@STER Project](https://idolmaster.jp/)
- [The iDOLM@STER Cinderella Girls Starlight Stage](https://cinderella.idolmaster.jp/sl-stage/)
- [The iDOLM@STER Cinderella Girls Starlight Stage Official Beginner's Tutorials `P tore!`](https://cinderella.idolmaster.jp/sl-stage/beginner.html)
- [Deremas, MilliMas, ShinyMas Song DB Fujiwara hajime](https://fujiwarahaji.me)
- [Fujiwarahaji.me API](https://fujiwarahaji.me/api/doc/)
- [HajimeAPI4J](https://github.com/Secret-Society-Braid/HajimeAPI4J)
- [Owner's Twitter Account](https://twitter.com/hizumiaoba)
- [Owner's Website](https://hizumiaoba.github.io/Personal-pages/)
