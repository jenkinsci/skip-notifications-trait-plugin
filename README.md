# Skip notifications trait plugin

[![Build Status](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/master/)
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/skip-notifications-trait.svg)](https://plugins.jenkins.io/skip-notifications-trait)
[![GitHub release](https://img.shields.io/github/release/jenkinsci/skip-notifications-trait-plugin.svg?label=changelog)](https://github.com/jenkinsci/skip-notifications-trait-plugin/releases/latest)
[![GitHub license](https://img.shields.io/github/license/jenkinsci/skip-notifications-trait-plugin)](https://github.com/jenkinsci/skip-notifications-trait-plugin/blob/master/LICENSE.md)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/skip-notifications-trait.svg?color=blue)](https://plugins.jenkins.io/skip-notifications-trait)

This is an extension plugin which adds custom feature to the Bitbucket and GitHub Branch Source plugins, allowing to disable build status notifications.

Similar to the [Disable GitHub Multibranch Status plugin](https://plugins.jenkins.io/disable-github-multibranch-status/).

## Usage

### BitBucket

```Groovy
  checkout resolveScm(
    source: bitbucket(
      repoOwner: 'example-owner',
      repository: 'example-repository',
      traits: [
        skipNotifications(),
        ...,
      ]
    )
  )
```

## License

 [MIT License](./LICENSE.md)

## More information

It was initially submitted as a PR for core plugin [PR](https://github.com/jenkinsci/bitbucket-branch-source-plugin/pull/132), but owners suggested to package it as an extension.
