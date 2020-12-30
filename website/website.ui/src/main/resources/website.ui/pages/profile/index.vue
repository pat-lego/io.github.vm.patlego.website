<template>
  <div id="app" class="flex flex-col w-full">
  <div>
    <header-component/>
  </div>
  <div class="flex w-full component">
    <div>
      <div
        class="flex flex-col sm:flex-row items-center w-full pt-2 sm:pt-3 md:pt-8"
      >
        <div class="w-1/2 flex justify-center items-center">
          <card-component :card="personal.image" />
        </div>
        <div class="me sm:w-1/2 flex pt-4">
          <profile-component :profile="personal.profile" />
        </div>
      </div>
      <div class="flex flex-col mt-6">
        <timeline-component :timeline="personal.timeline" :sort='"desc"' />
      </div>
    </div>
  </div>
  <div class="flex h-40 pt-10 w-full">
    <footer-component />
  </div>
</div>
</template>
<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import Card from '@/components/Card.vue'
import Profile from '@/components/Profile.vue'
import Timeline from '@/components/Timeline'

export default {
  name: 'home-view',
  components: {
    'header-component': Header,
    'footer-component': Footer,
    'card-component': Card,
    'profile-component': Profile,
    'timeline-component': Timeline
  },
  data: () => {
    return {
      personal: {
        image: {
          imageUrl: 'profile.jpg',
          imageAlt: 'Patrique Legault'
        },
        timeline: [
          {
            title: 'Software Developer',
            description: 'I developed an algorithm at Laurentian University to measure the energy of various chemical structures using Mathematica. ' +
              'Deployed and tested the solution on a super computer made available by <a href=\'https://www.sharcnet.ca/my/front/\'>SharcNet</a>.',
            year: 2011
          },
          {
            title: 'Technical Support Agent',
            description: 'I worked with many application servers and databases in order to install Adobe LiveCycle for clients. \n' +
                                'This required me to work with various components of the organization to accomplish this task. ' +
            'Used the Adobe Workbench utility to help clients troubleshoot processes developed for Adobe LiveCycle.',
            year: 2014
          },
          {
            title: 'Senior Systems Analyst',
            description: 'Worked on various projects involving Adobe Experience Manager and Forms. ' +
              'Used tools such as Jira, Bitbucket, Maven and VS Code to develop OSGi services and AEM components. ' +
              'Used various development tools to create integrations between client systems and Adobe Sign.',
            year: 2016
          },
          {
            title: 'Senior Developer',
            description: 'Managed product development with a team of developers and used Agile methodologies to create a quick and iterative delivery cycle. ' +
              'Used various tools to develop a deployment pipeline such as TravisCI, Ruby, Amazon ECS, Amazon ECR, Amazon RDS, Docker, Flyway DB Migration. ' +
              'Used various tools to develop a testing pipeline such as TravisCI, Selenium, JUnit. ' +
              'Worked as a full stack developer leveraging Angular, Java and Postgres as the main technologies for the application.',
            year: 2018
          },
          {
            title: 'Software Consultant',
            description: 'Leveraging Adobe Experience Manager to create web content for businesses.',
            year: 2019
          }
        ],
        profile: {
          name: 'Patrique Legault',
          career: 'Developer',
          location: 'Ottawa',
          email: 'patrique.legault@gmail.com',
          number: '613.914.2477',
          experience: [
            {
              name: 'Java'
            },
            {
              name: 'Vue.js',
              link: 'https://vuejs.org/'
            },
            {
              name: 'Adobe Experience Manager',
              link: 'https://www.adobe.com/ca/marketing/experience-manager.html'
            }
          ]
        }
      },
    }
  }
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
