<template>
    <div class="flex bg-gray-100 w-full">
        <div class="flex flex-row items-center m-6">
            <div v-if="github" class="pr-8">
                <a :href="github" target="_blank"><font-awesome-icon class="text-4xl hover:text-blue-300" :icon="['fab', 'github']" /></a>
            </div>
            <div v-if="twitter" class="pr-8">
                <a :href="twitter" target="_blank"><font-awesome-icon class="text-4xl hover:text-blue-300" :icon="['fab', 'twitter']" /></a>
            </div>
            <div v-if="linkedin" class="pr-8">
                <a :href="linkedin" target="_blank"><font-awesome-icon class="text-4xl hover:text-blue-300" :icon="['fab', 'linkedin']" /></a>
            </div>
            <div v-if="stackoverflow" class="pr-8">
                <a :href="stackoverflow" target="_blank"><font-awesome-icon class="text-4xl hover:text-blue-300" :icon="['fab', 'stack-overflow']" /></a>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  /**
    * @author pat-lego <patrique.legault@gmail.com>
    * @version 1.0
    * @description This is the footer for the site which displays specific icons only if the URL for the profile exists
    * @memberof components
  */
  name: 'footer-component',
  data() {
    return {
        github: 'https://github.com/pat-lego',
        twitter: 'https://twitter.com/_patlego',
        linkedin: 'https://www.linkedin.com/in/patrique-legault/',
        stackoverflow: 'https://stackoverflow.com/users/8828583/patrique-legault'
      }
  }
}
</script>
