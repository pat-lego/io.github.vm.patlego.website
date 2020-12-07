<template>
<div id="app" class="flex flex-col w-full">
  <div>
    <div class="flex mb-4 h-10 w-full">
      <div class="flex w-1/3">
        <icon-component />
      </div>
      <div class="flex w-full">
        <nav-component />
      </div>
    </div>
  </div>
  <div class="flex w-full component">
    <div class="w-full">
      <div
        v-if="blogs === undefined"
        class="flex justify-center items-center h-full animate-spin"
      >
        <font-awesome-icon
          class="text-6xl hover:text-blue-300"
          :icon="['fa', 'spinner']"
        />
      </div>
      <div v-if="blogs" class="w-full">
        <div class="flex flex-col md:flex-row">
          <div
            class="flex items-center justify-center h-auto md:h-48 w-full md:w-2/5"
          >
            <div class="font-bold m-6">Enjoy reading one of our blogs.</div>
          </div>
          <div class="flex md:w-3/5 md:pt-10 content-center justify-center">
            <table class="w-full">
              <thead class="w-full bg-blue-100">
                <tr>
                  <th class="pt-4 pb-10">Blog Title</th>
                </tr>
              </thead>
              <tbody class="w-full">
                <NuxtLink 
                  class="flex content-center	items-center justify-center z-0 hover:shadow-md"
                  v-for="blog in blogs"
                  :key="blog.blogId"
                  :to="{ path: '/profile/blog', query: { id: blog.blogId } }">
                  <tr>
                    <th class="pt-10 pb-10">{{blog.blogTitle}}</th>
                  </tr>
                </NuxtLink>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="flex h-40 pt-10 w-full">
    <footer-component :footer="footer" />
  </div>
</div>
</template>
<script>
import Header from '@/components/Header.vue'
import Icon from '@/components/Icon.vue'
import Footer from '@/components/Footer.vue'
export default {
  name: 'blogs-view',
  components: {
    'icon-component': Icon,
    'nav-component': Header,
    'footer-component': Footer
  },
  data () {
    return {
      footer: {
        github: 'https://github.com/pat-lego',
        twitter: 'https://twitter.com/_patlego',
        linkedin: 'https://www.linkedin.com/in/patrique-legault/',
        stackoverflow: 'https://stackoverflow.com/users/8828583/patrique-legault'
      }
    }
  },
  async asyncData ({$http}) {
    if (process.env.NODE_ENV === 'development') {
      const blogs = await $http.get('http://localhost:8181/cxf/patlegovm/1.0/site/blogs')
      return { blogs }
    } else {
      const blogs = await $http.get('/cxf/patlegovm/1.0/site/blogs')
      return { blogs }
    }
  }
}
</script>
