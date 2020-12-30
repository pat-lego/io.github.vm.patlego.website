<template>
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
</template>
<script>
import Header from "@/components/Nav.vue";
import Icon from "@/components/Icon.vue";
export default {
  name: "header-component",
  components: {
    "icon-component": Icon,
    "nav-component": Header,
  },
};
</script>