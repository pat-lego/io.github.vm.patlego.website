<template>
  <div>
    <div class='flex mb-4 w-full'>
        <div class='w-1/4'>
            <icon-component />
        </div>
        <div class='w-full'>
            <nav-component />
        </div>
    </div>
    <div class="flex flex-col md:flex-row">
      <div class="flex md:w-2/5 md:pt-40 content-center justify-center">
        <span class="font-bold m-6">Enjoy reading one of our blogs.</span>
      </div>
      <div class="flex md:w-3/5 md:pt-10 content-center justify-center">
            <table class="w-full">
                <thead class="w-full bg-blue-100">
                    <tr>
                        <th class="pt-4 pb-10">
                            Blog Title
                        </th>
                    </tr>
                </thead>
                <tbody class="w-4/5">
                    <tr class="z-0 hover:shadow-md" v-for="blog in blogs" :key="blog.blogId">
                        <th class="pt-10 pb-10">
                            {{blog.blogTitle}}
                        </th>
                    </tr>
                </tbody>
            </table>
      </div>
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
import axios from 'axios'
export default {
  name: 'blogs-view',
  components: {
    'icon-component': Icon,
    'nav-component': Header,
    'footer-component': Footer
  },
  data () {
    return {
      blogs: undefined,
      footer: {
        github: 'https://github.com/pat-lego',
        twitter: 'https://twitter.com/_patlego',
        linkedin: 'https://www.linkedin.com/in/patrique-legault/',
        stackoverflow: 'https://stackoverflow.com/users/8828583/patrique-legault'
      }
    }
  },
  created () {
    this.fetchBlogs()
  },
  methods: {
    fetchBlogs () {
      console.log(process.env.NODE_ENV)
      if (process.env.NODE_ENV === 'development') {
        axios
          .get('http://localhost:8181/cxf/patlegovm/1.0/site/blogs')
          .then((response) => {
            this.blogs = response.data
          })
      } else {
        axios
          .get('/cxf/patlegovm/1.0/site/blogs')
          .then((response) => {
            this.blogs = response.data
          })
      }
    }
  }
}
</script>
