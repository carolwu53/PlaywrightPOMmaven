pipeline
{
    agent any

        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/carolwu53/PlaywrightPOMmaven'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regressions.xml"

                }
            }
        }

        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false,
                                  keepAll: true,
                                  reportDir: 'build',
                                  reportFiles: 'TestExecutionReport.html',
                                  reportName: 'HTML Extent Report',
                                  reportTitles: ''])
            }
        }

 }