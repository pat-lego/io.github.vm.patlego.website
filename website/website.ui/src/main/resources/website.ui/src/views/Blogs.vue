<template>
  <div>
    <div class="flex flex-col md:flex-row">
      <div class="flex md:w-2/5 items-center justify-center">
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
                    <tr class="z-0 hover:shadow-md" v-for="blog in blogs" :key="blog.blogId" v-on:click="selectedBlog(blog)">
                        <th class="pt-10 pb-10">
                            {{blog.blogTitle}}
                        </th>
                    </tr>
                </tbody>
            </table>
      </div>
    </div>
</div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'blogs-view',
  data () {
    return {
      blogs: undefined
    }
  },
  created () {
    this.fetchBlogs()
  },
  methods: {
    fetchBlogs () {
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
    },
    selectedBlog (blog) {
      this.$router.push({ name: 'Blog', params: { blog: blog }, query: { id: blog.blogId } })
    }
  }
}
</script>
