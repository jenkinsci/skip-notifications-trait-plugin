# Skip notifications trait plugin

[![Build Status](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/main/badge/icon)](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/main/)
[![Coverage](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/main/badge/icon?status=${instructionCoverage}&subject=coverage&color=${colorInstructionCoverage})](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/main)
[![LOC](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/main/badge/icon?job=test&status=${lineOfCode}&subject=line%20of%20code&color=blue)](https://ci.jenkins.io/job/Plugins/job/skip-notifications-trait-plugin/job/main)
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/skip-notifications-trait.svg)](https://plugins.jenkins.io/skip-notifications-trait)
[![GitHub release](https://img.shields.io/github/release/jenkinsci/skip-notifications-trait-plugin.svg?label=changelog)](https://github.com/jenkinsci/skip-notifications-trait-plugin/releases/latest)
[![GitHub license](https://img.shields.io/github/license/jenkinsci/skip-notifications-trait-plugin)](https://github.com/jenkinsci/skip-notifications-trait-plugin/blob/main/LICENSE.md)
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
        bitbucketSkipNotifications(),
        ...,
      ]
    )
  )
```

### Github

```Groovy
  checkout resolveScm(
    source: github(
      repoOwner: 'example-owner',
      repository: 'example-repository',
      traits: [
        githubSkipNotifications(),
        ...,
      ]
    )
  )
```

### Via Jenkins UI

Edit the configuration of your job under `Branch Sources ` → `Behaviors` → Search for `Skip build status notifications`:

<img width="240" alt="image" src="https://github.com/jenkinsci/skip-notifications-trait-plugin/assets/8419048/6f10c174-d5eb-45b4-add8-0e087e50d4cf">

Don't forget to save the changes.

## License

 [MIT License](./LICENSE.md)

## More information

It was initially submitted as a PR for core plugin [PR](https://github.com/jenkinsci/bitbucket-branch-source-plugin/pull/132), but owners suggested to package it as an extension.
