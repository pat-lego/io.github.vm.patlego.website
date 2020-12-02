<template>
    <div>
        In blog component {{this.$route.params.id}}
    </div>
</template>
<script>
export default {
  props: {
    blog: Object
  },
  created () {
    console.log(this.blog)
  }
}
</script>
