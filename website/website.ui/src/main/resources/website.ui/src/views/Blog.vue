<template>
    <div v-if="data" class="flex flex-col">
        <div class="w-full sm:w-3/4">
            <div class="flex content-center sm:pl-10 pb-5 text-2xl lg:text-3xl xl:text-4xl">
                {{data.blogTitle}}
            </div>
        </div>
        <div class="flex w-full justify-center content-center">
            <div class="w-full sm:w-3/4 sm:p-20 bg-gray-100">
                <div class="blog" v-html="data.blog"></div>
            </div>
        </div>
         <div class="w-fullsm:w-1/2 sm:pl-10 pt-5 pb-5">
            <div class="flex content-center italic">
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
<style scoped>
.blog >>> .prgrph {
              padding: 0.4rem;
          }
.blog >>> h1 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
.blog >>> h2 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
.blog >>> h3 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
.blog >>> h4 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
</style>
