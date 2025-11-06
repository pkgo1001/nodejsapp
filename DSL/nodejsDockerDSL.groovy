job('Aplicacion Node.js Docker DSL desde Digital Ocean') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/pkgo1001/nodejsapp.git', 'master') { node ->
            node / gitConfigName('wilson')
            node / gitConfigEmail('pokegoacc1001@gmail.com')
        }
    }
    triggers {
        scm('H/1 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('pkgo1001/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    publishers {
		emailer('pokegoacc1001@gmail.com', false, true)
    }
}
