# arctlib
ArctLib, the Kotlin library for SpigotMC.

## Table of Contents
 * [ArctLib](#arctlib)
 * [Modules](#modules)
   * [ArctLib](#module-arctlib)
   * [ArctCore](#module-arctcore)
   * [TestPlugin](#module-testplugin)
 * [Contributing](#contributing)
 * [License](#license)

## Modules
The project is split into three different modules:

### Module: ArctLib
ArctLib is the main module of the project and contains all library features.

### Module: ArctCore
ArctCore is a minimalistic plugin that bundles ArctLib (and its dependencies) to be loaded as a core plugin.
This ensures that plugins that depend on ArctLib can be run without shading the library.

### Module: TestPlugin
TestPlugin is the plugin used to test ArctLib features.
TestPlugin depends on ArctCore.

## Contributing
Contributing details can be found at [CONTRIBUTING.md](https://github.com/arktfox/arctlib/blob/master/CONTRIBUTING.md)

## License
License can be found at [LICENSE](https://github.com/arktfox/arctlib/blob/master/LICENSE)
