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
      <div
        v-if="data === undefined"
        class="flex justify-center items-center w-full h-52 animate-spin"
      >
        <font-awesome-icon
          class="text-6xl hover:text-blue-300"
          :icon="['fa', 'spinner']"
        />
      </div>
      <div v-else-if="data !== error" class="flex flex-col">
        <div class="w-full sm:w-3/4">
          <div
            class="flex content-center sm:pl-10 pb-5 text-2xl lg:text-3xl xl:text-4xl"
          >
            {{ data.blogTitle }}
          </div>
        </div>
        <div class="flex w-full justify-center content-center">
          <div class="w-full sm:w-3/4 sm:p-20 bg-gray-100">
            <div class="blog" v-html="data.blog"></div>
          </div>
        </div>
        <div class="w-fullsm:w-1/2 sm:pl-10 pt-5 pb-5">
          <div class="flex content-center italic">
            By: {{ data.blogAuthor }}
          </div>
        </div>
      </div>
      <div
        v-else
        class="flex flex-col justify-center items-center align-middle w-full"
      >
        <div>
          <font-awesome-icon
            class="fa-10x hover:text-blue-300"
            :icon="['fa', 'exclamation-triangle']"
          />
        </div>
        <div class="pt-5 italic">{{ data }} loading the blog</div>
      </div>
    </div>
    <div class="flex h-40 pt-10 w-full">
      <footer-component :footer="footer" />
    </div>
  </div>
</template>
<script>
import Header from "@/components/Header.vue";
import Icon from "@/components/Icon.vue";
import Footer from "@/components/Footer.vue";
export default {
  name: "blog-view",
  components: {
    "icon-component": Icon,
    "nav-component": Header,
    "footer-component": Footer,
  },
  data: () => {
    return {
      error: "An error occured",
      data: undefined,
      footer: {
        github: "https://github.com/pat-lego",
        twitter: "https://twitter.com/_patlego",
        linkedin: "https://www.linkedin.com/in/patrique-legault/",
        stackoverflow:
          "https://stackoverflow.com/users/8828583/patrique-legault",
      },
    };
  },
  head() {
    return {
      title: "Personalized Blog",
      meta: [
        {
          hid: "description",
          name: "description",
          content: "Blog",
        },
        {
          hid: "og:title",
          name: "og:title",
          content: "Patrique Legault Blog",
        },
        {
          hid: "og:description",
          name: "og:description",
          content: "Enjoy this personalized blog",
        },
        {
          hide: "twitter:title",
          name: "twitter:title",
          content: "Patrique Legault Blog",
        },
        {
          hide: "twitter:description",
          name: "twitter:description",
          content: "Enjoy this personalized blog",
        },
        {
          hid: "keywords",
          name: "keywords",
          content:
            "Web Development, Blog, Blogger, Vue.js, Java, OSGi, Apache Karaf, Technical Architect, Amazon Web Services",
        },
      ],
    };
  },
  async fetch() {
    if (process.env.NODE_ENV === "development") {
      try {
        this.data = await fetch(
          `http://localhost:8181/cxf/patlegovm/1.0/site/blogs/${this.$route.query.id}`
        ).then((res) => res.json());
      } catch (e) {
        this.data = this.error;
      }
    } else {
      try {
        this.data = await fetch(
          `/cxf/patlegovm/1.0/site/blogs/${this.$route.query.id}`
        ).then((res) => res.json());
      } catch (e) {
        this.data = this.error;
      }
    }
  },
  fetchOnServer: false,
};
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
