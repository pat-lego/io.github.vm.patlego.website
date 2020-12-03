<template>
    <div v-if="data" class="flex flex-col">
        <div class="w-1/4">
            <div class="flex content-center pl-10 pb-5 text-xl">
                {{data.blogTitle}}
            </div>
        </div>
        <div class="flex w-full justify-center content-center">
            <div class="w-3/4 p-20 bg-gray-100">
                <span v-html="data.blog"></span>
            </div>
        </div>
         <div class="w-1/4">
            <div class="flex content-center pl-10 pt-5 italic">
                By: {{data.blogAuthor}}
            </div>
         </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
  props: {
    blog: Object
  },
  data: () => {
    return {
      data: undefined
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      if (this.blog) {
        this.data = this.blog
      } else {
        if (process.env.NODE_ENV === 'development') {
          axios
            .get(`http://localhost:8181/cxf/patlegovm/1.0/site/blogs/${this.$route.query.id}`)
            .then(response => { this.data = response.data })
        } else {
          axios
            .get(`/cxf/patlegovm/1.0/site/blogs/${this.$route.query.id}`)
            .then(response => { this.data = response.data })
        }
      }
    }
  }
}
</script>
