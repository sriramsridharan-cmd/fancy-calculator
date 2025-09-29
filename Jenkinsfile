pipeline {
  agent any

  options { skipDefaultCheckout(true) }

  triggers {
    // Jenkins will react to GitHub webhook OR poll every 2 minutes as backup
    pollSCM('H/2 * * * *')
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/<YOUR-USERNAME>/fancy-calculator.git'
      }
    }

    stage('Build with Maven') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('Build Docker image') {
      steps {
        sh 'docker build -t fancy-calculator:latest .'
      }
    }

    stage('Deploy on this VM') {
      steps {
        sh '''
          docker rm -f calc || true
          docker run -d --name calc -p 8080:8080 fancy-calculator:latest
        '''
      }
    }

    stage('Smoke test') {
      steps {
        sh 'curl -sS http://localhost:8080/calc/add?a=1&b=2 || true'
      }
    }
  }
}
