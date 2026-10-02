// Multibranch pipeline: every branch of the repo that has a Jenkinsfile gets its own job.
// Jenkins runs on localhost, so GitHub can't send webhooks; instead the repo is re-scanned every 5 minutes
// and any branch with new commits is built.
multibranchPipelineJob('kira-finance') {
    displayName('Kira finance')
    description('Spring Boot API + Expo mobile app · github.com/amirizalrahmat0799/kira-finance')

    branchSources {
        git {
            id('kira-finance-github') // must stay constant, Jenkins uses it to track branches
            remote('https://github.com/amirizalrahmat0799/kira-finance.git')
        }
    }

    triggers {
        periodicFolderTrigger {
            interval('5m')
        }
    }

    orphanedItemStrategy {
        discardOldItems {
            numToKeep(10)
        }
    }
}
