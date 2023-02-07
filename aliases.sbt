addCommandAlias("l", "projects")
addCommandAlias("ll", "projects")
addCommandAlias("ls", "projects")
addCommandAlias("cd", "project")
addCommandAlias("root", "cd root")
addCommandAlias("c", "compile")
addCommandAlias("ca", "Test / compile")
addCommandAlias("t", "test")
addCommandAlias("r", "run")
addCommandAlias("rs", "reStart")
addCommandAlias("s", "reStop")
addCommandAlias("star", "thankYouStars")
addCommandAlias(
  "styleCheck",
  "scalafmtSbtCheck; scalafmtCheckAll",
)
addCommandAlias(
  "styleFix",
  "scalafmtSbt; scalafmtAll",
)
addCommandAlias(
  "up2date",
  "reload plugins; dependencyUpdates; reload return; dependencyUpdates",
)

onLoadMessage +=
  s"""|
      |╭─────────────────────────────────╮
      |│     List of defined ${Utils.styled("aliases")}     │
      |├─────────────┬───────────────────┤
      |│ ${Utils.styled("l")} | ${Utils.styled("ll")} | ${Utils.styled("ls")} │ projects          │
      |│ ${Utils.styled("cd")}          │ project           │
      |│ ${Utils.styled("root")}        │ cd root           │
      |│ ${Utils.styled("c")}           │ compile           │
      |│ ${Utils.styled("ca")}          │ compile all       │
      |│ ${Utils.styled("t")}           │ test              │
      |│ ${Utils.styled("r")}           │ run               │
      |│ ${Utils.styled("rs")}          │ reStart           │
      |│ ${Utils.styled("s")}           │ reStop            │
      |│ ${Utils.styled("star")}        │ thankYouStars     │
      |│ ${Utils.styled("styleCheck")}  │ fmt check         │
      |│ ${Utils.styled("styleFix")}    │ fmt               │
      |│ ${Utils.styled("up2date")}     │ dependencyUpdates │
      |╰─────────────┴───────────────────╯""".stripMargin
