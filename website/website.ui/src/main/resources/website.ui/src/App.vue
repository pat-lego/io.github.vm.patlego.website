<template>
  <div id="app" class='w-full'>
    <div>
        <div class='flex mb-4 w-full'>
            <div class='w-1/4'>
                <icon-component />
            </div>
            <div class='w-full'>
                <nav-component />
            </div>
        </div>
    </div>
    <div class="component">
        <router-view />
    </div>
    <div class="relative h-40">
        <div class="absolute inset-x-0 bottom-0">
            <footer-component :footer='footer' />
        </div>
    </div>
</div>
</template>
<script>
import Header from '@/components/Header.vue'
import Icon from '@/components/Icon.vue'
import Footer from '@/components/Footer.vue'
export default {
  name: 'home-view',
  components: {
    'icon-component': Icon,
    'nav-component': Header,
    'footer-component': Footer
  },
  data: () => {
    return {
      footer: {
        github: 'https://github.com/pat-lego',
        twitter: 'https://twitter.com/_patlego',
        linkedin: 'https://www.linkedin.com/in/patrique-legault/',
        stackoverflow: 'https://stackoverflow.com/users/8828583/patrique-legault'
      }
    }
  }
}
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto&display=swap");
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
* {
   font-family: "Roboto" !important;
}
</style>
