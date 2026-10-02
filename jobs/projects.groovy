// The projects this Jenkins builds. To add one:
//   1. put a Jenkinsfile in the repo (start from one in templates/),
//   2. add an entry below,
//   3. run: docker compose restart jenkins
//
// Each project becomes a multibranch pipeline: every branch that has a Jenkinsfile gets its own job.
// Jenkins runs on localhost, so GitHub can't send webhooks; repos are re-scanned every 5 minutes instead
// and branches with new commits are built.
def projects = [
    [name: 'kira-finance', repo: 'https://github.com/amirizalrahmat0799/kira-finance.git'],
    // [name: 'my-next-app', repo: 'https://github.com/amirizalrahmat0799/my-next-app.git'],
]

projects.each { project ->
    multibranchPipelineJob(project.name) {
        description("Builds every branch of ${project.repo}")

        branchSources {
            git {
                id("${project.name}-source") // must stay constant, Jenkins uses it to track branches
                remote(project.repo)
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
}
