# BeatDownStick [![Curseforge](http://cf.way2muchnoise.eu/full_260245_downloads.svg)](https://curseforge.com/minecraft/mc-mods/beat-down-stick) [![Curseforge](http://cf.way2muchnoise.eu/versions/For%20MC_260245_all.svg)](https://curseforge.com/minecraft/mc-mods/beat-down-stick)

## About
This mod just adds a stick to the game, known as the Beat Down Stick, which can be found in various chests within dungeons and the like. Chances of finding the stick are very low. 

The stick itself has a very low durability (21) but the damage dealt to an entity is their max health. This damage does not go through armor. 

There is a creative mode only version that deals the max damage possible (Float.MAX_VALUE), has no durability, goes through armor, and hurts creative mode players.

## Downloads
https://curseforge.com/minecraft/mc-mods/beat-down-stick

## Latest Development Download
https://tamaized.com/artifacts/builds/Tamaized/BeatDownStick/latest/

## Maven
```
repositories {
    maven {
        url = "https://maven.tamaized.com/releases"
    }
}

dependencies {
    runtimeOnly fg.deobf("tamaized:beatdownstick:{version}")
}
```
