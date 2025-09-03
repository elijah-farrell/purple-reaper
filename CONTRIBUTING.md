# Contributing to Purple Reaper

Thank you for your interest in contributing to Purple Reaper! This document provides guidelines for contributing to this Minecraft mod.

## Getting Started

### Prerequisites
- Java 17 or higher
- Git
- A code editor (IntelliJ IDEA, VS Code, etc.)

### Setup
1. Fork the repository
2. Clone your fork: `git clone https://github.com/YOUR_USERNAME/purple-reaper.git`
3. Navigate to the project: `cd purple-reaper`
4. Build the project: `./gradlew build`

## Development Guidelines

### Code Style
- Follow Java naming conventions
- Use meaningful variable and method names
- Add comments for complex logic
- Keep methods focused and concise

### Minecraft Modding Best Practices
- Use Fabric API when possible
- Follow Minecraft's naming conventions
- Test your changes thoroughly
- Consider performance implications

### Configuration System
- All configurable values should be in `ConfigManager`
- Use appropriate data types
- Provide sensible defaults
- Document new configuration options

## Making Changes

### Branch Naming
Use descriptive branch names:
- `feature/new-sword-type`
- `fix/config-loading-issue`
- `docs/update-readme`

### Commit Messages
Write clear, descriptive commit messages:
- Use present tense ("Add feature" not "Added feature")
- Be specific about what changed
- Reference issues when applicable

### Pull Request Process
1. Create a feature branch from `main`
2. Make your changes
3. Test thoroughly
4. Update documentation if needed
5. Submit a pull request with a clear description

## Testing

### Local Testing
- Run `./gradlew runClient` to test in development
- Test all sword abilities and effects
- Verify configuration changes work
- Check for any console errors

### Compatibility Testing
- Test with other popular mods
- Verify Fabric API compatibility
- Test on different Minecraft versions (if applicable)

## Documentation

### Code Documentation
- Document public methods and classes
- Explain complex algorithms
- Update README.md for new features

### User Documentation
- Update configuration examples
- Add installation instructions for new features
- Document any breaking changes

## Issues and Bug Reports

### Reporting Bugs
When reporting bugs, please include:
- Minecraft version
- Fabric Loader version
- Mod version
- Steps to reproduce
- Expected vs actual behavior
- Log files (if applicable)

### Feature Requests
For feature requests, please:
- Describe the feature clearly
- Explain the use case
- Consider implementation complexity
- Check if it aligns with the mod's goals

## Questions?

If you have questions about contributing, feel free to:
- Open a GitHub issue
- Start a GitHub discussion
- Check existing documentation

Thank you for contributing to Purple Reaper!
