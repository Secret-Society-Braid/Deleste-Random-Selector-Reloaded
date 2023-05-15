# Deleste Random Selector -Reloaded-

English Version available [here](../README.md).

## 目次

- [イントロダクション](#イントロダクション)
- [使い方](#使い方)
- [ダウンロード方法](#ダウンロード方法)
- [Build方法](#Build方法)
- [リポジトリへの貢献について](#リポジトリへの貢献について)
- [ライセンスについて](#ライセンスについて)
- [謝辞](#謝辞)
- [連絡先](#連絡先)
- [バージョン更新情報](#バージョン更新情報)
- [免責事項](#免責事項)
- [リンク](#リンク)

## イントロダクション

もうどの曲をプレイするかどうか悩むことからおさらばしましょう！
このアプリはランダムに曲を選択することができます！

ほんの数クリックでランダムに曲を選択し、詳細な曲情報を取得し、プレイした曲を共有することができます！

## 使い方

**免責事項**: このプロジェクトはまだ開発中です。以下の使い方は事前の告知なしに今後変更される可能性があります。
また、より詳しい使い方は今後このリポジトリのwikiに記載されます。

## ダウンロード方法

**免責事項**: このプロジェクトはまだ開発中です。以下の方法は事前の告知なしに今後変更される可能性があります。
また、より詳しい方法は今後このリポジトリのwikiに記載されます。

1. [リリースページ](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/releases) より最新のリリースをダウンロードします。
2. ダウンロードしたファイルを解凍します。
3. 解答したファイルにある実行ファイルを実行すればOK！

## Build方法

このプロジェクトではgradleエコシステムを使用してビルドします。このリポジトリをクローンした後、以下の手順に従ってください。

```bash
  $ cd [path/to/your/repository]
  $ ./gradlew build
```

リリースページへアップロードしている実行ファイルと同じものをビルドするには、`jpackageImage` タスクを使用してください。

```bash
  $ ./gradlew jpackageImage
```

**免責事項**: もしビルドに問題があった場合は、まずgradleの公式ドキュメントを確認してください。gradleエコシステムに関するサポートは提供できません。
また、このリポジトリで作業するには [CONTRIBUTING.md](doc/CONTRIBUTING.md) を読むことをお勧めします。

## リポジトリへの貢献について

もしコントリビューションに関する詳しい情報を探している場合は、[CONTRIBUTING.md](doc/CONTRIBUTING.md) を読んでください。
以下に簡単な情報を記載します。

### コードへの貢献

もし何か問題があった場合や新しい機能を追加したい場合は、このリポジトリに [新しいissueを建てるか、機能要望](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/issues/new/choose) を送信してください。
また、このリポジトリにプルリクエストを送信することもできます。プルリクエストを送信する前に、[CONTRIBUTING.md](doc/CONTRIBUTING.md) を読んでください。

### 翻訳部分への貢献

このプロジェクトでは、翻訳を募集しています。もし翻訳を追加したい場合は、[翻訳リクエスト](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/issues/new/choose) を送信してください。
翻訳リクエストを確認し、翻訳を追加します。

## ライセンスについて

### このアプリについて

このアプリはApache License, Version 2.0のもとで公開されています。詳しいライセンスについては [LICENSE](LICENSE) を参照してください。

### このアプリで使用しているOSSライブラリについて

このアプリで使用しているすべてのOSSライブラリは、それぞれのライセンスのもとで公開されています。詳しいライセンスについては、各ライブラリのリポジトリを参照してください。

### `Fujiwarahaji.me API` と `HajimeAPI4J` について

<img src="https://api.fujiwarahaji.me/logo" width="40" alt="ふじわらはじめAPI ロゴマーク">

This app uses the [`Fujiwarahaji.me API`](https://fujiwarahaji.me/api/doc/) to get the Song properties. The `Fujiwarahaji.me API` is licensed under CC BY-NC-SA 4.0.
Details of the license can be found [here](https://fujiwarahaji.me/api/doc/)

このアプリは [`ふじわらはじめAPI`](https://fujiwarahaji.me/api/doc/) を使用して曲の情報を取得しています。`ふじわらはじめAPI` は CC BY-NC-SA 4.0のもとで公開されています。

また、このアプリは [`HajimeAPI4J`](https://github.com/Secret-Society-Braid/HajimeAPI4J) Javaライブラリを使用して `ふじわらはじめAPI` にアクセスしています。`HajimeAPI4J` は Apache License, Version 2.0のもとで公開されています。

## 謝辞

- このリポジトリにissueやプルリクエストを送信してくれた方々に感謝します。
- このアプリを他の言語に翻訳してくれた方々に感謝します。
- このプロジェクトを支援してくれた方々に感謝します。
- `ふじわらはじめAPI` の開発者に感謝します。
- アイドルマスター プロジェクトに関わったすべてのコントリビューターに感謝します。

## 連絡先

[discussion](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/discussions) にてスレッドを建てるか、[issue](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/issues/new/choose) を建ててください。

## バージョン更新情報

[リリースページ](https://github.com/Secret-Society-Braid/deleste-random-selector-reloaded/releases) を参照してください。

## 免責事項

本アプリおよびリポジトリ所有者は、株式会社バンダイナムコエンターテインメント、アイドルマスタープロジェクト、およびその他の関係者と一切関係がありません。

本アプリは、アイドルマスターの二次創作とみなします。株式会社バンダイナムコエンターテインメントの要請があれば、リポジトリ所有者は、何の告知もなく、本作品の削除、非公開、アーカイブ化（一時的または永久的）、開発中止を行う可能性があります。

`アイドルマスター` `アイマス` および関連するタイトル、ロゴ、画像、キャラクターは、株式会社バンダイナムコエンターテインメントおよびその子会社の商標および著作権です。

`Fujiwarahaji.me`、`ふじわらはじめAPI`および関連するすべての名称とロゴは、[`デレマス・ミリマス・シャニマス楽曲DB`](https://fujiwarahaji.me)の著作物です。

## リンク

- [アイドルマスター プロジェクト](https://idolmaster.jp/)
- [アイドルマスター シンデレラガールズ スターライトステージ](https://cinderella.idolmaster.jp/sl-stage/)
- [アイドルマスター シンデレラガールズ スターライトステージ 公式チュートリアル `Pトレ!`](https://cinderella.idolmaster.jp/sl-stage/beginner.html)
- [デレマス・ミリマス・シャニマス楽曲DB ふじわらはじめ](https://fujiwarahaji.me)
- [ふじわらはじめAPI](https://fujiwarahaji.me/api/doc/)
- [HajimeAPI4J](https://github.com/Secret-Society-Braid/HajimeAPI4J)
- [リポジトリ責任者 Twitter Account](https://twitter.com/hizumiaoba)
- [リポジトリ責任者 Website](https://hizumiaoba.github.io/Personal-pages/)
