LynxPlugin/
├── pom.xml                          # Maven 定義（Folia-API・Vault・Adventure・HikariCP・Gson を依存）
├── README.md                        # 導入・ビルド・使用説明
├── LICENSE
├── docs/                            # 設計資料一式
│   ├── architecture.md              # 全体アーキテクチャ
│   ├── ERD.drawio                   # DB エンティティ図
│   └── api-spec.md                  # 将来の REST/WebSocket 仕様
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── marvtech/
│   │   │       └── lynx/
│   │   │           ├── Lynx.java                    # プラグイン main（onEnable / onDisable）
│   │   │           ├── api/                         # 外部公開 API
│   │   │           │   ├── LynxAPI.java
│   │   │           │   └── event/
│   │   │           │       ├── LynxNationCreateEvent.java
│   │   │           │       ├── LynxNationDisbandEvent.java
│   │   │           │       └── LynxWarDeclareEvent.java
│   │   │           ├── commands/                    # スラッシュ／プレフィックスコマンド
│   │   │           │   ├── CountryCommand.java
│   │   │           │   ├── FactionCommand.java
│   │   │           │   ├── BankCommand.java
│   │   │           │   ├── LynxCommand.java         # /lynx accept /deny /reload
│   │   │           │   └── AdminCommand.java
│   │   │           ├── listeners/                   # Bukkit/Folia イベント
│   │   │           │   ├── PlayerJoinListener.java
│   │   │           │   ├── ChunkClaimListener.java
│   │   │           │   └── VaultBalanceListener.java
│   │   │           ├── scheduler/                   # RegionScheduler Tasks
│   │   │           │   ├── UpkeepTask.java
│   │   │           │   ├── MapSyncTask.java
│   │   │           │   └── BackupTask.java
│   │   │           ├── country/
│   │   │           │   ├── model/                   # POJO
│   │   │           │   │   ├── Country.java
│   │   │           │   │   ├── Rank.java
│   │   │           │   │   └── Capital.java
│   │   │           │   ├── repository/              # DAO (JDBC/Hikari)
│   │   │           │   │   └── CountryRepository.java
│   │   │           │   └── service/                 # ビジネスロジック
│   │   │           │       ├── CountryService.java
│   │   │           │       └── RankService.java
│   │   │           ├── faction/
│   │   │           │   ├── model/   ── Faction.java
│   │   │           │   ├── repository/FactionRepository.java
│   │   │           │   └── service/FactionService.java
│   │   │           ├── economy/
│   │   │           │   ├── EconomyService.java      # Vault ラッパ
│   │   │           │   └── Treasury.java
│   │   │           ├── map/
│   │   │           │   ├── SquaremapService.java    # マーカー/ポリゴン出力
│   │   │           │   └── ColorUtil.java           # ランダム HEX 生成
│   │   │           ├── backup/
│   │   │           │   ├── BackupManager.java
│   │   │           │   └── JsonExporter.java
│   │   │           ├── lang/
│   │   │           │   ├── LangManager.java         # locale→言語 YAML 解決
│   │   │           │   └── keys/
│   │   │           │       └── LangKey.java         # enum でメッセージキー管理
│   │   │           └── util/
│   │   │               ├── ConfigUtil.java
│   │   │               ├── ValidationUtil.java
│   │   │               ├── LocationUtil.java
│   │   │               └── AsyncHelper.java
│   │   └── resources/
│   │       ├── plugin.yml               # Folia manifest + commands
│   │       ├── settings.yml             # システム設定
│   │       ├── database.yml             # MariaDB / Hikari 接続
│   │       ├── permissions.yml          # Rank1-10 権限セット
│   │       └── languages/               # 多言語パック
│   │           ├── en.yml
│   │           ├── ja.yml
│   │           ├── ko.yml
│   │           └── zh.yml
│   └── test/
│       └── java/marvtech/lynx/
│           ├── CountryServiceTest.java
│           ├── FactionServiceTest.java
│           └── DatabaseMigrationTest.java
└── docker/                             # CI 用 Folia + MariaDB テスト環境
    ├── Dockerfile-folia
    └── docker-compose.yml
