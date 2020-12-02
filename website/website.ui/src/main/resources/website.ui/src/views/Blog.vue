<template>
    <div class="flex flex-col">
        <div class="w-1/4">
            <div class="flex content-center pl-10 pb-5 text-xl">
                {{blog.blogTitle}}
            </div>
        </div>
        <div class="flex w-full justify-center content-center">
            <div class="w-3/4 p-20 bg-gray-100">
                <span v-html="blog.blog"></span>
            </div>
        </div>
         <div class="w-1/4">
            <div class="flex content-center pl-10 pt-5 italic">
                By: {{blog.blogAuthor}}
            </div>
         </div>
    </div>
</template>
<script>
export default {
  props: {
    blog: Object
  }
}
</script>
