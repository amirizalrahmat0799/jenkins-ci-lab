# Changelog

All notable changes to this project. The format follows [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and versions follow [Semantic Versioning](https://semver.org/).

## [Unreleased]

### Added
- Dependabot: weekly, grouped minor and patch updates for the Jenkins base image, so CI checks them together. Major upgrades are left
  for deliberate, hand-made changes.

## [1.0.0] - 2026-10-02

### Added
- Jenkins defined as code: JCasC for security, the admin user and settings, and Job DSL for multibranch pipelines.
- Docker Compose setup with a PostgreSQL for integration tests on a shared `ci-lab` network.
- Jenkinsfile templates for Maven, Node, Maven with PostgreSQL, and Docker build-and-deploy.

[Unreleased]: https://github.com/amirizalrahmat0799/jenkins-ci-lab/compare/v1.0.0...HEAD
[1.0.0]: https://github.com/amirizalrahmat0799/jenkins-ci-lab/releases/tag/v1.0.0
