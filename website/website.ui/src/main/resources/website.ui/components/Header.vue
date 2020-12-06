<template>
  <div class="flex w-full h-6 sm:h-8 md:h-10 flex-row bg-gray-100 items-center text-center">
    <div class="header-item mr-6 w-1/3">
      <NuxtLink class="text-blue-500 hover:text-blue-800" to="/profile">Home</NuxtLink>
    </div>
    <div class="header-item mr-6 w-1/3">
      <a class="text-blue-500 hover:text-blue-800" href="https://drive.google.com/file/d/1biqtGZIjSAufZGDvYkyXvSPTl0yObzd0/view?usp=sharing" target="_blank">Resume</a>
    </div>
    <div class="header-item mr-6 w-1/3">
      <NuxtLink class="text-blue-500 hover:text-blue-800" to="/profile/blogs">Blogs</NuxtLink>
    </div>
  </div>
</template>
<script>
export default {
  /**
   * @author pat-lego <patrique.legault@gmail.com>
   * @version 1.0
   * @description This is the navbar component used within the site, it currently displays Home and Resume. Once the first page is complete then we will use the Contact us page
   * @memberof components
   */
  name: 'nav-component'
}
</script>
