job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell("npm install")
    }
    publishers {
		mailer('pokegoacc1001@gmail.com', false, true)
    }
}
