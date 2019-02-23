# Invincible Spawners

## What is it?
Invincible Spawners is a simple Spigot/Craftbukkit mod which prevents the destruction of monster spawner blocks. It currently catches and prevents them being broken "normally" (e.g. by pickaxe or hand) and being broken via explosions. It will not prevent other mods from removing the block (unless they call a `BlockBreakEvent` or an `EntityExplodeEvent` to do it).

## How to install/use the mod
See the [wiki](https://github.com/AnomalyTea/Invincible-Spawners/wiki) page for instructions on how to install, configure, and use the mod.

## Bug Reports & Feature Suggestions
For bug reports, feature suggestions, etc, please [open an issue](https://github.com/AnomalyTea/Invincible-Spawners/issues) on GitHub.

## How to get started with the code
There are no out-of-the-ordinary dependencies. Simply open up your editor of choice (Eclipse, IntelliJ, etc.) and add the Spigot API as an external library, as you would for any other Spigot mod.

### Contributing
Pull requests may be submitted to `master`. Please ensure that your pull request would not leave `master` in an un-deployable state.
